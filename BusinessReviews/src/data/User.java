package data;

public class User {
    private String login;
    private String psswrd;

    public User() {
    }

    public User(String login, String psswrd) {
        this.login = login;
        this.psswrd = psswrd;
    }

    public String getLogin() {
        return login;
    }

    public String getPsswrd() {
        return psswrd;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", psswrd='" + psswrd + '\'' +
                '}';
    }
}
