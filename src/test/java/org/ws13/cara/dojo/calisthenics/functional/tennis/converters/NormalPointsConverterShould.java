package org.ws13.cara.dojo.calisthenics.functional.tennis.converters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.ws13.cara.dojo.calisthenics.functional.tennis.Score;
import org.ws13.cara.dojo.calisthenics.functional.tennis.converters.NormalPointsConverter;

import java.util.Optional;

import static com.google.common.truth.Truth8.assertThat;

/**
 * @author ctranxuan
 */
@DisplayName("NormalPointsConverter should")
class NormalPointsConverterShould {
    private final NormalPointsConverter converter = new NormalPointsConverter();

    @ParameterizedTest(name = "score [{0}-{1}] is {2}")
    @CsvSource({
            "0, 0, LOVE-LOVE",
            "0, 1, LOVE-FIFTEEN",
            "0, 2, LOVE-THIRTY",
            "0, 3, LOVE-FORTY",
            "1, 0, FIFTEEN-LOVE",
            "1, 1, FIFTEEN-FIFTEEN",
            "1, 2, FIFTEEN-THIRTY",
            "1, 3, FIFTEEN-FORTY",
            "2, 0, THIRTY-LOVE",
            "2, 1, THIRTY-FIFTEEN",
            "2, 2, THIRTY-THIRTY",
            "2, 3, THIRTY-FORTY",
            "3, 0, FORTY-LOVE",
            "3, 1, FORTY-FIFTEEN",
            "3, 2, FORTY-THIRTY"
    })
    @DisplayName("return tennis points when the score is not deuce, advantage or win")
    void return_tennis_points_when_the_score_is_not_deuce_advantage_or_win(String aPoint1, String aPoint2, String aExpectedDisplay) {
        Score score = new Score(Integer.valueOf(aPoint1), Integer.valueOf(aPoint2));
        Optional<String> conversion = converter.apply(score);

        assertThat(conversion).hasValue(aExpectedDisplay);
    }

    @ParameterizedTest(name = "score is [{0}-{1}]")
    @CsvSource({
            "3, 3",
            "4, 4",
            "4, 5",
            "5, 4",
            "6, 4",
            "4, 6"
    })
    @DisplayName("return nothing when the score is deuce, advantage or win")
    void return_nothing_when_the_score_is_deuce_advantage_or_win(String aPoint1, String aPoint2) {
        // TODO refactor test with property-based checking
        Score score = new Score(Integer.valueOf(aPoint1), Integer.valueOf(aPoint2));
        Optional<String> conversion = converter.apply(score);

        assertThat(conversion).isEmpty();
    }
}