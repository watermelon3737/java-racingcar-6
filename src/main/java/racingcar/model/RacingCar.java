package racingcar.model;

import racingcar.view.GameMessage;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private String racingCarName;
    private List<Boolean> racingCarMove;
    private int moveCount;

    public RacingCar(final String racingCarName) {
        this.racingCarName = racingCarName;
        this.racingCarMove= new ArrayList<>();
        this.moveCount = 0;
    }

    public void isRacingCarMove(final int randomNumber) {
        if (randomNumber > 3) {
            this.racingCarMove.add(true);
            moveCount += 1;
        }
    }

    public String makeGameResult() {
        if (this.racingCarMove.isEmpty()) {
            return "";
        }
        String gameResult = "";
        for (int i = 0; i < this.racingCarMove.size(); i++) {
            if (this.racingCarMove.get(i).equals(true)) {
                gameResult += GameMessage.MOVE.getMoveMessage();
            }
        }
        return gameResult;
    }

    public String getRacingCarName() {
        return this.racingCarName;
    }

    public List<Boolean> getRacingCarMove() {
        return this.racingCarMove;
    }

    public int getMoveCount() {
        return this.moveCount;
    }
    @Override
    public String toString() {
        String gameResult = makeGameResult();

        return this.racingCarName + " : " + gameResult;
    }
}
