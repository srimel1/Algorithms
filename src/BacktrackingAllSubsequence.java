import java.util.ArrayList;
import java.util.List;

public class BacktrackingAllSubsequence {

    public static void main(String[] args) {
        BacktrackingAllSubsequence bts = new BacktrackingAllSubsequence();

        List<String> combinations = bts.subsequence("123");
        for (String c: combinations) System.out.print(c + " ");
    }

    public List<String> subsequence(String source) {
        List<String> combinations = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        subsequenceHelper(source, sb, 0, combinations);
        return combinations;
    }

    private void subsequenceHelper(String source, StringBuilder chosen, int index, List<String> combinations) {
        if (source.length() == index) {
            combinations.add(chosen.toString());
            return;
        }// make the choice: do not include charAt(index)
         int tmpLength = chosen.length();
        subsequenceHelper(source, chosen, index+1, combinations);
        // backtrack: recover chosen and then include charAt(index)
        chosen.setLength(tmpLength);
        subsequenceHelper(source,
                chosen.append(source.charAt(index)), index+1, combinations);
    }
}


