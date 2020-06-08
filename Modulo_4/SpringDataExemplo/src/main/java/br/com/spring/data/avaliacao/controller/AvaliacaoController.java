package br.com.spring.data.avaliacao.controller;

import br.com.spring.data.avaliacao.model.Avaliacao;
import br.com.spring.data.avaliacao.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public List<Avaliacao> findAll(){
        return this.avaliacaoService.findAll();
    }

    @PostMapping
    public Avaliacao save(@RequestBody Avaliacao avaliacao){
        return this.avaliacaoService.save(avaliacao);
    }
}
