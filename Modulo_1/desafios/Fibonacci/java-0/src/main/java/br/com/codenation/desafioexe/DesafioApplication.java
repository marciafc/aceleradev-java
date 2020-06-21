package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesafioApplication {

    private static final int FIBONACCI_GERAR_ATE = 350;

	private static List<Integer> fibonacci;

	public static List<Integer> fibonacci() {
		fibonacci = criarFibonacci(FIBONACCI_GERAR_ATE);
		System.out.println(fibonacci);
		return fibonacci;
	}

	public static Boolean isFibonacci(Integer valor) {
		return fibonacci.contains(valor);
	}

	private static List<Integer> criarFibonacci(int ultimoValor) {
		List<Integer> fibonacci = new ArrayList<>(Arrays.asList(0, 1));
		int i = fibonacci.size();

		// Sequência gerada: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233] -> até 350
		//while (fibonacci.get(i-2) + fibonacci.get(i-1) <= ultimoValor) {

		// Sequência gerada: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377] -> atende os testes unitários do AceleraDev
		while (fibonacci.get(fibonacci.size()-1) <= ultimoValor) {
			fibonacci.add(fibonacci.get(i-2) + fibonacci.get(i-1));
			i++;
		}

		return fibonacci;
	}
}