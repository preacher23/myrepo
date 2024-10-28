package com.dailycodebuffer.apigateway.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class Oktaoauth2 {

    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity security){
        security.authorizeExchange().anyExchange().authenticated().and().oauth2Login().
                and().oauth2ResourceServer().jwt();
        return security.build();
    }
}
