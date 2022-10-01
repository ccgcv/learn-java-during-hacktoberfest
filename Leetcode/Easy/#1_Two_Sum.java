package Leetcode.Easy;
import java.util.HashMap;
class Solution {
  public int[] twoSum(int[] num, int target) {
      int[] output = new int[2];
      HashMap<Integer, Integer> map = new HashMap<>();
      for(int i = 0; i < num.length; i++){
          if(map.containsKey(num[i])){
              output[0] = map.get(num[i]);
              output[1] = i;
              return output;
          }
          map.put(target - num[i], i);
      }
      return output;
  }
}
