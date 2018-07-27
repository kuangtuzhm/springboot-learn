package com.zealot.learn.redis.jedis;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

  
/**  
 * AbstractBaseRedisDao 
 * @author http://blog.csdn.net/java2000_wl  
 * @version <b>1.0</b>  
 */   
public class BaseRedisCache {  
      
	private static Logger logger = LoggerFactory.getLogger(BaseRedisCache.class);
	
    @Resource  
    protected JedisPool jedisPool;  
  
    public Jedis getResource() 
    {
    	Jedis jedis = null;
    	try 
    	{
    		jedis = jedisPool.getResource();
    		logger.debug("getResource:{}", jedis);
    	} catch (Exception e) 
    	{
    		logger.error("getResource:{}",e);
    		if (jedis!=null)
    		jedis.close();
    		throw  e;
    	}
    	return jedis;
    }
    
    public void returnResource(final Jedis jedis) 
    {
    	if (jedis != null) 
    	{
    		try 
    		{
    		    jedis.close();
    		} catch (Exception e) 
    		{
    			throw new JedisException("Could not return the resource to the pool", e);
    		}
    	}
    }
}
