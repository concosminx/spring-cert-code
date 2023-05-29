package com.nimsoc.springsec.config;


import com.nimsoc.springsec.config.security.filters.CustomAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

//TODO - custom authentication
@Configuration
public class FilterSecurityConfig {

  //private final CustomAuthenticationFilter customAuthenticationFilter;
  @Value("${a.real.secret.key}")
  private String key;


  //add our filter
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.httpBasic()
        .and()
        .addFilterBefore(new CustomAuthenticationFilter(key), BasicAuthenticationFilter.class)
        .authorizeRequests().anyRequest().authenticated()   // authorization
        //.and().authenticationManager()   or  by adding a bean of type AuthenticationManager
        //.and().authenticationProvider() it doesn't override the AP, it adds one more to the collection
        .and().build();
  }

}
