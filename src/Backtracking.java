//public class Backtracking {
//    private int backtracking(int[] weight, int[] val, int capacity, int item) {
//
//        if(capacity< 0) return Integer.MIN_VALUE;
//        if(item == val.length || capacity ==0) return 0;
//
//        //take it
//        int include = val[item] + backtracking(weight, val, capacity - weight[item], item + 1);
//        //dont take it
//        int exclude = backtracking(weight, val, capacity, item + 1);
//        //take the best
//        return Math.max(include, exclude);
//
//    }
//
//    private int backtracking2(int[] weight, int[] vale, int capacity, int item) {
//
//        String key = "vapacity = "+ capacity + ",  item = " + item;
//        if(memo.contains(key)) System.out.println("encounter this case again: " + key);
//        else memo.add(key);
//
//        if(capacity < 0) return Integer.MIN_Value;
//        if(item == val.length || capacity ==0) return 0;
//    }
//}
