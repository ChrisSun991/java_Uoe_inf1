import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Entropy {
	
	public static int[] charCount(String s) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		char[] s1 = s.toCharArray();
		for (int i = 0; i < s1.length; i++) {
			int index = 0;
			for ( int j = 0; j < s1.length; j++) {
				if(s1[1] == s1[j]) {
					index++;
				}
			}
			map.put(s1[i],  index);
		}
		Character[] keysets = map.keySet().toArray(new Character[map.size()]);
		Arrays.sort(keysets);
		
		int[] returnvalue = new int[map.size()];
		for (int i = 0; i < returnvalue.length; i++) {
			returnvalue[i] = map.get(keysets[i]);
		}
		return returnvalue;
	}
	
	public static double[] normalise(int[] c ) {
		double[] output = new double[c.length];
		int sum = 0;
		for ( int i = 0; i < c.length; i ++) {
			sum+= c[i];
		}
		for (int j = 0; j < c.length; j++) {
			output[j] = c[j]/sum;
		}
		return output;
	}
	
	public static double entropyOf(double[] p) {
		double sum = 0.0;
		for (int i = 0 ; i < p.length; i++) {
			sum += p[i]*Math.log(p[i]);
		}
		if (sum > 0) {
			sum = (-1) * sum;
		}
		return sum;
	}
	
	public static ArrayList<Character> uniqueFilter(String[] a ) {
		ArrayList<Character> result = new ArrayList<Character>();
		char[] arr = "abcdefghijklmnopqrstuvwsyz".toCharArray();
		for (char c : arr) {
			int ind = 0;
			for (String str : a) {
				if (str.indexOf(c) != -1) {
					ind ++;
				}
			}
			if(ind == 1) {
				result.add(c);
			}
		}
		return result;
	}
	
	public static int[][] charCountArray(String[] a){
		int[][] result = new int[a.length][] ;
		for (int i = 0; i < a.length; i++) {
			char[] chars = a[i].toCharArray();
			String output = "";
			for (char achar: chars) {
				if (uniqueFilter(a).contains(achar)) {
					output += achar;
				}
			}
			result[i] = charCount(output);
		}
		return result;
	}
	
	public static void main(String[] args) {
		String s1 = args[0];
		String s2 = args[1];
		String p1 = normalise(charCount(s1)).toString();
		System.out.println("Character Probabilities in " + s1 + ":" + p1);
		double[] en1 = normalise(charCount(s1));
		double[] en2 = normalise(charCount(s2));
		double e1 = entropyOf(en1);
		double e2 = entropyOf(en2);
		System.out.println("Entropy of " + s1 + " : " + e1);
		System.out.println("Entropy of " + s2 + " : " + e2);
		int[][] ccA = charCountArray(new String[] {s1,s2});
		double[] n1 = normalise(ccA[0]);
		double[] n2 = normalise(ccA[1]);
		double e3 = entropyOf(n1);
		double e4 = entropyOf(n2);
		System.out.println("Entropy of unique chars in " + s1 + " : " + e3);
		System.out.println("Entropy of unique chars in " + s2 + " : " + e4);	
	}
	
}
