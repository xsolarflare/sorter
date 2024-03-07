import java.util.Arrays;

public class Sorter {
    private Sorter() {

    }
    static int timerS; //Начало таймера
    static int timerE; //Конец таймера
    static int timerD; //Продолжительность
    static int[] timerResults = {0, 0, 0};
    //Пузырьковая, Вставочная, Быстрая

    public static int[] sorterBubble(int[] array) {
        timerStart();
        int counter = array.length;
        int temp = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < (counter-1); j++) {
                if (array[j+1] < array[j]) {
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
            counter--;
        }
        timerEnd(0);
        return array;
    }

    public static int[] sorterInput(int[] array) {
        timerStart();
        int currE = 0;
        int counter = 0;
        for (int i = 1; i < array.length; i++) {
            currE = array[i];
            counter = i-1;
            while(counter >= 0 && currE < array[counter]) {
                array[counter + 1] = array[counter];
                counter--;
            }
            array[counter+1] = currE;
        }
        timerEnd(1);
        return array;
    }

    public static int[] sorterQuick(int[] array) {
        timerStart();
        int[] sorted = sortQRec(array, array[0], array[(int) Math.round(array.length/2)]);
        timerEnd(2);
        return sorted;
    }

    public static int[] sortQRec(int[] a, int low, int high) {
        if (a.length == 0)
            return null;
        if (low >= high)
            return a;
        int middle = low + (high - low) / 2;
        int op = a[middle];
        int i = low, j = high;
        while (i <= j) {
            while (a[i] < op) {
                i++;
            }
            while (a[j] > op) {
                j--;
            }
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            sortQRec(a, low, j);
        if (high > i)
            sortQRec(a, i, high);
        return a;
    }

    private static void timerStart() {
        timerS = (int) System.nanoTime();
    }
    private static void timerEnd(int a) {
        timerE = (int) System.nanoTime();
        timerD = (timerE - timerS);
        timerResults[a] = timerD;
    }

    public static void printTR() {
        System.out.println("Время выполнения " + Arrays.toString(timerResults));
    }

    public static int getTR(int s) {
       return timerResults[s];
    }
}
