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

import java.util.List;

import javax.annotation.Resource;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * This example shows how to subscribe and consume messages using providing {@link DefaultMQPushConsumer}.
 */
@Service
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class.getName());
	
	
	 @Value("${rocket.server.addr}")
	 private String rocketServer;
	 
        /**
         * 消费者组
         */
        public static final String CONSUMER_GROUP = "test_consumer";

        
        public void start()
        {
        	try {
        		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(CONSUMER_GROUP);
				consumer.setNamesrvAddr(rocketServer);
				//消费模式:一个新的订阅组第一次启动从队列的最后位置开始消费 后续再启动接着上次消费的进度开始消费
				consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
				//订阅主题和 标签（ * 代表所有标签)下信息
				consumer.subscribe(JmsConfig.TOPIC, "*");
				// //注册消费的监听 并在此监听中消费信息，并返回消费的状态信息
				consumer.registerMessageListener(new MessageListenerConcurrently() {

				    @Override
				    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				    	logger.info("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
				        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				    }
       
				});

				consumer.start();
				logger.info("消费者启动成功=======");
			} catch (MQClientException e) {
				logger.error("消费者启动失败=======",e);
			}
        }
        
        
        
}