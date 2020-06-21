package br.com.codenation;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StatisticUtil {

	public static final int ERROR = -1;

	public static int average(int[] elements) {

		if(elements.length == 0) {
			return ERROR;
		}

		List<Integer> numerosLista = Arrays.stream(elements).boxed().collect(Collectors.toList());

		Integer numerosSomatorio = numerosLista.stream()
				.mapToInt(Integer::intValue)
				.sum();

		return Math.round(numerosSomatorio / numerosLista.size());

	}

	public static int mode(int[] elements) {

		if(elements.length == 0) {
			return ERROR;
		}

		// Considerar moda que pode repetir ou não... no desafio solicitava sem repetição (fiz com e sem repetição)
		return mode(elements, false).get(0).getKey();
	}

	public static List<Map.Entry<Integer, IntSummaryStatistics>>  mode(int[] elements, boolean modaPodeRepetir) {

		if(elements.length == 0) {
			throw new RuntimeException("Informe os elementos para obter a moda");
		}

		List<Integer> numerosLista = Arrays.stream(elements).boxed().collect(Collectors.toList());

		// Agrupa cada número, assim é possível obter posteriormente a quantidade de vezes que cada um aparece (getCount)
		Map<Integer, IntSummaryStatistics> numeroEstatisticas = numerosLista.stream()
				.collect(groupingBy(Integer::intValue, summarizingInt(Integer::intValue)));

		Optional<IntSummaryStatistics> maiorFrequenciaEstatisticas = numeroEstatisticas.values().stream()
				.max(Comparator.comparing(n -> n.getCount()));

		long maiorFrequencia = maiorFrequenciaEstatisticas.get().getCount();

		// entries.stream().filter(c -> c.getValue().getCount() == count).findFirst();
		return numeroEstatisticas.entrySet().stream()
				.filter(n -> n.getValue().getCount() == maiorFrequencia)
				.collect(toList());
	}

	public static int median(int[] elements) {

		if(elements.length == 0) {
			return ERROR;
		}

		List<Integer> numerosLista = Arrays.stream(elements)
				.boxed()
				.collect(Collectors.toList());

		List<Integer> numerosListaOrdenada = numerosLista.stream()
				.sorted(Comparator.comparing(Integer::intValue))
				.collect(Collectors.toList());

		Integer posicaoMeio = numerosListaOrdenada.size() / 2;

		if(numerosListaOrdenada.size() % 2 == 0) {
			return (numerosListaOrdenada.get(posicaoMeio -1) + numerosListaOrdenada.get(posicaoMeio)) / 2;
		}

		return numerosListaOrdenada.get(posicaoMeio);
	}

}