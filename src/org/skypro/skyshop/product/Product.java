package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String nameProduct;


    public Product(String nameProduct) {
        if (nameProduct == null) {
            throw new IllegalArgumentException("Название продукто не может быть null");
        }
        if (nameProduct.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов");
        }
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

    @Override
    public String getSearchTerm() {
        return nameProduct;
    }

    @Override
    public String getSearchContentType() {
        return "PRODUCT";
    }
}