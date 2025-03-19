package de.htmlfit.htmlfit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import de.htmlfit.services.AuthenticatedUserService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = AuthenticatedUserService.class)
public class WebSecurityConfig 
{

	   @Autowired
	   private AuthenticatedUserService userDetailsService;
	
	 /*  @SuppressWarnings("deprecation")
	@Bean
	   public static NoOpPasswordEncoder passwordEncoder() {
	       return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	   }*/
	   
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
			)
		
			.formLogin(form -> form
				.loginPage("/loginPage")
				.permitAll()
			);

		return http
				.build();
	}

	
	
	@Autowired
	   public void globalSecurityConfiguration(AuthenticationManagerBuilder auth) throws Exception {
	       auth.userDetailsService(userDetailsService);
	   }
	
	   
	   @SuppressWarnings("deprecation")
	   @Bean
	   public static NoOpPasswordEncoder passwordEncoder() {
	   return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	   }
	

	
	/*@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	    BCryptPasswordEncoder encoder = passwordEncoder();
	    auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}*/
	
	/*@Bean
	public AuthenticatedUserService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
*/
	
}