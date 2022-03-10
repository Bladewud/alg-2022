//Сармулейно Артем
//2Б2
//Задача 1

/*
 * Напишите программу, которая должна имитировать раздачу карт для игры в покер.
 * Программа получает число n, задаваемое с консоли пользователем, и раздает карты на n игроков (по 5 карт каждому)
 * из рассортированной колоды. Разделяйте пять карт, выданных каждому игроку, пустой строкой.
 * Объект карты реализуется классом PlayingCard.
 */

package com.company;

import ru.bgpu.task.arrays.PlayingCard;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Введите кол-во игроков: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n < 0 || n > 10) {
            System.out.println("Кол-во игроков не может быть меньше нуля или больше 10");
            System.exit(0);
        }
        int position = 0;
        PlayingCard[] cards = new PlayingCard[52];
        for (int i = 0; i < PlayingCard.SUITS_LIST.length; i++) {
            for (int j = 0; j < PlayingCard.RANK_LIST.length; j++) {
                cards[position] = new PlayingCard(PlayingCard.SUITS_LIST[i], PlayingCard.RANK_LIST[j]);
                position++;
            }
        }
        int[] randomValues = GenerateRandomArray(n);
        position = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("Карты игрока [%d]", i + 1);
            System.out.println();
            for (int j = 0; j < 5; j++) {
                System.out.println(cards[randomValues[position]].toString());
                position++;
            }
        }
    }

    private static int[] GenerateRandomArray(int n) {
        int[] randomArray = new int[n * 5];
        Random random = new Random();
        int randomValue;
        boolean trigger = false;
        for (int i = 0; i < randomArray.length; ) {
            randomValue = random.nextInt(52);
            for (int j = 0; j < randomArray.length; ) {
                if (randomArray[j] == randomValue) {
                    trigger = true;
                    break;
                }
                j++;
            }
            if (!trigger) {
                randomArray[i] = randomValue;
                i++;
            }
            trigger = false;
        }
        return randomArray;
    }
}