package com.kuang.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClienConfigController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String config_info;

    @GetMapping("/getinfo")
    public String getConfig_info() {
        return "serverPort: "+serverPort+"\t\n\n configInfo: "+config_info;
    }
}
