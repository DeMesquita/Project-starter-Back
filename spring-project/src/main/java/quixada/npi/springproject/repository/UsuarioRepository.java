package quixada.npi.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import quixada.npi.springproject.model.Usuario;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);

	/*
	 * @Query("SELECT new Usuario(u.id, u.nome, u.email, u.habilitado) FROM Usuario u"
	 * ) List<Usuario> findAll();
	 */
    
//    @Modifying
//    @Query(value = "update into usuario (id, nome, email, habilitado, password) VALUES (:id, :nome, :email, :habilitado, :password)", nativeQuery = true)
//    @Transactional
//    void atualizar(@Param("id") Integer id, @Param("nome") String nome, @Param("email") String email, @Param("habilitado") boolean habilitado, @Param("password") String password );
//	
    
    
}
