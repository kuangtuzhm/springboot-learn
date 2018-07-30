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

package com.zealot.learn.redis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zealot.learn.redis.CommonRedisDao;

/**
 * @FileName RedisController.java
 * @Description: 
 *
 * @Date 2018年7月27日 上午10:55:08
 * @author Zhao Haiming
 * @version 1.0
 */
@Controller
public class RedisController {

    @Autowired
    private CommonRedisDao commonRedisDao;
    
    ExecutorService executorService = Executors.newFixedThreadPool(100);
    
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    @ResponseBody
    public String set(String key,String value)
    {
        long start = System.currentTimeMillis();
        Map<String,String> map= new HashMap<>(100000);
        for(int i = 0; i<100000; i++)
        {
            map.put("key"+i, "value"+i);
        }
        commonRedisDao.multiSet(map);
        long end = System.currentTimeMillis();
        System.out.println("插入time="+(end-start));
        return "done";
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get(String key)
    {
        long start = System.currentTimeMillis();
        for(int i = 0; i<100000; i++)
        {
            final int k = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String s = commonRedisDao.get("key"+k);
                    System.out.println(s);
                    
                }  
            });
            
        }
        
        long end = System.currentTimeMillis();
        System.out.println("查询time="+(end-start));
        return "done";
    }
    
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ResponseBody
    public String del()
    {
        long start = System.currentTimeMillis();
        List<String> keys = new ArrayList<>(100000);
        for(int i = 0; i<100000; i++)
        {
            keys.add("key"+i);
        }
        commonRedisDao.multiDel(keys);
        long end = System.currentTimeMillis();
        System.out.println("删除time="+(end-start));
        return "done";
    }
}
