package br.com.idwall.desafios.str;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class FormaterText {

	
	//Desafio 1
	
	//parte 1
	//just limit the number of characters in a row
	public String limitText(String text, int width) {
		return linesAsText(splitToLines(width, text, false));
	}
	
	//parte 2
	//justify text and limit the number of characters in a row
	public String justify(String text, int width) {
		return linesAsText(splitToLines(width, text, true));
	}
	
	private String linesAsText(List<String> lines) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> iterator = lines.iterator();
		while(iterator.hasNext()) {
			sb.append(iterator.next());
			if(iterator.hasNext()) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
	private List<String> splitToLines(int width, String text, boolean paddedLine){
		List<String> lines = new ArrayList<String>();
		//variable allows that paragraph will be respected  
		String[] paragraph = text.split("\n");
		
		for(int i = 0 ; i < paragraph.length; i++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer tokenizer = new StringTokenizer(paragraph[i]);
			while(tokenizer.hasMoreElements()) {
				String word = tokenizer.nextElement().toString();
				if(sb.length() + word.length() > width) {
					if(paddedLine)
						lines.add(getPaddedLine(sb, width));
					else
						lines.add(sb.toString().trim());
					sb.setLength(0);
				}
				sb.append(word).append(" ");
			}
			if(sb.length() > 0) {
				if(paddedLine)
					lines.add(getPaddedLine(sb, width));
				else
					lines.add(sb.toString().trim());
			}
		}
		return lines;
	}
	
	private String getPaddedLine(StringBuilder sb, int width) {
		String text =sb.toString().trim();
		text = addPadding(0, width, text);
		return text;
	}
	
	private String addPadding(int index, int width, String text) {
		
		StringTokenizer st = new StringTokenizer(text);
		
		if((text.length() >= width) || st.countTokens() > 2) return text;
		
		if(index >= st.countTokens() -1) index = 0;
		
		if((text.length() >= width) || index >= st.countTokens()-1) return text;
		
		StringBuilder sb = new StringBuilder();
		
		String word = null;
		for(int i =0;i <= index; i++) {
			if(st.hasMoreElements())
				word = (String) st.nextElement();
			else
				word = null;
			
		}
		
		if(word == null) return text;
		
		sb.append(word).append(" ");
		
		return addPadding(++index,width, text.replace(word, sb.toString()));
		
	}
	
}
