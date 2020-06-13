package br.com.spring.data.usuario.repository;

import br.com.spring.data.usuario.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

    Usuario findByLogin(String login);

}