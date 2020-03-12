/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2020.
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
 * 2020年3月12日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.learn.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @FileName Producer.java
 * @Description: 
 *
 * @Date 2020年3月12日 下午3:27:05
 * @author Zhao Haiming
 * @version 1.0
 */
@Component
public class Producer {
    private String producerGroup = "test_producer";
    private DefaultMQProducer producer;
    
    @Value("${rocket.server.addr}")
    public String rocketServer;
    
    /**
     * 对象在使用之前必须要调用一次，只能初始化一次
     */
    public void start(){
        try {
        	//示例生产者
            producer = new DefaultMQProducer(producerGroup);
            //不开启vip通道 开通口端口会减2
            producer.setVipChannelEnabled(false);
            //绑定name server
            producer.setNamesrvAddr(rocketServer);
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
  
    public DefaultMQProducer getProducer(){
        return this.producer;
    }
    /**
     * 一般在应用上下文，使用上下文监听器，进行关闭
     */
    public void shutdown(){
        this.producer.shutdown();
    }
}