package org.ws13.cara.dojo.calisthenics.functional.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.Player.PLAYER1;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.Player.PLAYER2;

/**
 * @author ctranxuan
 */
@DisplayName("ConvertAnswerToPlayer should")
class ConvertAnswerToPlayerShould {
    private ConvertAnswerToPlayer convertAnswerToPlayer = new ConvertAnswerToPlayer();

    @Test
    @DisplayName("return PLAYER1 when P1 is given")
    void return_PLAYER1_for_P1() {
        Player player = convertAnswerToPlayer.apply("P1");

        assertThat(player).isEqualTo(PLAYER1);
    }

    @Test
    @DisplayName("return PLAYER2 when P2 is given")
    void return_PLAYER2_for_P2() {
        Player player = convertAnswerToPlayer.apply("P2");

        assertThat(player).isEqualTo(PLAYER2);
    }

    @Test
    @DisplayName("throw an Exception when neither P1 or P2 is given")
    void throw_an_Exception_if_argument_is_not_P1_nor_P2() {
        Assertions.assertThrows(RuntimeException.class, () -> convertAnswerToPlayer.apply("toto"));
    }
}