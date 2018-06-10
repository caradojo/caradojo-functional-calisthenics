package org.ws13.cara.dojo.calisthenics.functional.tennis.converters;

import org.ws13.cara.dojo.calisthenics.functional.tennis.Score;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * @author ctranxuan
 */
public final class DeucePointsConverter implements TennisPointsConverter {
    static final String DEUCE = "DEUCE";

    @Override
    public Optional<String> apply(Score aScore) {
        return Optional.ofNullable(aScore)
                       .filter(this::isDeuce)
                       .map(this::convertToString) ;
    }

    private boolean isDeuce(Score aScore) {
        requireNonNull(aScore);

        return aScore.player1Points() >= 3
                 && aScore.player2Points() >= 3
                 && aScore.player1Points() == aScore.player1Points();
    }

    private String convertToString(Score score) {
        return DEUCE;
    }
}
