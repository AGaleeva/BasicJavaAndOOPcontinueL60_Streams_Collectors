package optional;

import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    record Product(String title, double price) {
        @Override
        public String title() {
            return title;
        }

        @Override
        public double price() {
            return price;
        }
    };
    public static void main(String[] args) {
        List<String> fruits = List.of("orange", "apple", "banana", "mango", "kiwi");

//        как получить первый элемент, удовлетворяющий описанию
//        findFirst

        Optional<String> kiwiOptional = fruits.stream().filter(s -> s.length() < 5)
                .findFirst();

        String fruit = kiwiOptional.get();
        System.out.println(fruit);

        Optional<String> shortestOptional = fruits.stream().filter(s -> s.length() < 4)
                .findFirst();
//        shortestOptional.get(); вызывает ошибку
        System.out.println(shortestOptional.isPresent());
        /*if (shortestOptional.isPresent()) {
            System.out.println(shortestOptional.get());
        }*/

        shortestOptional.ifPresent(System.out::println);

//        Можно добавить значение по умолчанию - будет подставляться в случае, если внутри Optional null, т.е. пусто

//        если есть значение - мы его получим, если его нет - получим то, что указано в supplier

        String result =
            shortestOptional.orElseGet(() -> "passion fruit");
        System.out.println(result);

//        если есть значение - мы его получим, если его нет - выбросим ошибку
//        String res2 = shortestOptional
//                .orElseThrow(IllegalArgumentException::new);

//        Создайте лист из продуктов с полями:
//        - название
//        - цена
//        Создайте метод getProductByTitle, принимающий название продукта и весь список продуктов и возвращает
//        продукт с указанным названием (первый попавшийся). Если этого продукта нет, то он должен возвращать
//        продукт с названием "doll" и ценой 15.


        List<Product> products = List.of(new Product("dress", 100), new Product("TV", 1000), new Product("Set of " +
                "pencils", 5), new Product("Electric kettle", 45));

        System.out.println(getProductByTitle(products, "smartphone"));

    }
    public static Product getProductByTitle(List<Product> list, String title) {
        Optional<Product> res = list.stream().filter(p -> p.title().equalsIgnoreCase(title)).findFirst();
        return res.orElseGet(() -> new Product("doll", 15));
    }
}
