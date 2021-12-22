package com.gateway.Spring.Cloud.Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);
	}
}

@Configuration
class GatewayConfiguration{

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder rlb){
		return rlb.routes()
				.route(p->p
						.path("/rating/**")
						.uri("http://localhost:8082")
				)
				.route(p->p
						.path("/actors/**")
						.filters(f -> f
								.addRequestHeader("x-rapidapi-host","imdb8.p.rapidapi.com")
								.addRequestHeader("x-rapidapi-key","1ef7713c70mshfdd950e72ee08a7p14f736jsn30b99e581ea4"))
						.uri("https://imdb8.p.rapidapi.com")
				)
				.route(pre ->  pre
						.path("/products.json")
						.uri("https://dnc0cmt2n557n.cloudfront.net/")
				)
				.build();
	}
}
