package org.ws13.cara.dojo.calisthenics.functional.tennis;

import java.util.function.Function;

/**
 * @author ctranxuan
 */
final class AskWhoWinsThePoint implements Function<TennisConsole, String> {

    static AskWhoWinsThePoint askWhoWinsThePoint() {
        return new AskWhoWinsThePoint();
    }

    @Override
    public String apply(TennisConsole aConsole) {
        return aConsole.askWhoWinsThePoint();
    }
}
