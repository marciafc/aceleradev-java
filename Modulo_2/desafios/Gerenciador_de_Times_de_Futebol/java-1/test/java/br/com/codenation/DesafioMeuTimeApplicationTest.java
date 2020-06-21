package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DesafioMeuTimeApplicationTest {

    @Test
    public void deveIncluirTimeQueNaoExiste(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        assertEquals(new Long(1L), desafioMeuTimeApplication.buscarTimes().get(0));
    }

    @Test(expected = IdentificadorUtilizadoException.class)
    public void deveLevantarExceptionQuandoOTimeJaExiste(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
    }

    @Test
    public void deveIncluirJogadorNaoExistenteEmTimeJaExistente(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirJogador(1l, 1l, "Jogador", LocalDate.now(), 1, BigDecimal.TEN);
        assertEquals(new Long(1L), desafioMeuTimeApplication.buscarJogadoresDoTime(1L).get(0));
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void aoAdicionarJogadorDeveLevantarExceptionQuandoTimeNaoExiste(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirJogador(1l, 1l, "Jogador", LocalDate.now(), 1, BigDecimal.TEN);
    }

    @Test(expected = IdentificadorUtilizadoException.class)
    public void aoAdicionarJogadorDeveLevantarExceptionQuandoJogadorJaExiste(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirJogador(1l, 1l, "Jogador", LocalDate.now(), 1, BigDecimal.TEN);
        desafioMeuTimeApplication.incluirJogador(1l, 1l, "Jogador", LocalDate.now(), 1, BigDecimal.TEN);
    }

    @Test
    public void deveDefinirCapitao(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirJogador(1l, 1l, "Jogador", LocalDate.now(), 1, BigDecimal.TEN);
        desafioMeuTimeApplication.definirCapitao(1l);
        assertEquals(new Long(1L), desafioMeuTimeApplication.buscarCapitaoDoTime(1L));
    }

    @Test(expected = JogadorNaoEncontradoException.class)
    public void deveLevantarExceptionAoDefinirJogadorInexistenteComoCapitao(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.definirCapitao(1l);
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void deveLevantarExceptionAoBuscarCapitaoDeTimeInexistente(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.buscarCapitaoDoTime(1l);
    }

    @Test(expected = CapitaoNaoInformadoException.class)
    public void deveLevantarExceptionCasoTimeNaoTenhaCapitao(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.buscarCapitaoDoTime(1l);
    }

    @Test
    public void deveBuscarNomeJogador(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirJogador(1l, 1l, "Jogador", LocalDate.now(), 1, BigDecimal.TEN);
        assertEquals("Jogador", desafioMeuTimeApplication.buscarNomeJogador(1L));
    }

    @Test(expected = JogadorNaoEncontradoException.class)
    public void deveLevantarExceptionAoBuscarNomeDeJogadorQueNaoExiste(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.buscarNomeJogador(1L);
    }

    @Test
    public void deveBuscarNomeTime(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        assertEquals("Teste1", desafioMeuTimeApplication.buscarNomeTime(1L));
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void deveLevantarExceptionQuandoBuscaNomeDeTimeInexistente() {
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.buscarNomeTime(1L);
    }
    @Test
    public void deveBuscarJogadoresDoTime(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirJogador(2l, 1l, "Jogador", LocalDate.now(), 1, BigDecimal.TEN);
        desafioMeuTimeApplication.incluirJogador(3l, 1l, "Jogador", LocalDate.now(), 1, BigDecimal.TEN);
        List<Long> jogadoresTime = desafioMeuTimeApplication.buscarJogadoresDoTime(1L);
        assertTrue(jogadoresTime.contains(2L));
        assertTrue(jogadoresTime.contains(3L));
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void deveLevantarExceptionAoBuscarJogadoresDeTimeInexistente(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        List<Long> jogadoresTime = desafioMeuTimeApplication.buscarJogadoresDoTime(1L);
    }

    @Test
    public void deveBuscarMelhorJogadorDoTime(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirJogador(2l, 1l, "Jogador", LocalDate.now(), 1, BigDecimal.TEN);
        desafioMeuTimeApplication.incluirJogador(3l, 1l, "Jogador2", LocalDate.now(), 2, BigDecimal.TEN);
        assertEquals(3L, desafioMeuTimeApplication.buscarMelhorJogadorDoTime(1L).longValue());
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void deveLevantarExceptionAoBuscarMelhorJogadorDeTimeInexistente(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.buscarMelhorJogadorDoTime(1L);
    }

    @Test
    public void deveBuscarJogadorMaisVelho(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirJogador(2l, 1l, "Jogador", LocalDate.now().minus(25, ChronoUnit.YEARS), 1, BigDecimal.TEN);
        desafioMeuTimeApplication.incluirJogador(3l, 1l, "Jogador2", LocalDate.now().minus(20, ChronoUnit.YEARS), 2, BigDecimal.TEN);
        assertEquals(2L, desafioMeuTimeApplication.buscarJogadorMaisVelho(1L).longValue());
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void deveLevantarExceptionAoBuscarJogadorMaisVelhoDeTimeInexistente(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.buscarJogadorMaisVelho(1L);
    }

    @Test
    public void deveBuscarTodosOsTimesExistentes(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirTime(2l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirTime(3l, "Teste1", LocalDate.now(), "branco", "branco");
        assertEquals(3L, desafioMeuTimeApplication.buscarTimes().size());
    }

    @Test
    public void aoBuscarTimesDeveRetornarUmaListaVaziaQuandoNenhumTimeExiste(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        assertEquals(0L, desafioMeuTimeApplication.buscarTimes().size());
    }

    @Test
    public void deveBuscarJogadorComMaiorSalarioDoTime(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirJogador(2l, 1l, "Jogador", LocalDate.now().minus(25, ChronoUnit.YEARS), 1, new BigDecimal(10000));
        desafioMeuTimeApplication.incluirJogador(3l, 1l, "Jogador2", LocalDate.now().minus(20, ChronoUnit.YEARS), 2, new BigDecimal(20000));
        desafioMeuTimeApplication.incluirJogador(4l, 1l, "Jogador3", LocalDate.now().minus(20, ChronoUnit.YEARS), 2, new BigDecimal(30000));
        assertEquals(4L, desafioMeuTimeApplication.buscarJogadorMaiorSalario(1L).longValue());
    }

    @Test(expected = TimeNaoEncontradoException.class)
    public void deveLevantarExceptionAoBuscarJogadorComMaiorSalarioDeTimeInexistente(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.buscarJogadorMaiorSalario(1L);
    }

    @Test
    public void deveRetornarSalarioDoJogador(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirJogador(2l, 1l, "Jogador", LocalDate.now().minus(25, ChronoUnit.YEARS), 1, new BigDecimal(10000));
        desafioMeuTimeApplication.incluirJogador(3l, 1l, "Jogador2", LocalDate.now().minus(20, ChronoUnit.YEARS), 2, new BigDecimal(20000));
        desafioMeuTimeApplication.incluirJogador(4l, 1l, "Jogador3", LocalDate.now().minus(20, ChronoUnit.YEARS), 2, new BigDecimal(30000));
        assertEquals(new BigDecimal(10000), desafioMeuTimeApplication.buscarSalarioDoJogador(2L));
    }

    @Test(expected = JogadorNaoEncontradoException.class)
    public void deveLevantarExceptionAoBuscarSalarioDeJogadorInexistente(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.buscarSalarioDoJogador(2L);
    }

    @Test
    public void deveRetonarTopJogadores(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1l, "Teste1", LocalDate.now(), "branco", "branco");
        desafioMeuTimeApplication.incluirJogador(2l, 1l, "Jogador", LocalDate.now().minus(25, ChronoUnit.YEARS), 1, new BigDecimal(10000));
        desafioMeuTimeApplication.incluirJogador(3l, 1l, "Jogador2", LocalDate.now().minus(20, ChronoUnit.YEARS), 2, new BigDecimal(20000));
        desafioMeuTimeApplication.incluirJogador(4l, 1l, "Jogador3", LocalDate.now().minus(20, ChronoUnit.YEARS), 3, new BigDecimal(30000));
        List<Long> jogadores = desafioMeuTimeApplication.buscarTopJogadores(2);
        assertEquals(2, jogadores.size());
        assertEquals(4L, jogadores.get(0).longValue());
        assertEquals(3L, jogadores.get(1).longValue());
    }

    @Test
    public void aoBuscarTopJogadoresdeveRetonarListaVaziaAoBuscarQuandoNenhumJogadorExistir(){
        final DesafioMeuTimeApplication desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        assertEquals(0, desafioMeuTimeApplication.buscarTopJogadores(2).size());
    }
}
