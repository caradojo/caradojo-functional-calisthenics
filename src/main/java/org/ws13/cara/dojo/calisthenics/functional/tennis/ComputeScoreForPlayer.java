package org.ws13.cara.dojo.calisthenics.functional.tennis;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author ctranxuan
 */
final class ComputeScoreForPlayer implements Function<Player, UnaryOperator<Score>> {

    static ComputeScoreForPlayer computeScoreForPlayer() {
        return new ComputeScoreForPlayer();
    }

    @Override
    public UnaryOperator<Score> apply(Player aPlayer) {
        return aPlayer::winsThePoint;
    }
}
