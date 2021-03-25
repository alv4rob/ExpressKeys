package es.urjc.code.dad.xkeys_web.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import es.urjc.code.dad.xkeys_web.model.Cliente;
import es.urjc.code.dad.xkeys_web.service.ClienteService;

@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private ClienteService clienteS;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		Cliente cliente = clienteS.findByNombre(auth.getName());

		if (cliente == null) {
			throw new BadCredentialsException("Nombre de usuario no encontrado");
		}

		String password = (String) auth.getCredentials();
		if (!new BCryptPasswordEncoder().matches(password, cliente.getPasswordHash())) {
			throw new BadCredentialsException("Contraseña incorrecta");
		}

		List<GrantedAuthority> roles = new ArrayList<>();
		for (String role : cliente.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		
		return new UsernamePasswordAuthenticationToken(cliente.getNombre(), password, roles);
	}

	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}
}