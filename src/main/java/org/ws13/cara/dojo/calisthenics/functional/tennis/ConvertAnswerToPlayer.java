package org.ws13.cara.dojo.calisthenics.functional.tennis;

import java.util.function.Function;

import static java.util.Objects.requireNonNull;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.Player.PLAYER1;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.Player.PLAYER2;

/**
 * @author ctranxuan
 */
final class ConvertAnswerToPlayer implements Function<String, Player> {

    static ConvertAnswerToPlayer convertAnswerToPlayer() {
        return new ConvertAnswerToPlayer();
    }

    @Override
    public Player apply(String aAnswer) {
        requireNonNull(aAnswer);
        switch (aAnswer.toUpperCase()) {
            case "P1":
                return PLAYER1;
            case "1":
                return PLAYER1;
            case "P2":
                return PLAYER2;
            case "2":
                return PLAYER2;
            default:
                throw new IllegalArgumentException("unsupported answer: " +  aAnswer);

        }
    }
}
