package com.star.web.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    @Test
    public void test01(){
        /*
            1.获得连接对象
            设置ip地址和端口
         */
        Jedis jedis = new Jedis("192.168.220.36",6379);
        jedis.auth("jiang");
        System.out.println(jedis);
        //2.设置数据
        jedis.set("gender","male");
        //3.获取数据
        String name = jedis.get("name");
        System.out.println(name);
        //4.释放资源
        jedis.close();
    }
}
