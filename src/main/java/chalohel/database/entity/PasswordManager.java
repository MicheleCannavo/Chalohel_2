package chalohel.database.entity;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;

/**
 * Una classe di utilità per eseguire l'hash delle password
 * e controllare le password rispetto ai valori hash.
 * Usa una combinazione di hashing e sale unico.
 * L' algoritmo utilizzato è PBKDF2WithHmacSHA1 che,
 * è considerato robusto e consigliato dal NIST.
 * Il valore con hash ha 256 bit.
 */
public class PasswordManager {

    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 512;
    private static final int SALT_LENGTH = 16;

    /**
     * Classe di utilità statica
     */
    private PasswordManager() {
    }

    /**
     * Restituisce un salt casuale da utilizzare per l' hashing di una password.
     *
     * @return un salt casuale di SALT_LENGTH byte
     */
    public static byte[] getNextSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return salt;
    }

    /**
     * Restituisce una password salata e con hash utilizzando l'hash fornito.
     * Nota - effetto collaterale: la password viene distrutta.
     *
     * @param password la password da sottoporre ad hashing.
     * @param salt     un salt di SALT_LENGTH byte.
     * @return L hash della password con il salt.
     */
    public static byte[] hash(char[] password, byte[] salt) {

        try {
            KeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
            Arrays.fill(password, Character.MIN_VALUE);
            var skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (GeneralSecurityException | RuntimeException ex) {
            // log.error("Password non generata: "+ex);
            return new byte[0];
        }

    }


    /**
     * Restituisce true se la password e il salt forniti corrispondono al valore hash, altrimenti false. Note - side
     * effect: the password is destroyed (the char[] is filled with zeros)
     *
     * @param password     the password to check
     * @param salt         the salt used to hash the password
     * @param expectedHash the expected hashed value of the password
     * @return true if the given password and salt match the hashed value, false otherwise
     */
    public static boolean isSamePassword(char[] password, byte[] salt, byte[] expectedHash) {
        byte[] pwdHash = hash(password, salt);
        Arrays.fill(password, Character.MIN_VALUE);
        return Arrays.equals(pwdHash, expectedHash);
    }

}
