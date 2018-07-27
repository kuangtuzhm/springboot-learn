/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2018.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2018年7月27日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.learn.redis.jedis.controller;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zealot.learn.redis.jedis.BaseRedisCache;

import redis.clients.jedis.Jedis;


/**
 * @FileName RedisController.java
 * @Description: 
 *
 * @Date 2018年7月27日 上午10:55:08
 * @author Zhao Haiming
 * @version 1.0
 */
@Controller
public class RedisController extends BaseRedisCache{
    
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    @ResponseBody
    public String set()
    {

        long start = System.currentTimeMillis();
        Jedis jedis = this.getResource();
        jedis.select(15);
        String [] keys = new String[200000];
        for(int i = 0; i<100000;i++)
        {
            keys[i*2] = "key"+i;
            keys[i*2+1] = "value"+i;
//            for(int j = 0; j<200;j++)
//            {
//                keys[j*2] = "test"+i+j;
//                keys[j*2+1] = "value"+i+j;
//            }
            
        }
        jedis.mset(keys);
        jedis.close();
        long end = System.currentTimeMillis();
        System.out.println("插入time="+(end-start));
        return "done";
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get()
    {
        long start = System.currentTimeMillis();
        Jedis jedis = this.getResource();
        
        String [] keys = new String[200];
        for(int i = 0; i<500;i++)
        {
            for(int j = 0; j<200;j++)
            {
                keys[j] = "test"+i+j;
            }
            jedis.select(15);
            List<String> s = jedis.mget(keys);
        }
        jedis.close();
        long end = System.currentTimeMillis();
        System.out.println("查询time="+(end-start));
        return "done";
    }
    
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ResponseBody
    public String del()
    {
        long start = System.currentTimeMillis();
        Jedis jedis = this.getResource();
        
        String [] keys = new String[200];
        for(int i = 0; i<500;i++)
        {
            for(int j = 0; j<200;j++)
            {
                keys[j] = "test"+i+j;
            }
            jedis.select(15);
            jedis.del(keys);
        }
        jedis.close();
        long end = System.currentTimeMillis();
        System.out.println("删除time="+(end-start));
        return "done";
    }
}
