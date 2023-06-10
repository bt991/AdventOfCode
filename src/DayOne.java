import java.io.*;

public class DayOne {
    public static void main(String[] args) throws IOException {
        String temp;
        int total = 0;
        int currentHigh = 0;
        int secondHigh = 0;
        int thirdHigh = 0;
        BufferedReader read = new BufferedReader(new FileReader("input.txt"));

        while((temp = read.readLine()) != null){                 //read each line of the file
            if(temp.equals("")){                                //if next line is empty (indication of new elf)
                total = 0;                                      //resets total to 0
            }
            if(!temp.equals("")){                               //if line has text
                total += Integer.parseInt(temp);                //parse text into an int and add it to the total value

                if(total > currentHigh){                        //if calories is higher than current high
                    thirdHigh = secondHigh;                         //set third high equal to old second
                    secondHigh = currentHigh;                       //set second high equal to old current
                    currentHigh = total;                            //set current high equal to total
                } else if (total > secondHigh) {                //if calories is higher than second high
                    thirdHigh = secondHigh;                         //set third high equal to old second
                    secondHigh = total;                             //set second high equal to total
                } else if (total > thirdHigh) {                 //if calories is higher than third high
                    thirdHigh = total;                              //set third high equal to total
                }
            }
        }

        int actual = currentHigh + secondHigh + thirdHigh;

        System.out.println("Elf one: " + currentHigh + "\nElf two: " +
                secondHigh + "\nElf three: " + thirdHigh + "\nCombined they carry: " + actual);
        read.close();

        //read each line of the file
        //start summing each new line of the file until it runs into a space
        //once it hits empty line in the file, set current highest to that total
        //repeat summing calories for next elf in line
        //compare next sum of calories to the current highest, if higher, then replace, else move on
    }
}