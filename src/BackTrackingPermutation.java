import java.util.ArrayList;
import java.util.List;

public class BackTrackingPermutation {
    public static void main(String[] args) {

        BackTrackingPermutation btp = new BackTrackingPermutation();

        List<String> combinations = btp.permutate("123");
        for(String c : combinations) System.out.println(c + " ");

    }

    public List<String> permutate(String source) {

        List<String> combinations = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        permuteHelper(source, sb, combinations);
        return combinations;
    }
    private void permuteHelper(String source, StringBuilder chosen, List<String> combinations) {
        if(source.length() == 0){
            combinations.add(chosen.toString());
            return;
        }
        for (int i = 0; i < source.length(); i++) {

            //make the choice
            int currlength = chosen.length();
            chosen.append(source.charAt(i));

            //explore
            permuteHelper(source.substring(0, i) + source.substring(i + 1), chosen, combinations);

            //backtrack
            chosen.setLength(currlength);

        }
    }
}
