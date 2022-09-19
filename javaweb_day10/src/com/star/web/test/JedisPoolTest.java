package com.star.web.test;

/*
    redis 连接池
 */

import com.star.web.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import java.util.List;
import java.util.Set;


public class JedisPoolTest {
    @Test
    public void test01() {
        //1.创建配置对象
        Jedis jedis = JedisPoolUtils.getJedis();
        //2.设置密码授权
//        jedis.auth("jiang");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }

    @Test
    public void test02() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        JedisPool pool = new JedisPool(config, "192.168.220.36",
                6379, Protocol.DEFAULT_TIMEOUT, "jiang");
        Jedis jedis = pool.getResource();
        Set<String> fields = jedis.hkeys("user");
        System.out.println(fields);
        List<String> values = jedis.hvals("user");
        System.out.println(values);
        jedis.close();
    }
}
