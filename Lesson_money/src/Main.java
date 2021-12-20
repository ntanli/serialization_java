import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите количество монет: ");
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int[] number = new int[n];
        int summ = 0;
        int count = 0;
        System.out.println("Введите номинал монеты: ");

        //заполняем массив номиналами
        for (int i = 0; i < number.length; i++) {
            number[i] = console.nextInt();
        }
        //сортируем
        Arrays.sort(number);
        System.out.println(Arrays.toString(number));

        System.out.println("Введите сумму: ");
        int m = console.nextInt();

        for (int i = number.length - 1; i >= 0; i--) {
            if (m / number[i] != 0) {
                summ = number[i];
                count = m / summ;
                m = m - (number[i] * count);
                System.out.println("Нужны монеты: " + "Номинала " + summ + " Количество " + count);
            }
        }
    }
}
