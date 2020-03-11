package quixada.npi.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.service.CursoService;
import quixada.npi.springproject.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("")
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok(cursoService.buscar());
    }
    
    @GetMapping("{id}")
    public ResponseEntity<List<Curso>> find(@PathVariable Integer id) {
    	cursoService.buscarID(id);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("")
    public ResponseEntity<List<Curso>> cadastrar(@RequestBody Curso curso ) {
    	cursoService.cadastrar(curso);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<List<Curso>> delete(@PathVariable Integer id) {
        cursoService.excluirID(id);
        return ResponseEntity.ok(cursoService.buscar());
    }
    
    @PutMapping("{id}")
    public ResponseEntity<List<Curso>> update(@PathVariable Integer id, @RequestBody Curso curso) {
    	cursoService.cadastrar(curso);
        return ResponseEntity.ok(cursoService.buscar());
    }

}
