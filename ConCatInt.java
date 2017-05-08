    /*
     * 		[2017-05-08] Challenge #314 [Easy] Concatenated Integers
     * */
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Comparator;
    import java.util.Scanner;
    
    public class ConCatInt {
    	public static void main(String args[]){
    		Scanner scan = new Scanner(System.in);
    		String input = scan.nextLine();
    		scan.close();
    		String biggest = "",smallest = "";
    		ArrayList<String> splitNumbers = new ArrayList<String>(Arrays.asList(input.split(" ")));
    		splitNumbers.sort(new Comparator<String>(){
    			@Override
    			public int compare(String o1, String o2) {
    				for(int i=0; i < o1.length(); i++){
    					for(int j = 0; j < o2.length(); j++){
    						if((int)o1.charAt(i) > (int)o2.charAt(j)){
    							return -1;
    						}else if((int)o1.charAt(i) < (int)o2.charAt(j)){
    							return 1;
    						}
    					}
    				}
    				return 0;
    			}});
    		for(String s : splitNumbers){
    			biggest = biggest + s;
    			smallest = s + smallest;
    		}
    		
    		System.out.println(smallest + " " + biggest);
    	}
    }
