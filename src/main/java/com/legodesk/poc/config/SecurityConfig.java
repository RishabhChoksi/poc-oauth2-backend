package com.legodesk.poc.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;


@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> {
            authz.
                    requestMatchers("/campaigns/**").hasAnyRole("CAMPAIGN_MANAGEMENT")
                    .requestMatchers("/contacts/**").hasAnyRole("CONTACT_MANAGEMENT")
                    .requestMatchers("/loans/**").hasAnyRole("LOAN_ACCOUNT_MANAGEMENT")
                    .requestMatchers("/roles/**").hasAnyRole("ALLROLE_MANAGEMENT")
                    .requestMatchers("/settings/**").hasAnyRole("SETTINGS_MANAGEMENT")
                    .requestMatchers("/users/**").hasAnyRole("USER_MANAGEMENT")
                    .requestMatchers("/advertisement/**")
                    .permitAll();
        });
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
                configuration.setAllowedMethods(Collections.singletonList("*"));
                configuration.setAllowCredentials(true);
                configuration.setAllowedHeaders(Collections.singletonList("*"));
                configuration.setMaxAge(3600L);
                return configuration;
            }
        }));
        http.sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.oauth2ResourceServer(oauth2 -> {
            oauth2.jwt(jwtConfigurer -> {
                jwtConfigurer.jwtAuthenticationConverter(customJwtAuthenticationConverter());
            });
        });
        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter customJwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
        return converter;
    }


}
