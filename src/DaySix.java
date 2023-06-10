import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DaySix {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("characters.txt"));
        String temp;
        while((temp = read.readLine()) != null){
            partOne(temp);
            partTwo(temp);
        }

        /*
        read in line from the file
            index the first character in the file
            compare the first index character with the next 3 characters in line
                compare first to second, first to third, first to fourth, second to third, second to fourth, third to fourth
                if all the characters are unique, return the string
                else, increment the index character by one and continue to check the next 3 characters

            count the number of characters
         */
    }

    public static void partOne(String temp){
        System.out.println("First packet marker: " + marker(temp,4));
    }

    public static void partTwo(String temp) {
        System.out.println("First packet marker: " + marker(temp,14));
    }

    private static int marker(String input, int length){
        for(int i = 0; i < input.chars().count(); i++){
            String substring = input.substring(i, i + length);
            if(substring.chars().distinct().count() == length){
                System.out.println(substring);
                return length+i;
            }
        }
        return -1;
    }
}
