package com.example.springhessianconfig.config;

import com.example.springhessianconfig.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

@Configuration
public class HelloConfig {

    private final HelloService helloService;

    public HelloConfig(HelloService helloService) {
        this.helloService = helloService;
    }

    @Bean("/helloService")
    public RemoteExporter helloServiceExporter() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(helloService);
        exporter.setServiceInterface(HelloService.class);
        return exporter;
    }

}
