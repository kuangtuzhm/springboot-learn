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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @FileName JmsConfig.java
 * @Description: 
 *
 * @Date 2020年3月12日 下午3:24:46
 * @author Zhao Haiming
 * @version 1.0
 */
/**
 * @Description: 安装实际开发这里的信息 都是应该写在配置里，来读取，这里为了方便所以写成常量
 */
@Component
public class JmsConfig {
    /**
     * Name Server 地址，因为是集群部署 所以有多个用 分号 隔开
     */
	@Value("{rocket.server.addr}")
    public String rocketServer;
    /**
     * 主题名称 主题一般是服务器设置好 而不能在代码里去新建topic（ 如果没有创建好，生产者往该主题发送消息 会报找不到topic错误）
     */
    public static final String TOPIC = "topic_family";
    
    
	public String getRocketServer() {
		return rocketServer;
	}
	public void setRocketServer(String rocketServer) {
		this.rocketServer = rocketServer;
	}
    
    

}