package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permutation(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backtrack(nums , vis , new ArrayList<>() , res );
        return res;
    }

    private static void backtrack(int[] nums , boolean[] vis , List<Integer> curr , List<List<Integer>> res){
        if( curr.size() == nums.length ){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length ; i++){
            if(vis[i]) continue;

            vis[i] = true;
            curr.add(nums[i]);

            backtrack( nums , vis , curr , res);

            curr.remove(curr.size() - 1);
            vis[i] = false;
        }
    }

}
