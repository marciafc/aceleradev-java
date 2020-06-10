package br.com.spring.data.livro.service;

import br.com.spring.data.avaliacao.service.AvaliacaoService;
import br.com.spring.data.categoria.model.Categoria;
import br.com.spring.data.categoria.service.CategoriaService;
import br.com.spring.data.livro.model.Livro;
import br.com.spring.data.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Override
    public List<Livro> findAll(Pageable pageable) {
        return this.livroRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Livro> findByCategoria(Long idCategoria) {
        Categoria categoria = this.categoriaService.findById(idCategoria).get();
        return this.livroRepository.findByCategorias(categoria);
    }

    @Override
    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    @Override
    public Livro save(Livro livro) {
        preencherCategorias(livro);
        return this.livroRepository.save(livro);
    }

    @Override
    public void deleteById(Long id) {
        this.livroRepository.deleteById(id);
    }

    @Override
    public List<Livro> findByNome(String nome, Pageable pageable) {
        return this.livroRepository.findByTituloContaining(nome, pageable).getContent();
    }

    @Override
    public List<Livro> findByNomeCategoria(String nomeCategoria) {
        return this.livroRepository.findByNomeCategoria(nomeCategoria);
    }

    @Override
    public List<Livro> findComCategorias() {
        return this.livroRepository.findComCategoria();
    }

    private void preencherCategorias(Livro livro) {
        if (livro.getCategorias() != null) {
            List<Categoria> persistedCategorias = new ArrayList<>();
            for (Categoria categoria : livro.getCategorias()) {
                if (categoria.getId() != null) {
                    persistedCategorias.add(this.categoriaService.findById(categoria.getId()).get());
                } else {
                    persistedCategorias.add(this.categoriaService.save(categoria));
                }
            }
            livro.setCategorias(persistedCategorias);
        }
    }
}
