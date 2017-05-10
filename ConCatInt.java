    /*
     * 		[2017-05-08] Challenge #314 [Easy] Concatenated Integers
     * */
    import java.util.Arrays;
    import java.util.List;
    import java.util.Scanner;
    
    public class ConCatInt {
        public static void main(String args[]) {
          Scanner scan = new Scanner(System.in);
          String input = scan.nextLine();
          scan.close();
          String biggest = "", smallest = "",zeros="";
    
          List<String> splitNumbers = Arrays.asList(input.split(" "));
          while(splitNumbers.contains("0")){
              splitNumbers.remove("0");
              zeros+="0";
          }
          splitNumbers.sort((o1, o2) -> {
            return (o2 + o1).compareTo(o1+o2);
          });
          for(String s : splitNumbers){
              if(splitNumbers.indexOf(s)==1)smallest = zeros + smallest;
              biggest = biggest + s;
              smallest = s + smallest;
              if(splitNumbers.indexOf(s)==splitNumbers.size()-1)biggest = biggest + zeros;
          }
    
          System.out.println(smallest + " " + biggest);
        }
    }
