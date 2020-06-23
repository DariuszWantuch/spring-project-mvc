package pl.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;




@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return passwordEncoder;
	}
	
	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
	    StrictHttpFirewall firewall = new StrictHttpFirewall();
	    firewall.setAllowUrlEncodedSlash(true);    
	    return firewall;
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()	
			.antMatchers("/assets/**").permitAll()
			.antMatchers("/register").permitAll()
			.antMatchers("/user").permitAll()
			.antMatchers("/request").hasAuthority("ROLE_USER")
			.antMatchers("/manage").hasAuthority("ROLE_ADMIN")
			.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/loginform")
				.permitAll()
				.loginProcessingUrl("/processlogin")
				.permitAll()
				.defaultSuccessUrl("/secured", true)
		.and()
		.logout()
			.logoutUrl("/logmeout")
			.logoutSuccessUrl("/")
			.permitAll();		
		
		
		
	}
	
}
