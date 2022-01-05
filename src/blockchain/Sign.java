package blockchain;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class Sign {

    KeyPair keyPair;
    Signature sig;

    public Sign() throws Exception {
        this.keyPair = this.getKeyPair();
        sig = Signature.getInstance("SHA256WithRSA");
    }

    public String signMessage(String message) throws Exception {
        byte[] data = message.getBytes("UTF8");
        sig.initSign(this.keyPair.getPrivate());
        sig.update(data);
        System.out.println(sig);
        byte[] signatureBytes = sig.sign();
        return toHex(signatureBytes);
    }

    public boolean verify(String signature) throws Exception {
        byte[] data = signature.getBytes("UTF8");
        sig.initVerify(keyPair.getPublic());
        sig.update(data);
        System.out.println(sig.verify(data));
        return true;
        
    }

    /*
    * Generates a keypair
    * @param none
    * @throws NoSuchAlgorithmException if method not found
    * @return the generated keypair <KeyPair>
    */
    private KeyPair getKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
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
