package edu.course.lab03;

public class PriceCalculator {

    private final DiscountPolicy discountPolicy;

    public PriceCalculator(DiscountPolicy discountPolicy) {
        if (discountPolicy == null) {
            throw new IllegalArgumentException("Policy cannot be null");
        }

        this.discountPolicy = discountPolicy;
    }

    public double calculate(double price) {
        return discountPolicy.apply(price);
    }
}