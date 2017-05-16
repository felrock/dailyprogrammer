    /*
     *      [2017-05-08] Challenge #314 [Easy] Concatenated Integers
     * */
    import java.util.Arrays;
    import java.util.LinkedList;
    import java.util.List;
    import java.util.Scanner;
    
    public class ConCatInt {
        public static void main(String args[]) {
          Scanner scan = new Scanner(System.in);
          String input = scan.nextLine();
          scan.close();
          String biggest = "", smallest = "",zeros="";
    
          List<String> splitNumbers = new LinkedList<String>(Arrays.asList(input.split(" ")));
          while(splitNumbers.contains("0")){
              splitNumbers.remove("0");
              zeros+="0";
          }
          splitNumbers.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
          for(int i=0; i < splitNumbers.size(); i++){
              biggest = biggest + splitNumbers.get(i);
              smallest = splitNumbers.get(i) + smallest;
              if(i==0) {
                  smallest = zeros + smallest;
              }
              if(i == splitNumbers.size()-1) biggest = biggest + zeros;
          }
    
          System.out.println(smallest + " " + biggest);
        }
    }
