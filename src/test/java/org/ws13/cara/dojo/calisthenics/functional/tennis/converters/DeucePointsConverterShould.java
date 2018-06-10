package org.ws13.cara.dojo.calisthenics.functional.tennis.converters;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.ws13.cara.dojo.calisthenics.functional.tennis.Score;
import org.ws13.cara.dojo.calisthenics.functional.tennis.converters.DeucePointsConverter;

import java.util.Optional;

import static com.google.common.truth.Truth8.assertThat;

/**
 * @author ctranxuan
 */
@RunWith(JUnitQuickcheck.class)
public class DeucePointsConverterShould {
    private final DeucePointsConverter converter = new DeucePointsConverter();

    @Property
    @DisplayName("return DEUCE when points are equal and greater than 3")
    public void return_DEUCE_when_points_are_equal_and_greater_than_3(
            @InRange(min = "3") int aPoint) {
        Score score = new Score(aPoint, aPoint);
        Optional<String> conversion = converter.apply(score);

        assertThat(conversion).hasValue("DEUCE");
    }

    @Property
    @DisplayName("return nothing when points are less than 3")
    public void return_nothing_when_points_are_less_than_3(
            @InRange(min = "0", max="2") int aPoint) {
        Score score = new Score(aPoint, aPoint);
        Optional<String> conversion = converter.apply(score);

        assertThat(conversion).isEmpty();
    }
}