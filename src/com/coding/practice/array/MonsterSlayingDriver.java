package com.coding.practice.array;

/**
 * @author : Velmurugan Moorthy
 * @date : 08/09/2021
 *
 * Problem name : Circle of Monsters
 *
 * Problem Description
 *
 * You are playing another computer game, and now you have to slay n monsters. These monsters are standing in a circle, numbered clockwise from 1 to n. Initially, the i-th monster has ai health.
 *
 * You may shoot the monsters to kill them. Each shot requires exactly one bullet and decreases the health of the targeted monster by 1 (deals 1 damage to it). Furthermore, when the health of some monster i becomes 0 or less than 0, it dies and explodes, dealing bi damage to the next monster (monster i+1, if i < n, or monster 1, if i=n). If the next monster is already dead, then nothing happens. If the explosion kills the next monster, it explodes too, damaging the monster after it and possibly triggering another explosion, and so on.
 *
 * You have to calculate the minimum number of bullets mod 10 9 + 7 you have to fire to kill all n monsters in the circle.
 *
 * NOTE: If the minimum no. of bullets are x then you have to return x % 1e9 + 7 .
 *
 *
 *
 * Problem Constraints
 *
 * 2<= n <=300000
 * 1<= A[i], B[i]<= 1e9
 *
 *
 *
 * Input Format
 * First Argument is array of integers of N size denoting array A Second Argument is array of integers of N size denoting array B
 *
 *
 * Output Format
 * Return the miniumum number of bullets mod 10 9 + 7 you have to fire to kill all of the monsters.
 *
 *
 * Example Input
 * Input- 1
 *
 * A=[7,2,5]
 * B=[15,14,3]
 *
 * Input- 2
 *
 * A=[1 2]
 * B=[2 1]
 *
 *
 *
 * Example Output
 * Output- 1
 *
 * 6
 *
 * Output- 2
 *
 * 1
 *
 *
 *
 * Example Explanation
 * Explanation-1
 *
 * Firstly we shoot 2nd monster whose health is 2 with 2 bullets and then this monster will create damage of 14 to another monster.
 * Now 3rd monster health will decrease by 14 units . hence 3rd monster also died . hence it will create damage of 3 units to 1st monster
 * Now 1st monster health is 7-3=4 . and now 4 more bullets are required to kill 1st monster.
 * Total bullets required to kill all the monsters = 2+4= 6
 *
 * Explanation-2
 *
 * Kill 1st monster with 1 bullet so it will cause 2 units of damage to 2nd monster.
 * Hence 2nd monster automatically died.
 * Total bullets required=1
 */
public class MonsterSlayingDriver {
    public static void main(String[] args) {

        //Test case #1 - PASS
//        int[] lives = {7,2,5};
//        int[] explosives = {15,14,3};

        //Test case #2 - PASS
//        int[] lives = {1, 2};
//        int[] explosives = {2, 1};


        //Test case #No explosives in monsters - PASS
//        int[] lives = {100, 2, 3};
//        int[] explosives = {0, 0, 0};

        //Test case #No explosives in monsters - PASS
        int[] lives = {1, 2, 3, 4};
        int[] explosives = {0, 0, 0, 0};



        //Test case #
//        int[] lives = {};
//        int[] explosives = {};

        MonsterSlayerTools monsterSlayerTools = new MonsterSlayerTools();
//        int sum = monsterSlayerTools.findSum(lives, explosives);
//        System.out.println("Sum : " + sum);
        int minimumBullets = monsterSlayerTools.findMinimumBullets(lives, explosives);
        System.out.println("minimumBullets : " + minimumBullets);
    }
}

class MonsterSlayerTools{

    public int findMinimumBullets(int[] lives, int[] explosives){

        int sum = findSum(lives, explosives);
        int monsterCount = lives.length;
        int minimumBullets = Integer.MAX_VALUE;

        for(int loopIndex = 0; loopIndex < monsterCount; loopIndex++){
            System.out.println("LoopIndex : " + loopIndex);
            System.out.println("Modulo : " + (loopIndex - 1 + monsterCount)% monsterCount);
            int currentBulletsRequired = Math.max(0, lives[loopIndex] - explosives[(loopIndex - 1 + monsterCount) % monsterCount]);
            System.out.println("currentBulletsRequired : " + currentBulletsRequired);
            minimumBullets = Math.min(minimumBullets, sum - currentBulletsRequired + lives[loopIndex]);
        }
        //System.out.println("minimumBullets : " + minimumBullets);

        return minimumBullets;
    }

    public int findSum(int[] lives, int[] explosives){

        int monsterCount = lives.length;
        int sum = 0;

        for(int loopIndex = 0; loopIndex < monsterCount; loopIndex++){
            sum += Math.max(0, (lives[loopIndex] - explosives[(loopIndex - 1 + monsterCount) % monsterCount]));
        }
        //System.out.println("Sum : " + sum);
        return sum;
    }

}
