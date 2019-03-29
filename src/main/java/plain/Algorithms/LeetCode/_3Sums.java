package plain.Algorithms.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 13314409603@163.com
 * @date 2019/1/28
 * @time 18:44
 * @Description
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
[-1, 0, 1],
[-1, -1, 2]
]
 */
public class _3Sums {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4} ;
        List<List<Integer>> lists = threeSum(nums);
        lists.forEach(list->{
            for(Integer item:list){
                System.out.print(item+" ");
            }
            System.out.println();
        });
    }
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList() ;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int h=j+1;h<nums.length;h++){
                    if(nums[i]+nums[j]+nums[h]==0){
                        List<Integer> list = new ArrayList() ;
                        list.add(nums[i]) ;
                        list.add(nums[j]) ;
                        list.add(nums[h]) ;
                        result.add(list) ;
                    }
                }
            }
        }
        return result ;
    }
}
