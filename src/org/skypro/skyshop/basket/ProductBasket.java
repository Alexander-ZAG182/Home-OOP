package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] basket;

    public static final int NOT_FOUND = -1;

    public ProductBasket() {
        this.basket = new Product[5];
    }

    public void addProduct(Product product) {
        for (int i = 0; i < this.basket.length; i++) {
            if (this.basket[i] == null) {
                this.basket[i] = product;
                return;
            }
        }
        System.out.println("Не возможно добавить продукт!");
    }

    public int sumBasket() {
        int sum = 0;
        for (int i = 0; i < this.basket.length; i++) {
            if (this.basket[i] != null) {
                sum = sum + this.basket[i].getCostProduct();
            }
        }
        return sum;
    }

    public void printBasket() {
        int count = 0;
        for (int i = 0; i < this.basket.length; i++) {
            if (this.basket[i] != null) {
                System.out.println(this.basket[i].toString());
                count = count + 1;
            }
        }
        if (count == 0) {
            System.out.println("в корзине пусто");
        }
        if (count > 0) {
            System.out.println("Итого : " + sumBasket());
            System.out.println("Специальных товаров: " + getSpecialProductCount());
        }
    }

    public boolean findProduct(String nameProduct) {
        for (int i = 0; i < this.basket.length; i++) {
            if (this.basket[i] != null && nameProduct.equals(this.basket[i].getNameProduct())) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < this.basket.length; i++) {
            if (this.basket[i] != null) {
                this.basket[i] = null;
            }
        }
    }

    public int getSpecialProductCount() {
        int count = 0;
        for (Product product : basket) {
            if (product != null) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }

    private int getFreeIndex() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private int getProductCount() {
        int count = 0;
        for (Product product : basket) {
            if (basket != null) {
                count++;
            }
        }
        return count;
    }
}



