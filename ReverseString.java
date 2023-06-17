public class ReverseString {
    public static void main(String[] args) {
        
        String originalString = "Ms Shane";
        System.out.println("Original String: " + originalString + "\n");
        /*
            Using two variables, we loop until we get all of the values starting
            at the end of the original String to the first index.
        */
        
        String newString = "";
        for(int i = originalString.length() - 1; i >= 0; i--) {
            newString += originalString.charAt(i);
        }
        
        System.out.println("New String [Using Insertion]: " + newString);
        
        /*
            Second Solution:
            Using Array
        */
        
        char newArray[] = originalString.toCharArray();
        
        System.out.print("New String [Using Array]:     ");
        for(int i = newArray.length - 1; i >= 0; i--) {
            System.out.print(newArray[i]);
        }
        System.out.println();
        
    }
}