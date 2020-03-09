package top.selfhelp;

import org.junit.Test;

import java.util.*;

public class ByteCodeList {

    @Test
    public void threeSum(){
        int[] numbers = {-1, 0, 1, 2,-1, -4};
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int startIndex = 0;
        int sumResult = 0;
        add(numbers,0,0,0,result,new LinkedList<Integer>());
        System.out.println(result);
    }

    private void add(int[] nums,int start,int sumResult,int level,List<List<Integer>> result,LinkedList<Integer>tempList){
        if(level == 2&&start<nums.length){
            for(int i = start;i<nums.length;i++){
                if(sumResult==nums[i]){
                    List<Integer> tt = new ArrayList<Integer>(tempList.size());
                    tt.addAll(tempList);
                    tt.add(nums[i]);
                    result.add(tt);
                }
            }
        }
        if(tempList == null){
            tempList = new LinkedList<Integer>();
        }
        for(int i = start;i<nums.length;i++){
            tempList.addLast(nums[i]);
            sumResult = sumResult-nums[i];
            add(nums,i+1,sumResult,level+1,result,tempList);
            tempList.removeLast();
            sumResult+=nums[i];
        }
    }
}
