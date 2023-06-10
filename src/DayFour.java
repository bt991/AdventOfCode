import java.io.*;

public class DayFour {
    public static void main(String[] args) throws IOException {
        int totalOne = 0;
        int totalTwo = 0;
        String temp;
        BufferedReader read = new BufferedReader(new FileReader("sections.txt"));

        while((temp = read.readLine()) != null){
            String[] moves = temp.split("[-,-]");
            totalOne += checkContained(moves);
            totalTwo += checkOverlap(moves);
        }

        System.out.println("Part 1: " + totalOne);
        System.out.println("Part 2: " + totalTwo);
        /*
        read each line
            take the first and second number, delimited by hyphen, and store them as a range (first elves range)
            delimit second elf AFTER it finds a comma in the line of text
            take the third and fourth number, delimited by hyphen, and store them as a range (second elves range)

            check which range's start and end are lowest/highest, set that to the bounds
            check if the smaller range is contained within the entirety of the larger range

            return the amount of fully contained pairs
         */
    }
    public static Integer checkContained(String[] moves){
        int total = 0;
        int first = Integer.parseInt(moves[0]);
        int second = Integer.parseInt(moves[1]);
        int third = Integer.parseInt(moves[2]);
        int fourth = Integer.parseInt(moves[3]);

        if((first >= third && second <= fourth) || (first <= third && second >= fourth)){
            //if first section is contained within second
            //if second section is contained within first
            total++;
        }
        return total;
    }

    public static Integer checkOverlap(String[] moves){
        int overlap = 0;
        int first = Integer.parseInt(moves[0]);
        int second = Integer.parseInt(moves[1]);
        int third = Integer.parseInt(moves[2]);
        int fourth = Integer.parseInt(moves[3]);

        if((first >= third && second <= fourth) || (first <= third && second >= fourth)
                || (first <= third && second >= third) || (first <= fourth && second >= fourth)){
            //if first set is contained within second set
            //if second set is contained within first set
            //if first index is lower than third but second index is higher than third
            //if first index is lower than fourth but second index is higher than fourth
            overlap++;
        }
        return overlap;
    }
}
