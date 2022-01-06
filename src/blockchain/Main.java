package blockchain;

import java.security.NoSuchAlgorithmException;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		String message = "Hello World";
		try {
			Sign sign = new Sign();
			String signature = sign.signMessage(message, sign.getPrivateKey());
			System.out.println(signature);
			boolean verification = sign.verify(message, signature, sign.getPublicKey());
			System.out.println(verification);
		} catch (Exception e) {
			System.out.println(e);
		}

















//		try {
//			Miner miner = new Miner("thisIsAHeader", 4);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Transaction t1 = new Transaction(1, "Bo2b", "Alice", "feaaef", 10);
		Transaction t2 = new Transaction(2, "Alic2e", "Charlie", "feaaefef", 5);
		Transaction t3 = new Transaction(3, "Ch1ar2lie", "Bob", "afeaefaefaef", 20);
		Transaction t4 = new Transaction(4, "Ali2ce", "Bob", "grsagrf", 50);
		
		Hash genesisHash = new Hash("genesisblock");
		Block genesisBlock = new Block(genesisHash.getHash());
		genesisBlock.addTransaction(t1);
		genesisBlock.addTransaction(t2);
		genesisBlock.addTransaction(t3);
		System.out.println(genesisBlock.getRawData());
		Miner miner = new Miner(genesisBlock.getRawData(), 5);
		
		genesisBlock.setHash(miner.getProofOfWorkHash());
		genesisBlock.setNonce(miner.getNonce());
		
		// Block genesisBlockPlus1 = new Block(genesisBlock.getHash());
		// genesisBlockPlus1.addTransaction(t1);
		// genesisBlockPlus1.addTransaction(t2);
		// genesisBlockPlus1.addTransaction(t4);
		// System.out.println(genesisBlockPlus1.getRawData());
		// Miner miner2 = new Miner(genesisBlockPlus1.getRawData(), 5);

	}

}
