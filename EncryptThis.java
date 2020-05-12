// Description:
// Encrypt this!

// You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:

// Your message is a string containing space separated words.
// You need to encrypt each word in the message using the following rules:
// The first letter needs to be converted to its ASCII code.
// The second letter needs to be switched with the last letter
// Keepin' it simple: There are no special characters in input.
// Examples:
// Kata.encryptThis("Hello") => "72olle"
// Kata.encryptThis("good") => "103doo"
// Kata.encryptThis("hello world") => "104olle 119drlo"

// https://www.codewars.com/kata/5848565e273af816fb000449/train/java

public class Kata {
    public static String encryptThis(String text) {
        
        StringBuilder encrypteWordsSb = new StringBuilder();
        
        
        String[] words = text.split(" ");
        
        System.out.println(java.util.Arrays.toString(words));
        
        for(int i = 0; i < words.length; i++){
          
          if(words[i].length() == 0){
            continue;
          }
          
          StringBuilder wordSb = new StringBuilder(words[i]);

          int firstCharNum = Integer.valueOf(wordSb.charAt(0));


          if(wordSb.length() > 1){

            char tempChar = wordSb.charAt(1);
            
            wordSb.setCharAt(1, wordSb.charAt(wordSb.length()-1));
            wordSb.setCharAt(wordSb.length()-1, tempChar);
          }
          
          wordSb.deleteCharAt(0);
          wordSb.insert(0, Integer.toString(firstCharNum) );

          
          encrypteWordsSb.append(wordSb + " ");
        }
        
        
        return encrypteWordsSb.toString().trim();
        
        
    }
}