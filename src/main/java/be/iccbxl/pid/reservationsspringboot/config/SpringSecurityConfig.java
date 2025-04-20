package be.iccbxl.pid.reservationsspringboot.config;
//… (import)

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {
    //…
    @Bean
    public SecurityFilterChain configure(final HttpSecurity http) throws Exception {
        return http.cors(Customizer.withDefaults())
                .csrf(Customizer.withDefaults())
                //.csrf(csrf -> csrf.disable())	//Désactiver la protection des formulaires
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/admin").hasRole("ADMIN");
                    auth.requestMatchers("/user").hasRole("MEMBER");

                    //API
                    auth.requestMatchers("/api/public/**").permitAll(); // Endpoints publics
                    auth.requestMatchers("/api/admin/**").hasRole("ADMIN"); // Endpoints réservés aux administrateurs

                    auth.anyRequest().permitAll();
                })
                .httpBasic(Customizer.withDefaults()) // Permet l'authentification de base (utile pour les tests)
                .formLogin(form -> form
                        .loginPage("/login")
                        .usernameParameter("login")
                        .failureUrl("/login?loginError=true"))
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logoutSuccess=true")
                        .deleteCookies("JSESSIONID"))
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login?loginRequired=true")))
                .build();
    }

}
