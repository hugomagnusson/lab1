package textproc;

import java.util.*;

public class MultiWordCounter implements TextProcessor{
	
	private Map<String, Integer> words;

	public MultiWordCounter (String[] wordVec) {
		words = new HashMap<String, Integer>();
		for (int i = 0; i < wordVec.length; i++) {
			words.put(wordVec[i], 0);
		}
	}
	
	public void process (String w) {
		for(String s : words.keySet()) {
			if (w.equals(s)) {
				words.put(s, words.get(s) + 1);
				break;
			}
		}
	}
	
	public void report () {
		for(String s : words.keySet()) {
			System.out.println(s + ": " + words.get(s));
		}
	}
	
}
