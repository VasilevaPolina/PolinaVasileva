package homeWorks.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public static User PITER_CHAILOVSKII = new User("epam", "1234", "PITER CHAILOVSKII");

    private String login;
    private String password;
    private String name;

}
