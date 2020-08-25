package com.example.codingclass;

public class CodeReview {
    //frontBack("code");
    //frontBack2("code");
    //front3("code");
    //backAround("cat");
    //intMax(1, 3, 2);
    //twoAsOne(1, 2, 3);
    //inOrder(1, 2, 3, true);
    //inOrderEqual(2, 5, 11, false);
    //cigarParty(30, false);
    //shareDigit(12, 23);
    //withoutDoubles(3, 3, true);
    //stringTimes("Hi", 3);
    //firstLast6({1, 2, 6});
    //int[] myIntArray = {1, 2, 3};
    //firstLast6(myIntArray);
    //countEvens(myIntArray);
    //sameFirstLast(myIntArray);
    //helloName("X");
    //makeAbba("Hi", "Bye");
    //frontBack3("ab");
    //sleepIn(false, true);
    //monkeyTrouble(true, false);
    //sumDouble(2, 2);
    //makeTags("cite", "Yay");
    //makeOutWord("[[]]", "Word");
    //extraEnd("Hi");
    //dateFashion(8, 2);
    //squirrelPlay(70, true);
    //firstTwo("X");
    //makePi(3, 2, 4);
    int[] myIntArray = {1, 3, 4};
//    scoresIncreasing(myIntArray);


    public String frontBack(String str) {
        char firstLetter;
        char lastLetter;
        char[] result;
        if (str == null) {
            return null;
        }
        result = str.toCharArray();
        if (str.length() > 1) {
            firstLetter = str.charAt(0);
            lastLetter = str.charAt(str.length() - 1);
            result[0] = lastLetter;
            result[str.length() - 1] = firstLetter;
        }

        return result.toString();
    }

    public String frontBack2(String str) {
        char chFirstLetter;
        char chLastLetter;

        if (str == null) {
            return null;
        }

        if (str.length() <= 1) {
            return str;
        }

        chFirstLetter = str.charAt(0);
        chLastLetter = str.charAt(str.length() - 1);

        str = chLastLetter + str.substring(1, str.length() - 1) + chFirstLetter;

        return str;
    }

    public String front3(String str) {

        // check to see if string is null
        if (str == null) {
            return null;
        }

        //check to be sure input string is more than or equal to 3 characters
        if (str.length() >= 3) {
            //Take the first three letters of the string
            str = str.substring(0, 3) + str.substring(0, 3) + str.substring(0, 3);
            return str;
        } else {
            return str;
        }
    }

    //Given a string, take the last char and return a new string with the last char added at the front and back
    public String backAround(String str) {
        // Establish variables
        char firstLetter;
        char lastLetter;

        //Check to see if string is null
        if (str == null) {
            return null;
        }

        //Find the last letter in string
        lastLetter = str.charAt(str.length() - 1);
        firstLetter = lastLetter;

        //Return new string with last char added at the front and back
        str = firstLetter + str + lastLetter;

        return str;

    }

    //Given three int values, a b c, return the largest.
    //intMax(1, 2, 3) → 3
    //intMax(1, 3, 2) → 3
    //intMax(3, 4, 1) → 4
    public int intMax(int a, int b, int c) {
        //Compare the values of each int
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }
    //Given three ints, a b c, return true if it is possible to add two of the ints to get the third.
    //twoAsOne(1, 2, 3) → true
    //twoAsOne(3, 1, 2) → true
    //twoAsOne(3, 2, 2) → false

    public boolean twoAsOne(int a, int b, int c) {
        //Declare variables
        int ab = a + b;
        int ac = a + c;
        int bc = b + c;

        // Return true if adding two ints will equal the third
        if (ab == c) {
            return true;
        } else if (ac == b) {
            return true;
        } else if (bc == a) {
            return true;
        } else {
            return false;
        }
    }

    //Given three ints, a b c, return true if b is greater than a, and c is greater than b.
    // However, with the exception that if "bOk" is true, b does not need to be greater than a.
    //inOrder(1, 2, 4, false) → true
    //inOrder(1, 2, 1, false) → false
    //inOrder(1, 1, 2, true) → true

    public boolean inOrder(int a, int b, int c, boolean bOk) {

        if (b > a && c > b && bOk == false) {
            return true;
        } else if (c > b && bOk == true) {
            return true;
        } else {
            return false;
        }
    }

    //Given three ints, a b c, return true if they are in strict increasing order,
    // such as 2 5 11, or 5 6 7, but not 6 5 7 or 5 5 7. However, with the exception that
    // if "equalOk" is true, equality is allowed, such as 5 5 7 or 5 5 5.
    //inOrderEqual(2, 5, 11, false) → true
    //inOrderEqual(5, 7, 6, false) → false
    //inOrderEqual(5, 5, 7, true) → true

