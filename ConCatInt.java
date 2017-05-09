/*
 *      [2017-05-08] Challenge #314 [Easy] Concatenated Integers
 * */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConCatInt {
    public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      String input = scan.nextLine();
      scan.close();
      String biggest = "", smallest = "";

      List<String> splitNumbers = Arrays.asList(input.split(" "));

      splitNumbers.sort((o1, o2) -> {
        if(Integer.parseInt(o1 + o2) > Integer.parseInt(o2 + o1)){
            return -1;
        }else if(Integer.parseInt(o1 + o2) < Integer.parseInt(o2 + o1)){
            return 1;
        }
        return 0;
      });

      for(String s : splitNumbers){
          biggest = biggest + s;
          smallest = s + smallest;
      }

      System.out.println(smallest + " " + biggest);
    }
}
