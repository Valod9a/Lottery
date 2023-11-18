package app;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static int[][] Numbers = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };
    public static void main(String[] args) {
        outputList();
        outputResult(input(), randomNum(Numbers));
    }
    public static int input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Try to guess a number from the list: ");
        int num = sc.nextInt();
        sc.close();
        return num;
    }
    public static int randomNum(int[][] numbers){
        //Створюємо новий об'єкт типу Random
        Random random = new Random();
        //Повертаємо рандомне значення від 1 до 16
        int randomRow = random.nextInt(numbers.length);
        int randomColumn = random.nextInt(numbers[randomRow].length);
        return numbers[randomRow][randomColumn];
    }
    public static void outputResult(int inputNum, int winNum){
        boolean result = inputNum == winNum;
        if (result) System.out.println("You are right!");
        else {
            System.out.printf("""
                    You are wrong.
                    It was %d.""", winNum);
        }
    }
    public static void outputList(){
        for (int[] row: Numbers){
            for(int column: row){
                if (column == Numbers[Numbers.length-1][row.length-1]) {
                    System.out.printf("%d.", column);
                    break;
                }
                System.out.printf("%d,\t", column);
            }
            System.out.println();
        }
        System.out.println();
    }
}
