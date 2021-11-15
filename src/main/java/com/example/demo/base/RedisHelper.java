package com.example.demo.base;

import redis.clients.jedis.Jedis;

import java.net.ConnectException;

public class RedisHelper {
    private Jedis mJedis;
    private RedisHelper(){
        try{
            mJedis = new Jedis("localhost");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static RedisHelper getRedisHelper(){
        return new RedisHelper();
    }

    public static void connectServer(){
        try {
            Jedis jedis = new Jedis("localhost");
            // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
            // jedis.auth("123456");
            System.out.println("连接成功");
            //查看服务是否运行
            System.out.println("服务正在运行: " + jedis.ping());
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public void setString(String key, String value){
        mJedis.set(key, value);
    }

    public String getString(String key){
        return mJedis.get(key);
    }
}
