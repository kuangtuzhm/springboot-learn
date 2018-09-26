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
 * 2018年9月26日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.mq.producer;

import javax.jms.Destination;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
 
/**
 * @FileName Producer.java
 * @Description: 
 *
 * @Date 2018年9月26日 下午1:43:50
 * @author Zhao Haiming
 * @version 1.0
 */
@Service("producer")
public class MQProducer {

	@Autowired // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
	private JmsMessagingTemplate jmsMessagingTemplate;
	// 发送消息，destination是发送到的队列，message是待发送的消息
	public void sendMessage(Destination destination, final String message){
		jmsMessagingTemplate.convertAndSend(destination, message);
	}
}
