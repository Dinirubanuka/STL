package com.stl.gateway.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpHeaders;

import java.util.List;

@Component
public class ServerHttpBearerAuthenticationConverter implements ServerAuthenticationConverter {

    private final JwtTokenProvider jwtTokenProvider;

    public ServerHttpBearerAuthenticationConverter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String authToken = authHeader.substring(7);
            if (jwtTokenProvider.validateToken(authToken)) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        jwtTokenProvider.getUsernameFromToken(authToken),
                        null,
                        List.of(new SimpleGrantedAuthority("ROLE_USER")) // Add roles/authorities here
                );
                return Mono.just(authentication);
            }
        }
        return Mono.empty();
    }
}
