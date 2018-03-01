/**
 * CISC.3150 HW4
 *  Write a program that given a two dimensional array of characters prints 
 * out the combination of every letter with every other letter.
 *
 */

/**
 * @author Jaryl
 */
import java.text.MessageFormat;
import java.util.*;
public class CharCombinations {
        
       //Method to Create combinations and prints them
       public static void combination(char [] [] twoArray)
        {
                int totalComb =1; //total combinations
		int begin=0; 
                
        //Sources from the internet used to help with combination logic and printing  
        //http://hmkcode.com/calculate-find-all-possible-combinations-of-an-array-using-java/
        //https://stackoverflow.com/questions/15868914/how-to-get-2d-array-possible-combinations/15869610
            
            for (char[] array :twoArray) 
            {
                totalComb = totalComb * array.length;
            }
            
		// Stores the combinations in a list
            List<String> combinations = new ArrayList<>((int) totalComb);
		int combination[];
                combination = new int[twoArray.length];
		for(int i=0; i<combination.length;i++)
                    {
                        combination[i]=0;
                    }
                   
                https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
		while (begin < totalComb) //While the current index is less than the total combinations 
                {
                StringBuilder builder = new StringBuilder();
                    for(int j=0; j<twoArray.length;j++)
                    {
                      builder.append(twoArray[j][combination[j]]);
                    }
			combinations.add(builder.toString()); //adds new combination to the list
			
                        //Icrements so that the following combination is taken on when the loop iterates
			for (int inc=twoArray.length-1; inc>=0; inc--){
				
				if (combination[inc] < twoArray[inc].length-1)
                                {
                                    combination[inc]++;
                                    break; //higher indices no longers needs to be incremented
				}
				combination[inc]=0;
                      }
			begin++;
                }
	 System.out.println("The combinations are: " +combinations); //prints combinations
            
		
}  
    //Testing out the combination method
 public static void main(String[] args) {
		
        int rows; //Numbers of Rows in Array
        Scanner scanner = new Scanner(System.in);
               
             System.out.println("Please enter the number of rows for your array:"); //User input 
                rows= scanner.nextInt();
		  
	char [][] array= new char[rows][]; //Creates 2D Array with user inputted rows
                String in = null;
                  for(int x=0; x<rows; x++) //Adds elements to the Array
                  {
                   System.out.println(MessageFormat.format("Please fill out the elements in row # {0}:", x + 1));
                        in=scanner.next();
                        
                   for(int y=0; y<in.length(); y++)
                     {
                        array[x]=in.toCharArray();    //https://docs.oracle.com/javase/7/docs/api/java/util/List.html
                     }
		   }
	combination(array); //Prints combinations of inputted values
    }
}
