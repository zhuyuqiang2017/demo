package top.selfhelp.config;

import redis.clients.jedis.JedisPool;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class RedisTool {

    private static RedisTool redisTool = null;
    private final JedisPool redisPool;

    {
        redisTool = new RedisTool(null);
    }

    private RedisTool(JedisPool jedisPool){
        redisPool = jedisPool;
    }

    public static RedisTool get(){
        return redisTool;
    }
}
