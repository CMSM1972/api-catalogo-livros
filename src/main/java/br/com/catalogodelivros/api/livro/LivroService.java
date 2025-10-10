package br.com.catalogodelivros.api.livro;

import org.springframework.stereotype.Service;

@Service // 1. Anotação que define esta classe como um Serviço gerenciado pelo Spring.
public class LivroService {

    private final LivroRepository livroRepository; // 2. Dependência do nosso repositório.

    // 3. Injeção de Dependência via construtor.
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    // 4. Nosso primeiro método de lógica de negócio.
    public Livro cadastrar(Livro livro) {
        // Aqui poderíamos ter regras de negócio, como por exemplo:
        // "Não permitir cadastrar um livro com o mesmo título de um autor existente".
        // Por enquanto, nosso único trabalho é pedir ao repositório para salvar.

        return livroRepository.save(livro);
    }
}
