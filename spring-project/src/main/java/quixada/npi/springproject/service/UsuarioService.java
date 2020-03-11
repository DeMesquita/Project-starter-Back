package quixada.npi.springproject.service;


import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.repository.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	

	 @Autowired UsuarioRepository usuarioRepository;

	    public  List<Usuario> buscar(){
	    	return usuarioRepository.findAll();
	    }
	    public  Usuario buscarID(Integer id){
	    	return usuarioRepository.getOne(id);
	    }
	    
	    public  void cadastrar(Usuario usuario) {
			usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));//criptografando senha
	    	usuarioRepository.save(usuario);
	    }
	    
		public  void excluirID(Integer id) {
			usuarioRepository.deleteById(id);
		}
	    
		public  Usuario findByEmail(String email) {
			return usuarioRepository.findByEmail(email);
		}
		
		
}
