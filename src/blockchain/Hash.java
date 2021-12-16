package blockchain;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	
	public Hash() {
		
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
		System.out.println(hex);
		return hex.toString();
	}

}
