import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DayFive {
    public static void main(String[] args) throws IOException{
        partOne();
        partTwo();
        /*
        figure out how to read each stack, and it's associated crates
        start reading the sets of instructions
        parse the first integer as the amount of crates to pop from one stack and then push to the new stack
         */
    }

    public static void partOne() throws IOException{
        List<Deque<Character>> stacks = new ArrayList<>();
        boolean commands = false;
        try(BufferedReader read = new BufferedReader(new FileReader("organize.txt"))){
            String temp = read.readLine();
            if(temp != null){
                for(int i = 0; i < temp.length(); i+=4){
                    if(!Character.toString(temp.charAt(i+1)).equals(" ")){
                        Deque<Character> yup = new LinkedList<>();
                        yup.add(temp.charAt(i+1));
                        stacks.add(yup);
                    }else{
                        stacks.add(new LinkedList<>());
                    }
                }
            }
            while((temp = read.readLine())!=null){
                if(!commands){
                    if(!temp.startsWith(" 1   2 ")){
                        for(int i = 0, index = 0;i < temp.length();i+=4,index++){
                            if(!Character.toString(temp.charAt(i+1)).equals(" ")){
                                stacks.get(index).add(temp.charAt(i+1));
                            }
                        }
                    }else{
                        commands = true;
                        read.readLine();
                    }
                }else{
                    String[] command = temp.split(" ");
                    int count = Integer.parseInt(command[1]);
                    int from = Integer.parseInt(command[3])-1;
                    int into = Integer.parseInt(command[5])-1;

                    for(int counter = 0; counter < count; counter++){
                        char c = stacks.get(from).poll();
                        stacks.get(into).addFirst(c);
                    }
                }
            }
        }
        for (Deque<Character> stack : stacks) {
            System.out.print(stack.peek());
        }
        System.out.println();
    }

    public static void partTwo() throws IOException {
        List<Deque<Character>> stacks = new ArrayList<Deque<Character>>();
        boolean commands = false;
        try(BufferedReader read = new BufferedReader(new FileReader("organize.txt"))){
            String temp = read.readLine();
            if(temp != null)
            {
                for(int i = 0; i < temp.length(); i+=4)
                {
                    if(!Character.toString(temp.charAt(i+1)).equals(" "))
                    {
                        Deque<Character> aa = new LinkedList<Character>();
                        aa.add(temp.charAt(i+1));
                        stacks.add(aa);
                    }
                    else
                    {
                        stacks.add(new LinkedList<>());
                    }
                }
            }
            while ((temp = read.readLine()) != null) {
                if(!commands) {
                    if (!temp.startsWith(" 1   2 ")) {
                        for (int i = 0, index = 0; i < temp.length(); i += 4, index++) {
                            if(!Character.toString(temp.charAt(i + 1)).equals(" ")) {
                                stacks.get(index).add(temp.charAt(i + 1));
                            }
                        }
                    } else {
                        commands = true;
                        read.readLine();
                    }
                } else {
                    String[] command = temp.split(" ");
                    int count = Integer.parseInt(command[1]);
                    int from = Integer.parseInt(command[3])-1;
                    int into = Integer.parseInt(command[5])-1;
                    List<Character> toMove = new ArrayList<Character>();

                    for(int counter = 0; counter < count; counter++) {
                        toMove.add(stacks.get(from).poll());
                    }
                    for(int i = toMove.size()-1; i >= 0; i--) {
                        stacks.get(into).addFirst(toMove.get(i));
                    }
                }
            }
        }
        for(int i = 0; i < stacks.size(); i++) {
            System.out.print(stacks.get(i).peek());
        }
    }
}
