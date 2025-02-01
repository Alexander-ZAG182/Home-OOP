package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

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

        SearchEngine searchEngine = new SearchEngine();

        Article appleArticle = new Article(
                "Статья о яблоках",
                "Яблоко - очень полезно");
        Article bikeArticle = new Article(
                "Статья о велосипеде ",
                "Велосипед - средство передвижения"
        );

        searchEngine.add(banana);
        searchEngine.add(bike);
        searchEngine.add(apple);
        searchEngine.add(water);
        searchEngine.add(cheese);
        searchEngine.add(juice);
        searchEngine.add(appleArticle);
        searchEngine.add(bikeArticle);

        String searchQuery1 = "Яблоко";
        System.out.println("Поиск \"" + searchQuery1 + "\": " + Arrays.toString(searchEngine.search(searchQuery1)));

        String searchQuery2 = "Велосипед";
        System.out.println("Поиск \"" + searchQuery2 + "\": " + Arrays.toString(searchEngine.search(searchQuery2)));

        String searchQuery3 = "Лодка";
        System.out.println("Поиск \"" + searchQuery3 + "\": " + Arrays.toString(searchEngine.search(searchQuery3)));
    }
}
