package trb1914.paralleloi.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import trb1914.paralleloi.Comparison;
import trb1914.paralleloi.Paralleloi;

/**
 * This text object holds the methods used for a loaded text
 * to interact with it
 * @author Mees Gelein
 */
public class Text {
	
	/** Stored texts that have been succesfully loaded*/
	private static ArrayList<Text> texts = new ArrayList<Text>();
	
	/**
	 * Runs a comparison to compare every text against every other text
	 */
	public static void compareAll() {
		for(int i = 0; i < texts.size(); i++) {
			for(int j = i + 1; j < texts.size(); j++) {
				(new Comparison(texts.get(i), texts.get(j))).run();
			}
		}
	}
	
	/** The dictionary object of this Text*/
	public Dict dict;
	/** Reference to the actual file */
	public File file;
	/** The contents of the file once the encoding has been applied*/
	public String contents;
	
	/**
	 * Tries to create a new TextObject from a provided URL.
	 * @param url
	 */
	public Text(String url) {
		//Prevent bad input
		if(url == null || url.length() == 0) {
			System.err.println("Cannot instantiate a new text from null url string!");
			return;
		}
		//Create the file
		file = new File(url);
		//Test if it exists
		if(!file.exists()) {
			System.err.println("Cannot instantiate a new text. Cannot find file: " + file.getAbsolutePath());
			return;
		}
		
		//Reads all bytes into memory, but catches any exceptions
		try {
			System.out.println("Loading file: " + url);
			byte[] fileBytes = Files.readAllBytes(Paths.get(url));
			//Now create the string from the files using the character set
			contents = new String(fileBytes, Paralleloi.charSet);
			//Store the text in the hashmap of loaded texts
			texts.add(this);
			//Load the dictionary
			System.out.println("Creating Dictionary for: " + url);
			dict = new Dict(contents);
		} catch (IOException e) {
			System.err.println("Something went wrong reading the bytes into memory of file: " + url);
			e.printStackTrace();
		}
	}

}
