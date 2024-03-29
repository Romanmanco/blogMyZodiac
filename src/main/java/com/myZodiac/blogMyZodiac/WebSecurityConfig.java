//package com.myZodiac.blogMyZodiac;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.authentication.PasswordEncoderParser;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("123")
//                .roles("ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/profilePage").hasAnyRole("USER","ADMIN")
//                .antMatchers("/**").permitAll()
////                .antMatchers("/**").hasRole("ADMIN")
//                .and().formLogin();
//
//    }
//
//    @Bean
//    public PasswordEncoder encoder(){
//
//        return NoOpPasswordEncoder.getInstance();
//
//    }
//}
