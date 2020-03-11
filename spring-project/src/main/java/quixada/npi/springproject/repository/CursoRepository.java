package quixada.npi.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.model.Usuario;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
    



}
