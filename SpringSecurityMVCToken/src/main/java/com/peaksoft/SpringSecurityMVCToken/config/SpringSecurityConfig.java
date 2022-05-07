package com.peaksoft.SpringSecurityMVCToken.config;

import com.peaksoft.SpringSecurityMVCToken.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImpl service;
    private final JWTTokenFilter tokenFilter;

    public SpringSecurityConfig(UserServiceImpl service, JWTTokenFilter tokenFilter) {
        this.service = service;
        this.tokenFilter = tokenFilter;
    }

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/jwt/**").permitAll()
                .antMatchers("/v3/api-docs/**", "/swagger-ui/**", "swagger-ui.html").permitAll()
                .antMatchers("/api/company/**").permitAll()
                .antMatchers("/api/course/**").permitAll()
                .antMatchers("/api/group/**").permitAll()
                .antMatchers("/api/teacher/**").permitAll()
                .antMatchers("/api/student/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
