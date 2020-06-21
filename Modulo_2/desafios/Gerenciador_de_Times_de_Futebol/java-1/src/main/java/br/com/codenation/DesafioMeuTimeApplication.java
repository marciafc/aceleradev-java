package br.com.codenation;

import br.com.codenation.domain.Jogador;
import br.com.codenation.domain.Time;
import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Time> times = new ArrayList<>();
	private List<Jogador> jogadores = new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		verificarSeTemTimeComId(id);

		Time timeACadastrar = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		times.add(timeACadastrar);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		verificarSeTemJogadorComId(id);
		verificarSeNaoTemTimeComId(idTime);

		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		jogadores.add(jogador);
	}

	public void definirCapitao(Long idJogador) {
		Optional<Jogador> jogador = buscarJogador(idJogador);
		configurarCapitaoTime(jogador);
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		verificarSeNaoTemTimeComId(idTime);
		verificarSeNaoTemCapitaoTime(idTime);

		Optional<Long> id = jogadores.stream()
				.filter(jogador -> jogador.getIdTime() == idTime && jogador.getCapitao())
				.map(Jogador::getId).findAny();

		return id.get();
	}

	public String buscarNomeJogador(Long idJogador) {
		return buscarJogador(idJogador).get().getNome();
	}

	public String buscarNomeTime(Long idTime) {
		verificarSeNaoTemTimeComId(idTime);

		Optional<String> nomeTime = this.times.stream()
				.filter(t -> t.getId() == idTime)
				.map(Time::getNome).findFirst();

		return nomeTime.get();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		verificarSeNaoTemTimeComId(idTime);

		return this.jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getId))
				.filter(jogador -> jogador.getIdTime() == idTime)
				.map(Jogador::getId).collect(Collectors.toList());
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		verificarSeNaoTemTimeComId(idTime);

		// Buscar maior nivelHabilidade
		Optional<Integer> maiorNivelHabilidade = jogadores.stream()
				.filter(jogador -> jogador.getIdTime() == idTime)
				.max(Comparator.comparing(jogador -> jogador.getNivelHabilidade()))
				.map(Jogador::getNivelHabilidade);

		// Lista todos os jogadores que tem a habilidade igual ao maior nível
		List<Jogador> jogadoresMaiorNivelHabilidade = jogadores.stream()
				.filter(jogador -> jogador.getIdTime() == idTime && jogador.getNivelHabilidade() == maiorNivelHabilidade.get())
				.collect(Collectors.toList());

		// Não ha empate, apenas um jogador tem o maior nível
		if(jogadoresMaiorNivelHabilidade.size() == 1) {
			return jogadoresMaiorNivelHabilidade.get(0).getId();
		}

		// Buscar o desempate pelo menor identificador
		return jogadoresMaiorNivelHabilidade.stream()
				.min(Comparator.comparing(jogador -> jogador.getId()))
				.map(Jogador::getId).get();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		verificarSeNaoTemTimeComId(idTime);

		// Buscar data de nascimento do jogador mais velho do time (menor data de nascimento)
		Optional<LocalDate> dataNascimentoJogadorMaisVelhoTime = jogadores.stream()
				.filter(jogador -> jogador.getIdTime() == idTime)
				.min(Comparator.comparing(jogador -> jogador.getDataNascimento()))
				.map(Jogador::getDataNascimento);

		// Lista com todos os jogadores que tem a mesma data de nascimento do mais velho
		List<Jogador> jogadoresDataNascimentoEmpatado = jogadores.stream()
				.filter(jogador -> jogador.getIdTime() == idTime && jogador.getDataNascimento().equals(dataNascimentoJogadorMaisVelhoTime.get()))
				.collect(Collectors.toList());

		// Não ha empate, apenas um jogador é o mais velho
		if(jogadoresDataNascimentoEmpatado.size() == 1) {
			return jogadoresDataNascimentoEmpatado.get(0).getId();
		}

		// Buscar o desempate pelo menor identificador
		return jogadoresDataNascimentoEmpatado.stream()
				.min(Comparator.comparing(jogador -> jogador.getId()))
				.map(Jogador::getId).get();
	}

	public List<Long> buscarTimes() {
		List<Long> timesId = new ArrayList<>();
		if(times != null && times.size() > 0) {
			timesId.addAll(times.stream()
					.sorted(Comparator.comparing(Time::getId))
					.map(Time::getId)
					.collect(java.util.stream.Collectors.toList()));
		}
		return timesId;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		verificarSeNaoTemTimeComId(idTime);

		// Buscar maior salário do time
		Optional<BigDecimal> maiorSalarioTime = jogadores.stream()
				.filter(jogador -> jogador.getIdTime() == idTime)
				.max(Comparator.comparing(jogador -> jogador.getSalario()))
				.map(Jogador::getSalario);

		// Lista com todos os jogadores que tem o salário igual ao maior (empatados)
		List<Jogador> jogadoresTimeSalarioEmpatado = jogadores.stream()
				.filter(jogador -> jogador.getIdTime() == idTime && jogador.getSalario().setScale(2).equals(maiorSalarioTime.get().setScale(2)))
				.collect(Collectors.toList());

		// Não ha empate, apenas um jogador tem o maior salário
		if(jogadoresTimeSalarioEmpatado.size() == 1) {
			return jogadoresTimeSalarioEmpatado.get(0).getId();
		}

		// Buscar o desempate pelo menor identificador
		return jogadoresTimeSalarioEmpatado.stream()
				.min(Comparator.comparing(jogador -> jogador.getId()))
				.map(Jogador::getId).get();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {

		Optional<Jogador> jogador = buscarJogador(idJogador);

		if(jogador.isPresent()) {
			return jogador.get().getSalario();
		}

		return BigDecimal.ZERO;
	}

	public List<Long> buscarTopJogadores(Integer top) {

		List<Long> jogadoresIdTop = new ArrayList<>();

		if(jogadores != null && jogadores.size() > 0) {

			// Obtém de forma decrescente e distinta TODAS as habilidades dos jogadores
			List<Integer> habilidadesOrdemDescrescente = jogadores.stream()
					.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
					.map(Jogador::getNivelHabilidade).distinct()
					.collect(Collectors.toList());

			// Obtém SOMENTE as top habilidades
			List<Integer> topHabilidadesOrdenadas = habilidadesOrdemDescrescente.subList(0, top);

			// Lista todos os jogadores que estão entre as top habilidades
			for (Integer habilidade: topHabilidadesOrdenadas) {

				List<Jogador> jogadoresPorHabilidade = jogadores.stream()
						.filter(jogador -> jogador.getNivelHabilidade() == habilidade)
						.collect(Collectors.toList());

				// Se não há empate
				if(jogadoresPorHabilidade.size() == 1) {
					jogadoresIdTop.add(jogadoresPorHabilidade.get(0).getId());
				} else {
					// Buscar o desempate pelo menor identificador
					jogadoresIdTop.add(jogadoresPorHabilidade.stream()
							.min(Comparator.comparing(jogador -> jogador.getId()))
							.map(Jogador::getId).get());
				}

			}
		}

		return jogadoresIdTop;
	}

	/**
	 * Caso NÃO encontre algum capitão no time, retornará CapitaoNaoInformadoException
	 * @param idTime
	 */
	private void verificarSeNaoTemCapitaoTime(Long idTime) {
		long quantidadeCapitaoTimeInformado = jogadores.stream()
				.filter(jogador -> jogador.getIdTime() == idTime && jogador.getCapitao())
				.count();

		if(quantidadeCapitaoTimeInformado == 0) {
			throw new CapitaoNaoInformadoException();
		}
	}

	/**
	 * Caso NÃO encontre algum time com o mesmo id informado, retornará TimeNaoEncontradoException
	 * @param idTime
	 */
	private void verificarSeNaoTemTimeComId(Long idTime) {
		long quantidadeTimeComIdInformado = times.stream()
				.filter(time -> time.getId() == idTime)
				.count();

		if(quantidadeTimeComIdInformado == 0) {
			throw new TimeNaoEncontradoException();
		}
	}

	/**
	 * Caso encontre algum time com o mesmo id informado, retornará IdentificadorUtilizadoException
	 * @param idTime
	 */
	private void verificarSeTemTimeComId(Long idTime) {
		long quantidadeTimeComIdInformado = times.stream()
				.filter(time -> time.getId() == idTime)
				.count();

		if(quantidadeTimeComIdInformado > 0) {
			throw new IdentificadorUtilizadoException();
		}
	}

	/**
	 * Caso encontre algum jogador com o mesmo id informado, retornará IdentificadorUtilizadoException
	 * @param id
	 */
	private void verificarSeTemJogadorComId(Long id) {
		long quantidadeJogadorComIdInformado = jogadores.stream()
				.filter(jogador -> jogador.getId() == id)
				.count();

		if(quantidadeJogadorComIdInformado > 0) {
			throw new IdentificadorUtilizadoException();
		}
	}

	/**
	 * Caso NÃO encontre algum jogador com o mesmo id informado, retornará JogadorNaoEncontradoException.
	 * Caso encontre, retorna-o.
	 * @param id
	 */
	private Optional<Jogador> buscarJogador(Long id) {
		Optional<Jogador> jogadorObjeto = jogadores.stream()
				.filter(jogador -> jogador.getId() == id)
				.findFirst();

		if(!jogadorObjeto.isPresent()) {
			throw new JogadorNaoEncontradoException();
		}
		return jogadorObjeto;
	}

	private void configurarCapitaoTime(Optional<Jogador> jogador) {
		if(jogador.isPresent()) {
			List<Jogador> jogadores = buscarJogadoresObjetoDoTime(jogador.get().getIdTime());
			for (Jogador todosJogadoresDoTime: jogadores){
				todosJogadoresDoTime.setCapitao(false);
			}
			jogador.get().setCapitao(true);
		}
	}

	private List<Jogador> buscarJogadoresObjetoDoTime(Long idTime) {
		return this.jogadores.stream()
				.filter(jogador -> jogador.getIdTime() == idTime)
				.collect(Collectors.toList());
	}

}
