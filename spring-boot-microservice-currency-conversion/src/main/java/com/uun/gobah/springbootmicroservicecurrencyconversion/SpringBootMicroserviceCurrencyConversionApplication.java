package com.uun.gobah.springbootmicroservicecurrencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.uun.gobah.springbootmicroservicecurrencyconversion.feign")
@EnableDiscoveryClient
public class SpringBootMicroserviceCurrencyConversionApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootMicroserviceCurrencyConversionApplication.class, args);

		for (String name : context.getBeanDefinitionNames()){
			System.out.println(name);
		}
	}
}
