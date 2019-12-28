package com.groupOne;

import java.util.ArrayList;
import java.util.Random;

public class auto {
    public static int[] StringtoDigit(String a) {
        int[] digit = new int[4];
        for(int i = 0; i < 4; i++){
            digit[i] = Integer.parseInt(String.valueOf(a.charAt(i)));
        }
        return digit;
    }
    public static int[] GetStrikeHit(int[] guess, String random_secret){
        int[] strike_hit = {0,0};
        int[] secret = StringtoDigit(random_secret);
        for(int i=0;i<guess.length;i++){
            if(contains(secret, guess[i])) {
                if(guess[i] == secret[i]) {
                    strike_hit[0]++;
                } else{
                    strike_hit[1]++;
                }
            }
        }
        return strike_hit;
    }
    public static void main(String[] args) {

        ArrayList<String> random_secret = new ArrayList<>();
        int[] secret = new int[4];
        int i;
        int j;
        //int[] guess = { 1, 2, 3, 4 };
        int[] get_sh = new int[2];

        for (i = 0; i < 10000; i++) {
            random_secret.add(String.format("%04d", i));
        }
       // System.out.println("\nRandom secret: 1234");


        for (int x = 1000; x < 1002; x++) {
            int[] guess = {1, 2, 3, 4};
            boolean z = true;
            ArrayList<String> digits = new ArrayList<>();
            ArrayList<String> remove_list = new ArrayList<>();
            ArrayList<String> consist_number = new ArrayList<>();


            for (i = 0; i < 10000; i++) {
                digits.add(String.format("%04d", i));
            }

            int l = 1;
            while (z) {
                System.out.println(guess[0] +""+guess[1] +""+guess[2] +""+guess[3]);
                get_sh = GetStrikeHit(guess, random_secret.get(x));
                System.out.println(get_sh[0] + "-" + get_sh[1]);
                if (get_sh[0] == 4) {
                    System.out.println("Random secret: " + random_secret.get(x));
                    System.out.println("I won the game in " + l + " Steps.\n");
                    z = false;
                }
                for (i = 0; i < digits.size(); i++) {
                    int strikes = 0;
                    int hits = 0;
                    secret = StringtoDigit(digits.get(i));
                    for (j = 0; j < guess.length; j++) {
                        if (contains(secret, guess[j])) {
                            if (guess[j] == secret[j]) {
                                strikes++;
                            } else {
                                hits++;
                            }
                        }
                    }
                    if (strikes == get_sh[0] && hits == get_sh[1]) {
                        //System.out.println(digits.get(i));
                        consist_number.add(digits.get(i));
                    }
                }
                for (i = 0; i < digits.size(); i++) {
                    digits.remove(i);
                }
                for (i = 0; i < consist_number.size(); i++) {
                    digits.add(consist_number.get(i));
                }
                int size = digits.size() - 1;
                guess = StringtoDigit(digits.get(size));
                l++;
            }
        }
    }

    public static int[] numberGenerator() {
        Random randy = new Random();
        int[] randArray = {10,10,10,10};

        for(int i=0;i<randArray.length;i++){
            int temp = randy.nextInt(10);
            int j = 0;
            while(j < 5){
                temp=randy.nextInt(10);
                j++;
            }
            randArray[i]=temp;
        }
        return randArray;
    }
    public static boolean contains(final int[] array, final int v) {
        boolean result = false;
        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }
        return result;
    }

}
