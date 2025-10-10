package br.com.catalogodelivros.api.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Usar * importa tudo que precisamos do pacote
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

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

} // FIM da classe LivroController