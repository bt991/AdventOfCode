import java.io.*;

public class DayTwo {
    public static void main(String[] args) throws IOException{
        int total_score = 0;
        String temp;
        BufferedReader read = new BufferedReader(new FileReader("guide.txt"));

        while((temp = read.readLine()) != null){
            String[] moves = temp.trim().split("\\s+");
            if(moves[0].equals("A")){
                if(moves[1].equals("X")){
                    //rock > scissors,lose
                    total_score += 3;
                } else if (moves[1].equals("Y")) {
                    //rock = rock,draw
                    total_score += 4;
                } else if (moves[1].equals("Z")) {
                    //rock < paper,win
                    total_score += 8;
                }
            } else if (moves[0].equals("B")) {
                if(moves[1].equals("X")){
                    //paper > rock,lose
                    total_score += 1;
                } else if (moves[1].equals("Y")) {
                    //paper = paper, draw
                    total_score += 5;
                } else if (moves[1].equals("Z")) {
                    //paper < scissor, win
                    total_score += 9;
                }
            } else if (moves[0].equals("C")) {
                if(moves[1].equals("X")){
                    //scissor > paper, lose
                    total_score += 2;
                } else if (moves[1].equals("Y")) {
                    //scissor = scissor,draw
                    total_score += 6;
                } else if (moves[1].equals("Z")) {
                    //scissor < rock, win
                    total_score += 7;
                }
            }
        }

        System.out.println("Total score: " + total_score);
        //rock beats scissors, scissors beats paper, paper defeats rock, if same shape then round is draw
        //a+x is rock, b+y is paper, c+z is scissor
        //score is determined by what you play that round
        //(1 for rock, 2 for paper, 3 for scissors) PLUS outcome of the round (0 for loss, 3 for draw, 6 for win)

        //read each line of the file
        //check what the first letter of the line is to determine what they play
        //check the second letter of the line to determine what you should play
        //sum overall score based on what you play each game
    }

}
