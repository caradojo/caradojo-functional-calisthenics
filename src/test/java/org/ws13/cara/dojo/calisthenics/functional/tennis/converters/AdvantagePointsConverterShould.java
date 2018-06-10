package org.ws13.cara.dojo.calisthenics.functional.tennis.converters;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assume;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.ws13.cara.dojo.calisthenics.functional.tennis.Score;

import java.util.Optional;

import static com.google.common.truth.Truth8.assertThat;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.converters.AdvantagePointsConverter.ADVANTAGE_IN;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.converters.AdvantagePointsConverter.ADVANTAGE_OUT;

/**
 * @author ctranxuan
 */
@RunWith(JUnitQuickcheck.class)
public class AdvantagePointsConverterShould {

    private final AdvantagePointsConverter advantagePointsConverter = new AdvantagePointsConverter();
    private DeucePointsConverterShould deucePointsConverterShould;

    @Property
    @DisplayName("return ADVANTAGE IN if player1Point is 1 point greater than player2Point")
    public void return_ADVANTAGE_IN(@InRange(min="3",max="2147483646") int aPoint) {
        Score score = new Score(aPoint + 1, aPoint);
        Optional<String> conversion = advantagePointsConverter.apply(score);

        assertThat(conversion).hasValue(ADVANTAGE_IN);
    }

    @Property
    @DisplayName("return ADVANTAGE OUT if player2Point is 1 point greater than player1Point")
    public void return_ADVANTAGE_OUT(@InRange(min="3",max="2147483646") int aPoint) {
        Score score = new Score(aPoint, aPoint + 1);
        Optional<String> conversion = advantagePointsConverter.apply(score);

        assertThat(conversion).hasValue(ADVANTAGE_OUT);
    }

    @Property
    @DisplayName("return nothing if player points have not a difference of 1")
    public void return_nothing(@InRange(min="0",max="2147483646") int aPoint1,
                               @InRange(min="0",max="2147483646") int aPoint2) {
        Assume.assumeTrue(Math.abs(aPoint1 - aPoint2) != 1);

        Score score = new Score(aPoint1, aPoint2);
        Optional<String> conversion = advantagePointsConverter.apply(score);

        assertThat(conversion).isEmpty();
    }
}


