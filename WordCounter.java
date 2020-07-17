/**
 * 
 * So since all of the codes is converted into String 
 * This should work for all of them 
 * 
 */

public static int countWord(String word){ 
  
  if (word == null){ 
    return 0; 
  } 
  
  String input = word.trim(); 
  int count = input.isEmpty() ? 0 : input.split("\\s+").length; 
  
  return count; 

   } 


