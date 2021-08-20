package com.coding.practice.array;

import java.util.Arrays;

/**
 * @author Velmurugan Moorthy
 * @date 20.08.2021
 *
 * Problem name : Beggars Outside Temple
 *
 * There are N (N > 0) beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to his faith and ability) to some K beggars sitting next to each other.
 *
 * Given the amount donated by each devotee to the beggars ranging from i to j index, where 1 <= i <= j <= N, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
 *
 * Example:
 *
 * Input:
 * N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
 *
 * Return: [10, 55, 45, 25, 25]
 *
 * Explanation:
 * => First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
 *
 * => Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
 *
 * => Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
 *
 * ×
 * -->
 */
public class CoinsCountDriver {
    public static void main(String[] args) {

        int beggarCount = 5;
        int[][] worshipperData = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        //int beggarCount = 10;
        //int[][] worshipperData = {{0,3}};
        CoinsCountTools coinsCountTools = new CoinsCountTools();
        int[] result = coinsCountTools.countCoins(beggarCount, worshipperData);
        coinsCountTools.printArray(result);
    }
}

class CoinsCountTools {
    public int[] countCoins(int beggarCount, int[][] worshipperData) {

       // System.out.println("worshipppers count : " + worshipperData.length);
        int worshippersCount = worshipperData.length;
        int[] finalCoinCount = new int[beggarCount];

        if(worshippersCount <= 0){
            return  finalCoinCount;
        }

        if(worshippersCount == 1 && beggarCount == 1){
            return worshipperData[0];
        }

        for(int loopIndex = 0; loopIndex < worshippersCount; loopIndex++){

            int start = worshipperData[loopIndex][0] - 1;
            int end = worshipperData[loopIndex][1];
            int donationCoinCount = worshipperData[loopIndex][2];

                finalCoinCount[start] += donationCoinCount;
                if(end < beggarCount){
                    finalCoinCount[end] -= donationCoinCount;
                }
        }

        for(int loopIndex = 0; loopIndex < beggarCount; loopIndex++){
            if(loopIndex > 0 && loopIndex < beggarCount){
                finalCoinCount[loopIndex] += finalCoinCount[loopIndex - 1];
            }
        }

        //System.out.println();

        //printArray(finalCoinCount);

        return finalCoinCount;
    }

    public void printArray(int[] finalCoinCount) {
        Arrays.stream(finalCoinCount).forEach(element -> {
            System.out.print(element + " ");
        });
    }

    public void printTwoDArray(int[][] beggarCoinsCount) {
        for(int rowIndex = 0; rowIndex < beggarCoinsCount.length ; rowIndex++){
            for(int columnIndex = 0; columnIndex < beggarCoinsCount[0].length ; columnIndex++){
                System.out.print(beggarCoinsCount[rowIndex][columnIndex] + " ");
            }
            System.out.println();
        }
    }


}
