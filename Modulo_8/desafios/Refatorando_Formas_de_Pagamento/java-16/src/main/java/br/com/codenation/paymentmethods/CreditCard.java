package br.com.codenation.paymentmethods;

public class CreditCard implements PriceStrategy {

    private final double PERCENTAGE_OF_DISCOUNT = 0.98;

    @Override
    public Double calculate(Double price) {
        return price * PERCENTAGE_OF_DISCOUNT;
    }

}