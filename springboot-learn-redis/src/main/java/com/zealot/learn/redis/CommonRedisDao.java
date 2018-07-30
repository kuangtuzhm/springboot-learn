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

package com.zealot.learn.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.core.ListOperations;

/**
 * @FileName CommonRedisDao.java
 * @Description: 
 *
 * @Date 2018年7月27日 上午8:51:19
 * @author Zhao Haiming
 * @version 1.0
 */
public interface CommonRedisDao {

    /**
     * 添加
     *
     * @param key
     * @param value
     * @param time
     * @return
     */
    boolean cacheValue(String key, String value, long time);

    /**
     * 添加
     *
     * @param key
     * @param value
     * @return
     */
    boolean cacheValue(String key, String value);

    /**
     * 是否包含
     *
     * @param key
     * @return
     */
    boolean containsValueKey(String key);

    /**
     * 是否包含
     *
     * @param key
     * @return
     */
    boolean containsSetKey(String key);

    /**
     * 是否包含
     *
     * @param key
     * @return
     */
    boolean containsListKey(String key);

    /**
     * 是否包含
     *
     * @param key
     * @return
     */
    boolean containsKey(String key);

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    String getValue(String key);

    /**
     * 移除缓存
     *
     * @param key
     * @return
     */
    boolean removeValue(String key);

    /**
     * 移除缓存
     *
     * @param key
     * @return
     */
    boolean removeSet(String key);

    /**
     * 移除缓存
     *
     * @param key
     * @return
     */
    boolean removeList(String key);

    /**
     * 缓存Set
     *
     * @param key
     * @param value
     * @param time
     * @return
     */
    boolean cacheSet(String key, String value, long time);

    /**
     * 缓存Set
     *
     * @param key
     * @param value
     * @return
     */
    boolean cacheSet(String key, String value);

    /**
     * 缓存Set
     *
     * @param k
     * @param v
     * @param time
     * @return
     */
    boolean cacheSet(String k, Set<String> v, long time);

    /**
     * 缓存Set
     *
     * @param k
     * @param v
     * @return
     */
    boolean cacheSet(String k, Set<String> v);

    /**
     * 获取Set
     *
     * @param k
     * @return
     */
    Set<String> getSet(String k);

    /**
     * 缓存List
     *
     * @param k
     * @param v
     * @param time
     * @return
     */
    boolean cacheList(String k, String v, long time);

    /**
     * 缓存List
     *
     * @param k
     * @param v
     * @return
     */
    boolean cacheList(String k, String v);

    /**
     * 缓存List
     *
     * @param k
     * @param v
     * @param time
     * @return
     */
    boolean cacheList(String k, List<String> v, long time);

    /**
     * 缓存List
     *
     * @param k
     * @param v
     * @return
     */
    boolean cacheList(String k, List<String> v);

    /**
     * 获取List
     *
     * @param k
     * @param start
     * @param end
     * @return
     */
    List<String> getList(String k, long start, long end);

    /**
     * 获取页码
     *
     * @param key
     * @return
     */
    long getListSize(String key);

    /**
     * 获取页码
     *
     * @param listOps
     * @param k
     * @return
     */
    long getListSize(ListOperations<String, String> listOps, String k);

    /**
     * 移除list缓存
     *
     * @param k
     * @return
     */
    boolean removeOneOfList(String k);
    
    /**
     * @Title: multiSet 
     * @Description:批量缓存
     * @param map
     * @return 
     * @author Zhao Haiming
     * @date 2018年7月27日 下午5:50:34
     */
    public boolean multiSet(Map<String,String> map);
    
    /**
     * @Title: multiSet 
     * @Description:批删
     * @param keys
     * @return 
     * @author Zhao Haiming
     * @date 2018年7月27日 下午5:57:16
     */
    public boolean multiDel(List<String> keys);
    
    public String get(String key);
}
