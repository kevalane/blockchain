package blockchain;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	
	private String rawInput;
	private String hash;
	
	public Hash(String rawInput) throws NoSuchAlgorithmException {
		this.rawInput = rawInput;
		this.hash = this.toHex(this.getSHA(rawInput));
	}
	
	// Getters
	public String getHash() {
		return this.hash;
	}
	
	// Convert rawdata to sha256 byte array
	private byte[] getSHA(String rawData) throws NoSuchAlgorithmException {
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-256");
		return md.digest(rawData.getBytes(StandardCharsets.UTF_8));
	}
	
	// Convert sha256 byte array to hex string
	private String toHex(byte[] hash) {
		BigInteger num = new BigInteger(1, hash);
		StringBuilder hex = new StringBuilder(num.toString(16));
		System.out.println(hex.length());
		// Padding with zeroes
		while (hex.length() < 64) {
			hex.insert(0, '0');
		}
		System.out.println(hex);
		return hex.toString();
	}

}
