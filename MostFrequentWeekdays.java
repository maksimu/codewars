/**
 * What is your favourite day of the week? Check if it's the most frequent day of the week in the year.

You are given a year as integer (e. g. 2001). You should return the most frequent day(s) of the week in that year. 
The result has to be a list of days sorted by the order of days in week (e. g. ['Monday', 'Tuesday']). 
Week starts with Monday.

Input: Year as an int.

Output: The list of most frequent days sorted by the order of days in week (from Monday to Sunday).

Preconditions: Year is between 1 and 9999. Week starts with Monday. Calendar is Gregorian.

Example:

Kata.mostFrequentDays(2427) => {"Friday"}
Kata.mostFrequentDays(2185) => {"Saturday"}
Kata.mostFrequentDays(2860) => {"Thursday", "Friday"}
In Ruby years will start from 1593.
 */


import java.time.*;
import java.util.*;

public class Kata {
  public static String[] mostFrequentDays(int year) {

    Map<Integer, Integer> weekDaysCountMap = new HashMap<>();
    
    
    String yearStr = ""+year;

    // add zeros. kinda hacky. but works
    if(year < 1000){
        yearStr = "0"+yearStr;
        if(year < 100){
           yearStr = "0"+yearStr;
           if(year < 10){
                yearStr = "0"+yearStr;
           }
        }
    }
    LocalDate start = LocalDate.parse(yearStr + "-01-01"),
          end   = LocalDate.parse(yearStr + "-12-31");
    
    
    LocalDate next = start.minusDays(1);
    
    int largestNum = 0;
    
    while ((next = next.plusDays(1)).isBefore(end.plusDays(1))) {
//         System.out.println(next + " -> " + next.getDayOfWeek());
        
        Integer key = next.getDayOfWeek().getValue();
        
//         key = key.substring(0, 1).toUpperCase() + key.substring(1).toLowerCase(); // to capitalize first letter

        
        if( weekDaysCountMap.containsKey(key)){
          weekDaysCountMap.put(key, weekDaysCountMap.get(key)+1);
        } else {
          weekDaysCountMap.put(key, 1);
        }
        
        if(weekDaysCountMap.get(key) > largestNum){
          largestNum = weekDaysCountMap.get(key);
        }
    }

    
    List<Integer> mostFrequentWeekDays = new ArrayList<>();
    
    for(Integer key : weekDaysCountMap.keySet()){
      if(weekDaysCountMap.get(key) == largestNum){
        mostFrequentWeekDays.add(key);
      }
    }
    
    Collections.sort(mostFrequentWeekDays);

    

    String[] mostFrequentWeekDaysArr = new String[mostFrequentWeekDays.size()];
    
    for(int i = 0; i < mostFrequentWeekDays.size(); i++){
      DayOfWeek dow = DayOfWeek.of(mostFrequentWeekDays.get(i));
      String dowStr = dow.toString();
      
      dowStr = dowStr.substring(0, 1).toUpperCase() + dowStr.substring(1).toLowerCase(); // to capitalize first letter

      mostFrequentWeekDaysArr[i] = dowStr;
    }

    return mostFrequentWeekDaysArr;

  }
}