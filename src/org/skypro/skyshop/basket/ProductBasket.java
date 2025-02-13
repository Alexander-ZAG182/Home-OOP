package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private final List<Product> basket;

    public ProductBasket() {
        this.basket = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть null");
        }
        basket.add(product);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getNameProduct().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }

    public int sumBasket() {
        int sum = 0;
        for (Product product : basket) {
            sum += product.getCostProduct();
        }
        return sum;
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            for (Product product : basket) {
                System.out.println(product.toString());
            }
            System.out.println("Итого: " + sumBasket());
            System.out.println("Специальных товаров: " + getSpecialProductCount());
        }
    }

    public boolean findProduct(String nameProduct) {
        for (Product product : basket) {
            if (nameProduct.equals(product.getNameProduct())) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        basket.clear();
    }

    public int getSpecialProductCount() {
        int count = 0;
        for (Product product : basket) {
            if (product.isSpecial()) {
                count++;
            }
        }
        return count;
    }

    public int getProductCount() {
        return basket.size();
    }
}