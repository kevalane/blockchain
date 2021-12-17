package blockchain;

public class Transaction {
	
	private int id;
	private String sender;
	private String receiver;
	private String signature;
	private double amount;
	
	public Transaction (int id, String sender, String receiver, String signature, double amount) {
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.signature = signature;
		this.amount = amount;
	}
	
	// Getter
	public int getId() {
		return this.id;
	}
	
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
	
	public String getRawString() {
		return String.valueOf(this.id) + this.sender + this.receiver + this.signature + String.valueOf(this.amount);
	}
	
	
	
}
