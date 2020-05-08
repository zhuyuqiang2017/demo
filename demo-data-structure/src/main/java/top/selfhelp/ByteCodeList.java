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

    private void add(int[] nums,int start,int sumResult,int level,
                     List<List<Integer>> result,LinkedList<Integer> tempList){
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

    @Test
    public void biggestIsland() {
        long startTime = System.currentTimeMillis();
        int[][] sources = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int max = 0;
        for(int i = 0;i<sources.length;i++){
            for (int j = 0;j<sources[i].length;j++){
                if (sources[i][j]!=0){
                   max = Math.max(checkIsland(sources,i,j),max);
                }
            }
        }
        System.out.println(max);
        System.out.println("总耗时："+(System.currentTimeMillis()-startTime));
    }

    private int checkIsland(int[][] source,int i,int j){
        if(i<0 || i>=source.length || j>=source[i].length || j<0){
            return 0;
        }
        if(source[i][j]==0){
            return 0;
        }else{
            int currentSize = source[i][j];
            source[i][j] = 0;
            return currentSize+checkIsland(source,i-1,j)+checkIsland(source,i+1,j)+checkIsland(source,i,j+1)+checkIsland(source,i,j+1);
        }
    }

    @Test
    public void searchRotateList(){
        // 1 2 3 4 5 6 7 8 --> 2 3 4 5 6 7 8 1  target = 0
        // 1 2 3 4 5 6 7 8 --> 3 4 5 6 7 8 2 1  target = 1
        // 1 2 3 4 5 6 7 8 --> 4 5 6 7 8 3 1 2  target = 2
        // 1 2 3 4 5 6 7 8 --> 5 6 7 8 4 1 2 3  target = 3
        // 1 2 3 4 5 6 7 8 --> 6 7 8 5 1 2 3 4  target = 4
        // 1 2 3 4 5 6 7 8 --> 7 8 6 1 2 3 4 5  target = 5
        // 1 2 3 4 5 6 7 8 --> 8 7 1 2 3 4 5 6  target = 6
        // 1 2 3 4 5 6 7 8 --> 8 1 2 3 4 5 6 7  target = 7
        //中值大于最右边值时，左边有序;中值小于右边时，右边有序
        int target = 6;
        int[] source = {4,5,6,7,0,1,2};
        int startIndex = 0;
        int endIndex = source.length-1;
        int targetIndex = -1;
        while (endIndex>=startIndex){
            int temp = (startIndex+endIndex)/2;
            if(source[temp]==target){
                targetIndex = temp;
                break;
            }
            if(endIndex-startIndex<=1){
                if(source[endIndex] == target){
                    targetIndex = endIndex;
                }else if (source[startIndex] == target){
                    targetIndex = startIndex;
                }
                break;
            }
            if(source[temp]>source[endIndex]){
                if(target<source[temp]&&source[startIndex]<=target){
                    targetIndex = findInOrder(source,startIndex,temp,target);
                    break;
                }else{
                    startIndex = temp;
                }
            }
            if(source[temp]<source[endIndex]){
                if(target>source[temp]&&target<=source[endIndex]){
                    targetIndex = findInOrder(source,temp,endIndex,target);
                    break;
                }else{
                    endIndex = temp;
                }
            }
        }
        System.out.println(targetIndex);
    }

    private int findInOrder(int[] source, int startIndex, int endIndex, int target) {
        while (endIndex >= startIndex) {
            int temp = (startIndex + endIndex) / 2;
            if (source[temp] == target) {
                return temp;
            }
            if(endIndex-startIndex<=1){
                if(source[endIndex] == target){
                    return endIndex;
                }else if (source[startIndex] == target){
                    return startIndex;
                }
            }
            if (target < source[temp]) {
                endIndex = temp;
            } else {
                startIndex = temp;
            }
        }
        return -1;
    }
}
