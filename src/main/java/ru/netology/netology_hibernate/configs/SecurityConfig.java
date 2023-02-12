package ru.netology.netology_hibernate.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.*; annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Tom").password("{noop}qwerty").authorities("City")
                .and()
                .withUser("Admin").password("{noop}admin").authorities("Admin")
                .and()
                .withUser("Olga").password("{noop}1qw24e").authorities("Age");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and()
                .authorizeHttpRequests().antMatchers("/persons/user-city/**").hasAnyAuthority("City", "Admin")
                .and()
                .authorizeHttpRequests().antMatchers("/persons/user-age/**").hasAnyAuthority("Age", "Admin")
                .and()
                .authorizeHttpRequests().antMatchers("/persons/admin/**").hasAuthority("Admin")
                .and()
                .authorizeHttpRequests().antMatchers("/persons/").permitAll()
                .and()
                .authorizeHttpRequests().anyRequest().authenticated();


    }
}