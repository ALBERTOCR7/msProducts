package com.compustore.products.config;

import com.compustore.products.security.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.http.HttpMethod;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

  private final JwtAuthFilter jwtFilter;
  public SecurityConfig(JwtAuthFilter jwtFilter){ this.jwtFilter = jwtFilter; }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable())
      .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .authorizeHttpRequests(auth -> auth
        .requestMatchers(
          "/swagger-ui.html","/swagger-ui/**",
          "/api-docs","/api-docs/**",
          "/v3/api-docs","/v3/api-docs/**",
          "/webjars/**","/error"
        ).permitAll()
        .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()

        .requestMatchers("/api/products","/api/products/*").hasAnyRole("ADMIN","CLIENT")
        .requestMatchers("/api/products/**").hasRole("ADMIN")
        .anyRequest().authenticated()
      )
      .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
