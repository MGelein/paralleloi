package trb1914.paralleloi.data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Every Text has a Dict object. This is a text content that has been broken into pieces
 * @author Mees Gelein
 */
public class Dict {
	
	/** Map of locations of every Seed*/
	public HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	
	/**
	 * The BLAST seed SIZE
	 */
	public static int K = 4;
	
	/**
	 * Creates a new Dictionary from the provided String contents
	 * @param text the text contents
	 */
	public Dict(String text) {
		load(text);
	}
	
	/**
	 * Parses the provided text into this Dictionary of BLAST seed sizes
	 * @param text
	 */
	public void load(String text) {
		//The index we start at
		int i = 0;
		//The maximum index we go to
		int max = text.length() - Dict.K;
		//The BLAST seed
		String seed;
		//Go through every possible K-size BLAST seed
		for(i = 0; i < max; i++) {
			//Save the seed
			seed = text.substring(i, i + K);
			//Check if the seed is already in the map
			if(map.containsKey(seed)) {
				//If it is already in the list, add this index to the list of occurences
				map.get(seed).add(i);
			}else {
				//If it is not in there, add the current index as the first integer
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(seed, list);
			}
		}
	}
}
