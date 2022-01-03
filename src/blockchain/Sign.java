package blockchain;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class Sign {

    KeyPair keyPair;

    public Sign() throws Exception {
        this.keyPair = this.getKeyPair();
    }

    public String signMessage(String message) throws Exception {
        byte[] data = message.getBytes("UTF8");
        Signature sig = Signature.getInstance("SHA1WithRSA");
        sig.initSign(this.keyPair.getPrivate());
        sig.update(data);
        byte[] signatureBytes = sig.sign();
        return toHex(signatureBytes);
    }

    private KeyPair getKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(4096);
        return kpg.genKeyPair();
    }

    // Convert sha256 byte array to hex string
	private String toHex(byte[] hash) {
		BigInteger num = new BigInteger(1, hash);
		StringBuilder hex = new StringBuilder(num.toString(16));
		// while (hex.length() < 64) {
		// 	hex.insert(0, '0');
		// }
		return hex.toString();
	}
    
}
