package blockchain;

import java.security.NoSuchAlgorithmException;

public class Miner {
	private int nonce;
	private String header;
	private int difficulty;
	private String prefix;
	private String proofOfWorkHash;
	
	public Miner (String header, int difficulty) throws NoSuchAlgorithmException {
		this.header = header;
		this.difficulty = difficulty;
		this.prefix = this.fixPrefix();
		this.start();
	}
	
	// Getters
	public String getNonce() {
		return String.valueOf(this.nonce);
	}
	
	public String getProofOfWorkHash() {
		return this.proofOfWorkHash;
	}
	
	private void start() throws NoSuchAlgorithmException {
		long startTime = System.nanoTime();
		this.proofOfWorkHash = this.mine();
		long endTime = System.nanoTime();
		long duration = (endTime-startTime)/1000000000;
		System.out.println("Proof of work hash: " + this.proofOfWorkHash);
		System.out.println("Nonce: " + String.valueOf(this.nonce));
		System.out.println("Blocktime: " + String.valueOf(duration) + "s");
	}
	
	private String mine() throws NoSuchAlgorithmException {
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
