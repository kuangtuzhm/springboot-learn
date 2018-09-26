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

package com.zealot.mq.queue.producer;


import cn.lzg.mq.dto.MessageDto;
import cn.lzg.mq.utils.ProtoStuffSerializerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 生产者类
 * @Author lzg
 * @Date 2016/12/23 23:19
 */
@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue testQueue;

    @Autowired
    private Topic testTopic;

    @Autowired
    private Queue testQueueObj;

    public void sendQueueText(String msg)  {
        this.jmsMessagingTemplate.convertAndSend(this.testQueue, msg);
    }

    public void sendTopicText(String msg)  {
        this.jmsMessagingTemplate.convertAndSend(this.testTopic, msg);
    }

    public void sendQueueObj(MessageDto msg)  {
        this.jmsMessagingTemplate.convertAndSend(this.testQueueObj, ProtoStuffSerializerUtil.serialize(msg));
    }
}