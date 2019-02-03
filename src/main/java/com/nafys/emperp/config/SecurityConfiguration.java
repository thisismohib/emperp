/*package com.nafys.emperp.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

	private static final String[] PUBLIC_MATCHERS = {
			"/css/**",
			"/js/**",
			"/image/**",
			"/",
			"/newUser",
			"/forgetPassword",
			"/login",
			"/fonts/**",
			"/api/employees"
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().
			antMatchers("/**").
			antMatchers(PUBLIC_MATCHERS).
			permitAll().anyRequest().authenticated();

		http
			.csrf().disable().cors().disable()
			.formLogin().failureUrl("/login?error")
			.defaultSuccessUrl("/")
			.loginPage("/login").permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll()
			.and()
			.rememberMe();
	}
}
*/