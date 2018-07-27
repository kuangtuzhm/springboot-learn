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
    
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    @ResponseBody
    public String set(String key,String value)
    {
        commonRedisDao.cacheValue(key, value);
        return "done";
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get(String key)
    {
        return commonRedisDao.getValue(key);
    }
}
