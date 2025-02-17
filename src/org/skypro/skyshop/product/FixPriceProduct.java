package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private final static int PRICE = 1000;

    public FixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    @Override
    public int getCostProduct() {
        return PRICE;
    }

    @Override
    public String toString() {
        return getNameProduct() + " : фиксированная цена " + PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}