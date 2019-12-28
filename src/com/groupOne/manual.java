package com.groupOne;
import java.util.*;

public class manual {
//1234
        public static void main(String[] args) {
            ArrayList<String> bigArr = generate10k();
            ArrayList<String> usable = new ArrayList<>();

            Boolean firstTry = true;
            String firstGuess = "5000";
            String randomGuess = "";
            int step = 1;

            while (true) {
                if (firstTry) {
                    System.out.println("My guess is: " + firstGuess);
                } else {
                    int randomIndex = generateRandomInt(bigArr.size());
                    randomGuess = bigArr.get(randomIndex);
                    System.out.println("My guess is: " + bigArr.get(randomIndex));
                }

                Scanner input = new Scanner(System.in);
                System.out.println("How many Strike did I get: ");
                int strike = input.nextInt();
                System.out.println("How many Hit did I get: ");
                int hit = input.nextInt();

                if (strike == 4 && hit == 0) {
                    System.out.println("I win after: " + step + " step(s)");
                    return;
                }

                step++;

                for (int i = 0; i < bigArr.size(); i++) {
                    if (firstTry) {
                        Map<String, Integer> scoreMap = checkScore(stringToIntArr(bigArr.get(i)), stringToIntArr(firstGuess));
                        if (scoreMap.get("strike").equals(strike) && scoreMap.get("hit").equals(hit)) {
                            usable.add(bigArr.get(i));
                        }
                    } else {
                        Map<String, Integer> scoreMap = checkScore(stringToIntArr(bigArr.get(i)), stringToIntArr(randomGuess));
                        if (scoreMap.get("strike").equals(strike) && scoreMap.get("hit").equals(hit)) {
                            usable.add(bigArr.get(i));
                        }
                    }
                }

                firstTry = false;

                System.out.println("Before: ");
                System.out.println(bigArr.toString());
                System.out.println("Size: " + bigArr.size() + "\n");

                bigArr.clear();
                for (int i = 0; i < usable.size(); i++) {
                    bigArr.add(usable.get(i));
                }
                usable.clear();

                System.out.println("After: ");
                System.out.println(bigArr.toString());
                System.out.println("Size: " + bigArr.size() + "\n");
            }
        }

        public static ArrayList<String> generate10k() {
            ArrayList<String> arr = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                arr.add(String.format("%04d", i));
            }
            return arr;
        }

        public static int generateRandomInt(int maxRange) {
            Random random = new Random();
            return random.nextInt(maxRange);
        }

        public static int[] stringToIntArr(String string) {
            int[] intArr = new int[4];
            for (int i = 0; i < 4; i++) {
                intArr[i] = Integer.parseInt(String.valueOf(string.charAt(i)));
            }
            return intArr;
        }

        public static Map<String, Integer> checkScore(int[] random, int[] guess) {
            int strike = 0;
            int hit = 0;
            Map<String, Integer> scoreMap = new HashMap<>();

            for (int i = 0; i < random.length; i++) {
                if (contain(random, guess[i])) {
                    if (random[i] == guess[i]) {
                        strike++;
                    } else {
                        hit++;
                    }
                }
            }
            scoreMap.put("strike", strike);
            scoreMap.put("hit", hit);
            return scoreMap;
        }

        public static boolean contain(int[] array, int number) {
            for(int i = 0; i < array.length; i++) {
                if(array[i] == number){
                    return true;
                }
            }
            return false;
        }
    }

