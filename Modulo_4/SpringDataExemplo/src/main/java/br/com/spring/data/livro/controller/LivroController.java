package br.com.spring.data.livro.controller;

import br.com.spring.data.controller.ResourceNotFoundException;
import br.com.spring.data.livro.model.Livro;
import br.com.spring.data.livro.service.LivroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    @ApiOperation("Cria um novo livro")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Livro criado com sucesso")})
    public ResponseEntity<Livro> create(@Valid @RequestBody Livro livro) {
        return new ResponseEntity<Livro>(this.livroService.save(livro), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Livro> update(@Valid @RequestBody Livro livro) {
        return new ResponseEntity<Livro>(this.livroService.save(livro), HttpStatus.ACCEPTED);
    }

    @GetMapping
    @ApiOperation("Lista todos os livros")
    public Iterable<Livro> findAll(@PathParam("nome") String nome, Pageable pageable) {
        if (nome != null) {
            return this.livroService.findByNome(nome.toString(), pageable);
        }
        return this.livroService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Livro não localizado"), @ApiResponse(code = 200, message = "Livro localizado")})
    public ResponseEntity<Livro> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Livro>(this.livroService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro")),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(code = 200, message = "Livro excluído")
    public void delete(@PathVariable("id") Long id) {
        this.livroService.deleteById(id);
    }

    @GetMapping("/byCategoria/{id}")
    public List<Livro> findByCategoria(@PathVariable("id") Long idCategoria) {
        return this.livroService.findByCategoria(idCategoria);
    }

    @GetMapping("/byNomeCategoria/{nome}")
    public List<Livro> findByNomeCategoria(@PathVariable("nome") String nomeCategoria) {
        return this.livroService.findByNomeCategoria(nomeCategoria);
    }

    @GetMapping("/comCategorias")
    public List<Livro> findComCategoria() {
        return this.livroService.findComCategorias();
    }

    @GetMapping("/testException")
    public void testException() {
        Integer x = 2 / 0;
    }

}


