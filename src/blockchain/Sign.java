package blockchain;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
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
        sig.update(message.getBytes(StandardCharsets.UTF_8));
        byte[] signature = sig.sign();
        return Base64.getEncoder().encodeToString(signature);
    }

    /**
     * 
     * @param message. message of string
     * @param signature, the signature to verify as base64 string
     * @param publicKey, public key associated with priv sig key
     * @return boolean of true or false depending on signature result
     * @throws Exception if method not found
     */
    public boolean verify(String message, String signature, PublicKey publicKey) throws Exception {
        sig.initVerify(publicKey);
        sig.update(message.getBytes(StandardCharsets.UTF_8));
        byte[] signatureBytes = Base64.getDecoder().decode(signature);
        return sig.verify(signatureBytes);
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

    /**
     * @param none
     * @return private key
     */
    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }

    /**
     * 
     * @return the public key associated with keypair
     */
    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }
    
}
