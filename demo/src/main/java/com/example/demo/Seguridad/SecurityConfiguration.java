package com.example.demo.Seguridad;

import com.example.demo.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


    @Configuration
    @EnableWebSecurity
    public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private UsuarioServicio usuarioServicio;


        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            auth.userDetailsService(usuarioServicio);
        }

        @Bean
        public BCryptPasswordEncoder passwordEncoder(){

            return new BCryptPasswordEncoder();
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers(
                            "/registro**",
                            "/js/**",
                            "/css/**",
                            "/img/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                    .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .permitAll();
        }

        }



