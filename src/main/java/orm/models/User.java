package orm.models;

import lombok.*;

import javax.persistence.*;

/**
 * This class represents user-model.
 * @author Svyatoslav Sabirov.
 * @since 16.11.2018
 * @version 7.
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "users")
@NamedQuery(name = "User.getAll", query = "SELECT u from User u")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_ID")
    private long id;

    @Column(name = "first_name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private int age;

    public User(final String firstName, final String secondName, final int ageInYears) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
