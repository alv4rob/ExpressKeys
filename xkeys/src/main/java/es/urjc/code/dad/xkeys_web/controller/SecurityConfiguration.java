package es.urjc.code.dad.xkeys_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/loginerror").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		http.authorizeRequests().antMatchers("/registro").permitAll();
		http.authorizeRequests().antMatchers("/registrado").permitAll();
		http.authorizeRequests().antMatchers("/producto/{id}").permitAll();
		
		// Private pages (all other pages)
		http.authorizeRequests().antMatchers("/home").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/perfil").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/clientes").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/clientes/{id}").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/clientes/{id}/eliminar").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/producto/{id}/introducirValoracion").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/producto/{id}/ValoracionEnviada").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/comprar").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/carrito").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/producto/nuevo1").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("producto/nuevo").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/producto/{id}/eliminar").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/producto/{id}/anadido").hasAnyRole("ADMIN","USER");
       
               
		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/home");
		http.formLogin().failureUrl("/loginerror");
		
		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");	
	}
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider);	    		    	
	}	
}