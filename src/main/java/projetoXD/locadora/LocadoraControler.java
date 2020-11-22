package projetoXD.locadora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/locadoras")
public class LocadoraControler {
	
	@Autowired
	private LocadoraRepository repo;
	
	@GetMapping
    public List<Locadora> recuperarTodos() {
        return repo.findAll();
    }

    @GetMapping("/{id}")    
    public Locadora locadoraPorId(@PathVariable String id) {
        return repo.findById(id).get();
    }

    @PostMapping
    public String criar(@RequestBody Locadora l) {
        if (repo.findById(l.getId()).isPresent()) {            
            throw new LocadoraDuplicadaException();
        }
        l = repo.save(l);
        return l.getId();
    }

    @DeleteMapping("/{id}")    
    public void deletarPorId(@PathVariable String id) {
        repo.deleteById(id);
    }

    @PutMapping("/{id}")
    public void AtualizarLocadora(@PathVariable String id, @RequestBody Locadora locadora) {
        if (!id.equals(locadora.getId())) {
            throw new LocadoraDuplicadaException();
        }
        if (!repo.findById(locadora.getId()).isPresent()) {            
            throw new LocadoraNaoIdendificadoException();

        }
        repo.save(locadora);
    }
	
}
