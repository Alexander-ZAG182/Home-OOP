package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    public final int discount;

    public DiscountedProduct(String nameProduct, int basePrice, int discount) {
        super(nameProduct);
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
