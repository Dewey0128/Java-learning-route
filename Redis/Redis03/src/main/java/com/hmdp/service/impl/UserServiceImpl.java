package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RegexUtils;
import com.hmdp.utils.SystemConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.hmdp.utils.RedisConstants.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result sendCode(String phone, HttpSession session) {

        //  发送短信验证码并保存验证码
        // 1. 校验手机号
        if(!RegexUtils.isPhoneInvalid(phone)){
            // 2. 如果不符合，返回错误信息
            return Result.fail("手机号格式错误！");
        }
        // 符合，则生成验证码
        String code = RandomUtil.randomNumbers(6);
        // 4 . 保存验证码
        // 4.1 session 保存
        /*session.setAttribute("code", code)*/;
        // 4.2 redis 保存 用手机号作为key保存验证码
        stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY + phone, code, Duration.ofMinutes(LOGIN_CODE_TTL));

        // 5.发送验证码
        log.debug("发送验证码成功：验证码：{}", code);
        //返回ok
        return Result.ok();
    }

    @Override
    public Result login(LoginFormDTO loginForm, HttpSession session) {
        //  发送短信验证码并保存验证码
        // 1. 校验手机号
        if(!RegexUtils.isPhoneInvalid(loginForm.getPhone())){
            // 2. 如果不符合，返回错误信息
            return Result.fail("手机号格式错误！");
        }
        // 2.校验验证码
        // 2.1 从session中拿到验证码
        /*Object cacheCode = session.getAttribute("code");*/
        // 2.2 从redis中拿到验证码
        String cacheCode = stringRedisTemplate.opsForValue().get(LOGIN_CODE_KEY + loginForm.getPhone());
        String code = loginForm.getCode();
        if(cacheCode == null || !cacheCode.equals(code)){
            // 3. 验证码不一致
            return Result.fail("验证码错误！");
        }

        // 4.手机号 验证码校验通过 查询用户
        User user = query().eq("phone", loginForm.getPhone()).one();

        // 5. 判断用户是否存在
        if(null == user){
            user = creatUserWithPhone(loginForm.getPhone());
        }

        // 7.1 保存用户信息到Session中
        /*session.setAttribute("user", BeanUtil.copyProperties(user, UserDTO.class))*/;
        // 7.2 保存用户信息到redis中 (希望浏览器发送给我的token去redis取用户信息登入)
        // 7.2.1 随机生成token，作为登录令牌
        String token =  UUID.randomUUID().toString();
        // 7.2.2 将User对象转为HashMap
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        /*Map<String, Object> userMap = BeanUtil.beanToMap(userDTO);*/  //class java.lang.Long cannot be cast to class java.lang.String
        Map<String, Object> userMap = BeanUtil.beanToMap(userDTO,
                new HashMap<>(),
                CopyOptions.create()
                        .setIgnoreNullValue(true)
                        .setFieldValueEditor((fieldName,fieldValue) -> fieldValue.toString()));


        // 7.2.3 存储
        String tokenKey = LOGIN_USER_KEY + token;
        stringRedisTemplate.opsForHash().putAll(tokenKey, userMap);
        // 7.2.4 设置token有效期
        stringRedisTemplate.expire(tokenKey, Duration.ofMinutes(LOGIN_USER_TTL));
        return Result.ok(token);
    }

    @Override
    public Result sign() {
        return null;
    }

    @Override
    public Result signCount() {
        return null;
    }

    private User creatUserWithPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        user.setNickName(SystemConstants.USER_NICK_NAME_PREFIX + RandomUtil.randomString(10));
        // 保存用户
        save(user);
        return user;
    }
}
