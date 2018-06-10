package org.ws13.cara.dojo.calisthenics.functional.tennis.converters;

import org.ws13.cara.dojo.calisthenics.functional.tennis.Score;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * @author ctranxuan
 */
public final class NormalPointsConverter implements TennisPointsConverter {
    private static final String[] SCORE_FROM_POINTS = {"LOVE", "FIFTEEN", "THIRTY", "FORTY"};

    @Override
    public Optional<String> apply(Score aScore) {
        return Optional.ofNullable(aScore)
                .filter(this::isNormalScore)
                .map(this::convertToTennisPoints);
    }

    private boolean isNormalScore(Score aScore) {
        requireNonNull(aScore);

        return aScore.player1Points() <= 3
                && aScore.player2Points() <=3
                && !(aScore.player1Points() == 3 && aScore.player1Points() == aScore.player2Points());
    }

    private String convertToTennisPoints(Score aScore) {
        requireNonNull(aScore);
        return SCORE_FROM_POINTS[aScore.player1Points()] + "-" + SCORE_FROM_POINTS[aScore.player2Points()];
    }
}
