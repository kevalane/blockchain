package blockchain;

public class Miner {
	private String nonce;
	private String header;
	private int difficulty;
	private String prefix;
	
	public Miner (String header, int difficulty) {
		this.header = header;
		this.difficulty = difficulty;
		this.prefix = 
		this.mine();
	}
	
	private boolean mine () {
		Hash hash;
//		while ()
		return true;
	}
		
	// Fix prefix
	private String fixPrefix() {
		StringBuilder prefix = new StringBuilder("");
		for (int i = 0; i < this.difficulty; i++) {
			prefix.append("0");
		}
		return prefix.toString();
	}
}
