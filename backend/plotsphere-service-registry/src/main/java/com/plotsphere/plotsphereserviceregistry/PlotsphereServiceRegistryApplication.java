package com.plotsphere.plotsphereserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PlotsphereServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlotsphereServiceRegistryApplication.class, args);
    }

}
