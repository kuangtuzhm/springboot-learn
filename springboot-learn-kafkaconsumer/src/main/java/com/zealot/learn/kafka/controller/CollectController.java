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

package com.zealot.learn.kafka.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @FileName CollectController.java
 * @Description: 
 *
 * @Date 2018年7月6日 上午9:43:32
 * @author Zhao Haiming
 * @version 1.0
 */
@RestController
@RequestMapping("/kafka")
public class CollectController {
 protected final Logger logger = LoggerFactory.getLogger(this.getClass());
 
 @Autowired
 private KafkaTemplate<String,String> kafkaTemplate;
 
 @RequestMapping(value = "/send", method = RequestMethod.GET)
 @ResponseBody
 public String sendKafka(HttpServletRequest request, HttpServletResponse response) {
  try {
   String message = request.getParameter("message");
   message="测试消息key=";
   for(int i = 0;i<10;i++)
   {
       logger.info("kafka的消息={}", message+i);
       kafkaTemplate.send("flume.log.test", String.valueOf(i), message+i);
       logger.info("发送kafka成功.");
   }
   return "发送kafka成功";
  } catch (Exception e) {
   logger.error("发送kafka失败", e);
   return "发送kafka失败";
  }
 }
}