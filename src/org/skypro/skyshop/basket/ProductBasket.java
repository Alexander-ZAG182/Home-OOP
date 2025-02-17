
package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> basket;

    public ProductBasket() {
        this.basket = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть null");
        }
        String productName = product.getNameProduct();
        List<Product> products = basket.get(productName);
        if (products == null) {
            products = new ArrayList<>();
            basket.put(productName, products);
        }
        products.add(product);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = basket.remove(name);
        if (removedProducts != null) {
            return removedProducts;
        } else {
            return new ArrayList<>();
        }
    }

    public int sumBasket() {
        int sum = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                sum += product.getCostProduct();
            }
        }
        return sum;
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
                for (Product product : entry.getValue()) {
                    System.out.println(product.toString());
                }
            }
            System.out.println("Итого: " + sumBasket());
            System.out.println("Специальных товаров: " + getSpecialProductCount());
        }
    }

    public boolean findProduct(String nameProduct) {
        return basket.containsKey(nameProduct);
    }

    public void cleanBasket() {
        basket.clear();
    }

    public int getSpecialProductCount() {
        int count = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getProductCount() {
        int count = 0;
        for (List<Product> products : basket.values()) {
            count += products.size();
        }
        return count;
    }
}