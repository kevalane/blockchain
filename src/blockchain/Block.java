package blockchain;
import java.util.ArrayList;

public class Block {
	private String prevHash;
	private ArrayList<Transaction> transactions;
	private String nonce;
	private String hash;
	
	public Block(String prevHash) {
		// TODO - implement BlockHeader class
		// Generally, go through https://www.oreilly.com/library/view/mastering-bitcoin/9781491902639/ch01.html
		this.prevHash = prevHash;
		this.transactions = new ArrayList<Transaction>();
	}
	
	// Getters
	public String getHash() {
		return this.hash;
	}
	
	// Setters
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	
	public void addTransaction(Transaction t) {
		this.transactions.add(t);
	}
	
	public String getRawData() {
		StringBuilder returnString = new StringBuilder("");
		returnString.append(this.prevHash);
		for (int i = 0; i < this.transactions.size(); i++) {
			returnString.append(this.transactions.get(i).getRawString());
		}
		return returnString.toString();
	}
}
