package org.ws13.cara.dojo.calisthenics.functional.tennis.converters;

import org.ws13.cara.dojo.calisthenics.functional.tennis.Score;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * @author ctranxuan
 */
public final class AdvantagePointsConverter implements TennisPointsConverter {
    static final String ADVANTAGE_IN = "ADVANTAGE IN";
    static final String ADVANTAGE_OUT = "ADVANTAGE OUT";

    @Override
    public Optional<String> apply(Score aScore) {
        return Optional.ofNullable(aScore)
                       .filter(this::hasAdvantage)
                       .map(AdvantagePointsConverter::convertToString);
    }

    private static String convertToString(Score aScore) {
        requireNonNull(aScore);

        if (aScore.player1Points() > aScore.player2Points()) {
            return ADVANTAGE_IN;

        } else {
            return ADVANTAGE_OUT;

        }
    }

    private boolean hasAdvantage(Score score) {
        return score.player1Points() >= 3
                && score.player2Points() >= 3
                && Math.abs(score.player1Points() - score.player2Points()) == 1;
    }
}
