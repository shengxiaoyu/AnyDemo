package plain.Algorithms.DynamicProgramming;

import org.omg.CORBA.INTERNAL;

/**
 * @author 13314409603@163.com
 * @date 2019/3/30
 * @time 21:56
 * @Description
 * 53. Maximum Subarray
Easy

3865

133

Favorite

Share
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    public int maxSubArray(int[] nums){
        int len = nums.length ;
        int result = Integer.MIN_VALUE ;
        for(int i=0;i<len;i++){
            int max = nums[i] ;
            int sum = nums[i] ;
            for(int j=i+1;j<len;j++){
                sum += nums[j] ;
                max = Math.max(sum,max) ;
            }
            result = Math.max(result,max) ;
        }
        return result ;
    }

    public int maxSubArray2(int[] nums){
        //存储从0到当前节点的最大连续和（当前节点一定在内）
        int[] memo = new int[nums.length] ;
        int max = memo[0] ;
        for(int i=1;i<nums.length;i++){
            if(memo[i-1]>0){
                memo[i] = memo[i-1]+nums[i] ;
            }else {
                memo[i] = nums[i] ;
            }
            max=Math.max(max,memo[i]) ;
        }
        return max ;
    }
}
