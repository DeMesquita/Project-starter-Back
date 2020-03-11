package quixada.npi.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.buscar());
    }
    
    @GetMapping("{id}")
    public ResponseEntity<List<Usuario>> find(@PathVariable Integer id) {
    	usuarioService.buscarID(id);
        return ResponseEntity.ok().build();
    }
    
    
    @PostMapping("")
    public ResponseEntity<List<Usuario>> cadastrar(@RequestBody Usuario usuario ) {
    	usuarioService.cadastrar(usuario);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<List<Usuario>> delete(@PathVariable Integer id) {
    	Usuario usuario = usuarioService.buscarID(id);
    	if(usuario.isHabilitado() == false) {
        	usuarioService.excluirID(id);
    	}
        return ResponseEntity.ok(usuarioService.buscar());
    }
    
    @PutMapping("{id}")
    public ResponseEntity<List<Usuario>> update(@PathVariable Integer id, @RequestBody Usuario usuario) {
    	usuarioService.excluirID(id);
    	usuarioService.cadastrar(usuario);
        return ResponseEntity.ok(usuarioService.buscar());
    }

    

}
