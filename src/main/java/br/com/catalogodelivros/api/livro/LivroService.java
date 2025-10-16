package br.com.catalogodelivros.api.livro;

import org.springframework.stereotype.Service;
import java.util.List; // Adicione este import, pois estamos usando List<Livro>
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro cadastrar(Livro livro) {
        // Aqui poderíamos ter regras de negócio, como por exemplo:
        // "Não permitir cadastrar um livro com o mesmo título de um autor existente".
        // Por enquanto, nosso único trabalho é pedir ao repositório para salvar.
        return livroRepository.save(livro);
    } // <- O método cadastrar TERMINA AQUI

    // O método listarTodos COMEÇA AQUI, do lado de fora
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }
    // ... dentro da classe LivroService ...

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }
}