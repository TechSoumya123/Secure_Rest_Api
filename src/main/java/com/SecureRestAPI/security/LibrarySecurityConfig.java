package com.SecureRestAPI.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@SuppressWarnings("removal")
public class LibrarySecurityConfig {

	private static final String[] SECURED_URLs = { "/books/**" };
	private static final String[] UN_SECURED_URLs = { "/books/getAll", "/books/book/{id}", "/users/**" };

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf().disable().authorizeHttpRequests().requestMatchers(UN_SECURED_URLs).permitAll().and()
				.authorizeHttpRequests().requestMatchers(SECURED_URLs).hasAuthority("ADMIN").anyRequest()
				.authenticated().and().httpBasic().and().build();
		/*
		 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
		 * throws Exception { http .authorizeHttpRequests()
		 * .requestMatchers("/**").hasRole("USER") .and() .formLogin(); return
		 * http.build(); }
		 */

		/*
		 * http .csrf((csrf) -&gt; csrf.disable()); return http.build(); return
		 * http.authorizeHttpRequests(autherize -> {
		 * autherize.requestMatchers(UN_SECURED_URLs).permitAll().anyRequest();
		 * 
		 * }).formLogin(formLogin -> formLogin.loginPage("/login").permitAll()).build();
		 * return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(autherize -> {
		 * autherize.requestMatchers(UN_SECURED_URLs).permitAll().anyRequest();
		 * }).formLogin(formLogin -> formLogin.loginPage("/login").permitAll()).build();
		 */

	}
}

/*
 * http .csrf((csrf) -&gt; csrf.disable()); return http.build(); return
 * http.authorizeHttpRequests(autherize -> {
 * autherize.requestMatchers(UN_SECURED_URLs).permitAll().anyRequest();
 * }).formLogin(Customizer.withDefaults()).build();
 */

/*
 * http.authorizeHttpRequests(authorize ->
 * authorize.requestMatchers(UN_SECURED_URLs).permitAll())
 * .requestMatchers(SECURED_URLs).hasRole("ADMIN").anyRequest().permitAll().
 * anyRequest().authenticated();
 */
/*
 * http.authorizeHttpRequests(authorize ->
 * authorize.requestMatchers(UN_SECURED_URLs).permitAll().anyRequest());
 * 
 * http.authorizeHttpRequests( authorize ->
 * authorize.requestMatchers(SECURED_URLs).permitAll().anyRequest().
 * authenticated());
 * 
 * return http.build();
 */

/*
 * http.authorizeHttpRequests((t)->t.requestMatchers(SECURED_URLs).
 * hasAnyAuthority("ADMIN") .anyRequest().authenticated());
 */

/*
 * return
 * http.csrf().disable().authorizeHttpRequests().requestMatchers(UN_SECURED_URLs
 * ).permitAll().and()
 * .authorizeHttpRequests().requestMatchers(SECURED_URLs).hasAuthority("ADMIN").
 * anyRequest() .authenticated().and().formLogin().and().build();
 */
/*
 * http .authorizeRequests((authorizeRequests) ->; authorizeRequests
 * .requestMatchers(&quot;/**&quot;).hasRole(&quot;USER&quot;) )
 * .formLogin(withDefaults()); return http.build();
 */
