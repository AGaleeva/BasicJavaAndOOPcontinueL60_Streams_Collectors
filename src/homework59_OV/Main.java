package homework59_OV;

import java.util.List;

public class Main {
    /*
        Создайте класс товар Product с полями:
        название
        рейтинг
        цена
        категория
        Создайте лист из 10 товаров с разными значениями

        Задание 1
        Получите лист товаров, которые стоят дороже 200 евро.

        Задание 2
        Получите лист товаров, отсортированных по рейтингу

        Задание 3
        Проверьте есть ли в листе товаров, товар с названием: "Iphone XR"

        Задание 4 map
        Создайте новый лист товаров на основании старого, пусть в новом листе рейтинг будет увеличен на 1.
        Товары в исходном листе не должны измениться.

        Задание 5 forEach
        Измените цену товаров в исходном листе товаров: увеличьте ее на 20 евро.
        Товары в исходном листе должны измениться.

        Задание 6 reduce
        Посчитайте общую стоимость всех товаров в листе.
        */
    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Chair Aemes", "furniture", 200, 9),
                new Product("Iphone XR", "electronics", 1000, 7),
                new Product("Gibson Les Paul", "music", 2000, 6),
                new Product("Iron", "electronics", 120, 9),
                new Product("Washing Machine", "electronics", 800, 2),
                new Product("Vinyl Beatles", "music", 40, 5),
                new Product("Jeans", "clothes", 70, 4));


        List<Product> extensiveProduct = products.stream()
                .filter(p -> p.getPrice() > 100)
                .toList();
        System.out.println(extensiveProduct);
// сколько товаров стоят дороже 200 евро

        System.out.println("---------------------------------------------------");

        long res = products.stream()
                .filter(p -> p.getPrice() > 200)
                .count();
        System.out.println(res);

        System.out.println("---------------------------------------------------");

        List<Product> sortedByRating = products.stream()
                .sorted((a, b) -> Double.compare(a.getRate(), b.getRate()))
                .toList();
        System.out.println(sortedByRating);

        System.out.println("---------------------------------------------------");
        List<Product> topFive = products.stream()
                .sorted((a, b) -> Double.compare(b.getRate(), a.getRate()))
                .limit(5)
                .toList();
        System.out.println(topFive);

        boolean matchRes = products.stream().anyMatch(p -> p.getTitle().equals("Iphone XR"));
        System.out.println(matchRes);

        System.out.println("---------------------------------------------------");

        List<Product> modifiedProducts = products
                .stream().map(p -> {
                    p.setRate(p.getRate() + 1);
                return p;
                }).toList();

        List<Product> modifiedProducts1 = products // делает тоже самое, что и в предыдущем случае с мэп, но писать return
                                              // не нужно. Похож на forEach, но не терминальный
                .stream().peek(p -> p.setRate(p.getRate() + 1)).toList();
        System.out.println(products); // ссылка не изменилась, мутировал только объект внутри

        List<Product> newProducts = products.stream()
                .map(p -> new Product(p.getTitle(), p.getCategory(), p.getPrice(), p.getRate() + 1)).toList();

        System.out.println("---------------------------------------------------");

        products.forEach(s -> s.setPrice(s.getPrice() + 20));
        System.out.println(products);

        System.out.println("---------------------------------------------------");

        double totalPrice = products.stream()
                .map(Product::getPrice)
                .reduce(0., Double::sum);
        System.out.println(totalPrice);
    }
}
