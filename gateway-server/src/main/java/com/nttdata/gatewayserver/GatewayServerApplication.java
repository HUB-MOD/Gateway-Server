package com.nttdata.gatewayserver;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import reactor.netty.http.client.HttpClient;

@EnableEurekaClient
@SpringBootApplication
public class GatewayServerApplication {

	@Bean
	public HttpClient httpClient(){
		return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
	}

	/*@Bean
	public RouteLocator customRoutes(RouteLocatorBuilder builder){

		return builder.routes()
				.route(p -> p
						.path("/account/getAll")
						.uri("http://localhost:8091")) //http://localhost:8091/account/getAll
				.route(p -> p
						.path("/getAll")
						.filters(f -> f.prefixPath("/account"))
						.uri("http://localhost:8091")) //http://localhost:8091/account/getAll
				.route(p -> p
						.path("/getAllAccounts")
						.filters(f -> f.setPath("/account/getAll"))
						.uri("http://localhost:8091")) //http://localhost:8091/account/getAll
				.build();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

}
