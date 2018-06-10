export type ScoreAndBallWinner = { score: Score, ballWinner: string };
export type Score = [number, number]
type ScoreWithFormatting = { score: Score, formattedScore: string }

export const p1 = "p1";
export const p2 = "p2";
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

export function isGameFinished([p1Points, p2Points]: Score): boolean {
    return (p1Points >= 4 || p2Points >= 4) && Math.abs(p1Points - p2Points) > 1
}

export function formatScore([p1Points, p2Points]: Score) {


    if (p1Points === p2Points) {
        if (p1Points >= 3) {
            return 'Deuce';
        } else {
            return getPointScore(p1Points) + "-" + "All"
        }
    } else if (p1Points <= 3 && p2Points <= 3) {
        return getPointScore(p1Points) + "-" + getPointScore(p2Points)
    } else {
        const getLeader = p1 => p2 => p1 >= p2 ? "player1" : "player2";
        const typeOfResult = p1 => p2 => Math.abs(p1 - p2) > 1 ? "Win for " : "Advantage ";
        return typeOfResult(p1Points)(p2Points) + getLeader(p1Points)(p2Points)
    }
}

function nextScore([p1Points, p2Points]: Score): (ballWinner: any) => Score {
    return ballWinner => {
        if (ballWinner === p1) {
            return [p1Points + 1, p2Points];
        } else if (ballWinner === p2) {
            return [p1Points, p2Points + 1];
        } else {
            return [p1Points, p2Points];
        }
    }
}
