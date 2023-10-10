import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*
        Возьмём числа 50, 60, 70, 80, 90, 100, 110, 120.
        Отберём те из них, которые меньше 90.
        Добавим к каждому отобранному по 10.
        Распечатаем первые три получившихся числа.
        */

        int[] array = {50, 60, 70, 80, 90, 100, 110, 120};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 90) {
                array[i] += 10;
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("----------------------------------------------------");

        int[] newArray = {50, 60, 70, 80, 90, 100, 110, 120};

        Arrays.stream(newArray).filter(i -> i < 90).map(i -> i += 10).limit(3).forEach(System.out :: println);


    }
}
