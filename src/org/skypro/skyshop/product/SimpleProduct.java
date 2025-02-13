package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int costProduct;

    public SimpleProduct(String nameProduct, int costProduct) {
        super(nameProduct);
        if (costProduct <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть больше 0 ");
        }
        this.costProduct = costProduct;
    }

    @Override
    public int getCostProduct() {
        return costProduct;
    }

    @Override
    public String toString() {
        return getNameProduct() + ": " + getCostProduct();
    }
}