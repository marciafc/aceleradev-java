package com.challenge.domain;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class Valor {

    public Valor(BigDecimal valorSoma1, BigDecimal valorSoma2, BigDecimal valorSubtrair1, BigDecimal valorSubtrair2) {
        this.valorSoma1 = valorSoma1;
        this.valorSoma2 = valorSoma2;
        this.valorSubtrair1 = valorSubtrair1;
        this.valorSubtrair2 = valorSubtrair2;
    }

    @Somar
    public BigDecimal valorSoma1;

    @Somar
    public BigDecimal valorSoma2;

    @Subtrair
    public BigDecimal valorSubtrair1;

    @Subtrair
    public BigDecimal valorSubtrair2;

}
