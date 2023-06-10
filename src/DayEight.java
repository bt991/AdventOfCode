import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayEight {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader("grid.txt"));
        List<List<Integer>> matrix = new ArrayList<>();
        String temp;
        int visible = 0;
        int score = 0;

        while((temp = read.readLine()) != null){
            List<Integer> intList = new ArrayList<>();
            for(String s : temp.trim().split("")){
                intList.add(Integer.parseInt(s));
            }
            matrix.add(intList);
        }

        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.get(0).size(); j++){
                if(checkVisibility(matrix,i,j)){
                    visible++;
                }
                score = Math.max(score, calculateScore(matrix,i,j));
            }
        }

        System.out.println("Visible: " + visible + "\nBest Score: "+ score);

        /*
        read the entire file and parse it into a grid
        as it reads each character, compare the current character to it's associated column and row
            if there's a null on one side, assume this number is on the border
            else
                check if there's any numbers greater than current to the left
                    0 to given index
                check if there's any numbers greater than current to the right
                    given index to matrix.length
                check if there's any numbers greater than current upwards
                    0 to given index
                check if there's any numbers greater than current downwards
                    given index to matrix[index].length



         */
    }

    public static boolean checkVisibility(List<List<Integer>> matrix, int i, int j){
        if(i == 0 || j == 0 || (i == matrix.size() - 1) || (j == matrix.get(0).size() - 1)){
            return true;
        }
        boolean visible = false;
        boolean directionVis = true;

        for(int row = i+1; row < matrix.size(); row++){
            if(matrix.get(row).get(j) >= matrix.get(i).get(j)){
                directionVis = false;
            }
        }

        visible = visible || directionVis;
        directionVis = true;

        for(int row = i-1; row >= 0; row--){
            if(matrix.get(row).get(j) >= matrix.get(i).get(j)){
                directionVis = false;
            }
        }
        visible = visible || directionVis;
        directionVis = true;
        for(int column = j + 1; column < matrix.get(0).size(); column++) {
            if(matrix.get(i).get(column) >= matrix.get(i).get(j)) {
                directionVis = false;
            }
        }
        visible = visible || directionVis;
        directionVis = true;
        for(int column = j - 1; column >= 0; column--) {
            if(matrix.get(i).get(column) >= matrix.get(i).get(j)) {
                directionVis = false;
            }
        }
        visible = visible || directionVis;
        return visible;
    }

    public static int calculateScore(List<List<Integer>> grid, int i, int j) {
        int score = 1;
        int directionVisible = 0;
        for(int row = i + 1; row < grid.size(); row++) {
            directionVisible++;
            if(grid.get(row).get(j) >= grid.get(i).get(j)) {
                break;
            }
        }
        score*= directionVisible;
        directionVisible = 0;
        for(int row = i - 1; row >= 0; row--) {
            directionVisible++;
            if(grid.get(row).get(j) >= grid.get(i).get(j)) {
                break;
            }
        }
        score*= directionVisible;
        directionVisible = 0;
        for(int column = j + 1; column < grid.get(0).size(); column++) {
            directionVisible++;
            if(grid.get(i).get(column) >= grid.get(i).get(j)) {
                break;
            }
        }
        score*= directionVisible;
        directionVisible = 0;
        for(int column = j - 1; column >= 0; column--) {
            directionVisible++;
            if(grid.get(i).get(column) >= grid.get(i).get(j)) {

                break;
            }
        }
        score*= directionVisible;
        return score;
    }
}
