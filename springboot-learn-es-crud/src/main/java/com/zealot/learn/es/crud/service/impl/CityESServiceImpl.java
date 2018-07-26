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
 * 2018年7月26日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.learn.es.crud.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zealot.learn.es.crud.dao.CityRepository;
import com.zealot.learn.es.crud.domain.City;
import com.zealot.learn.es.crud.service.CityService;

/**
 * @FileName CityESServiceImpl.java
 * @Description: 
 *
 * @Date 2018年7月26日 上午9:54:03
 * @author Zhao Haiming
 * @version 1.0
 */
@Service
public class CityESServiceImpl implements CityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityESServiceImpl.class);

    // 分页参数 -> TODO 代码可迁移到具体项目的公共 common 模块
    private static final Integer pageNumber = 0;
    private static final Integer pageSize = 10;
    Pageable pageable = new PageRequest(pageNumber, pageSize);

    // ES 操作类
    @Autowired
    CityRepository cityRepository;

    public Long saveCity(City city) {
        City cityResult = cityRepository.save(city);
        return cityResult.getId();
    }

    public List<City> findByDescriptionAndScore(String description, Integer score) {
        return cityRepository.findByDescriptionAndScore(description, score);
    }

    public List<City> findByDescriptionOrScore(String description, Integer score) {
        return cityRepository.findByDescriptionOrScore(description, score);
    }

    public List<City> findByDescription(String description) {
        return cityRepository.findByDescription(description, pageable).getContent();
    }

    public List<City> findByDescriptionNot(String description) {
        return cityRepository.findByDescriptionNot(description, pageable).getContent();
    }

    public List<City> findByDescriptionLike(String description) {
        return cityRepository.findByDescriptionLike(description, pageable).getContent();
    }

}