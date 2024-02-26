package com.easylearn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

  @Autowired
  private UserDetailsService userDetailsService;

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.csrf((csrf) -> csrf.disable())
      .authorizeHttpRequests((requests) -> requests.requestMatchers("/dashboard").authenticated()
      .requestMatchers("", "/", "/home").permitAll()
      .requestMatchers("/holidays/**").permitAll()
      .requestMatchers("/contact").permitAll()
      .requestMatchers("/saveMsg").permitAll()
      .requestMatchers("/courses").permitAll()
      .requestMatchers("/about").permitAll()
      .requestMatchers("/login").permitAll()
      .requestMatchers("/assets/**").permitAll())
      .formLogin(loginConfigurer -> loginConfigurer.loginPage("/login")
        .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll())
      .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
        .invalidateHttpSession(true).permitAll())
      .httpBasic(Customizer.withDefaults())
      .userDetailsService(userDetailsService); // add this line
     
    return http.build();
  }

}
