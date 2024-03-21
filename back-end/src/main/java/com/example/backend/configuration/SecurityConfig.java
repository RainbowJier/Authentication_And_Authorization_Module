package com.example.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @projectName: Authentication_And_Authorization_Module
 * @package: com.example.backend.configuration
 * @className: SecurityConfig
 * @author: Rainbow
 * @description: The Configuration of Security to check the password.
 * @date: 2024/3/18 15:06
 * @version: 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 密码加密的方式
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * Access permission setting
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()           // Enable cross-origin configuration
                .and()
                .csrf().disable() // Disable CSRF
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/user/login", "/register").permitAll()
                .anyRequest().authenticated();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}