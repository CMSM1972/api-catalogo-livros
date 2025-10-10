package br.com.catalogodelivros.api.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController // 1. Define a classe como um Controller REST.
@RequestMapping("/livros") // 2. Define um prefixo de URL para todos os métodos deste controller.
public class LivroController {

    private final LivroService livroService; // 3. Injeção de dependência do nosso serviço.

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping // 4. Mapeia este método para o verbo HTTP POST na URL /livros.
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro, UriComponentsBuilder uriBuilder) { // 5.
        Livro livroSalvo = livroService.cadastrar(livro);

        // 6. Construindo a URL de retorno (boa prática REST).
        var uri = uriBuilder.path("/livros/{id}").buildAndExpand(livroSalvo.getId()).toUri();

        // 7. Retorna o status 201 Created com a URL e o objeto criado.
        return ResponseEntity.created(uri).body(livroSalvo);
    }
}
