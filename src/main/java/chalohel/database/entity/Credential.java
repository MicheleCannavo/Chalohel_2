package chalohel.database.entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * The type Credential.
 */
@Entity
@Table(name = "credenziali")
public class Credential {

    @Id
    private Long id;

    @Column(name = "password", columnDefinition = "BINARY(16) NOT NULL")
    private byte[] password;

    @Column(name = "salt", columnDefinition = "BINARY(16) NOT NULL")
    private byte[] salt;

    @JoinColumn(name = "IdUSER")
    @OneToOne
    @MapsId
    private User user;

    public Credential() {
    }

    public Credential(byte[] password, byte[] salt) {
        this.password = password;
        this.salt = salt;
    }

    /**
     * Gets id.
     *
     * @return the id
     */

    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets password.
     *
     * @return the password
     */

    public byte[] getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(byte[] password) {
        this.password = password;
    }

    /**
     * Get salt byte [ ].
     *
     * @return the byte [ ]
     */

    public byte[] getSalt() {
        return salt;
    }

    /**
     * Sets salt.
     *
     * @param salt the salt
     */
    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public User getUser() {
        return user;
    }

    /**
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Credential{" +
            "id=" + id +
            ", password=" + Arrays.toString(password) +
            ", salt=" + Arrays.toString(salt) +
            ", user=" + user.toString() +
            '}';
    }
}