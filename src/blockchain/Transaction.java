package blockchain;

public class Transaction {
	
	private int id;
	private String sender;
	private String receiver;
	private String signature;
	private double amount;
	
	/**
	 * Constructor for transaction.
	 * TODO: Build with inputs (arraylist) and outputs (arraylist) to build a transaction.
	 * If not balancing with right side, goes to miner as transaction fee.
	 * 
	 * @param id
	 * 		int id of transaction
	 * @param sender
	 * 		String sender address
	 * @param receiver
	 * 		String receiver address
	 * @param signature
	 * 		String base16 signature
	 * @param amount
	 * 		amount to be sent
	 */
	public Transaction (int id, String sender, String receiver, String signature, double amount) {
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.signature = signature;
		this.amount = amount;
	}
	
	/**
	 * Getter for transaction id
	 * @return transaction id, int
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Getter of sender address
	 * @return sender address string base16
	 */
	public String getSender() {
		return this.sender;
	}
	
	/**
	 * Get receiver address
	 * @return receiver address base16
	 */
	public String getReceiver() {
		return this.receiver;
	}
	
	/**
	 * Getter for signature attribute
	 * @return signature in base16, string
	 */
	public String getSignature() {
		return this.signature;
	}

	/**
	 * Getter for amount
	 * @return double of amount
	 */
	public double getAmount() {
		return this.amount;
	}
	
	/**
	 * Build and return a concatenated raw string
	 * @return string of concatenated attributes (to be hashed)
	 */
	public String getRawString() {
		return String.valueOf(this.id) + this.sender + this.receiver + this.signature + String.valueOf(this.amount);
	}
}
