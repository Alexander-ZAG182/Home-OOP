package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;


public class App {
    public static void main(String[] args) {
        Product bike = new SimpleProduct("Велосипед", 13000);
        Product apple = new DiscountedProduct("Яблоко", 500, 10);
        Product banana = new FixPriceProduct("Банан");
        Product water = new DiscountedProduct("Вода", 100, 20);
        Product cheese = new FixPriceProduct("Сыр");

        Product juice = new SimpleProduct("Сок", 350);

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
