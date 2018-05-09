package trb1914.paralleloi;

import trb1914.paralleloi.data.Text;

/**
 * A single comparison between two texts
 * @author Mees Gelein
 */
public class Comparison {

	/** The first text*/
	private Text a;
	/** The second text*/
	private Text b;
	/**
	 * Creates a new comparison for the provided two texts
	 */
	public Comparison(Text a, Text b) {
		this.a = a;
		this.b = b;
	}
	
	/**
	 * Starts running the provided comparison
	 */
	public void run() {
		//Log that we're starting
		System.out.println("Comparing " + a.file.getName() + " to " + b.file.getName());
		
		//Go through both the dicts and find the overlaps, if we find one, expand that match
		for(String seed : a.dict.map.keySet()) {
			//If b also contains that seed, output it
			if(b.dict.map.containsKey(seed)) {
				
			}
		}
	}
}
