import com.george.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @author George
 * @description redis 连接测试
 * @date 2025/8/17 17:34
 */

public class MyJedisTest {

    private Jedis jedis;


    @BeforeEach
    void setUp() {
        // 1. 建立连接
        /*jedis = new Jedis("117.72.64.21", 6379);*/
        // 1.1 使用连接池获取对象
        jedis = JedisConnectionFactory.getJedis();

        // 2.设置密码
        jedis.auth("@Poole0128");

        // 3. 选择库
        jedis.select(0);
    }

    @Test
    public void JedisConnTest(){
        // 存入数据
        String result    = jedis.set("name", "zhoukun");
        System.out.println("result:" + result);

        // 取数据
        String nameValue = jedis.get("name");
        System.out.println("name:" + nameValue);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
