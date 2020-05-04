package hackerearth.inputoutput.basicsofprogramming;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//Program to find number of letters to delete from either string to make them anagram of each other
public class Anagrams {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
		String a, b;
		int t = in.nextInt();
		in.nextLine();
		while (t > 0) {
			a = in.nextLine();
			b = in.nextLine();
			w.write(anagramsOptimized(a, b) + "\n");
			t--;
		}
		w.flush();

	}

	public static int anagramsNaive(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		boolean[] s2Tracker = new boolean[l2]; // default value is false for all elements
		String anagram = "";
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++)
				if (!s2Tracker[j]) { // i.e. letter is not touched earlier
					if (s2.charAt(j) == s1.charAt(i)) {
						s2Tracker[j] = true;
						anagram = anagram + s2.charAt(j);
						break;
					}
				}
		}
		int aL = anagram.length();
		return l1 - aL + l2 - aL;
	}

	public static int anagramsOptimized(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int[] count1 = new int[26]; 
		int[] count2=new int[26];
		int result=0;
		
		for(int i=0;i<l1;i++) {
			count1[s1.charAt(i)-'a']++;
		}
		for(int i=0;i<l2;i++) {
			count2[s2.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++) {
			result+=Math.abs(count1[i]-count2[i]);
		}
		return result;
	}
}
