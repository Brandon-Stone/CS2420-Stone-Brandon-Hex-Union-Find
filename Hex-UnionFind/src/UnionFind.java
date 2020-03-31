import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UnionFind {
    private int[] set;


    //DisjSet object
    public UnionFind(int size){
        set = new int[size];
        Arrays.fill(set, -1);
    }


    public void union(int root1, int root2){
        if(set[root1] > set[root2])
            set[root1] = root2;                                                                                                                                                                                                    
        else
        {
            if( set[ root1 ] == set[ root2 ] )
                set[ root1 ]--;          // Update height if same
            set[ root2 ] = root1;        // Make root1 new root
        }
    }


    public int find(int value){
        if(set[value] < 0)
            return value;
        else{
            set[value] = find(set[value]);
            return set[value];
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        File moves1 = new File("src/moves.txt");
        File moves2 = new File("src/moves2.txt");
        Scanner input1 = new Scanner(moves1);
        Scanner input2 = new Scanner(moves2);
    }
}
