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

package com.zealot.learn.es.crud.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @FileName City.java
 * @Description: 城市实体类
 *
 * @Date 2018年7月26日 上午9:50:19
 * @author Zhao Haiming
 * @version 1.0
 */
@Document(indexName = "province", type = "city")
public class City implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 城市编号
     */
    @Id
    private Long id;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 城市评分
     */
    private Integer score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}