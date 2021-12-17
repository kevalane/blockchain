package blockchain;

import java.security.NoSuchAlgorithmException;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
//		try {
//			Miner miner = new Miner("thisIsAHeader", 4);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		// Lets generate some transactions
		Transaction t1 = new Transaction(1, "Bob", "Alice", "feaaef", 10);
		Transaction t2 = new Transaction(2, "Alice", "Charlie", "feaaefef", 5);
		Transaction t3 = new Transaction(3, "Charlie", "Bob", "afeaefaefaef", 20);
		Transaction t4 = new Transaction(4, "Alice", "Bob", "grsagrf", 50);
		
		Hash genesisHash = new Hash("genesisblock");
		Block genesisBlock = new Block(genesisHash.getHash());
		genesisBlock.addTransaction(t1);
		genesisBlock.addTransaction(t2);
		genesisBlock.addTransaction(t3);
		genesisBlock.addTransaction(t4);
		System.out.println(genesisBlock.getRawData());
	}

}
