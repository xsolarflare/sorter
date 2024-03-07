import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        //int[] array = {9, 23, 17, 83, 1, 8, 6, 100};
        int[][] sortTmies = new int[3][3]; //Кол-во элементов / Тип сортировки

        int[] arrayS = fillArray(100); //Small
        int[] arrayM = fillArray(1000); //Medium
        int[] arrayB = fillArray(10000); //Big

        System.out.println("Сортировка массива длинны 100");
        print(arrayS);
        print(Sorter.sorterBubble(arrayS));
        print(Sorter.sorterInput(arrayS));
        print(Sorter.sorterQuick(arrayS));
        Sorter.printTR();
        sortTmies[0][0] = Sorter.getTR(0);
        sortTmies[0][1] = Sorter.getTR(1);
        sortTmies[0][2] = Sorter.getTR(2);

        System.out.println("Сортировка массива длинны 1000");
        print(arrayM);
        print(Sorter.sorterBubble(arrayM));
        print(Sorter.sorterInput(arrayM));
        print(Sorter.sorterQuick(arrayM));
        Sorter.printTR();
        sortTmies[1][0] = Sorter.getTR(0);
        sortTmies[1][1] = Sorter.getTR(1);
        sortTmies[1][2] = Sorter.getTR(2);

        System.out.println("Сортировка массива длинны 10000");
        print(arrayB);
        print(Sorter.sorterBubble(arrayB));
        print(Sorter.sorterInput(arrayB));
        print(Sorter.sorterQuick(arrayB));
        Sorter.printTR();
        sortTmies[2][0] = Sorter.getTR(0);
        sortTmies[2][1] = Sorter.getTR(1);
        sortTmies[2][2] = Sorter.getTR(2);

        graphCreate(sortTmies);


    }

    public static void graphCreate(int[][] arr) {
        int[][] percentArr = new int[3][3];
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                percentArr[j][i] = arr[j][i] / ((int) Math.round((arr[j][0] + arr[j][1] + arr[j][2])/50));
            }
        }
        int elements = 100;
        for (int i = 0; i < 3; i++) {
            System.out.println("============================================================================");
            System.out.println("Длительность выполнения сортировок массива с "+ elements +" элементами");
            elements = elements * 10;
            System.out.print("Пузырьком ");
            for (int j = 0; j < percentArr[i][0]; j++) {
                System.out.print("█");
            }
            System.out.println();
            System.out.print("Вставками ");
            for (int j = 0; j < percentArr[i][1]; j++) {
                System.out.print("█");
            }
            if (percentArr[i][1] == 0) { System.out.print("█"); }
            System.out.println();
            System.out.print("Быстрая   ");
            for (int j = 0; j < percentArr[i][2]; j++) {
                System.out.print("█");
            }
            if (percentArr[i][1] == 0) { System.out.print("█"); }
            System.out.println();
        }

        System.out.println("============================================================================");

        System.out.println("Средние результаты длительности выполнения сортировок");
        elements = elements * 10;
        System.out.print("Пузырьком ");
        for (int j = 0; j < ((int) Math.round((percentArr[0][0] + percentArr[1][0] + percentArr[2][0])/3)); j++) {
            System.out.print("█");
        }
        System.out.println();
        System.out.print("Вставками ");
        for (int j = 0; j < ((int) Math.round((percentArr[0][1] + percentArr[1][1] + percentArr[2][1])/3)); j++) {
            System.out.print("█");
        }
        if (((int) Math.round((percentArr[0][1] + percentArr[1][1] + percentArr[2][1])/3)) == 0) { System.out.print("█"); }
        System.out.println();
        System.out.print("Быстрая   ");
        for (int j = 0; j < ((int) Math.round((percentArr[0][2] + percentArr[1][2] + percentArr[2][2])/3)); j++) {
            System.out.print("█");
        }
        if (((int) Math.round((percentArr[0][2] + percentArr[1][2] + percentArr[2][2])/3)) == 0) { System.out.print("█"); }
        System.out.println();


    }

    public static int[] fillArray(int num){
        int array[] = new int[num];
        for (int i = 0; i < array.length; i++) {
            array[i] =  ThreadLocalRandom.current().nextInt(0, num + 1);
        }
        return array;
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

}

/*

DONE---TODO Реализовать пузырьковую сортировку отдельным методом
DONE---TODO Реализовать сортировку вставками отдельным методом
DONE---TODO Реализовать быструю сортировку из учебника отдельным методом
DONE---TODO Написать метод по заполнению массива с заданным кол-вом элементов
DONE---TODO Реализовать возможность отследить время работы метода
DONE---TODO Засечь время каждой сортировки для 100 1000 и 10000 эл-тов массива
DONE---TODO Построить сравнительный график (как видит автор)

*/
