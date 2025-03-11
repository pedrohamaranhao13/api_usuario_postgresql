package br.com.phamtecnologiarepositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.phamtecnologia.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("select u from Usuario u where u.email = :email")
	Optional<Usuario> findByEmail(@Param("email") String email);
	
	@Query("select u from Usuario u where u.email = :email and u.senh = :senha")
	Optional<Usuario> findByEmailAndSenha(@Param("email") String email,@Param("senha") String senha);
}
