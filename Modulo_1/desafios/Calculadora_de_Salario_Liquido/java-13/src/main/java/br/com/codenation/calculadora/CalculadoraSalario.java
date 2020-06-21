package br.com.codenation.calculadora;


public class CalculadoraSalario {

	private final static float INSS_PERCENTUAL_DESCONTO_ATE_1500 = 0.08f;
	private final static float INSS_PERCENTUAL_DESCONTO_DE_1500_01_ATE_4000 = 0.09f;
	private final static float INSS_PERCENTUAL_DESCONTO_ACIMA_4000 = 0.11f;
	private final static float INSS_FAIXA_ATE_1500 = 1500f;
	private final static float INSS_FAIXA_DE_1500_01_ATE_4000 = 4000f;
	private final static float INSS_FAIXA_ACIMA_4000 = 4000.01f;

	private final static float IRRF_PERCENTUAL_DESCONTO_ATE_3000 = 0f;
	private final static float IRRF_PERCENTUAL_DESCONTO_DE_3000_01_ATE_6000 = 0.075f;
	private final static float IRRF_PERCENTUAL_DESCONTO_ACIMA_6000 = 0.15f;
	private final static float IRRF_FAIXA_ATE_3000 = 3000f;
	private final static float IRRF_FAIXA_DE_3000_01_ATE_6000 = 6000f;
	private final static float IRRF_FAIXA_ACIMA_6000 = 6000.01f;

	private final static float VALOR_SALARIO_MINIMO = 1039f;



	public long calcularSalarioLiquido(double salarioBase) {

		//  Caso o valor do salário base recebido seja abaixo do salário mínimo (R$ 1.039,00), o algoritmo deve retornar 0.0.
		if(salarioBase < VALOR_SALARIO_MINIMO){
			return 0l;
		}

		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		long salarioAposCalcularInss = Math.round(calcularInss(salarioBase));
		return Math.round(calcularIrrf(salarioAposCalcularInss));
	}

	private double calcularInss(double salarioBase) {
		if(salarioBase <= INSS_FAIXA_ATE_1500) {
			return salarioBase * (1 - INSS_PERCENTUAL_DESCONTO_ATE_1500);
		}

		if(salarioBase <= INSS_FAIXA_DE_1500_01_ATE_4000) {
			return salarioBase * (1 - INSS_PERCENTUAL_DESCONTO_DE_1500_01_ATE_4000);
		}

		return salarioBase * (1 - INSS_PERCENTUAL_DESCONTO_ACIMA_4000);
	}

	private double calcularIrrf(double salarioAposCalcularInss) {
		if(salarioAposCalcularInss <= IRRF_FAIXA_ATE_3000) {
			return salarioAposCalcularInss;
		}

		if(salarioAposCalcularInss <= IRRF_FAIXA_DE_3000_01_ATE_6000) {
			return salarioAposCalcularInss * (1 - IRRF_PERCENTUAL_DESCONTO_DE_3000_01_ATE_6000);
		}

		return salarioAposCalcularInss * (1 - IRRF_PERCENTUAL_DESCONTO_ACIMA_6000);
	}
}

/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/