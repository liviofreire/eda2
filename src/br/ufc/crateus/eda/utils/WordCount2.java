package br.ufc.crateus.eda.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCount2 {
	public static void main(String[] args) throws IOException {
		File file = new File("/Users/disciplinas/Documents/EDA/artigo.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		Map<String, Integer> map = new HashMap<>();
		
		while (reader.ready()) {
			String line = reader.readLine();
			for (String word : line.split("\\s+")) {
				String nWord = word.toLowerCase();
				
				Integer count = map.get(nWord);
				count = (count != null)? count + 1 : 1;
				map.put(nWord, count);
			}
			
			for (String word : map.keySet()) {
				System.out.println(word + " = " + map.get(word));
			}
			
//			System.out.println(reader.readLine());
		}
		
		reader.close();
	}
}
