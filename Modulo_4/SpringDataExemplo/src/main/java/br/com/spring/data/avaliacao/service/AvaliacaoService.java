package br.com.spring.data.avaliacao.service;

import br.com.spring.data.avaliacao.model.Avaliacao;

import java.util.List;

public interface AvaliacaoService {

    List<Avaliacao> findAll();

    Avaliacao save(Avaliacao avaliacao);

}

