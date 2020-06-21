package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    /**
     * Deverá somar todos os atributos do tipo BigDecimal que estão anotados com @Somar de uma classe recebida como parâmetro
     * e retornar um BigDecimal.
     *
     * @param objeto
     * @return BigDecimal
     */
    @Override
    public BigDecimal somar(Object objeto) {
        Total resultado = null;
        try {
            resultado = somarAtributosPorAnotacao(objeto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return resultado.soma;
    }

    /**
     * Deverá somar todos os atributos do tipo BigDecimal que estão anotados com @Subtrair de uma classe recebida como parâmetro
     * e retornar um BigDecimal.
     *
     * @param objeto
     * @return BigDecimal
     */
    @Override
    public BigDecimal subtrair(Object objeto) {
        Total resultado = null;
        try {
            resultado = somarAtributosPorAnotacao(objeto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return resultado.subtracao;
    }

    /**
     * Deverá subtrair os atributos annotados com @Subtrair dos atributos annotados com @Somar.
     *
     * Exemplo:
     *
     * Valores dos atributos anotados com @Somar: 1, 2, 3
     *
     * Valores dos atributos anotados com @Subtrair: 4, 5, 6
     *
     *  valor1 = 1 + 2 + 3;
     *  valor2 = 4 + 5 + 6;
     *
     * Resultado esperado: valor1 - valor2
     *
     * @param objeto
     * @return BigDecimal
     */
    @Override
    public BigDecimal totalizar(Object objeto) {
        BigDecimal resultado = null;
        try {
            Total total = somarAtributosPorAnotacao(objeto);
            resultado = total.soma.subtract(total.subtracao);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return resultado;
    }


    /**
     * Obtém o valor do campo informado e converte para BigDecimal.
     *
     * Caso o campo não seja BigDecimal, retornar BigDecimal.ZERO
     *
     * @param atributo
     * @param objeto
     * @return
     * @throws IllegalAccessException
     */
    private BigDecimal converterValorParaBigDecimal(Field atributo, Object objeto) throws IllegalAccessException {
        if(atributo.getType() == BigDecimal.class) {
            atributo.setAccessible(true);
            return  (BigDecimal) atributo.get(objeto);
        }

        return BigDecimal.ZERO;
    }

    private Total somarAtributosPorAnotacao(Object objeto) throws IllegalAccessException {
        Total total = new Total();

        Class classe = objeto.getClass();
        Field[] todosAtributos = classe.getDeclaredFields();

        for (Field atributo: todosAtributos) {
            try {
                atributo.setAccessible(true);

                if (atributo.isAnnotationPresent(Somar.class)) {
                    total.soma = total.soma.add(converterValorParaBigDecimal(atributo, objeto));

                } else if (atributo.isAnnotationPresent(Subtrair.class)) {
                    total.subtracao = total.subtracao.add(converterValorParaBigDecimal(atributo, objeto));
                }

            } catch(Exception e){
                throw e;
            }
        }

        return total;
    }

    private class Total {
        BigDecimal soma = BigDecimal.ZERO;
        BigDecimal subtracao = BigDecimal.ZERO;
    }

}
