package Scaler.DesignPatterns.Flyweight.ChessUser;

import lombok.Getter;

@ExtrinsicState
@Getter
public class UserExtrinsicState {
    private Colour colour;

    private int currentGameStreak;
    private UserIntrinsicState user;
}