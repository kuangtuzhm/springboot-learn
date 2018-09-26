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

package com.zealot.mq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @FileName LoginMsgConsumer.java
 * @Description: 
 *
 * @Date 2018年9月26日 下午1:48:18
 * @author Zhao Haiming
 * @version 1.0
 */
@Component
public class LoginMsgConsumer {

	// 使用JmsListener配置消费者监听的队列，其中text是接收到的消息	
	@JmsListener(destination = "queue.live.login")	
	public void receiveQueue(String text) 
	{		
		System.out.println("Consumer收到的报文为:"+text);	
	}
 
}
