package chalohel.database.entity;

import javax.persistence.*;

/**
 * The type User.
 */
@Entity
@Table(name = "utenti")
public class User {

    @Id
    @Column(name = "IdUSER", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "varchar(30) NOT NULL")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "varchar(6) NOT NULL")
    private Role role = Role.USER;

    @OneToOne(
        mappedBy = "user",
        cascade = CascadeType.PERSIST,
        orphanRemoval = true
    )
    private Credential credential;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instanziazione nuovo Utente.
     *
     * @param name the nome
     */
    public User(String name) {
        this.name = name;
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
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Credential getCredential() {
        return credential;
    }

    /**
     * @param credential
     */
    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }/**/

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User: " + System.lineSeparator() +
            "\tID    = " + id + System.lineSeparator() +
            "\tnome  = " + name + System.lineSeparator() +
            "\trole  = " + role + System.lineSeparator() +
            '}';
    }
}