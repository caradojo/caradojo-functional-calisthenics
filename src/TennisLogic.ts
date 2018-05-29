export type ScoreAndBallWinner = { score: Score, ballWinner: string };
export type Score = [number, number]
type ScoreWithFormatting = { score: Score, formattedScore: string }

export function nextScoreWithFormatting({score, ballWinner}: ScoreAndBallWinner): ScoreWithFormatting {
    let nextScoreValue = nextScore(score)(ballWinner); // violates no naming of values only functions
    return toScoreWithFormatting(nextScoreValue);
}

export function createInitialScore(): ScoreWithFormatting {
    let initialScore: Score = [0, 0]; // violates no naming of values only functions
    return {score: initialScore, formattedScore: formatScore(initialScore)};
}

function toScoreWithFormatting(score) {
    return {
        score: score,
        formattedScore: formatScore(score)
    };
}

function getPointScore(points: number) {
    return {0: "Love", 1: "Fifteen", 2: "Thirty", 3: "Forty"}[points];
}

export function formatScore([p1Points, p2Points]: Score) {
    return ""

}

function nextScore(score: Score): (ballWinner: any) => Score {
    // Fake todo implement
    return ballWinner => [score[0] + 1, score[1]]
}
