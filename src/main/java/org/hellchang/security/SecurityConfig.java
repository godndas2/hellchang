package org.hellchang.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // TODO Unknown integral data type for ids
    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers( "/v2/api-docs",
                "/swagger-resources/**",
                "/swagger-ui.html",
                "/webjars/**",
                "/swagger/**",
                "/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()

                .authorizeRequests()
                .antMatchers("/api/**").access("hasRole('ROLE_?USER')")

                .and()

                .authorizeRequests()
                .antMatchers("/v1/signup").permitAll()

                .and()

                .formLogin()
                .defaultSuccessUrl("/api/")
                .failureUrl("/login?error=true");
    }

}
