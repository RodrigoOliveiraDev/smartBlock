package com.projetct.smartBlock.resource;

import com.projetct.smartBlock.aux.AuthenticationDTO;
import com.projetct.smartBlock.aux.LoginResponseDTO;
import com.projetct.smartBlock.aux.RegisterDTO;
import com.projetct.smartBlock.model.Pessoa;
import com.projetct.smartBlock.model.Usuario;
import com.projetct.smartBlock.repository.PessoaRepository;
import com.projetct.smartBlock.repository.UsuarioRepository;
import com.projetct.smartBlock.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("auth")
public class LoginResource {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/registrar")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){

        if(this.repository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().body("Já existe um usuário com este login, favor escolher outro!");
        }

        Optional<Pessoa> pessoa = pessoaRepository.findById(data.codPessoa());
        if(pessoa.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
        }

        if(this.repository.findByPessoa(pessoa.get()) != null) {
            return ResponseEntity.badRequest().body("Já existe um usuário com está pessoa vinculada!");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());

        Usuario newUser = new Usuario(pessoa.get(), data.login(), encryptedPassword);

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
