package br.com.albertoferes.springcontacts.resources;

import br.com.albertoferes.springcontacts.domain.Contato;
import br.com.albertoferes.springcontacts.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/contatos")
@RestController
public class ContatoResource {

    @Autowired
    private ContatoService service;

    @GetMapping
    public ResponseEntity<List<Contato>> buscarTodos() {
        List<Contato> contatos = service.buscarTodos();
        return ResponseEntity.ok().body(contatos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarPorId(@PathVariable Integer id) {
        Contato contato = service.buscarPorId(id);
        return ResponseEntity.ok().body(contato);
    }

    @PostMapping
    public ResponseEntity<Void> inserir (@RequestBody Contato contato) {
        Contato contatoSaved = service.inserir(contato);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contatoSaved.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable  Integer id) {
        service.remover(id);
        return ResponseEntity.ok().build();
    }
}
