package org.skypro.skyshop.product;

public abstract class Product {
    private final String nameProduct;


    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public abstract int getCostProduct();

    public String getNameProduct() {
        return nameProduct;
    }

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return nameProduct;
    }
}
