/* Challenge #312 [Easy] L33tspeak Translator */

public class LeetSpeak {
	
	public static String toLeet(String s){
		for(int i=0; i < alphabetLength; i++){
			 s = s.replace(norm[i].toLowerCase(), leet[i]);
			 s = s.replace(norm[i], leet[i]);
		}
		return s;
	}

	public static String toNorm(String s){
		for(int i=0; i < alphabetLength; i++){
			s = s.replace(leet[i], norm[i]).equals(s) ? s : s.replace(leet[i], norm[i].toLowerCase());
		}
		return s;
	}
	public static void main(String args[]){
		String[] testWords = {"I am elite.", "Da pain!", "Eye need help!"};
		String[] testLeets = {"3Y3 (\\)33d j00 t0 g37 d4 d0c70r.", "1 n33d m4 p1llz!"};
		for(int i=0; i < testWords.length; i++){
			System.out.println(testWords[i] + " -> " + toLeet(testWords[i]));
		}
		for(int i=0; i < testLeets.length; i++){
			System.out.println(testLeets[i] + " -> " + toNorm(testLeets[i]));
		}
	}
	private static final String[] 	norm = {"A","B","E","I","L","M","N","O","S","T","V","W"};
	private static final String[] 	leet = {"4","6","3","1","|","(\\/)","(\\)","0","5","7","/\\","´//"};
	private static int alphabetLength = 12;
}
