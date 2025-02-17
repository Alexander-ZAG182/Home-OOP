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

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        // Проверка на некорректные данные
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

        // Создание продуктов
        Product bike = new SimpleProduct("Велосипед", 13000);
        Product apple = new DiscountedProduct("Яблоко", 500, 10);
        Product banana = new FixPriceProduct("Банан");
        Product water = new DiscountedProduct("Вода", 100, 20);
        Product cheese = new FixPriceProduct("Сыр");
        Product juice = new SimpleProduct("Сок", 350);

        // Работа с корзиной
        ProductBasket basket = new ProductBasket();

        basket.addProduct(bike);
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(water);
        basket.addProduct(cheese);
        basket.addProduct(juice);

        // Удаление продуктов по имени
        List<Product> removedProducts = basket.removeProductByName("Яблоко");
        System.out.println("Удаленные продукты: " + removedProducts);
        basket.printBasket();

        removedProducts = basket.removeProductByName("Лодка");
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }

        basket.printBasket();
        System.out.println("Стоимость корзины: " + basket.sumBasket());

        // Поиск товаров в корзине
        System.out.println("Поиск товара " + apple.getNameProduct() + " в корзине: " + basket.findProduct(apple.getNameProduct()));
        System.out.println("Поиск товара " + juice.getNameProduct() + " в корзине: " + basket.findProduct(juice.getNameProduct()));

        // Очистка корзины
        basket.cleanBasket();
        basket.printBasket();
        System.out.println("Стоимость пустой корзины: " + basket.sumBasket());
        System.out.println("Поиск товара: " + apple.getNameProduct() + " в корзине: " + basket.findProduct(apple.getNameProduct()));

        // Работа с поисковым движком
        SearchEngine searchEngine = new SearchEngine();

        Article appleArticle = new Article("Статья о яблоках", "Яблоко - очень полезно");
        Article bikeArticle = new Article("Статья о велосипеде", "Велосипед - средство передвижения");

        searchEngine.add(banana);
        searchEngine.add(bike);
        searchEngine.add(apple);
        searchEngine.add(water);
        searchEngine.add(cheese);
        searchEngine.add(juice);
        searchEngine.add(appleArticle);
        searchEngine.add(bikeArticle);

        // Поиск по запросу
        String searchQuery1 = "Яблоко";
        Map<String, Searchable> searchResults1 = searchEngine.search(searchQuery1);
        System.out.println("Поиск \"" + searchQuery1 + "\": " + searchResults1);

        String searchQuery2 = "Велосипед";
        Map<String, Searchable> searchResults2 = searchEngine.search(searchQuery2);
        System.out.println("Поиск \"" + searchQuery2 + "\": " + searchResults2);

        String searchQuery3 = "Лодка";
        Map<String, Searchable> searchResults3 = searchEngine.search(searchQuery3);
        System.out.println("Поиск \"" + searchQuery3 + "\": " + searchResults3);

        // Поиск лучшего результата
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