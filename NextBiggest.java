/* Challenge #312 [Intermediate] Next largest number */
import java.util.ArrayList;
import java.util.Comparator;

public class NextBiggest {
    private static ArrayList<Integer> numbers = new ArrayList<Integer>();
    public static void main(String args[]){
        String a = "234765";
        bruteForce("",a,Integer.parseInt(a));
        numbers.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }    

        });
        System.out.println(numbers.get(1));
    }
    private static void bruteForce(String prefix, String str, int firstNum) {
        int n = str.length();
        if (n == 0 && Integer.parseInt(prefix) > firstNum) numbers.add(Integer.parseInt(prefix));
        else {
            for (int i = 0; i < n; i++)
                bruteForce(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n),firstNum);
        }
    }
}
