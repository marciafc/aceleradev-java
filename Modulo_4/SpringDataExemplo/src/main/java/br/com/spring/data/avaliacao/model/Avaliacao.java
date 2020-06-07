package br.com.spring.data.avaliacao.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Avaliacao {

    @EmbeddedId
    private AvaliacaoIdentity avaliacaoIdentity;

    @Min(1)
    @Max(5)
    @NotNull
    private Byte nota;

    @NotBlank
    @NotNull
    private String avaliacao;

    public AvaliacaoIdentity getAvaliacaoIdentity() {
        return avaliacaoIdentity;
    }

    public void setAvaliacaoIdentity(AvaliacaoIdentity avaliacaoIdentity) {
        this.avaliacaoIdentity = avaliacaoIdentity;
    }

    public Byte getNota() {
        return nota;
    }

    public void setNota(Byte nota) {
        this.nota = nota;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
}
