package top.selfhelp;


import top.selfhelp.entity.Node;

import java.util.ArrayList;
import java.util.List;

public class ListApplication {

    public static void main(String[] args){
        Node head = generatorNodeList(2);
        Node reversalHead = getReversalNodeList(head);
        printNodeList(reversalHead);
        reversalHead = getReversalNodeListWithRecursion(reversalHead,reversalHead.getNext(),true);
        printNodeList(reversalHead);
    }

    private static Node getReversalNodeList(Node head){
        Node nextNode = head.getNext();
        Node reversalHead = null;
        head.setNext(null);
        while(head != null && nextNode != null){
            reversalHead = nextNode;
            nextNode = nextNode.getNext();
            reversalHead.setNext(head);
            head = reversalHead;
        }
        return reversalHead;
    }

    private static Node getReversalNodeListWithRecursion(Node head ,Node next,boolean isFirst){
        if(isFirst){
            head.setNext(null);
        }
        if(head == null || next == null){
            return head;
        }
        Node temp = null;
        temp = next;
        next = next.getNext();
        temp.setNext(head);
        head = temp;
        return getReversalNodeListWithRecursion(head,next,false);
    }

    private static Node generatorNodeList(int nodeCount){
        List<Node> nodes = new ArrayList<>();
        Node head = null;
        Node currentNode = null;
        for(int i = 0;i<nodeCount;i++){
            if(head == null){
                head = new Node();
                head.setName(new String(new char[]{(char) ('A'+i)}));
                currentNode = head;
            }else{
                Node node = new Node();
                node.setName(new String(new char[]{(char) ('A'+i)}));
                currentNode.setNext(node);
                currentNode = node;
            }
        }
        printNodeList(head);
        return head;
    }

    private static void printNodeList(Node head){
        if(head == null){
            System.out.println("Empty Node List");
        }else{
            StringBuilder builder = new StringBuilder();
            while(head != null){
                builder.append(head.getName()).append("->");
//                System.out.println(builder.toString());
                head = head.getNext();
            }
            System.out.println(builder.toString());
        }
    }

}
