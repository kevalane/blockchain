package blockchain;

import java.security.NoSuchAlgorithmException;

public class Miner {
	private int nonce;
	private String header;
	private int difficulty;
	private String prefix;
	private String proofOfWorkHash;
	
	/**
	 * Constructor creating a miner object with relevant attributes
	 * @param header, string format of base16 hash of header of block
	 * @param difficulty, int of specified diffuculty of blockchain (num of zeroes to start with for proof of work)
	 * @throws NoSuchAlgorithmException
	 */
	public Miner (String header, int difficulty) throws NoSuchAlgorithmException {
		this.header = header;
		this.difficulty = difficulty;
		this.prefix = this.fixPrefix();
		this.start();
	}
	
	/**
	 * Getter for nonce
	 * @return nonce, as string
	 */
	public String getNonce() {
		return String.valueOf(this.nonce);
	}
	
	/**
	 * Getter of proof of work hash (when done)
	 * @return sting base16 representation of hash
	 */
	public String getProofOfWorkHash() {
		return this.proofOfWorkHash;
	}
	
	/**
	 * Start function being called in constructor (to make it cleaner).
	 * Sets starttime, starts mining, sets endtime and prints to console when done.
	 * @throws NoSuchAlgorithmException
	 */
	private void start() throws NoSuchAlgorithmException {
		long startTime = System.nanoTime();
		this.proofOfWorkHash = this.mine();
		long endTime = System.nanoTime();
		long duration = (endTime-startTime)/1000000000;
		System.out.println("Proof of work hash: " + this.proofOfWorkHash);
		System.out.println("Nonce: " + String.valueOf(this.nonce));
		System.out.println("Blocktime: " + String.valueOf(duration) + "s");
	}
	/**
	 * Mining function that increments nonce until proof of work hash is found
	 * @return String of proof of work hash when done
	 * @throws NoSuchAlgorithmException
	 */
	private String mine() throws NoSuchAlgorithmException {
		this.nonce = 0;
		Hash hash = new Hash(this.header + String.valueOf(this.nonce));
		while (!hash.getHash().startsWith(this.prefix)) {
			this.nonce++;
			hash = new Hash(this.header + String.valueOf(this.nonce));
		}
		return hash.getHash();
	}
		
	/**
	 * Creates a startswith string containing a number of 0s set by the complexity
	 * @return the string with prefix. ex "0000"
	 */
	private String fixPrefix() {
		StringBuilder prefix = new StringBuilder("");
		for (int i = 0; i < this.difficulty; i++) {
			prefix.append("0");
		}
		return prefix.toString();
	}
}
