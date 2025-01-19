package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] basket;

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
                System.out.println(this.basket[i].getNameProduct() + " : " + this.basket[i].getCostProduct());
                count = count + 1;
            }
        }
        if (count == 0) {
            System.out.println("в корзине пусто");
        }
        if (count > 0) {
            System.out.println("Итого : " + sumBasket());
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
}



