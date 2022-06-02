package blockchain;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	
	private String rawInput;
	private String hash;
	
	/**
	 * Constructor
	 * @param rawInput, the string to be hashed
	 * @throws NoSuchAlgorithmException
	 */
	public Hash(String rawInput) throws NoSuchAlgorithmException {
		this.rawInput = rawInput;
		this.hash = toHex(getSHA(rawInput));
	}
	
	/**
	 * Function to get the hash
	 * @return hash attribute
	 */
	public String getHash() {
		return this.hash;
	}

	/**
	 * Return raw input used to compute hash
	 * @return String of raw input
	 */
	public String getRawInput() {
		return this.rawInput;
	}
	
	/**
	 * Convert rawdata to sha256 byte array
	 * @param rawData, a string of raw data (as in constructor)
	 * @return byte[] array of corresponding hash
	 * @throws NoSuchAlgorithmException
	 */
	private static byte[] getSHA(String rawData) throws NoSuchAlgorithmException {
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-256");
		return md.digest(rawData.getBytes(StandardCharsets.UTF_8));
	}
	
	/**
	 * Convert sha256 byte array to hex string
	 * @param hash, byte array of sha256 hash to convert
	 * @return string of hash in base16
	 */
	private static String toHex(byte[] hash) {
		BigInteger num = new BigInteger(1, hash);
		StringBuilder hex = new StringBuilder(num.toString(16));
		while (hex.length() < 64) {
			hex.insert(0, '0');
		}
		System.out.println(hex.toString());
		return hex.toString();
	}

}
