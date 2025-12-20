package user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter //Idea предложила добавить геттер от Ломбок, ну я и не отказался
@AllArgsConstructor
public class User {
    private final String email;
    private final String password;
}