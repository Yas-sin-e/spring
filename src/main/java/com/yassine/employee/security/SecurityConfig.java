package com.yassine.employee.security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;



@Configuration

public class SecurityConfig {



    @Bean

    public PasswordEncoder passwordEncoder () {

        return new BCryptPasswordEncoder();

    }



// @Bean

// public InMemoryUserDetailsManager userDetailsService() {

// PasswordEncoder encoder = passwordEncoder();

//

// UserDetails admin = User.withUsername("admin")

// .password(encoder.encode("123")).authorities("ADMIN").build();

//

// UserDetails agent = User.withUsername("yassine")

// .password(encoder.encode("123")).authorities("AGENT","USER").build();

// UserDetails user = User.withUsername("user")

// .password(encoder.encode("123")).authorities("USER").build();

//

// return new InMemoryUserDetailsManager(admin, agent, user);

// }



    @Bean

    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> requests

                        .requestMatchers("/login", "/webjars/**","/resources/**").permitAll() // Autorise le login et le CSS

                        .requestMatchers("/showCreate", "/saveEmployee").hasAnyAuthority("ADMIN", "AGENT")

                        .requestMatchers("/modifierEmployee", "/supprimerEmployee").hasAuthority("ADMIN")

                        .requestMatchers("/listeEmployees").hasAnyAuthority("ADMIN", "AGENT", "USER")

                        .anyRequest().authenticated())



                .formLogin((formLogin) -> formLogin

                        .loginPage("/login")

                        .defaultSuccessUrl("/")

                        .permitAll()) // Très important







                .httpBasic(Customizer.withDefaults())



                .exceptionHandling((exception) -> exception.accessDeniedPage("/accessDenied"));



        return http.build();

    }

}