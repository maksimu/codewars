//Your task is to make a function that can take any non-negative integer as a argument and return it with its digits in descending order. Essentially, rearrange the digits to create the highest possible number.
//
//Examples:
//Input: 21445 Output: 54421
//
//Input: 145263 Output: 654321
//
//Input: 123456789 Output: 987654321
//
//
//
//--- code
import java.util.*;

public class DescendingOrder {
  public static int sortDesc(final int num) {
  
    // 1. convert to char array
    // 2. convert to int array
    // 3. add up to numbers by using multiplication from 1 to x (multiply by 10 each time)
    char[] numChars = String.valueOf(num).toCharArray();
        
    Integer[] nums = new Integer[numChars.length];
       
    for(int i = 0; i < numChars.length; i++){
      nums[i] = Character.getNumericValue(numChars[i]);
    }
    

    Arrays.sort(nums, Collections.reverseOrder());
    

    int result = 0;
    
    int multiplyer = 1;
    
    
    for(int i = (nums.length-1); i >= 0; i--){
      result = result + (nums[i] * multiplyer);
      
      multiplyer = multiplyer * 10;
    }
    
     return result;
    
   }
}
