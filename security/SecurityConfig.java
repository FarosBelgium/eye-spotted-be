package com.faros.EyeSpotted.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain contactcenterSecurityFilterChain(HttpSecurity http, EyeSpottedAuthenticationTokenFactory authenticationTokenFactory) throws Exception {
        final String[] matchers = new String[] {"/expeditions/**", "/animals/**", "/expedition-targets/**", "/tags/**", "/users/**"};

        http.securityMatcher(matchers).addFilterBefore(new EyeSpottedAuthenticationFilter(authenticationTokenFactory), BasicAuthenticationFilter.class)
                .authorizeHttpRequests((customizer) -> customizer.requestMatchers(matchers).authenticated());

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
