package org.ws13.cara.dojo.calisthenics.functional.tennis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;
import static java.util.Objects.requireNonNull;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.Player.PLAYER1;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.Player.PLAYER2;

/**
 * @author ctranxuan
 */
@DisplayName("TennisGame should")
class TennisGameShould {
    private static final class TestConsole implements TennisConsole {
        private final Iterator<String> pointWinnersSeries;
        private Player actualWinner;

        private TestConsole(List<String> aPointWinnersSeries) {
            pointWinnersSeries = requireNonNull(aPointWinnersSeries).iterator();
        }

        @Override
        public String askWhoWinsThePoint() {
            if (pointWinnersSeries.hasNext()) {
                return pointWinnersSeries.next();

            }
            return null;
        }

        @Override
        public void displayWinner(Player aWinner) {
            actualWinner = aWinner;
        }

        @Override
        public void displayPoints(Score aScore) {
        }

        public Player actualWinner() {
            return actualWinner;
        }
    }

    @ParameterizedTest(name = "game is {0}")
    @MethodSource("player1Wins")
    @DisplayName("return PLAYER1 when player1 wins the match")
    void return_PLAYER1_when_player1_wins_the_match(List<String> aPointsSeries) {
        TestConsole testConsole = new TestConsole(aPointsSeries);
        new TennisGame(testConsole).runGame();

        assertThat(testConsole.actualWinner()).isEqualTo(PLAYER1);
    }

    static Stream<Arguments> player1Wins() {
        return Stream.of(
            Arguments.of(List.of("P1", "P1", "P1", "P1")),
            Arguments.of(List.of("P1", "P2", "P1", "P1", "P1")),
            Arguments.of(List.of("P1", "P2", "P2", "P1", "P1", "P1"))
        );
    }

    @ParameterizedTest(name = "game is {0}")
    @MethodSource("player2Wins")
    @DisplayName("return PLAYER2 when player2 wins the match")
    void return_PLAYER2_when_player2_wins_the_match(List<String> aPointsSeries) {
        TestConsole testConsole = new TestConsole(aPointsSeries);
        new TennisGame(testConsole).runGame();

        assertThat(testConsole.actualWinner()).isEqualTo(PLAYER2);
    }

    static Stream<Arguments> player2Wins() {
        return Stream.of(
                Arguments.of(List.of("P2", "P2", "P2", "P2")),
                Arguments.of(List.of("P2", "P2", "P1", "P2", "P2")),
                Arguments.of(List.of("P1", "P2", "P2", "P2", "P1", "P2")),
                Arguments.of(List.of("P1", "P2", "P1", "P2", "P1", "P2", "P1", "P2", "P2", "P2"))
        );
    }

}