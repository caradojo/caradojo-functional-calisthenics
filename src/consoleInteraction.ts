import {Observable} from "rxjs/Observable";
import {map, tap, filter} from 'rxjs/operators'
import {Subject} from "rxjs/Subject";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';

import * as readline from 'readline';
import {
    createInitialScore, isGameFinished,
    nextScoreWithFormatting,
    ScoreAndBallWinner,
    Score,
} from "./TennisLogic";

function setupInteractionLoop() {
    function askForNextBallWinner(score: Score) {
        ifc.question('Winner of next ball? "p1" or "p2"? ', ballWinner => {
            if (ballWinner !== 'p2' && ballWinner !== 'p1') {
                ifc.write('invalid player\n')
            }
            inputReceiver.next({score, ballWinner});
        });
    }

    function displayAndAskForWinner({score, formattedScore}) {
        ifc.write('Score: ' + formattedScore + "\n\n");
        if (isGameFinished(score)) {
            inputReceiver.complete();
        } else {
            askForNextBallWinner(score);
        }
    }

    const ifc = readline.createInterface(process.stdin, process.stdout)
    const inputReceiver: Subject<ScoreAndBallWinner> = new Subject();
    inputReceiver
        .pipe(
            map(nextScoreWithFormatting),
            tap(displayAndAskForWinner),
        )
        .subscribe({complete: () => process.exit()});
    return displayAndAskForWinner;
}


const displayAndAskForBallWinner = setupInteractionLoop();
let initialScore = createInitialScore();
displayAndAskForBallWinner(initialScore)

