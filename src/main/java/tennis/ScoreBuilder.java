package tennis;

public interface ScoreBuilder {
    boolean isAcceptable(Points points);

    String getScore(Points points);
}