    public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {

        if (a < b && b < c && equalOk == false) {
            return true;
        } else if (a <= b && b <= c && equalOk == true) {
            return true;
        } else {
            return false;
        }

    }

    //When squirrels get together for a party, they like to have cigars.
    // A squirrel party is successful when the number of cigars is between 40 and 60, inclusive.
    // Unless it is the weekend, in which case there is no upper bound on the number of cigars.
    // Return true if the party with the given values is successful, or false otherwise.
    //cigarParty(30, false) → false
    //cigarParty(50, false) → true
    //cigarParty(70, true) → true

    public boolean cigarParty(int cigars, boolean isWeekend) {
        if (cigars >= 40 && cigars <= 60 && isWeekend == false) {
            return true;
        } else if (cigars >= 40 && isWeekend == true) {
            return true;
        } else {
            return false;
        }
    }

    //Given two ints, each in the range 10..99, return true if there is a digit that appears
    // in both numbers, such as the 2 in 12 and 23. (Note: division, e.g. n/10, gives
    // the left digit while the % "mod" n%10 gives the right digit.)

    //shareDigit(12, 23) → true
    //shareDigit(12, 43) → false
    //shareDigit(12, 44) → false

    public boolean shareDigit(int a, int b) {
        //Define Variables
        int aLeftDigit = a / 10;
        int aRightDigit = a % 10;
        int bLeftDigit = b / 10;
        int bRightDigit = b % 10;

        if (aLeftDigit == bLeftDigit) {
            return true;
        } else if (aLeftDigit == bRightDigit) {
            return true;
        } else if (aRightDigit == bLeftDigit) {
            return true;
        } else if (aRightDigit == bRightDigit) {
            return true;
        } else {
            return false;
        }
    }

    //Return the sum of two 6-sided dice rolls, each in the range 1..6.
    // However, if noDoubles is true, if the two dice show the same value, increment
    // one die to the next value, wrapping around to 1 if its value was 6.

    //withoutDoubles(2, 3, true) → 5
    //withoutDoubles(3, 3, true) → 7
    //withoutDoubles(3, 3, false) → 6

    public int withoutDoubles(int die1, int die2, boolean noDoubles) {
        if (die1 == die2 && noDoubles == true) {
            if (die1 == 6 && die2 == 6) {
                die1 = 1;
                return die1 + die2;
            } else {
                die1 = die1 + 1;
                return die1 + die2;
            }
        } else {
            return die1 + die2;
        }
    }

    //Given a string and a non-negative int n, return a larger string
    // that is n copies of the original string.

    //stringTimes("Hi", 2) → "HiHi"
    //stringTimes("Hi", 3) → "HiHiHi"
    //stringTimes("Hi", 1) → "Hi"

    public String stringTimes(String str, int n) {
        //Declare Variables
        String largerStr = "";

        //Check to see if string is null
        if (str == null) {
            return null;
        }

        for (int i = 0; i < n; i++) {
            largerStr += str;
        }
        return largerStr;
    }

    //Given an array of ints, return true if 6 appears as either the first or
    // last element in the array. The array will be length 1 or more.

    //firstLast6({1, 2, 6}) → true
    //firstLast6({6, 1, 2, 3}) → true
    //firstLast6({13, 6, 1, 2, 3}) → false

    public boolean firstLast6(int[] nums) {
        // Declare Variables

        // Go through the array looking for 6 in the first or last element

        if (nums[0] == 6) {
            return true;

        } else if (nums[nums.length - 1] == 6) {
            return true;

        } else {
            return false;
        }


    }

    //Return the number of even ints in the given array.
    // Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.

    //countEvens({2, 1, 2, 3, 4}) → 3
    //countEvens({2, 2, 0}) → 3
    //countEvens({1, 3, 5}) → 0

