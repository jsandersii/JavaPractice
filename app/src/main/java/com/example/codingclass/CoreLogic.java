package com.example.codingclass;

import java.util.HashMap;
import java.util.Map;

public class CoreLogic {

    /*
     * Question #1
     * Given a non-empty string and an int n, return a new string where the char at index n has been removed. The value of n will be a valid index
     * of a char in the original string (i.e. n will be in the range 0..str.length()-1 inclusive).
     * missingChar(“kitten”, 1) → “ktten”
     * missingChar(“kitten”, 0) → “itten”
     * missingChar(“kitten”, 4) → “kittn” (edited)
     */

    public static String changeString (String str, int n) {
        try {
            StringBuilder results = new StringBuilder();
            for (int i = 0; i <= str.length() -1; i++) {
                if (i != n) {
                    results.append(str.charAt(i));
                }
            }

            return results.toString();
        } catch (Exception e) {
            System.out.print("Something went wrong or someone lied" + e);
            return null;
        }

    }

    /*
     * Given an array of ints, return the number of times that two 6's are next to each other in the array. Also count instances where the second “6” is
     * actually a 7.
     * array667([6, 6, 2]) → 1
     * array667([6, 6, 2, 6]) → 1
     * array667([6, 7, 2, 6]) → 1
     */

    public static int getSixCount (int[] array) {
        int results = 0;
        // Checking for number of pairs so less than a pair should return 0 or invalid
        if (array.length < 2) {
            return 0;
        }

        for (int j = 1; j <= array.length - 1; j++){
            int a = array[j - 1];
            int b = array[j];

            if (a == 6 && b == 6 || a == 6 && b == 7 ) {
                results += 1;
            }
        }

        return results;
    }


    /*
     * Question #3 Given 2 non-negative ints, a and b, return their sum, so long as the sum has the same number of digits as a.
     * If the sum has more digits than a, just return a without b. (Note: one way to compute the number of digits of a non-negative int n is
     * to convert it to a string with String.valueOf(n) and then check the length of the string.)
     *
     * sumLimit(2, 3) → 5
     * sumLimit(8, 3) → 8
     * sumLimit(8, 1) → 9
     */

    public static int getSumthing(int a, int b) {
        int sum = a + b;
        int aLength = String.valueOf(a).length();
        int sumLength = String.valueOf(sum).length();

        return sumLength == aLength? sum : a;

    }

    /*
     * Question #4
     * We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and big bars (5 kilos each).
     * Return the number of small bars to use, assuming we always use big bars before small bars. Return -1 if it can’t be done.
     * makeChocolate(4, 1, 9) → 4
     * makeChocolate(4, 1, 10) → -1
     * makeChocolate(4, 1, 7) → 2
     * makeChocolate(6, 2, 7) → 2
     * makeChocolate(4, 1, 5) → 0
     */

    public static int getChocolateBox(int smallBars, int bigBars, int goalKilos) {
        int bigWeight = bigBars * 5;
        int filterWeight = goalKilos - bigWeight;
        int checkWeight = filterWeight % smallBars;

        while (bigWeight > goalKilos) {
            bigWeight = ((bigWeight / 5) - 1) * 5;
            filterWeight = goalKilos - bigWeight;
            checkWeight = filterWeight % smallBars;
        }

        if (filterWeight > 0 && goalKilos > 0) {
            if (checkWeight == 0) {
                if (smallBars + bigWeight == goalKilos) {
                    return smallBars;

                } else {
                    return -1;
                }

            }  else {
                if (checkWeight + bigWeight == goalKilos) {
                    return checkWeight;

                } else {
                    return -1;
                }
            }

        } else {
            return 0;
        }

    }


    /*Question #5
     * Given two strings, base and remove, return a version of the base string where all instances of the remove
     * string have been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with “xxx” removing “xx” leaves “x”.
     * not allowed to use any functions like String.remove()
     *
     * public String withoutString(String base, String remove)
     * withoutString(“Hello there”, “llo”) → “He there”
     * withoutString(“Hello there”, “e”) → “Hllo thr”
     * withoutString(“Hello there”, “x”) → “Hello there” (edited)
     */

