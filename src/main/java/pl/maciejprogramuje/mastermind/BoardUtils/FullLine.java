package pl.maciejprogramuje.mastermind.BoardUtils;

import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * Created by m.szymczyk on 2017-04-07.
 */
public class FullLine {
    Text number;
    Circle big1, big2, big3, big4, small1, small2, small3, small4;

    public FullLine(Text number, Circle big1, Circle big2, Circle big3, Circle big4, Circle small1, Circle small2, Circle small3, Circle small4) {
        this.number = number;
        this.big1 = big1;
        this.big2 = big2;
        this.big3 = big3;
        this.big4 = big4;
        this.small1 = small1;
        this.small2 = small2;
        this.small3 = small3;
        this.small4 = small4;
    }

    public Text getNumber() {
        return number;
    }

    public Circle getBig1() {
        return big1;
    }

    public Circle getBig2() {
        return big2;
    }

    public Circle getBig3() {
        return big3;
    }

    public Circle getBig4() {
        return big4;
    }

    public Circle getSmall1() {
        return small1;
    }

    public Circle getSmall2() {
        return small2;
    }

    public Circle getSmall3() {
        return small3;
    }

    public Circle getSmall4() {
        return small4;
    }
}
