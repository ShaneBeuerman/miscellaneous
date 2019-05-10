package miscellaneous;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class main {

    public static void main(String[] args) {

        System.out.println(reverse("ritzy"));
        
        palindrome("amanaplanacanalpanama");
        palindrome2("racecar");
        
        System.out.println(Collatz(3, 0));
        
        coinFlip(1000000);
        
        fizzBuzz(7, 8, 100);
        
        piglatin("beef");
        countVowels("How many vowels are in this sentence?");
        
        char[] alpha = {'a','b','c','d', 'e', 'f', 'g', 'h',
                        'i','j','k','l','m','n','o','p','q','r',
                        's','t','u','v','w','x','y','z'};
        
        int key = 1;
        String saying = "hello";
        String coded = cipher(alpha, key, saying);
        System.out.println(coded);
        System.out.println(decipher(alpha, key, coded));
        
    }
    
    /*
        Reverses a string
    */
    public static String reverse(String word){
        String finish = "";
        for(int i = word.length(); i > 0; i--){
            finish += word.charAt(i - 1);        
        }
        return finish;
    }
    
    /*
        Returns true if given String is a palindrome.
    */
    public static boolean palindrome(String input){
        int j = input.length() - 1;
        for(int i = 0; i <= input.length(); i++){
            if(input.charAt(i) != input.charAt(j)){
                System.out.println("Not a palindrome!");
                return false;
            }
            if(i == j || i - j == 1){
                System.out.println("It is a palindrome!");
                return true;
            }
            j--;           
        }
        System.out.println("Nope!");
        return false;
    }
    
    /*
        Returns true if given String is a palindrome. It works 
        differently from palindrome(), but it returns true or
        false just the same.
    */
    public static boolean palindrome2(String input){
        if(reverse(input).equals(input)){
            System.out.println("It is a palindrome!");
            return true;
        }
        System.out.println("Not a palindrome!");
        return false;
    }
    
    /*
        Returns the number of steps it takes to solve the Collatz conjecture.
    */
    public static int Collatz(int n, int counter){
        if(n == 1){
            return counter;
        }  
        else if(n % 2 == 0){
            return Collatz(n/2, counter+1);
        }else{
            return Collatz(n*3 + 1, counter+1);
        }     
    }

    /*
        Prints the number of heads and the number of tails in
        n number of coin flips.
    */
    public static void coinFlip(int n){
        Random r = new Random();
        int heads = 0;
        int tails = 0;
        int call;
        for(int i = 0; i < n; i++){
            call = r.nextInt(2);
            if(call == 0){
                heads++;
            }else{
                tails++;
            }
        }
        
        System.out.println("Number of heads is " + heads);
        System.out.println("Number of tails is " + tails);
        
    }
    
    /*
        Plays a game of fizzBuzz with a given n and given
        fizz value and given buzz value.
    */
    public static void fizzBuzz(int fizz, int buzz, int n){
        String number = "";
        for(int i = 0; i < n; i++){
            if(i % fizz == 0){
                number += "fizz";
            }
            if(i % buzz == 0){
                number+= "buzz";
            }
            if(number == ""){
                number = Integer.toString(i);
            }
            System.out.println(number);
            number = "";      
        }
        
    }
    
    /*
        Prints out a message translated to pig latin.
    */
    public static void piglatin(String message){
        String newMessage = "";
        char end = message.charAt(0);
        for(int i = 1; i < message.length(); i++){
            newMessage += message.charAt(i);
        }
        newMessage += '-';
        newMessage += end;
        newMessage += "ay";
        System.out.println(newMessage);
    }
    
    /*
        Prints out the number of vowels in a given string.
    */
    public static void countVowels(String word){
        int counter = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == 'a' || word.charAt(i) == 'A'
               ||word.charAt(i) == 'e' || word.charAt(i) == 'E'
               ||word.charAt(i) == 'i' || word.charAt(i) == 'I'
               ||word.charAt(i) == 'o' || word.charAt(i) == 'O'
               ||word.charAt(i) == 'u' || word.charAt(i) == 'U'){
                counter++;
            }
        }
        System.out.println(counter);
        
        
    }
    
    /*
        Returns a string encoded in a ceaser cipher. It takes in the
        alphabet that the string uses, the message itself, and the key
        that shifts the char in the caeser cipher.
    */
    public static String cipher(char[] alphabet, int key, String message){
        String result = "";
        for(int i = 0; i < message.length(); i++){
            char temp = message.charAt(i);
            for(int j = 0; j < alphabet.length; j++){
                if(temp == alphabet[j]){
                    result += alphabet[(j+key) % alphabet.length];
                }
            }
        }
        return result;
    }
    
    /*
        Returns a string decoded in a caesar cipher. It basically does the same as the
        cipher, but in reverse.
    */
    public static String decipher(char[]alphabet, int key, String message){
        String result = "";
        for(int i = 0; i < message.length(); i++){
            char temp = message.charAt(i);
            for(int j = 0; j < alphabet.length; j++){
                if(temp == alphabet[(j+key)% alphabet.length]){
                    result += alphabet[j];
                }
            }
        }
        return result;
    }
    
    /*
        Prints all the values in an int array.
    */
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    
}