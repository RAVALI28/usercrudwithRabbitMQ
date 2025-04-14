package com.BasicCrudUserWithRabbitMQ.UserCrudWithRabbitMQ.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions().sameOrigin())
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/h2-console/**").permitAll()
                                .anyRequest().permitAll()
                        )
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();

    }




        @Bean
        public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
            // Creating an in-memory user with static password
            var uds = new InMemoryUserDetailsManager();
            uds.createUser(User.withUsername("admin")
                    .password(passwordEncoder().encode("password123")) // Static password: "password123"
                    .roles("USER")
                    .build());
            return uds;
        }

}
