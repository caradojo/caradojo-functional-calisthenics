package org.ws13.cara.dojo.calisthenics.functional.tennis;

import java.util.function.Function;

import static java.util.Objects.requireNonNull;

/**
 * @author ctranxuan
 */
public enum Player {
    PLAYER1(score -> new Score(score.player1Points() + 1, score.player2Points())),
    PLAYER2(score -> new Score(score.player1Points(), score.player2Points() + 1));

    private final Function<Score, Score> computeScore;

    Player(Function<Score, Score> aScore) {
        computeScore = requireNonNull(aScore);
    }

    public Score winsThePoint(Score aScore) {
        requireNonNull(aScore);
        return computeScore.apply(aScore);
    };
}
