package org.ws13.cara.dojo.calisthenics.functional.tennis;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

/**
 * @author ctranxuan
 */
final class HasAWinner implements Predicate<Score> {

    static Predicate<Score> hasAWinner() {
        return new HasAWinner();
    }

    @Override
    public boolean test(Score aScore) {
        requireNonNull(aScore);

        return (aScore.player1Points() > 3
                || aScore.player2Points() > 3)
                && Math.abs(aScore.player1Points() - aScore.player2Points()) > 1;
    }

}
