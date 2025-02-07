package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    public final int discount;

    public DiscountedProduct(String nameProduct, int basePrice, int discount) {
        super(nameProduct);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть больше 0 ");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100");
        }
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getCostProduct() {
        return basePrice - (int) ((double) (basePrice * discount) / 100.0);
    }

    @Override
    public String toString() {
        return getNameProduct() + ": " + getNameProduct() + " (скидка " + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}