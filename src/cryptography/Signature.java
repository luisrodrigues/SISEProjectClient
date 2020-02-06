package cryptography;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Signature {

    private AsymEncryptPriv asymEncryptPriv;
    private AsymDecryptPub asymDecryptPub;
    private MessageDigest digest;

    public Signature() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.asymEncryptPriv = new AsymEncryptPriv();
        this.asymDecryptPub = new AsymDecryptPub();
        this.digest = MessageDigest.getInstance("SHA-256");
    }

    //generate signature
    public String generate(String message, String privateKeyFilename) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        PrivateKey privateKey = this.asymEncryptPriv.getPrivate(privateKeyFilename);
        String hash = buildHash(message);
        return this.asymEncryptPriv.encryptText(hash, privateKey);
    }

    //Verifies signature
    public boolean verify(String message, String digest, String publicKeyFilename) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        PublicKey publicKey = this.asymDecryptPub.getPublic(publicKeyFilename);
        String messageHash = buildHash(message);
        String digestHash = this.asymDecryptPub.decryptText(digest, publicKey);
        return messageHash.equals(digestHash);
    }

    private String buildHash(String message) {
        return Base64.getEncoder().encodeToString(this.digest.digest(message.getBytes(StandardCharsets.UTF_8)));
    }

}