    public int countEvens(int[] nums) {
        //Declare Variables
        int evenInts = 0;

        // Iterate through the array and for each object, determine if the value is even.
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] % 2) == 0) {
                evenInts++;
            }

        }
        return evenInts;
    }

    //Given an array of ints, return true if the array is length 1 or more,
    // and the first element and the last element are equal.

    //sameFirstLast({1, 2, 3}) → false
    //sameFirstLast({1, 2, 3, 1}) → true
    //sameFirstLast({1, 2, 1}) → true

    public boolean sameFirstLast(int[] nums) {
        //Declare Variables
        int i = 0;
        int firstNum = 0;
        int lastNum = 0;

        // Perform checks
        // check to see if nums has something in it
        if (nums == null) {
            return false;
        } else if (nums.length == 0) {
            return false;
        }

        // Initialize Variables
        i = nums.length;
        firstNum = nums[0];
        lastNum = nums[nums.length - 1];

        // Determine conditions - if array has 1 or more elements AND first equals last element,
        // then return true

        if (firstNum == lastNum) {
            return true;
        } else {
            return false;
        }

    }

    //Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".

    //helloName("Bob") → "Hello Bob!"
    //helloName("Alice") → "Hello Alice!"
    //helloName("X") → "Hello X!"

    public String helloName(String name) {

        // Declare Variables
        String newGreeting = null;

        // Perform Checks
        // Verify that string is not null
        if (name == null) {
            return null;
        }

        // Initialize Variables
        newGreeting = "Hello " + name + "!";

        return newGreeting;

    }

    //Given two strings, a and b, return the result of putting them together in the
    // order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".

    //makeAbba("Hi", "Bye") → "HiByeByeHi"
    //makeAbba("Yo", "Alice") → "YoAliceAliceYo"
    //makeAbba("What", "Up") → "WhatUpUpWhat"

    public String makeAbba(String a, String b) {

        // Declare Variables
        String complete = null;

        // Perform Checks
        if (a == null) {
            return null;
        } else if (b == null) {
            return null;
        }

        // Initialize Variables
        complete = a + b + b + a;

        return complete;

    }

    //Given a string, return a new string where the first and last chars have been exchanged.

    //frontBack("code") → "eodc"
    //frontBack("a") → "a"
    //frontBack("ab") → "ba"

    public String frontBack3(String str) {

        // Declare Variables
        String strExchange = null;
        char chfirstLetter = 0;
        char chlastLetter = 0;


        // Perform validation on input
        if (str == null) {
            return null;
        }

        if (str.length() <= 1) {
            return str;
        }


        // Initialize Variables
        chfirstLetter = str.charAt(0);
        chlastLetter = str.charAt(str.length() - 1);
        strExchange = chlastLetter + str.substring(1, str.length() - 1) + chfirstLetter;

        return strExchange;

    }

    //The parameter weekday is true if it is a weekday, and the parameter vacation
    // is true if we are on vacation. We sleep in if it is not a weekday
    // or we're on vacation. Return true if we sleep in.

    //sleepIn(false, false) → true
    //sleepIn(true, false) → false
    //sleepIn(false, true) → true

    public boolean sleepIn(boolean weekday, boolean vacation) {
        //if(vacation == true){
        //    return true;

        //}else if(weekday == true){
        //    return false;

        //}else {
        //    return true;
        //}
        return ((!weekday) || (vacation));
    }

    //We have two monkeys, a and b, and the parameters aSmile and bSmile
    // indicate if each is smiling. We are in trouble if they are both smiling
    // or if neither of them is smiling. Return true if we are in trouble.

    //monkeyTrouble(true, true) → true
    //monkeyTrouble(false, false) → true
    //monkeyTrouble(true, false) → false

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {

        // Declare Variables

        // Perform Input Validation

        // Initialize Variables

        if (aSmile == bSmile) {
            return true;

        } else {
            return false;
        }

    }

    //Given two int values, return their sum.
    // Unless the two values are the same, then return double their sum.

    //sumDouble(1, 2) → 3
    //sumDouble(3, 2) → 5
    //sumDouble(2, 2) → 8

    public int sumDouble(int a, int b) {

        // Declare Variables
        int intDouble = 0;
        int intSum = 0;

        // Perform Input Validation
        // Could potentially check to see if the values are negative since the ints can't be null


        // Initialize Variables
        intSum = a + b;
        intDouble = ((a + b) * 2);


        if (a == b) {
            return intDouble;
        } else {
            return intSum;
        }

    }

    //The web is built with HTML strings like "<i>Yay</i>" which draws
    // Yay as italic text. In this example, the "i" tag makes <i> and </i>
    // which surround the word "Yay". Given tag and word strings,
    // create the HTML string with tags around the word, e.g. "<i>Yay</i>".

    //makeTags("i", "Yay") → "<i>Yay</i>"
    //makeTags("i", "Hello") → "<i>Hello</i>"
    //makeTags("cite", "Yay") → "<cite>Yay</cite>"

    public String makeTags(String tag, String word) {

        //Declare Variables
        String strOpenTag = null;
        String strCloseTag = null;
        String strHTML = null;

        // Perform Input Validation
        if (tag == null || word == null) {
            return null;
        }

        // Initialize Variables
        strOpenTag = "<" + tag + ">";
        strCloseTag = "</" + tag + ">";
        strHTML = strOpenTag + word + strCloseTag;

        return strHTML;

    }

    //Given an "out" string length 4, such as "<<>>", and a word,
    // return a new string where the word is in the middle of the out string, e.g. "<<word>>".

    //makeOutWord("<<>>", "Yay") → "<<Yay>>"
    //makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
    //makeOutWord("[[]]", "word") → "[[word]]"

    public String makeOutWord(String out, String word) {

        // Declare Variables
        String strMiddle = null;
        String strFirst = null;
        String strLast = null;

        // Perform Input Validation
        if (out == null || word == null) {
            return null;
        } else if (out.length() > 4) {
            return out;
        }

        // Initialize Variables
        strFirst = out.substring(0, 2);
        strLast = out.substring(2, 4);
        strMiddle = strFirst + word + strLast;

        return strMiddle;

    }

    //Given a string, return a new string made of 3 copies of the last 2 chars
    // of the original string. The string length will be at least 2.

    //extraEnd("Hello") → "lololo"
    //extraEnd("ab") → "ababab"
    //extraEnd("Hi") → "HiHiHi"

    public String extraEnd(String str) {

        // Declare Variables
        String strLastChars = null;
        String strFinal = null;

        // Perform Input Validation
        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            return str;
        }

        // Initialize Variables
        strLastChars = str.substring((str.length() - 2), (str.length()));
        strFinal = strLastChars + strLastChars + strLastChars;

        return strFinal;

    }

    //You and Nicole are trying to get a table at a restaurant.
    // The parameter "you" is the stylishness of your clothes, in the range 0..10, and "nicole"
    // is the stylishness of your her clothes. The result getting the table is encoded as an int
    // value with 0=no, 1=maybe, 2=yes. If either of you is very stylish, 8 or more, then the
    // result is 2 (yes). With the exception that if either of you has style of 2 or less, then
    // the result is 0 (no). Otherwise the result is 1 (maybe).

    //dateFashion(5, 10) → 2
    //dateFashion(5, 2) → 0
    //dateFashion(5, 5) → 1

    public int dateFashion(int you, int nicole) {

        // Declare Variables

        // Perform Input Validation
        if (you < 0 || you > 10) {
            return you;
        } else if (nicole < 0 || nicole > 10) {
            return nicole;
        }

        //Initialize Variables

        if (you > 7 && nicole > 2) {
            return 2;
        } else if (you > 2 && nicole > 7) {
            return 2;
        } else if (you < 3 || nicole < 3) {
            return 0;
        } else {
            return 1;
        }

    }
    //The squirrels in Palo Alto spend most of the day playing. In particular, they play if
    // the temperature is between 60 and 90 (inclusive). Unless it is summer, then
    // the upper limit is 100 instead of 90. Given an int temperature and a boolean isSummer,
    // return true if the squirrels play and false otherwise.

    //squirrelPlay(70, false) → true
    //squirrelPlay(95, false) → false
    //squirrelPlay(95, true) → true

    public boolean squirrelPlay(int temp, boolean isSummer) {
        if (temp >= 60 && temp <= 90 && isSummer == false) {
            return true;
        } else if (temp >= 60 && temp <= 100 && isSummer == true) {
            return true;
        } else {
            return false;
        }

    }

    //Given a string, return the string made of its first two chars,
    // so the String "Hello" yields "He". If the string is shorter than length 2,
    // return whatever there is, so "X" yields "X", and the empty string ""
    // yields the empty string "". Note that str.length() returns the length of a string.

    //firstTwo("Hello") → "He"
    //firstTwo("abcdefg") → "ab"
    //firstTwo("ab") → "ab"

    public String firstTwo(String str) {
        //Declare Variables
        String strRemix = str;

        // Perform Input Validation
        if (str == null) {
            return null;
        }

        if (str.length() < 2) {
            return str;
        }

        // Initialize Variables
        strRemix = str.substring(0, 2);

        return strRemix;
    }

    //Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.

    //makePi() → {3, 1, 4}

    public int[] makePi() {
        //Declare Variables
        int[] aNums;


        //Perform Input Validation

        // Initialize Variables
        aNums = new int[3];
        aNums[0] = 3;
        aNums[1] = 1;
        aNums[2] = 4;

        return aNums;


    }
    //Given an array of scores, return true if each score is equal or greater than
    // the one before. The array will be length 2 or more.

    //scoresIncreasing({1, 3, 4}) → true
    //scoresIncreasing({1, 3, 2}) → false
    //scoresIncreasing({1, 1, 4}) → true

    public boolean scoresIncreasing(int[] scores) {

        //Declare Variables
        int iFirstNum = 0;
        int iSecNum = 0;
        int iThirdNum = 0;

        // Perform Input Validation

        // Initialize Variables
        iFirstNum = scores[0];
        iSecNum = scores[1];
        iThirdNum = scores[2];

        for(int i = 0; i < scores.length; i++){
            // Take the first number
        }
        if (iSecNum >= iFirstNum && iSecNum <= iThirdNum) {
            return true;
        } else {
            return false;
        }

    }
}
