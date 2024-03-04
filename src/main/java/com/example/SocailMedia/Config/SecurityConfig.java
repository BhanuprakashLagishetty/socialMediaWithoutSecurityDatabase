package com.example.SocailMedia.Config;//package com.example.SocailMedia.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                        .requestMatchers(HttpMethod.POST,"/Register").hasAnyRole("ADMIN","USER")
//                        .requestMatchers(HttpMethod.GET,"/viewUsers" ).hasRole("USER")
//                        .requestMatchers(HttpMethod.DELETE,"/hotels/delete/*").hasRole("ADMIN"));
//
//        http.httpBasic(Customizer.withDefaults());
//
//        //disable cross Site request Forgery(CSRF)
//        http.csrf(AbstractHttpConfigurer::disable);
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        return new InMemoryUserDetailsManager(
//                org.springframework.security.core.userdetails.User.withUsername("admin")
//                        .password(passwordEncoder().encode("admin"))
//                        .roles("ADMIN")
//                        .build(),
//                org.springframework.security.core.userdetails.User.withUsername("user")
//                        .password(passwordEncoder().encode("user"))
//                        .roles("USER")
//                        .build()
//        );
//    }
//}
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                authorizeRequests
                        .requestMatchers(HttpMethod.POST,"/SaveUser").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.GET,"/hotels/*").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.DELETE,"/hotels/delete/*").hasRole("ADMIN"));
        http.httpBasic(Customizer.withDefaults());

        //disable cross Site request Forgery(CSRF)
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(
                org.springframework.security.core.userdetails.User.withUsername("admin")
                        .password(passwordEncoder().encode("admin"))
                        .roles("ADMIN")
                        .build(),
                org.springframework.security.core.userdetails.User.withUsername("user")
                        .password(passwordEncoder().encode("user"))
                        .roles("USER")
                        .build()
        );
    }
}