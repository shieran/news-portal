package com.hancharou.newsportal.config;

import com.hancharou.newsportal.secutity.jwt.JwtConfigurer;
import com.hancharou.newsportal.secutity.jwt.JwtTokenProvider;
import com.hancharou.newsportal.secutity.jwt.JwtUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final JwtUserDetailsService jwtUserDetailsService;

    private static final String LOGIN_ENDPOINT = "/login";
    private static final String USER_BLOCK_ENDPOINT = "/users/*/block";
    private static final String USER_RESTORE_ENDPOINT = "/users/*/restore";
    private static final String REGISTRATION_ENDPOINT = "registration";
    private static final String SWAGGER_ENDPOINT = "/swagger-ui.html";
    private static final String SWAGGER_WEBJARS_ENDPOINT = "/webjars/**";
    private static final String SWAGGER_RESOURCES_ENDPOINT = "/swagger-resources/**";
    private static final String SWAGGER_V2_ENDPOINT = "/v2/**";

    public SecurityConfig(JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder, JwtUserDetailsService jwtUserDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .antMatchers(SWAGGER_ENDPOINT).permitAll()
                .antMatchers(SWAGGER_WEBJARS_ENDPOINT).permitAll()
                .antMatchers(SWAGGER_RESOURCES_ENDPOINT).permitAll()
                .antMatchers(SWAGGER_V2_ENDPOINT).permitAll()
                .antMatchers(REGISTRATION_ENDPOINT).permitAll()
                .antMatchers(USER_BLOCK_ENDPOINT).hasAuthority("ADMIN")
                .antMatchers(USER_RESTORE_ENDPOINT).hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }

}
