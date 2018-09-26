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

package com.zealot.mq.queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定义队列和topic的类
 * @Author lzg
 * @Date 2016/12/24 12:22
 */
@Configuration
public class QueueDefine {
    /**
     * 定义test.queue Queue
     */
    @Bean(name = "testQueue")
    public javax.jms.Queue testQueue() {
        return new ActiveMQQueue("test.queue");
    }

    /**
     * 定义test.topic Topic
     */
    @Bean(name = "testTopic")
    public javax.jms.Topic testTopic() {
        return new ActiveMQTopic("test.topic");
    }

    /**
     * 定义test.queue.obj Queue
     */
    @Bean(name = "testQueueObj")
    public javax.jms.Queue testQueueObj() {
        return new ActiveMQQueue("test.queue.obj");
    }
}