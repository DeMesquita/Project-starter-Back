package quixada.npi.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired CursoRepository cursoRepository;
	public List<Curso> buscar() {
		return cursoRepository.findAll();
		
	}

	public Curso buscarID(Integer id) {
		return cursoRepository.getOne(id);		
	}

	public void cadastrar(Curso curso) {
		cursoRepository.save(curso);
	}
	
	public void excluirID(Integer id) {
		cursoRepository.deleteById(id);
	}

}
