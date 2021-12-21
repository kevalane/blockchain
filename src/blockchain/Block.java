package blockchain;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Block {
	private String prevHash;
	private ArrayList<Transaction> transactions;
	private String merkleRoot;
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
	
	// Add transactions
	public void addTransaction(Transaction t) throws NoSuchAlgorithmException {
		this.transactions.add(t);
		this.updateMerkleRoot();
	}
	
	// Update merkleRoot
	private void updateMerkleRoot() throws NoSuchAlgorithmException {
		StringBuilder allTx = new StringBuilder("");
		for (int i = 0; i < this.transactions.size(); i++) {
			allTx.append(this.transactions.get(i).getRawString());
		}
		Hash merkleHash = new Hash(allTx.toString());
		this.merkleRoot = merkleHash.getHash();
	}
	
	public String getRawData() {
		StringBuilder returnString = new StringBuilder("");
		returnString.append(this.prevHash);
		returnString.append(this.merkleRoot);
		return returnString.toString();
	}
}
