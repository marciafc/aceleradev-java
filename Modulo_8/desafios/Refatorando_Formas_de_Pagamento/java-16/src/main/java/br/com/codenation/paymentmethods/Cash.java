package br.com.codenation.paymentmethods;

public class Cash implements PriceStrategy {

    private final double PERCENTAGE_OF_DISCOUNT = 0.9;

    @Override
    public Double calculate(Double price) {
        return price * PERCENTAGE_OF_DISCOUNT;
    }

}
