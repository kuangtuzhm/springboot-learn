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
 * 2018年7月6日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
 */

package com.zealot.learn.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @FileName Listener.java
 * @Description:
 * 
 * @Date 2018年7月6日 上午9:52:07
 * @author Zhao Haiming
 * @version 1.0
 */
public class Listener {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = { "flume.log.test" })
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("kafka的key: " + record.key());
        logger.info("kafka的value: " + record.value().toString());
    }
}
