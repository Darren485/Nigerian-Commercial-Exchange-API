package com.example.niceapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.niceapi.security.CustomAccessDeniedHandler;
import com.example.niceapi.security.CustomAuthenticationEntryPoint;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authEntryPoint;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService,
            CustomAccessDeniedHandler accessDeniedHandler,
            CustomAuthenticationEntryPoint authEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.accessDeniedHandler = accessDeniedHandler;
        this.authEntryPoint = authEntryPoint;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(form -> form.disable())
                .httpBasic(basic -> {})
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .requestMatchers("/v3/api-docs/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/companies/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/assets/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/companies/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/companies/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/companies/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/v1/assets/**").hasAnyRole("ADMIN", "TRADER")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/assets/**").hasAnyRole("ADMIN", "TRADER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/assets/**").hasAnyRole("ADMIN", "TRADER")
                        .requestMatchers(HttpMethod.POST, "/api/v1/transactions/**").hasAnyRole("ADMIN", "TRADER")
                        .requestMatchers(HttpMethod.GET, "/api/v1/transactions/**")
                        .hasAnyRole("ADMIN", "ANALYST", "TRADER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/transactions/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/contact/**").authenticated()
                        .anyRequest().authenticated())
                .exceptionHandling(ex -> ex
                        .accessDeniedHandler(accessDeniedHandler)
                        .authenticationEntryPoint(authEntryPoint));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
