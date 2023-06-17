public class CountingSizeOfName {
    public static void main(String[] args) {
        
        // Name to be counted.
        // Note that spaces will be disregard.
        String name = "Shane Danikka";
        
        // Using the .length() method of the String class.
        System.out.println("Length of name: " + name.replaceAll(" ", "").length());
        
        // Using while loop and decrementing to count.
        // This code uses Unicode to calculate if name is still valid.
        int i = 0;
        int j = 0;
        try {
            while((name.codePointAt(i) >= 65 && name.codePointAt(i) <= 122) || name.codePointAt(i) == 32) {
                if(name.codePointAt(i) == 32)
                    j++;
                i++;
            }
        } catch(Exception help) {}
        if(j >= 1)
            i -= j;
        System.out.println("Length of name: " + i);
        
    }
}