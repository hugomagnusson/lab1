package textproc;

import java.util.*;

public class GeneralWordCounter implements TextProcessor{
	
	private Map<String, Integer> words;
	private Set<String> stopwords;

	public GeneralWordCounter(Set<String> stopwords) {
		words = new HashMap<String, Integer>();
		this.stopwords = stopwords;
	}
	
	public void process(String w) {
		Iterator<String> itr = stopwords.iterator();
		int i = 0;
		while(itr.hasNext()) {
			if (w.equals(itr.next())) {
				break;
			}
			else {
				i++;
			}
		}
		if (i >= stopwords.size()) {
			Integer v = words.putIfAbsent(w, 1);
			if (v != null) {
				words.replace(w, v + 1);
			}
		}
	}
	
	public void report() {
//		for(String s : words.keySet()) {
//			if(words.get(s) >= 200) {
//				System.out.println(s + ": " + words.get(s));
//			}
//		}
		Set<Map.Entry<String, Integer>> wordSet = words.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		
		wordList.sort(new WordCountComparator());
		
		for (int i = 0; i < 5; i++) {
			System.out.println(wordList.get(i).getKey() + ": " + wordList.get(i).getValue());
		}
	}
	
}
