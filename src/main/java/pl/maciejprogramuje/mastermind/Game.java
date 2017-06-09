package pl.maciejprogramuje.mastermind;

import javafx.scene.paint.Paint;
import pl.maciejprogramuje.mastermind.BoardUtils.FullLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by m.szymczyk on 2017-04-07.
 */
public class Game {
    public static int turnNum = 1;
    List<Integer> trueColorCode = new ArrayList<>();
    List<Integer> yourColorCode = new ArrayList<>();
    List<Integer> hintsPins = new ArrayList<>();
    boolean success;

    public Game() {
        success = false;
        for (int i = 0; i < 4; i++) {
            trueColorCode.add(0);
            yourColorCode.add(0);
            hintsPins.add(0);
        }
    }

    public void generateCode() {
        trueColorCode.set(0, new Random().nextInt(6) + 1);

        do {
            trueColorCode.set(1, new Random().nextInt(6) + 1);
        } while (trueColorCode.get(1) == trueColorCode.get(0));

        do {
            trueColorCode.set(2, new Random().nextInt(6) + 1);
        } while (trueColorCode.get(2) == trueColorCode.get(0) || trueColorCode.get(2) == trueColorCode.get(1));

        do {
            trueColorCode.set(3, new Random().nextInt(6) + 1);
        }
        while (trueColorCode.get(3) == trueColorCode.get(0) || trueColorCode.get(3) == trueColorCode.get(1) || trueColorCode.get(3) == trueColorCode.get(2));

        //System.out.println("trueColorCode: " + trueColorCode);
    }

    public void checkCode(FullLine checkingLine) {
        yourColorCode.set(0, changeColorToNumber(checkingLine.getBig1().getFill()));
        yourColorCode.set(1, changeColorToNumber(checkingLine.getBig2().getFill()));
        yourColorCode.set(2, changeColorToNumber(checkingLine.getBig3().getFill()));
        yourColorCode.set(3, changeColorToNumber(checkingLine.getBig4().getFill()));

        setValueOfHintsPins(0);
        setValueOfHintsPins(1);
        setValueOfHintsPins(2);
        setValueOfHintsPins(3);

        Collections.sort(hintsPins);

        //System.out.println("yourColorCode: " + yourColorCode);
        //System.out.println("pins: " + hintsPins);

        if (trueColorCode.equals(yourColorCode)) {
            success = true;
        }
    }

    private int changeColorToNumber(Paint color) {
        if (color.equals(Paint.valueOf("WHITE"))) {
            return 1;
        } else if (color.equals(Paint.valueOf("DODGERBLUE"))) {
            return 2;
        } else if (color.equals(Paint.valueOf("YELLOW"))) {
            return 3;
        } else if (color.equals(Paint.valueOf("GREEN"))) {
            return 4;
        } else if (color.equals(Paint.valueOf("BLACK"))) {
            return 5;
        } else {
            return 6;
        }
    }

    private void setValueOfHintsPins(int pinNumber) {
        if (yourColorCode.get(pinNumber) == trueColorCode.get(pinNumber)) {
            hintsPins.set(pinNumber, 2);
        } else if (trueColorCode.contains(yourColorCode.get(pinNumber))) {
            hintsPins.set(pinNumber, 1);
        } else {
            hintsPins.set(pinNumber, 0);
        }
    }

    public String getColorOfHintsPins(int pinNumber) {
        if (hintsPins.get(pinNumber) == 1) {
            return "WHITE";
        } else if (hintsPins.get(pinNumber) == 2) {
            return "BLACK";
        }
        return "DARKGRAY";
    }

    public boolean isSuccess() {
        return success;
    }

    public List<Integer> getTrueColorCode() {
        return trueColorCode;
    }
}
