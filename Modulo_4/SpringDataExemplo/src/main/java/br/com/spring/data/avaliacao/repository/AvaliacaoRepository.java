package br.com.spring.data.avaliacao.repository;

import br.com.spring.data.avaliacao.model.Avaliacao;
import br.com.spring.data.avaliacao.model.AvaliacaoIdentity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvaliacaoRepository extends CrudRepository<Avaliacao, AvaliacaoIdentity> {

    List<Avaliacao> findAll();
}