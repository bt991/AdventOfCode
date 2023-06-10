import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayThree {
    public static void main(String[] args) throws IOException {
        int totalOne = 0;
        int totalTwo = 0;
        String temp;
        BufferedReader read = new BufferedReader(new FileReader("rucksack.txt"));
        List<String> group = new ArrayList<>();

        while((temp = read.readLine()) != null){
            String moves = temp.trim();
            group.add(moves);
            totalOne += calculateTotal(moves);
        }

        totalTwo += calculateTotalTwo(group);
        System.out.println("Total one: " + totalOne);
        System.out.println("Total two: " + totalTwo);

        //each new line is one rucksack
        //first half of the string is compartment one, second half of the string is compartment two
        //each rucksack should be equal size
        //compare each rucksack to find the item type which is the same in each side
        //assign the found item type to it's correct priority number
        //sum the priorities of each rucksack
    }

    public static Integer calculateTotal(String str) {
        int typeInInt = 0;
        int size = str.length() / 2;
        String compOne = str.substring(0, size);
        String compTwo = str.substring(size);

        if (str.length() % 2 != 0) {
            System.out.println("Line was not even size.");
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (compOne.charAt(i) == compTwo.charAt(j)) {
                    typeInInt = compOne.charAt(i);
                    if (typeInInt > 96 && typeInInt < 123) {
                        //lowercase
                        typeInInt = typeInInt - 96;

                    }
                    if (typeInInt > 64 && typeInInt < 91) {
                        //uppercase
                        typeInInt = typeInInt - 38;
                    }

                }
            }
        }
        return typeInInt;
    }
    public static Integer calculateTotalTwo(List s){
        int typeInInt = 0;
        int total = 0;
        for(int i = 0; i < s.size(); i+=3){
            String one = s.get(i).toString();
            String two = s.get(i+1).toString();
            String three = s.get(i+2).toString();

            for(int x = 0; x < one.length(); x++){
                for(int y = 0; y < two.length(); y++){
                    for(int z = 0; z < three.length(); z++){
                        if ((one.charAt(x) == two.charAt(y)) && (two.charAt(y) == three.charAt(z))){
                            typeInInt = one.charAt(x);
                            if(typeInInt > 96 && typeInInt < 123){
                                //lowercase
                                typeInInt = typeInInt - 96;

                            }
                            if (typeInInt > 64 && typeInInt < 91){
                                //uppercase
                                typeInInt = typeInInt - 38;
                            }
                        }
                    }
                }
            }
            total+=typeInInt;
        }
        return total;
    }
}
