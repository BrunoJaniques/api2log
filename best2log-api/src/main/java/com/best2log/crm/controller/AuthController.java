package com.best2log.crm.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.best2log.crm.dto.CredenciaisLoginDTO;
import com.best2log.crm.entity.Funcionario;
import com.best2log.crm.security.JWTUtil;
import com.best2log.crm.service.FuncionarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	// Injecting Dependencies
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// Registro de funcionario
	@PostMapping("/registro")
	public Map<String, Object> registerHandler(@RequestBody Funcionario funcionario) {
		// Encriptando a senha usando o Bcrypt
		String encodedPass = passwordEncoder.encode(funcionario.getSenhaFuncionario());
		funcionario.setSenhaFuncionario(encodedPass);

		funcionario = funcionarioService.saveFuncionario(funcionario);

		// Gerando o token JWT a partir do e-mail do funcionario
		// String token = jwtUtil.generateToken(funcionario.getEmail());

		// Gerando o token JWT a partir dos dados do funcionario
		Funcionario funcionarioResumido = new Funcionario();
		funcionarioResumido.setIdFuncionario(funcionario.getIdFuncionario());
		funcionarioResumido.setNomeFuncionario(funcionario.getNomeFuncionario());
		funcionarioResumido.setEmailFuncionario(funcionario.getEmailFuncionario());
		funcionarioResumido.setRgFuncionario(funcionario.getRgFuncionario());
		funcionarioResumido.setCpfFuncionario(funcionario.getCpfFuncionario());
		funcionarioResumido.setFuncaoFuncionario(funcionario.getFuncaoFuncionario());
		funcionarioResumido.setStatusFuncionario(funcionario.getStatusFuncionario());
		String token = jwtUtil.generateTokenWithUserData(funcionarioResumido);
		System.out.println("eu");


		// Retornando a resposta com o JWT
		return Collections.singletonMap("jwt-token", token);
	}
	// Login de usuario

	@PostMapping("/login")
	public Map<String, Object> loginHandler(@RequestBody CredenciaisLoginDTO credenciaisLoginDTO) {
		try {
			// Criando o token que sera usado no processo de autenticacao
			UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
					credenciaisLoginDTO.getEmail(), credenciaisLoginDTO.getSenha());

			// Autenticando as credenciais de login
			authManager.authenticate(authInputToken);

			// Se o processo de autenticacao foi concluido com sucesso - etapa anterior,
			// eh gerado o JWT
			// String token = jwtUtil.generateToken(body.getEmail());

			Funcionario funcionario = funcionarioService.findByEmail(credenciaisLoginDTO.getEmail());
			Funcionario funcionarioResumido = new Funcionario();
			funcionarioResumido.setNomeFuncionario(funcionario.getNomeFuncionario());
			funcionarioResumido.setEmailFuncionario(funcionario.getEmailFuncionario());
			funcionarioResumido.setIdFuncionario(funcionario.getIdFuncionario());
			// Gerando o token JWT a partir dos dados do Usuario
			String token = jwtUtil.generateTokenWithUserData(funcionarioResumido);

			// Responde com o JWT
			Map<String, Object>mapa = new HashMap<>();
			mapa.put("jwt-token", token);
			mapa.put("funcao", funcionario.getFuncaoFuncionario().toString());
			return mapa;
		} catch (AuthenticationException authExc) {
			throw new RuntimeException("Credenciais Invalidas");
		}

	}

}
