/*
 * [2017-05-10] Challenge #314 [Intermediate] Comparing Rotated Words
 * 
 * */
public class StringRotate {
    public static String rotLexi(String s){
        String smallest = s;
        for(int i=0; i < s.length(); i++){
            String temp = s.substring(s.length()-i, s.length()) + s.substring(0, s.length()-i);
            if(temp.compareTo(smallest) < 1){
                smallest = temp;
            }
        }
        return smallest;
    }
    public static void main(String args[]){
        String s = "pneumonoultramicroscopicsilicovolcanoconiosis";
        System.out.println(rotLexi(s));
    }
} 
