package org.ws13.cara.dojo.calisthenics.functional.tennis;

import java.util.function.Function;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.Player.PLAYER1;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.Player.PLAYER2;

/**
 * @author ctranxuan
 */
public final class FindWinner implements Function<Score, Player> {
    private final HasAWinner hasAWinner = new HasAWinner();

    static FindWinner findWinner() {
        return new FindWinner();
    }

    @Override
    public Player apply(Score aScore) {
        requireNonNull(aScore);
        checkArgument(hasAWinner.test(aScore), "there is no winner with a such score %s", aScore);

        if (aScore.player1Points() > aScore.player2Points()) {
            return PLAYER1;

        } else {
            return PLAYER2;

        }
    }
}
