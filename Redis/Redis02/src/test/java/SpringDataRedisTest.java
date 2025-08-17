import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.george.po.User;
import com.george.spring.DataRedisSpringBoot;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.xmlunit.util.Mapper;

/**
 * @author George
 * @description
 * @date 2025/8/17 18:29
 */
@SpringBootTest(classes = DataRedisSpringBoot.class)
public class SpringDataRedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    ObjectMapper GetMapper(){
        return new ObjectMapper();
    }

    // 存储 单字符串
    @Test
    void StringRedisTemplateTest(){
        stringRedisTemplate.opsForValue().set("name", "周坤");
        System.out.println("name:" + stringRedisTemplate.opsForValue().get("name"));
    }

    // 存储对象
    @Test
    void RedisPojoTest() throws JsonProcessingException {
        User user = new User("周坤", 23);
        // 转为序列化参数
        String userJson = GetMapper().writeValueAsString(user);

        // 存储数据
        stringRedisTemplate.opsForValue().set("user0128", userJson);

        //取数据
        String user0128 = stringRedisTemplate.opsForValue().get("user0128");

        // 手动反序列化
        System.out.println( "User:" + GetMapper().readValue(user0128, User.class));
    }

    @Test
    void HashDataTest(){
        stringRedisTemplate.opsForHash().put("user0113", "name", "tjj");
        stringRedisTemplate.opsForHash().put("user0113", "age", "24");

        System.out.println(stringRedisTemplate.opsForHash().entries("user0113"));

    }

}
