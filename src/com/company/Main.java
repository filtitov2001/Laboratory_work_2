package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int MoneyDecrease[] = new int[4];
        int[] Money =new int[4];
        System.out.print("Введите количество купюр в банке ( Купюры номиналом:1000, 500, 100, 30):\n");
        for(int i=0;i<4;i++)
            Money[i]=in.nextInt();
        System.out.println();
        int sum = Money[0] * 1000 + Money[1] * 500 + Money[2] * 100 + Money[3] * 30;
        System.out.println("Сумма снятия:");
        int sumout = in.nextInt();
        if(sumout % 10 !=0) {
            System.out.print("Невозможно выдать нужную сумму купюрами имеющегося номинала.");
            return;
        }
        else  if (sumout > sum){
            System.out.println("К сожалению, в банкомате недостаточно купюр для выдачи.");
            return;
        }
        else {
            while (sumout % 100 != 0 && sumout > 0 && Money[3] > 0) {
                sumout -= 30;
                Money[3]--;
                MoneyDecrease[3]++;
            }
            while( Money[0] > 0 && sumout - 1000 >= 0) {
                sumout -= 1000;
                Money[0]--;
                MoneyDecrease[0]++;
            }
            while (Money[1] > 0 && sumout - 500 >= 0) {
                sumout -= 500;
                Money[1]--;
                MoneyDecrease[1]++;
            }
            while (Money[2] > 0 && sumout - 100 >= 0) {
                sumout -= 100;
                Money[2]--;
                MoneyDecrease[2]++;
            }
            if (sumout == 0) {
                System.out.print(MoneyDecrease[0] + ": 1000-рублевых купюр; " + MoneyDecrease[1] + ": 500-рублевых купюр; " + MoneyDecrease[2] + ": 100-рублевых купюр; " + MoneyDecrease[3] + ": 30-рублевых купюр.");
            }
            else
                System.out.println("Невозможно выдать введенную сумму.");
        }
    }
}