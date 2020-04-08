import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnionFind {
    final int RED = 1;
    final int BLUE = 0;
    public int[] set;
    ArrayList<Integer> blueMoves;
    ArrayList<Integer> redMoves;


    //DisjSet object
    public UnionFind(int size) {
        set = new int[size];
        Arrays.fill(set, -1);
    }

    public String toString() {
        return Arrays.toString(set);
    }


    //Doesn't need roots to pass in, will find it automatically when called.
    public void union(int root1, int root2) {
        int top1 = root1;
        int top2 = root2;
        if(top1 > -1)
            top1 = find(top1);
        if(top2 > -1)
            top2 = find(top2);

        if (set[top1] > set[top2]) {
            set[top2] += set[top1];
            set[top1] = top2;
        } else {
            set[top1] += set[top2];
            set[top2] = top1;
        }
    }



    public int find(int value) {
        if (set[value] < 0)
            return value;
        else {
            set[value] = find(set[value]); //Recursively update all values to the root.
            return set[value];
        }
    }


    private int[] getNeighbors(int item, int player) {
    //Get size of array
        //test if corner
        int[] neighbors;
        if(item == 1 || item == 121){
            neighbors = new int[2];
        }
        //test if bigger corner
        else if(item == 11 || item == 111){
            neighbors = new int[3];
        }
        //test if top or bottom edge
        else if(item >= 2 && item <= 10 || item >= 112 && item <= 120){
            neighbors = new int[4];
        }
        else if(item % 11 == 1|| item % 11 == 0){
            neighbors = new int[5];
        }
        else{
            neighbors = new int[6];
        }
    //find neighbors
        int postition = 0;
       if(set[item - 1] == player){
           union(set[item], set[item - 1]);
           neighbors[postition] = item - 1;
       }
        if(set[item + 1] == player){
            union(set[item], set[item + 1]);
            neighbors[postition] = item + 1;
        }
        if(set[item - 11] == player){
            union(set[item], set[item - 11]);
            neighbors[postition] = item - 11;
        }
        if(set[item - 10] == player){
            union(set[item], set[item - 10]);
            neighbors[postition] = item - 10;
        }
        if(set[item + 10] == player){
            union(set[item], set[item + 10]);
            neighbors[postition] = item + 10;
        }
        if(set[item + 11] == player){
            union(set[item], set[item + 11]);
            neighbors[postition] = item + 11;
        }
        return neighbors;
    }


    public static void main(String[] args) throws FileNotFoundException {
        //Read in files and set up all storage arrays.
        System.out.println("Please enter (1) for moves.txt\nOr enter (2) for moves2.txt");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        if (answer.equals("1"))
            answer = "src/moves.txt";
        else
            answer = "src/moves2.txt";
        File moves = new File(answer);
        Scanner fileR = new Scanner(moves);

        int count = 0;
        HexBoard board = new HexBoard();
        //Set up objects with arrays for blue and red team.
        UnionFind hexList = new UnionFind(121);
        ArrayList<Integer> blueTurns = new ArrayList<>();
        ArrayList<Integer> redTurns = new ArrayList<>();

        while (fileR.hasNextLine()) {
            count += 1;
            if(count%2 != 0){
            }

        }
//        UnionFind test1 = new UnionFind(7);
//        test1.union(0,1);
//        System.out.println(test1.toString());
//        test1.union(2, 3);
//        System.out.println(test1.toString());
//        test1.union(4, 0);
//        System.out.println(test1.toString());
//        test1.union(5, 0);
//        System.out.println(test1.toString());
//        test1.union(6,2);
//        System.out.println(test1.toString());
//        test1.union(2, 0);
//        System.out.println(test1.toString());

    }
}