    public static String withoutString(String base, String remove) {

        if (remove.length() > base.length()) {
            return base;

        } else {
            int n = base.length();
            int r = remove.length();
            String convertedBaseStr = base.toLowerCase();
            String convertedRemoveStr = remove.toLowerCase();
            StringBuilder altString = new StringBuilder();
            boolean isPatternCheckComplete = false;
            boolean isPatternMatched = false;

            // Primary Loop Checking Base String
            for (int i = 0; i <= n - 1; i++) {
                char baseChar = base.charAt(i);
                char lowerBaseChar = convertedBaseStr.charAt(i);

                // Secondary Loop Checking Remove String
                for (int j = 0; j <= r - 1; j++) {
                    char lowerRemoveChar = convertedRemoveStr.charAt(j);

                    // Check for Remove String Pattern Match
                    if (!isPatternMatched) {
                        if (lowerBaseChar != lowerRemoveChar) {
                            isPatternCheckComplete = true;
                            break;

                        } else {
                            isPatternMatched = true;
                        }

                    } else { // Pattern Match has Started
                        int k = i + 1;
                        if (k <= n - 1) {
                            char nextChar = convertedBaseStr.charAt(k);

                            if (nextChar != lowerRemoveChar) {
                                isPatternMatched = false;
                                isPatternCheckComplete = true;
                                break;

                            } else {
                                isPatternMatched = true;
                                // update index position
                                i = k;
                            }

                        } else {
                            isPatternMatched = false;
                            isPatternCheckComplete = true;
                            break;
                        }
                    }

                }

                if (isPatternCheckComplete && !isPatternMatched) {
                    altString.append(baseChar);
                }
                isPatternMatched = false;
                isPatternCheckComplete = false;
            }
            return altString.toString();
        }
    }

    /***
     *
     * INTRO TO RECURSION
     *
     */

    /*
    Question #6
    We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears.
    The even bunnies (2, 4, ..) we’ll say have 3 ears, because they each have a raised foot.
    Recursively return the number of “ears” in the bunny line 1, 2, ... n (without loops or multiplication).

    A recursive function can go infinite like a loop. To avoid infinite running of recursive function, there are two properties that a recursive function must have −
    Base criteria − There must be at least one base criteria or condition, such that, when this condition is met the function stops calling itself recursively.
    Progressive approach − The recursive calls should progress in such a way that each time a recursive call is made it comes closer to the base criteria.

    bunnyEars2(0) → 0
    bunnyEars2(1) → 2
    bunnyEars2(2) → 5
     */
    public static int getBunnyEars(int numOfBunnies) {
        int earCount = 0;
        // Base condition
        if (numOfBunnies == 0) {
            return earCount;
        } else if (numOfBunnies % 2 == 0) {
            earCount += 3;
        } else {
            earCount += 2;
        }
        // Progressive Approach
        return earCount + getBunnyEars(numOfBunnies - 1);
    }

    /*
    Question #7
    Given a non-negative int n, return the sum of its digits recursively (no loops).
    Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
    sumDigits(126) → 9
    sumDigits(49) → 13
    sumDigits(12) → 3
     */

    public static int getSumDigits(int digit) {
        int sumDigit = 0;

        // base condition
        if (digit < 10) {
            return digit;
        } else if (digit < 100) {
            return sumDigit + (digit / 10) + (digit % 10);
        } else {
            // Progressive
            sumDigit += digit % 10;
            return sumDigit + getSumDigits((digit / 10));
        }

    }

    /*
    Question #8
    Given a string, compute recursively a new string where all the ‘x’ chars have been removed.
    noX(“xaxb”) → “ab”
    noX(“abc”) → “abc”
    noX(“xx”) → “”
     */

    public static String dropTheNasty(String strNasty) {
        String strClean = "";

        // base condition
        if (strNasty.length() < 1) {
            return strClean;
        } else {
            String startChar = strNasty.substring(0, 1);
            if (!startChar.equals("x")) {
                strClean += startChar;

            }
        }

        return strClean + dropTheNasty(strNasty.substring(1));


    }

    /*
       Question #9
       The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with a key for each different string,
       with the value the number of times that string appears in the array.
        wordCount([“a”, “b”, “a”, “c”, “b”]) → {“a”: 2, “b”: 2, “c”: 1}
        wordCount([“c”, “b”, “a”]) → {“a”: 1, “b”: 1, “c”: 1}
        wordCount([“c”, “c”, “c”, “c”]) → {“c”: 4}
     */

    public static Map<String, Integer> sayWordCount(String[] arrString) {
        Map<String, Integer> wordMap = new HashMap<>();
        if (arrString.length >= 1) {
            for (String word : arrString) {
                if (wordMap.size() > 0 && wordMap.containsKey(word)) {
                    int wordCount = wordMap.get(word) + 1;
                    wordMap.put(word, wordCount);
                } else {
                    int wordCount = 1;
                    wordMap.put(word, wordCount);
                }
            }

        } else {
            return null;
        }

        return wordMap;
    }

}
