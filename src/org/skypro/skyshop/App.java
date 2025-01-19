package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        Product bike = new Product("Велосипед", 13000);
        Product apple = new Product("Яблоко", 500);
        Product banana = new Product("Банан", 300);
        Product water = new Product("Вода", 100);
        Product cheese = new Product("Сыр", 400);

        Product juice = new Product("Сок", 350);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(bike);
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(water);
        basket.addProduct(cheese);
        basket.addProduct(juice);

        basket.printBasket();
        System.out.println("Стоимость корзины : " + basket.sumBasket());
        System.out.println("Поиск товара " + apple.getNameProduct() + " в корзине : " + basket.findProduct(apple.getNameProduct()));
        System.out.println("Поиск товара " + juice.getNameProduct() + " в корзине : " + basket.findProduct(juice.getNameProduct()));
        basket.cleanBasket();
        basket.printBasket();
        System.out.println("Стоимость пустой корзины : " + basket.sumBasket());
        System.out.println("Поиск товара : " + apple.getNameProduct() + " в корзине : " + basket.findProduct(apple.getNameProduct()));
    }
}
