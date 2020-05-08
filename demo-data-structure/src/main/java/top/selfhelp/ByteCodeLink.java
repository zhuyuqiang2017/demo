package top.selfhelp;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;

public class ByteCodeLink {
    @Test
    public void mergeLink(){
        LinkedList<Integer> Link1 = new LinkedList<Integer>();
        LinkedList<Integer> Link2 = new LinkedList<Integer>();
        String s = "TARGET_URL-TARGET_URL-  TARGET_URL-hh word     ";
        s = s.replaceAll("(TARGET_URL)+","");
        System.out.println(s);
    }

    @Test
    public void ss(){
        System.out.println("接过："+"20052002人体关键点未检测到人体".matches("^\\d{8}.*"));
        List l = new ArrayList<String>();
        System.out.println(l.get(0));
    }

    @Test
    public void rotateLink(){
        //1->2->3->4->5->NULL
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addLast("1");
        linkedList.addLast("2");
        linkedList.addLast("3");
        linkedList.addLast("4");
        linkedList.addLast("5");
        linkedList.addFirst("$$$");
        doReserve(linkedList,0);
        System.out.println(JSONObject.toJSONString(linkedList));
    }

    @Test
    public void findMedianSortedArrays(){
        int[] nums1 = {1,2,3,4,5,6,9};
        int[] nums2 = {3,4,6,7,9,12};
        //假设寻找第k位，目前定义为中间数
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    //两个数据均不为空，且元素个数
    private double findMedianSortedArrays(int[] nums1,int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        if(n > m)   //保证数组1一定最短
            return findMedianSortedArrays(nums2,nums1);
        int L1=0,L2=0,R1=0,R2=0,c1=0,c2=0,lo = 0, hi = 2*n;  //我们目前是虚拟加了'#'所以数组1是2*n+1长度
        while(lo <= hi)   //二分
        {
            c1 = (lo+hi)/2;  //c1是二分的结果
            c2 = m+n- c1;
            L1 = (c1 == 0)?Integer.MIN_VALUE:nums1[(c1-1)/2];   //map to original element
            R1 = (c1 == 2*n)?Integer.MAX_VALUE:nums1[c1/2];
            L2 = (c2 == 0)?Integer.MIN_VALUE:nums2[(c2-1)/2];
            R2 = (c2 == 2*m)?Integer.MAX_VALUE:nums2[c2/2];

            if(L1 > R2)
                hi = c1-1;
            else if(L2 > R1)
                lo = c1+1;
            else
                break;
        }
        return (Math.max(L1,L2)+ Math.min(R1,R2))/2.0;
    }


    private void doReserve(LinkedList<String> source,int index){

        for(;;){
            String s = source.removeLast();
            if(s.equals("$$$")){
                return;
            }
            source.add(index,s);
            index++;
        }
    }

    @Test
    public void Max(){
        int[][] matrix = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        if(matrix.length == 0) {
            System.out.println(0);
        }else{
            int m = matrix.length, n = matrix[0].length;
            int max = 0;
            int[][] dp = new int[m][n];
            // 第一列赋值
            for(int i = 0; i < m; i++){
                dp[i][0] = matrix[i][0];
                max = Math.max(max, dp[i][0]);
            }
            // 第一行赋值
            for(int i = 0; i < n; i++){
                dp[0][i] = matrix[0][i];
                max = Math.max(max, dp[0][i]);
            }
            // 递推
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    dp[i][j] = matrix[i][j] == 1 ? Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1 : 0;
                    max = Math.max(max, dp[i][j]);
                }
            }
            System.out.println( max * max);
        }

    }
    @Test
    public void test1(){
        int[] ss = new int[]{1,2,3,4};
        sortNumber(ss,0,ss.length-1);
    }
    private  synchronized void swapNumber(int[] arr ,int target,int des){
        int temp = arr[target];
        arr[des] = temp;
        arr[target] = temp;

    }
    private  void sortNumber(int[] source ,int start,int end){
        if(start==end){
            for(int i : source){
                System.out.print(i);
            }
            System.out.println();
        }
        for(int i = start;i<end;i++){
            swapNumber(source,i,start);
            sortNumber(source,start+1,end);
            swapNumber(source,i,start);
        }
    }

    @Test
    public void printUrl(){
        String prefix = "a";
        String subfix = "   b";
        if(!subfix.startsWith("/")){
            subfix = "/"+subfix;
        }
        if(!prefix.startsWith("/")){
            prefix = "/"+prefix;
        }
        String completeUrl = prefix+subfix;
        String url = completeUrl.replaceAll("(\\/)+","/").replaceAll("\\s+","");
        System.out.println(url);
    }

    @Test
    public void arrayListTest() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<String> a = new ArrayList<String>();
        a.add("-1");
        for(int i = 0;i<10000;i++){
            a.add(1,i+"");
        }
        for(int j = 9999;j>1;j--){
            a.remove(j);
        }
        Field field = a.getClass().getField("elementData");
        field.setAccessible(true);
        Object ss = field.get(a);
        System.out.println(a.size());
    }

    @Test
    public void print(){
        System.out.println("hello");
        int cap = 12;
            int n = cap - 1;
            n |= n >>> 1;
            n |= n >>> 2;
            n |= n >>> 4;
            n |= n >>> 8;
            n |= n >>> 16;
            System.out.println(n);
    }

    @Test
    public void squr(){
        int x = 27;
        if(x<2){
            System.out.println(x);
        }
        calculate(2,x/3,x);
    }

    private void calculate(int left,int right,int x){
        if(left<=right){
            int num = (left+right)/2;
            if(num*num*num>x){
                right--;
            }else if(num*num*num<x){
                left++;
            }else {
                System.out.println(num);
                return;
            }
            calculate(left,right,x);
        }else{
            System.out.println(right);
        }
    }


    @Test
    public void testtest(){
        String str = "()((()";
        int count = 0;
        while(str.indexOf("()")>=0){
            str = str.replaceFirst("\\(\\)","");
            count++;
        }
        System.out.println(count*2);
    }


    @Test
    public void test11() {
        String testStr = " ";
        int start = testStr==null?-1:testStr.indexOf('(');
        if(start<0){
            System.out.println(0);
            return;
        }
        int left=0,right = 0,sum = 0;
        boolean hasLeft = false;
        boolean rightend = false;
        for(int i = start; i<testStr.length();i++){
            if(hasLeft&& rightend){
                sum += Math.min(right,left);
                right = 0;
                left = 0;
                hasLeft = false;
                rightend = false;
            }
            if(testStr.charAt(i)=='('&&i<testStr.length()-2&&testStr.charAt(i+1)!='('){
                left++;
                hasLeft = true;
            }else if(testStr.charAt(i)=='('){
                left++;
            }
            if(testStr.charAt(i)==')'&&i<testStr.length()-2&&testStr.charAt(i+1)!=')'){
               right++;
                rightend = true;
            }else if(testStr.charAt(i)==')'){
                right++;
            }
        }
        sum += Math.min(right,left);
        System.out.println(sum*2);
    }

    @Test
    public void test111(){
        Node root = getTree();
        Stack<Node> leftStack = new Stack<>();
        leftStack.push(root.left);
        leftStack = leftStack(leftStack);
        Stack<Node> rightStack = new Stack<>();
        leftStack.push(root.right);
        rightStack = rightStack(rightStack);
        boolean flag = true;
        while (!rightStack.empty()&&!leftStack.empty()){
            Node rightNode = rightStack.pop();
            Node leftNode = leftStack.pop();
            if(leftNode.value!=rightNode.value){
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

    private Stack<Node> leftStack(Stack<Node> root){
        Node leftRoot = root.pop();
        if(leftRoot ==null){
            return root;
        }
        while (leftRoot.right!= null || leftRoot.left!=null){
            root.push(leftRoot);
            if(leftRoot.right!= null){
                root.push(leftRoot.right);
                leftStack(root);
            }
            if(leftRoot.left!=null){
                root.push(leftRoot.left);
                leftStack(root);
            }
        }
        return root;
    }
    private Stack<Node> rightStack(Stack<Node> root){
        Node leftRoot = root.pop();
        if(leftRoot ==null){
            return root;
        }
        while (leftRoot.right!= null || leftRoot.left!=null){
            root.push(leftRoot);
            if(leftRoot.left!= null){
                root.push(leftRoot.left);
                leftStack(root);
            }
            if(leftRoot.right!=null){
                root.push(leftRoot.right);
                leftStack(root);
            }
        }
        return root;
    }

    private Node getTree(){
        Node root = new Node(3);
        Node level1l = new Node(1);
        Node level1r = new Node(1);
        Node level2Right = new Node (5);
        Node level2Left = new Node(2);
        Node level3 = new Node(4);
        root.left = level1l;
        root.right = level1r;
        return root;
    }

    private class Node{
        Node parent;
        int value;
        Node left;
        Node right;
        boolean hasLeftNode;
        boolean hasRightNode;

        public Node(int value) {
            this.value = value;
        }

        public Node getNext() {
            return left;
        }

        public void setNext(Node next) {
            this.left = next;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public boolean hasLeftNode(){
            return hasLeftNode;
        }

        public boolean hasRightNode(){
            return hasRightNode;
        }
    }

    @Test
    public void test1111(){
        System.out.println(fastPower(2,3));
    }

    int fastPower(int base, int exponent) {
        int sum = 1;
        while (exponent != 0) {
            if ((exponent & 1) != 0) {
                sum *= base;
            }
            exponent = exponent >> 1;  // 对指数进行移位
            base *= base;               // 让base的次幂以2的倍数增长
        }
        return sum;
    }
}
