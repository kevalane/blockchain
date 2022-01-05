package blockchain;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Base64;

public class Sign {

    private KeyPair keyPair;
    private Signature sig;

    public Sign() throws Exception {
        this.keyPair = this.getKeyPair();
        sig = Signature.getInstance("SHA256WithRSA");
    }

    /**
     * 
     * @param message string we want to sign, pk is the privatekey
     * @return a hexstring of our signature
     * @throws Exception if method not found
     */
    public String signMessage(String message, PrivateKey pk) throws Exception {
        sig.initSign(pk);
        sig.update(message.getBytes("UTF_8"));
        byte[] signature = sig.sign();
        return Base64.getEncoder().encodeToString(signature);
    }

    /**
    * Generates a keypair
    * @param none
    * @throws NoSuchAlgorithmException if method not found
    * @return the generated keypair <KeyPair>
    */
    private KeyPair getKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(4096, new SecureRandom());
        return kpg.genKeyPair();
    }

    // Convert sha256 byte array to hex string
    // TODO: REMOVE and implement one static shared by hash and this class
	private String toHex(byte[] hash) {
		BigInteger num = new BigInteger(1, hash);
		StringBuilder hex = new StringBuilder(num.toString(16));
		// while (hex.length() < 64) {
		// 	hex.insert(0, '0');
		// }
		return hex.toString();
	}
    
}
