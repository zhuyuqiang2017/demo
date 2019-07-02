package top.selfhelp;

import top.selfhelp.entity.TreeNode;

import java.util.Random;

public class TreeApplication {

    private static final Random random = new Random();
    static {
//        random.setSeed();
    }

    public static void main(String[] args){
        generatorTree();
    }


    private static TreeNode generatorTree(){
        TreeNode root = new TreeNode(new String(new char[]{'A'}));
        birthTree(root,5);
        return root;
    }

    private static int birthTree(TreeNode root,int height){
        if(height == 1){
            return height;
        }
        int count = Math.abs(random.nextInt()%3);
        if(count == 0){
            // have left node
            TreeNode leftNode = new TreeNode(new String(new char[]{(char) ('A'+height)})+height);
            root.setLeftNode(leftNode);
            leftNode.setParentNode(root);
            return birthTree(leftNode,height-1);
        }
        if(count == 1){
            //have right node
            TreeNode rightNode = new TreeNode(new String(new char[]{(char) ('A'+height)})+height);
            root.setRightNode(rightNode);
            rightNode.setParentNode(root);
            return birthTree(rightNode,height-1);
        }
        if(count == 2){
            //have left and right node
            TreeNode leftNode = new TreeNode(new String(new char[]{(char) ('A'+height)})+height);
            TreeNode rightNode = new TreeNode(new String(new char[]{(char) ('A'+height)})+height+1);
            root.setRightNode(rightNode);
            root.setLeftNode(leftNode);
            leftNode.setParentNode(root);
            rightNode.setParentNode(root);
            birthTree(leftNode,height-1);
            return birthTree(rightNode,height-1);
        }
        return -1;
    }
}
