package homeWorks.enums;

@Deprecated
public enum Users {
    /**
     * this class used in old SELENIUM homework block
     */
    PITER_CHAILOVSKII("PITER CHAILOVSKII", "epam", "1234");

    public String name;
    public String login;
    public String password;

    Users(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

}
