package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		long t0 = System.nanoTime();
		
//		List<TextProcessor> words = new ArrayList<TextProcessor>();
		
//		words.add(new SingleWordCounter("nils"));
//		words.add(new SingleWordCounter("norge"));
		
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<String>();
		while(scan.hasNext()) {
			stopwords.add(scan.next());
		}
		
		TextProcessor words = new GeneralWordCounter(stopwords);
		scan.close();

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

//			for (TextProcessor p : words) {
//				p.process(word);
//			}
			words.process(word);
			
		}

		s.close();

//		for (TextProcessor p : words) {
//			p.report();
//		}
		words.report();
		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
	}
}