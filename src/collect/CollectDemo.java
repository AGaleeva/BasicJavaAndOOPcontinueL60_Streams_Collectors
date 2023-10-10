package collect;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectDemo {
    public static void main(String[] args) {

        List<String> fruits = List.of("apple", "orange", "mango", "lime", "lime");

//        собираем в лист
        List<String> fruitsInCapital = fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

//        собираем в множество

        Set<String> fruitsSetInCapital = fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println(fruitsSetInCapital);

//        собрать в конкретную структуру

        LinkedList<String> fruitsLinkedList = fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toCollection(LinkedList::new));

// counting
        long count = fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.counting());

//        собираем в Map
//        у нас массив слов fruits: можно сохранить сами слова в качестве ключей, а длину - в качестве значений.
        Map<String, Integer> fruitsMap = fruits.stream()
//                .map(String::toUpperCase)   // могут быть промежуточные операции
                .distinct()                   // остаются только уникальные значения
                .collect(Collectors.toMap(    // Function.identity(): s -> s (равносильна такой стрелке, т.е. возвращает
                        Function.identity(),  // сам объект)
                        fruit -> fruit.length()
                ));
        System.out.println(fruitsMap);

    }
}
