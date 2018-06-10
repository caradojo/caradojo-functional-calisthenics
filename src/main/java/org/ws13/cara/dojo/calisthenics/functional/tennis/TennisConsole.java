package org.ws13.cara.dojo.calisthenics.functional.tennis;

/**
 * @author ctranxuan
 */
public interface TennisConsole {
    String askWhoWinsThePoint();

    void displayWinner(Player aWinner);

    void displayPoints(Score aScore);
}
