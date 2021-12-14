package blockchain;

public class Transaction {
	
	private String sender;
	private String receiver;
	private String signature;
	private double amount;
	
	public Transaction (String sender, String receiver, String signature, double amount) {
		this.sender = sender;
		this.receiver = receiver;
		this.signature = signature;
		this.amount = amount;
	}
	
	// Getter
	public String getSender() {
		return this.sender;
	}
	
	public String getReceiver() {
		return this.receiver;
	}
	
	public String getSignature() {
		return this.signature;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	
	
}
