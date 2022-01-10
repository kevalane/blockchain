package blockchain;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Block {
	private String prevHash;
	private ArrayList<Transaction> transactions;
	private String merkleRoot;
	private String nonce;
	private String hash;
	
	/**
	 * Constructor, sets prevHash and initiates ArrayList for transactions in block.
	 * @param prevHash, string format of previous hash.
	 */
	public Block(String prevHash) {
		this.prevHash = prevHash;
		this.transactions = new ArrayList<Transaction>();
	}
	
	/**
	 * Getter for hash
	 * @return hash of block (proof of work hash) in base16 string
	 */
	public String getHash() {
		return this.hash;
	}

	/**
	 * Getter of nonce
	 * @return return string nonce
	 */
	public String getNonce() {
		return this.nonce;
	}
	
	/**
	 * Set hash (when proof of work hash is found)
	 * @param hash in base64 string format
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	/**
	 * Setter of the nonce, also after proof of work hash is found
	 * @param nonce string format
	 */
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	
	/**
	 * Add transaction to the arraylist of transactions
	 * @param t the transaction of type Transaction
	 * @throws NoSuchAlgorithmException
	 */
	public void addTransaction(Transaction t) throws NoSuchAlgorithmException {
		this.transactions.add(t);
		this.updateMerkleRoot();
	}
	
	/**
	 * This is not merkle root, tree structure will be built in the future.
	 * Currently just taking all transaction data, appending to a string and hashing.
	 * @throws NoSuchAlgorithmException
	 */
	private void updateMerkleRoot() throws NoSuchAlgorithmException {
		StringBuilder allTx = new StringBuilder("");
		for (int i = 0; i < this.transactions.size(); i++) {
			allTx.append(this.transactions.get(i).getRawString());
		}
		Hash merkleHash = new Hash(allTx.toString());
		this.merkleRoot = merkleHash.getHash();
	}
	
	/**
	 * Get the raw data of the block.
	 * Concatenated prevHash and merkle root
	 * @return String of concatenated rawData.
	 */
	public String getRawData() {
		StringBuilder returnString = new StringBuilder("");
		returnString.append(this.prevHash);
		returnString.append(this.merkleRoot);
		return returnString.toString();
	}
}
