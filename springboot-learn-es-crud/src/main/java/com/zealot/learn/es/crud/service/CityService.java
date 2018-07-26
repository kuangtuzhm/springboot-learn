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

package com.zealot.learn.es.crud.service;

import java.util.List;

import com.zealot.learn.es.crud.domain.City;

/**
 * @FileName CityService.java
 * @Description: 
 *
 * @Date 2018年7月26日 上午9:53:15
 * @author Zhao Haiming
 * @version 1.0
 */
public interface CityService {

    /**
     * 新增 ES 城市信息
     *
     * @param city
     * @return
     */
    Long saveCity(City city);

    /**
     * AND 语句查询
     *
     * @param description
     * @param score
     * @return
     */
    List<City> findByDescriptionAndScore(String description, Integer score);

    /**
     * OR 语句查询
     *
     * @param description
     * @param score
     * @return
     */
    List<City> findByDescriptionOrScore(String description, Integer score);

    /**
     * 查询城市描述
     *
     * @param description
     * @return
     */
    List<City> findByDescription(String description);

    /**
     * NOT 语句查询
     *
     * @param description
     * @return
     */
    List<City> findByDescriptionNot(String description);

    /**
     * LIKE 语句查询
     *
     * @param description
     * @return
     */
    List<City> findByDescriptionLike(String description);
}
