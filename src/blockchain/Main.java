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
		// Transaction t1 = new Transaction(1, "Bob", "Alice", "feaaef", 10);
		// Transaction t2 = new Transaction(2, "Alice", "Charlie", "feaaefef", 5);
		// Transaction t3 = new Transaction(3, "Charlie", "Bob", "afeaefaefaef", 20);
		// Transaction t4 = new Transaction(4, "Alice", "Bob", "grsagrf", 50);
		
		// Hash genesisHash = new Hash("genesisblock");
		// Block genesisBlock = new Block(genesisHash.getHash());
		// genesisBlock.addTransaction(t1);
		// genesisBlock.addTransaction(t2);
		// genesisBlock.addTransaction(t3);
		// System.out.println(genesisBlock.getRawData());
		// Miner miner = new Miner(genesisBlock.getRawData(), 4);
		
		// genesisBlock.setHash(miner.getProofOfWorkHash());
		// genesisBlock.setNonce(miner.getNonce());
		
		// Block genesisBlockPlus1 = new Block(genesisBlock.getHash());
		// genesisBlockPlus1.addTransaction(t1);
		// genesisBlockPlus1.addTransaction(t2);
		// genesisBlockPlus1.addTransaction(t4);
		// System.out.println(genesisBlockPlus1.getRawData());
		// Miner miner2 = new Miner(genesisBlockPlus1.getRawData(), 4);

		try {
			Sign sign = new Sign();
			System.out.println(sign.signMessage("Hello wold"));
			sign.verify(sign.signMessage("Hello wold"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
