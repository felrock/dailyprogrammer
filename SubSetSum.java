/*
 * 	Challenge #313 [Easy] Subset sum
 * */
import java.util.HashSet;

public class SubSetSum {
	public static boolean sumOfSubSet(int[] list){
		HashSet<Integer> previousInts = new HashSet<Integer>();
		for(int i=0; i < list.length; i++){
			int temp = list[i];
			previousInts.add(temp);
			if(previousInts.contains(-temp)){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args){
		int[] test = {1, 2, 3};
		System.out.println(sumOfSubSet(test));
	}
}
