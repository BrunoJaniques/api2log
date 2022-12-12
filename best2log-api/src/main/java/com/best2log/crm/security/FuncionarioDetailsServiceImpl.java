package com.best2log.crm.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.best2log.crm.entity.Funcionario;
import com.best2log.crm.repository.FuncionarioRepository;

// O FuncionarioDetailService e usado para recuperar os detalhes do funcionario que esta tentando se autenticar
// na aplicacao. Isso e feito atraves do metodo loadUserByUsername.
// Se o funcionario nao for encontrado e disparada uma excecao do tipo UsernameNotFoundException

@Component
public class FuncionarioDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Funcionario> funcionarioRes = funcionarioRepository.findByEmailFuncionario(email);
		if (funcionarioRes.isEmpty())
			throw new UsernameNotFoundException("Não foi possível encontrar usuário com o email = " + email);

		Funcionario funcionario = funcionarioRes.get();
		return new org.springframework.security.core.userdetails.User(email, funcionario.getSenhaFuncionario(),
				Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))); // Define, de forma estatica, //
																						// perfil do usuario encontrado
	}
}
