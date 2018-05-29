package tennis;

public class ScoreBuilderNormal implements ScoreBuilder {
    @Override
    public boolean isAcceptable(Points points) {
        return true;
    }

    @Override
    public String getScore(Points points) {
        return getScorePlayer(points.pointsPlayer1) + " - " + getScorePlayer(points.pointsPlayer2);
    }

    private String getScorePlayer(int pointsPlayer) {
        return SCORE_FROM_POINTS[pointsPlayer];
    }

    private static final String[] SCORE_FROM_POINTS = { "LOVE", "FIFTEEN", "THIRTY", "FORTY" };
}
