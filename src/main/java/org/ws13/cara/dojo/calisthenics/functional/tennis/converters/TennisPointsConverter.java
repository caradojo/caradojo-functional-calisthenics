package org.ws13.cara.dojo.calisthenics.functional.tennis.converters;

import org.ws13.cara.dojo.calisthenics.functional.tennis.Score;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author ctranxuan
 */
@FunctionalInterface
public interface TennisPointsConverter extends Function<Score, Optional<String>>{
}
