package challenge1;

public class Answer {   
    public static int answer(String s) { 
        // Your code goes here.
        int numCharsToCheck = 1;
        int max = 1;
        while (numCharsToCheck <= s.length() / 2){
            String sub = s.substring(0, numCharsToCheck);
            int temp = checkNumOccurences(s, sub);
            if (temp != 0 && max == 1)
                max = temp;
            else if (temp != 0 && temp >= max)
                max = temp;
            numCharsToCheck++;
        }
        
        return max;
    } 
    
    public static int checkNumOccurences(String s, String sub){
        String temp = s.replaceAll(sub, " ");
        if (containsOnlySpaces(temp)){
            return temp.length();
        }
        
        return 0;
    }
    
    public static boolean containsOnlySpaces(String t){
        for (int x = 0; x < t.length(); x++){
            if (t.charAt(x) != ' ')
                return false;
        }
        
        return true;
    }
    
    public static void main(String[] args){
    	System.out.println("Max: " + Answer.answer("aaabaaab"));
    }
}
