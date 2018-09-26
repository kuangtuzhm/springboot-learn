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
 * 2018年9月21日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.mq.controller;

import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zealot.mq.producer.MQProducer;


/**
 * @FileName TestController.java
 * @Description: 
 *
 * @Date 2018年9月21日 上午9:53:01
 * @author Zhao Haiming
 * @version 1.0
 */
@Controller
public class TestController {
	
	private static Destination destination = new ActiveMQQueue("queue.live.login");
	
	
	@Autowired
	private MQProducer producer;

	@RequestMapping("/send")
	@ResponseBody
	public String send(HttpServletRequest request, HttpServletResponse response)
	{
		producer.sendMessage(destination, "ffffffffffff");
		return "success";
	}
}
