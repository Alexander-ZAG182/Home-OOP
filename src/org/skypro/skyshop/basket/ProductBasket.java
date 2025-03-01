
package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

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
        return basket.values()
                .stream()
                .flatMap(List::stream)
                .mapToInt(Product::getCostProduct)
                .sum();
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            basket.values()
                    .stream()
                    .flatMap(List::stream)
                    .forEach(System.out::println);
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
        return (int) basket.values()
                .stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public int getProductCount() {
        return basket.values().stream()
                .mapToInt(List::size)
                .sum();
    }
}