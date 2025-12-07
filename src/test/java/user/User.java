package user;

import lombok.Getter;

@Getter //Idea предложила добавить геттер от Ломбок, ну я и не отказался
public class User {
    private final String email;
    private final String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}