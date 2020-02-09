import java.util.ArrayList;
import java.util.List;
public class Subsets {
    // main function to start the program
    public static void main(String[] args) {
        // Creating object for backtracking
        Subsets b = new Subsets();
        // Declaring array
        int[] a = {1, 2, 3};
        // creating list of lists
        List<List<Integer>> sub = b.sub(a);
        // printing all subsets
        System.out.println(sub);
    }

    // sub function
    public List<List<Integer>> sub(int[] a) {
        List<List<Integer>> list = new ArrayList<>();
        // calling function to store elements of array
        subsets(list, new ArrayList<>(), a, 0);
        return list;
    }

    // this method will create subset
    private void subsets(List<List<Integer>> list, List<Integer> result, int[] a, int begin) {
        list.add(new ArrayList<>(result));
        // iterating in array
        for (int i = begin; i < a.length; i++) {
            // add element
            result.add(a[i]);
            // Explore
            subsets(list, result, a, i + 1);
            // remove
            result.remove(result.size() - 1);
        }
    }
}