package com.hmdp.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.hmdp.dto.UserDTO;
import com.hmdp.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.Map;

import static com.hmdp.utils.RedisConstants.LOGIN_USER_KEY;
import static com.hmdp.utils.RedisConstants.LOGIN_USER_TTL;


/**
 * @author George
 * @description
 * @date 2025/8/18 17:26
 */
public class RefreshTokenInterceptor implements HandlerInterceptor {

    private final StringRedisTemplate stringRedisTemplate;

    public RefreshTokenInterceptor(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.1获取session ： 为了得到user
        /*HttpSession session = request.getSession();*/
        // 1.2 从redis中 通过 token 获取
        // 1.2.1 从浏览器获取token
        String token = request.getHeader("authorization");
        // 1.2.2 判断token是否为空
        /*if(StrUtil.isBlank(token)){
            // 不存在 则拦截
            *//* response.setStatus(401);*//*
            return true;
        }*/

        // 2. 获取session用户
        /*Object user = session.getAttribute("user");*/
        // 2.2 获取redis用户
        Map<Object, Object> userMap = stringRedisTemplate
                .opsForHash()
                .entries(LOGIN_USER_KEY + token);

        // 2.2.1 判断用户是否存在
        /*if(userMap.isEmpty()){
            // 不存在 则拦截
            *//*response.setStatus(401);*//*
            return true;
        }*/

        // 将用户Hash转为UserDTO对象
        UserDTO userDTO = BeanUtil.fillBeanWithMap(userMap, new UserDTO(), false);

        // 保存用户信息到ThreadLocal
        UserHolder.saveUser(userDTO);

        // ** 刷新token有效期
        stringRedisTemplate.expire(LOGIN_USER_KEY + token, Duration.ofMinutes(LOGIN_USER_TTL));

        /*// 判断用户是否存在
        if (null == user) {
            // 4. 不存在，拦截
            response.setStatus(401);
            return false;
        }*/
        /*
        // 5.存在，保存用户信息到ThreadLocal
        UserHolder.saveUser((UserDTO) user);*/

        // 6. 放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        UserHolder.removeUser();
    }
}