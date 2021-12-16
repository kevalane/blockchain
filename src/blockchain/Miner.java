package blockchain;

import java.security.NoSuchAlgorithmException;

public class Miner {
	private int nonce;
	private String header;
	private int difficulty;
	private String prefix;
	
	public Miner (String header, int difficulty) throws NoSuchAlgorithmException {
		this.header = header;
		this.difficulty = difficulty;
		this.prefix = this.fixPrefix();
		System.out.println(this.mine());
	}
	
	private String mine () throws NoSuchAlgorithmException {
		this.nonce = 0;
		Hash hash = new Hash(this.header + String.valueOf(this.nonce));
		while (!hash.getHash().startsWith(this.prefix)) {
			this.nonce++;
			hash = new Hash(this.header + String.valueOf(this.nonce));
		}
		return hash.getHash();
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
