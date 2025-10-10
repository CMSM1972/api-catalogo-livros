package br.com.catalogodelivros.api.livro;

import org.springframework.data.jpa.repository.JpaRepository;

// 1. Esta é uma interface, não uma classe.
public interface LivroRepository extends JpaRepository<Livro, Long> { // 2. Estendemos JpaRepository
    // 3. Pronto!
}
