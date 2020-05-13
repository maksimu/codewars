/**
Create a function isDivisible(n,...) that checks if the first agrument n is divisible by all other arguments (return true if no other arguments)

Example:

isDivisible(6,1,3)--> true because 6 is divisible by 1 and 3
isDivisible(12,2)--> true because 12 is divisible by 2
isDivisible(100,5,4,10,25,20)--> true
isDivisible(12,7)--> false because 12 is not divisible by 7
This kata is following kata: http://www.codewars.com/kata/is-n-divisible-by-x-and-y
*/

public class Divisible {
    public static boolean isDivisible(int ... nums) {
        if(nums.length <= 1){
          return false;
        }
        
        int firstNum = nums[0];
        
        for(int i = 1; i < nums.length; i++){
        
          if(nums[i] == 0)
            return false;
        
          if(((double) firstNum/(double) nums[i]) % 1 != 0){
            return false;
          }
        
        }
        
        
        return true;
    }
}


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivisibleTest {
    @Test
    public void basicTests() throws Exception {        
        assertEquals(Divisible.isDivisible(3, 3, 4), false);
        assertEquals(Divisible.isDivisible(12, 3, 4), true);   
        assertEquals(Divisible.isDivisible(8, 3, 4, 2, 5), false);
    }
}
