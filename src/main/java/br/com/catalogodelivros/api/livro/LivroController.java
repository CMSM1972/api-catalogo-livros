package br.com.catalogodelivros.api.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Usar * importa tudo que precisamos do pacote
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro, UriComponentsBuilder uriBuilder) {
        Livro livroSalvo = livroService.cadastrar(livro);

        var uri = uriBuilder.path("/livros/{id}").buildAndExpand(livroSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(livroSalvo);
    } // FIM do método cadastrar

    // O método listarTodos() começa AQUI, DEPOIS que o outro terminou.
    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos() {
        List<Livro> livros = livroService.listarTodos();
        return ResponseEntity.ok(livros);
    } // FIM do método listarTodos
    // ... dentro da classe LivroController ...

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        Optional<Livro> livroOptional = livroService.buscarPorId(id);

        if (livroOptional.isPresent()) {
            return ResponseEntity.ok(livroOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

} // FIM da classe LivroController