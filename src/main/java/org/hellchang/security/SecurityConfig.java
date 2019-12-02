package org.hellchang.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()

                .authorizeRequests()
                .antMatchers("/").access("hasRole('ANONYMOUS')")
                .antMatchers("/"
                , "/api/**"
                , "/h2-console/**")
                .permitAll()

                .and()

                .formLogin()
                .failureUrl("/login?error=true");
    }

}
