package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            Product invalidProduct1 = new SimpleProduct("", 1000000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Product invalidProduct2 = new DiscountedProduct("Яблоко", -100, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Product invalidProduct3 = new FixPriceProduct(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Product invalidProduct4 = new DiscountedProduct("Груша", 200, -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
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

            List<Product> removedProducts = basket.removeProductByName("Яблоко");
            System.out.println("Удаленные продукты: " + removedProducts);
            basket.printBasket();

            removedProducts = basket.removeProductByName("Лодка");
            if (removedProducts.isEmpty()) {
                System.out.println("Список пуст");
            }

            basket.printBasket();
            System.out.println("Стоимость корзины : " + basket.sumBasket());

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка " + e.getMessage());
        }

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
        System.out.println("Поиск \"" + searchQuery1 + "\": " + searchEngine.search(searchQuery1));

        String searchQuery2 = "Велосипед";
        System.out.println("Поиск \"" + searchQuery2 + "\": " + searchEngine.search(searchQuery2));

        String searchQuery3 = "Лодка";
        System.out.println("Поиск \"" + searchQuery3 + "\": " + searchEngine.search(searchQuery3));

        try {
            Searchable bestMatch = searchEngine.findBestMatch("Яблоко");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("Лодка");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}