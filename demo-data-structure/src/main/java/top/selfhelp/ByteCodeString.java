package top.selfhelp;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ByteCodeString {

    @Test
    public void printTest(){
        System.out.println("hello junit");
    }

    @Test
    public void findUnRepeatString(){
        String source = "pwwkewbca";
        int startIndex = 0;
        int endIndex = 0;
        List<Character> byteList = new ArrayList<Character>();
        List<String> childString = new ArrayList<String>();
        while(endIndex<=source.length()){
            if(endIndex == source.length() ){
                childString.add(source.substring(startIndex));
            }else if(!byteList.contains(source.charAt(endIndex))){
                byteList.add(source.charAt(endIndex));
            }else{
                childString.add(source.substring(startIndex,endIndex));
                byteList.clear();
                byteList.add(source.charAt(endIndex));
                startIndex = endIndex;
            }
            endIndex++;
        }
//        childString.add(source);
        System.out.println(JSON.toJSONString(childString));
    }

    @Test
    public void findLongestCommonPrefix(){
        String[] sources = {"flower", "flow", "flight"};
//        String[] sources = {"dog","racecar","car"};
        String longestPrefix = findShortestString(sources);
        int j=0,i=0,res = 0;
        exit:
        for (; j < longestPrefix.length(); j++) {
            i = i==sources.length?0:i;
            for (; i < sources.length; i++) {
                if(longestPrefix.charAt(j)!=sources[i].charAt(j)){
                    if(j == 0){
                        longestPrefix = "";
                        break exit;
                    }
                    longestPrefix = longestPrefix.substring(0,j);
                    j = -1;
                    i -=1;
                    break;
                }
            }
        }
        System.out.println(longestPrefix);

    }

    @Test
    public void hasStringOrder(){
        String s1 = "dba",s2 = "eidbaooo";
        String shortString = s1.length()>s2.length()?s2:s1;
        String longString = s1.length()<s2.length()?s2:s1;
        String orderString = getOrderString(shortString);
        int endIndex = shortString.length();
        boolean hasOrder = false;
        int j = 0;
        for(int m = 0 ;m<longString.length()-shortString.length()+1;m++){
            if(longString.charAt(m)==orderString.charAt(j)
            ||longString.charAt(m)==orderString.charAt(endIndex-j-1)){
                if(endIndex-j==1){
                    hasOrder = true;
                    break;
                }
                j++;
            }else{
                j = 0;
            }
        }
        System.out.println(hasOrder);
    }

    @Test
    public void multiplyString(){
        String source1 = "123";
        String source2 = "123";
        int[] res = new int[source1.length()+source2.length()-1];
        for(int i = source1.length()-1;i>=0;i--){
            int add = 0;
            for(int j = source2.length()-1;j>=0;j--){
                int s1 = source2.charAt(j)-'0';
                int multiResult = s1*(source1.charAt(i)-'0');
                int tmp = multiResult+res[i+j]+add;
                res[i+j] = tmp%10;
                add = tmp/10;
            }
        }
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void reverseString(){
        String sentence = "a good   example";
        String[] ss = sentence.split("\\s+");
        System.out.println(JSON.toJSONString(ss));
        for(int i = ss.length-1;i>0;i--){
            System.out.print(ss[i]+" ");
        }
        System.out.println(ss[0]);
    }

    @Test
    public void simplifyPath(){
        String path = "/a/./b/../../c/";
        String deleteLastSymbol = "\\/$";
        String simplifyPathRegex = "\\/{2}+";
        String removeDot = "(\\/\\.\\/)+";
        String newPath = path.replaceAll(deleteLastSymbol,"")
                .replaceAll(simplifyPathRegex,"")
                .replaceAll(removeDot,"/");
        String[] ss = newPath.split("\\/{1}");
        LinkedList<String> pathLink = new LinkedList<String>();
        for(String s : ss){
            if("..".equals(s)){
                pathLink.removeLast();
            }else{
                s = "".equals(s)?"/":s;
                pathLink.addLast(s);
            }
        }
        System.out.println(JSON.toJSONString(pathLink));
    }

    @Test
    public void restoreIp(){
        String source = "10511135";
        List<String> ips = new ArrayList<String>();
        findAndStoreIp(source,"",0,0,ips);
        System.out.println(ips);
    }

    private void findAndStoreIp(String source,String currentStr,int level,int offset,List<String> ips){
        if(level==3){
            if(isValidString(source.substring(offset))){
                currentStr = currentStr+"."+source.substring(offset);
                ips.add(currentStr);
            }
            return;
        }
        String oldStr = currentStr;
        for(int i = 1;i<=3;i++){
            if(offset+i>source.length()){
                return;
            }
            String tmp = source.substring(offset,offset+i);
            if(isValidString(tmp)){
                if(currentStr.equals("")){
                    currentStr = tmp;
                }else{
                    currentStr = currentStr+"."+tmp;
                }
                findAndStoreIp(source,currentStr,level+1,offset+i,ips);
                currentStr = oldStr;
            }
        }
    }

    private boolean isValidString(String source){
        try {
            if(Integer.parseInt(source)>255 || Integer.parseInt(source)<0||source.length()>3||(source.startsWith("0")&&source.length()!=1)){
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    String findShortestString(String[] strings){
        String shortString = null ;
        for(int i = 0;i<strings.length;i++){
            if(shortString==null){
                shortString = strings[i];
            }else{
                shortString = shortString.length()>strings[i].length()?strings[i]:shortString;
            }
        }
        return shortString;
    }

    String getOrderString(String source){
        byte[] bytes = source.getBytes();
        for(int i = 0;i<bytes.length;i++){
            for(int j = 0;j<bytes.length;j++){
                if(bytes[i]<bytes[j]){
                    byte tmp = bytes[j];
                    bytes[j] = bytes[i];
                    bytes[i] = tmp;
                }
            }
        }
        return new String(bytes,0,bytes.length);
    }

}
