package com.feiniu.springcloud.alibaba;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxin
 * @date 2021/1/31 15:18
 * @description:
 */
@RestController
@RefreshScope  //支持nacos的动态刷新
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
