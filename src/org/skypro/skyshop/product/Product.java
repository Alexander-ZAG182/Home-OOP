package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
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

    @Override
    public String getSearchTerm() {
        return nameProduct;
    }

    @Override
    public String getSearchContentType() {
        return "PRODUCT";
    }
}
