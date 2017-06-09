package pl.maciejprogramuje.mastermind.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.maciejprogramuje.mastermind.BoardUtils.FullLine;
import pl.maciejprogramuje.mastermind.Game;
import pl.maciejprogramuje.mastermind.Main;
import pl.maciejprogramuje.mastermind.MyAlertWindow;

import java.util.Map;
import java.util.Optional;

/**
 * Created by m.szymczyk on 2017-04-07.
 */
public class BoardController {
    FullLine fullLine1, fullLine2, fullLine3, fullLine4, fullLine5, fullLine6, fullLine7, fullLine8, fullLine9, fullLine10;
    Map<Integer, FullLine> linesMap = FXCollections.observableHashMap();
    Game game;

    @FXML
    public void initialize() {
        buildLines();
        addListenersToBigCircles();
        prepareGame();
        checkButton.setOnAction(event -> {
            if (noEmptyBigCircles()) {
                blockLine(Game.turnNum);
                game.checkCode(linesMap.get(Game.turnNum));
                setColorsOfHintsPins(game);

                if (game.isSuccess()) {
                    Alert successAlert = new MyAlertWindow(
                            Alert.AlertType.INFORMATION,
                            Main.bundles.getString("success.alert.content"),
                            Main.bundles.getString("success.alert.congratulations"),
                            280,
                            250);
                    successAlert.showAndWait();
                    prepareGame();
                } else if (Game.turnNum < 10) {
                    Game.turnNum++;
                    unblockLine(Game.turnNum);
                } else {
                    Alert faulAlert = new MyAlertWindow(
                            Alert.AlertType.INFORMATION,
                            Main.bundles.getString("faul.alert.faul"),
                            Main.bundles.getString("faul.alert.content"),
                            Main.bundles.getString("faul.alert.proper.code"),
                            280,
                            250,
                            game.getTrueColorCode());
                    faulAlert.showAndWait();
                    prepareGame();
                }
            }
        });
    }

    private void prepareGame() {
        Alert startAlert = new MyAlertWindow(Alert.AlertType.CONFIRMATION,
                (Main.bundles.getString("start.alert.content1") + "\n\n\n"
                        + Main.bundles.getString("start.alert.content2") + "\n"
                        + Main.bundles.getString("start.alert.content3") + "\n"
                        + Main.bundles.getString("start.alert.content4") + "\n"
                        + Main.bundles.getString("start.alert.content5")),
                Main.bundles.getString("start.alert.header"),
                280,
                550);
        Optional<ButtonType> result = startAlert.showAndWait();
        if (result.get() == ButtonType.OK) {
            setColorOfBigAndSmallCircles();
            Game.turnNum = 1;
            game = new Game();
            game.generateCode();
            unblockLine(Game.turnNum);
        } else {
            System.exit(0);
        }
    }

    private void setColorOfBigAndSmallCircles() {
        big1_1.setFill(Paint.valueOf("DARKGREY"));
        big1_2.setFill(Paint.valueOf("DARKGREY"));
        big1_3.setFill(Paint.valueOf("DARKGREY"));
        big1_4.setFill(Paint.valueOf("DARKGREY"));

        big2_1.setFill(Paint.valueOf("DARKGREY"));
        big2_2.setFill(Paint.valueOf("DARKGREY"));
        big2_3.setFill(Paint.valueOf("DARKGREY"));
        big2_4.setFill(Paint.valueOf("DARKGREY"));

        big3_1.setFill(Paint.valueOf("DARKGREY"));
        big3_2.setFill(Paint.valueOf("DARKGREY"));
        big3_3.setFill(Paint.valueOf("DARKGREY"));
        big3_4.setFill(Paint.valueOf("DARKGREY"));

        big4_1.setFill(Paint.valueOf("DARKGREY"));
        big4_2.setFill(Paint.valueOf("DARKGREY"));
        big4_3.setFill(Paint.valueOf("DARKGREY"));
        big4_4.setFill(Paint.valueOf("DARKGREY"));

        big5_1.setFill(Paint.valueOf("DARKGREY"));
        big5_2.setFill(Paint.valueOf("DARKGREY"));
        big5_3.setFill(Paint.valueOf("DARKGREY"));
        big5_4.setFill(Paint.valueOf("DARKGREY"));

        big6_1.setFill(Paint.valueOf("DARKGREY"));
        big6_2.setFill(Paint.valueOf("DARKGREY"));
        big6_3.setFill(Paint.valueOf("DARKGREY"));
        big6_4.setFill(Paint.valueOf("DARKGREY"));

        big7_1.setFill(Paint.valueOf("DARKGREY"));
        big7_2.setFill(Paint.valueOf("DARKGREY"));
        big7_3.setFill(Paint.valueOf("DARKGREY"));
        big7_4.setFill(Paint.valueOf("DARKGREY"));

        big8_1.setFill(Paint.valueOf("DARKGREY"));
        big8_2.setFill(Paint.valueOf("DARKGREY"));
        big8_3.setFill(Paint.valueOf("DARKGREY"));
        big8_4.setFill(Paint.valueOf("DARKGREY"));

        big9_1.setFill(Paint.valueOf("DARKGREY"));
        big9_2.setFill(Paint.valueOf("DARKGREY"));
        big9_3.setFill(Paint.valueOf("DARKGREY"));
        big9_4.setFill(Paint.valueOf("DARKGREY"));

        big10_1.setFill(Paint.valueOf("DARKGREY"));
        big10_2.setFill(Paint.valueOf("DARKGREY"));
        big10_3.setFill(Paint.valueOf("DARKGREY"));
        big10_4.setFill(Paint.valueOf("DARKGREY"));

        small1_1.setFill(Paint.valueOf("DARKGREY"));
        small1_2.setFill(Paint.valueOf("DARKGREY"));
        small1_3.setFill(Paint.valueOf("DARKGREY"));
        small1_4.setFill(Paint.valueOf("DARKGREY"));

        small2_1.setFill(Paint.valueOf("DARKGREY"));
        small2_2.setFill(Paint.valueOf("DARKGREY"));
        small2_3.setFill(Paint.valueOf("DARKGREY"));
        small2_4.setFill(Paint.valueOf("DARKGREY"));

        small3_1.setFill(Paint.valueOf("DARKGREY"));
        small3_2.setFill(Paint.valueOf("DARKGREY"));
        small3_3.setFill(Paint.valueOf("DARKGREY"));
        small3_4.setFill(Paint.valueOf("DARKGREY"));

        small4_1.setFill(Paint.valueOf("DARKGREY"));
        small4_2.setFill(Paint.valueOf("DARKGREY"));
        small4_3.setFill(Paint.valueOf("DARKGREY"));
        small4_4.setFill(Paint.valueOf("DARKGREY"));

        small5_1.setFill(Paint.valueOf("DARKGREY"));
        small5_2.setFill(Paint.valueOf("DARKGREY"));
        small5_3.setFill(Paint.valueOf("DARKGREY"));
        small5_4.setFill(Paint.valueOf("DARKGREY"));

        small6_1.setFill(Paint.valueOf("DARKGREY"));
        small6_2.setFill(Paint.valueOf("DARKGREY"));
        small6_3.setFill(Paint.valueOf("DARKGREY"));
        small6_4.setFill(Paint.valueOf("DARKGREY"));

        small7_1.setFill(Paint.valueOf("DARKGREY"));
        small7_2.setFill(Paint.valueOf("DARKGREY"));
        small7_3.setFill(Paint.valueOf("DARKGREY"));
        small7_4.setFill(Paint.valueOf("DARKGREY"));

        small8_1.setFill(Paint.valueOf("DARKGREY"));
        small8_2.setFill(Paint.valueOf("DARKGREY"));
        small8_3.setFill(Paint.valueOf("DARKGREY"));
        small8_4.setFill(Paint.valueOf("DARKGREY"));

        small9_1.setFill(Paint.valueOf("DARKGREY"));
        small9_2.setFill(Paint.valueOf("DARKGREY"));
        small9_3.setFill(Paint.valueOf("DARKGREY"));
        small9_4.setFill(Paint.valueOf("DARKGREY"));

        small10_1.setFill(Paint.valueOf("DARKGREY"));
        small10_2.setFill(Paint.valueOf("DARKGREY"));
        small10_3.setFill(Paint.valueOf("DARKGREY"));
        small10_4.setFill(Paint.valueOf("DARKGREY"));
    }

    private void setColorsOfHintsPins(Game game) {
        linesMap.get(Game.turnNum).getSmall1().setFill(Paint.valueOf(game.getColorOfHintsPins(0)));
        linesMap.get(Game.turnNum).getSmall2().setFill(Paint.valueOf(game.getColorOfHintsPins(1)));
        linesMap.get(Game.turnNum).getSmall3().setFill(Paint.valueOf(game.getColorOfHintsPins(2)));
        linesMap.get(Game.turnNum).getSmall4().setFill(Paint.valueOf(game.getColorOfHintsPins(3)));
    }

    private boolean noEmptyBigCircles() {
        return linesMap.get(Game.turnNum).getBig1().getFill() != Paint.valueOf("DARKGRAY")
                && linesMap.get(Game.turnNum).getBig2().getFill() != Paint.valueOf("DARKGRAY")
                && linesMap.get(Game.turnNum).getBig3().getFill() != Paint.valueOf("DARKGRAY")
                && linesMap.get(Game.turnNum).getBig4().getFill() != Paint.valueOf("DARKGRAY");
    }

    private void blockLine(int turn) {
        FullLine tempLine = linesMap.get(turn);
        tempLine.getNumber().fillProperty().setValue(Paint.valueOf("BLACK"));

        tempLine.getBig1().setDisable(true);
        tempLine.getBig2().setDisable(true);
        tempLine.getBig3().setDisable(true);
        tempLine.getBig4().setDisable(true);
    }

    private void unblockLine(int turn) {
        FullLine tempLine = linesMap.get(turn);
        tempLine.getNumber().fillProperty().setValue(Paint.valueOf("RED"));

        tempLine.getBig1().setDisable(false);
        tempLine.getBig2().setDisable(false);
        tempLine.getBig3().setDisable(false);
        tempLine.getBig4().setDisable(false);
    }

    private void addListenersToBigCircles() {
        clickOnBigCircle(big1_1);
        clickOnBigCircle(big1_2);
        clickOnBigCircle(big1_3);
        clickOnBigCircle(big1_4);
        clickOnBigCircle(big2_1);
        clickOnBigCircle(big2_2);
        clickOnBigCircle(big2_3);
        clickOnBigCircle(big2_4);
        clickOnBigCircle(big3_1);
        clickOnBigCircle(big3_2);
        clickOnBigCircle(big3_3);
        clickOnBigCircle(big3_4);
        clickOnBigCircle(big4_1);
        clickOnBigCircle(big4_2);
        clickOnBigCircle(big4_3);
        clickOnBigCircle(big4_4);
        clickOnBigCircle(big5_1);
        clickOnBigCircle(big5_2);
        clickOnBigCircle(big5_3);
        clickOnBigCircle(big5_4);
        clickOnBigCircle(big6_1);
        clickOnBigCircle(big6_2);
        clickOnBigCircle(big6_3);
        clickOnBigCircle(big6_4);
        clickOnBigCircle(big7_1);
        clickOnBigCircle(big7_2);
        clickOnBigCircle(big7_3);
        clickOnBigCircle(big7_4);
        clickOnBigCircle(big8_1);
        clickOnBigCircle(big8_2);
        clickOnBigCircle(big8_3);
        clickOnBigCircle(big8_4);
        clickOnBigCircle(big9_1);
        clickOnBigCircle(big9_2);
        clickOnBigCircle(big9_3);
        clickOnBigCircle(big9_4);
        clickOnBigCircle(big10_1);
        clickOnBigCircle(big10_2);
        clickOnBigCircle(big10_3);
        clickOnBigCircle(big10_4);
    }

    private void clickOnBigCircle(Circle big) {
        big.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            if (big.getFill().equals(Paint.valueOf("DARKGRAY"))) {
                big.setFill(Paint.valueOf("WHITE"));
            } else if (big.getFill().equals(Paint.valueOf("WHITE"))) {
                big.setFill(Paint.valueOf("DODGERBLUE"));
            } else if (big.getFill().equals(Paint.valueOf("DODGERBLUE"))) {
                big.setFill(Paint.valueOf("YELLOW"));
            } else if (big.getFill().equals(Paint.valueOf("YELLOW"))) {
                big.setFill(Paint.valueOf("GREEN"));
            } else if (big.getFill().equals(Paint.valueOf("GREEN"))) {
                big.setFill(Paint.valueOf("BLACK"));
            } else if (big.getFill().equals(Paint.valueOf("BLACK"))) {
                big.setFill(Paint.valueOf("RED"));
            } else if (big.getFill().equals(Paint.valueOf("RED"))) {
                big.setFill(Paint.valueOf("WHITE"));
            }
        });
    }

    private void buildLines() {
        fullLine1 = new FullLine(line1, big1_1, big1_2, big1_3, big1_4, small1_1, small1_2, small1_3, small1_4);
        fullLine2 = new FullLine(line2, big2_1, big2_2, big2_3, big2_4, small2_1, small2_2, small2_3, small2_4);
        fullLine3 = new FullLine(line3, big3_1, big3_2, big3_3, big3_4, small3_1, small3_2, small3_3, small3_4);
        fullLine4 = new FullLine(line4, big4_1, big4_2, big4_3, big4_4, small4_1, small4_2, small4_3, small4_4);
        fullLine5 = new FullLine(line5, big5_1, big5_2, big5_3, big5_4, small5_1, small5_2, small5_3, small5_4);
        fullLine6 = new FullLine(line6, big6_1, big6_2, big6_3, big6_4, small6_1, small6_2, small6_3, small6_4);
        fullLine7 = new FullLine(line7, big7_1, big7_2, big7_3, big7_4, small7_1, small7_2, small7_3, small7_4);
        fullLine8 = new FullLine(line8, big8_1, big8_2, big8_3, big8_4, small8_1, small8_2, small8_3, small8_4);
        fullLine9 = new FullLine(line9, big9_1, big9_2, big9_3, big9_4, small9_1, small9_2, small9_3, small9_4);
        fullLine10 = new FullLine(line10, big10_1, big10_2, big10_3, big10_4, small10_1, small10_2, small10_3, small10_4);

        linesMap.put(1, fullLine1);
        linesMap.put(2, fullLine2);
        linesMap.put(3, fullLine3);
        linesMap.put(4, fullLine4);
        linesMap.put(5, fullLine5);
        linesMap.put(6, fullLine6);
        linesMap.put(7, fullLine7);
        linesMap.put(8, fullLine8);
        linesMap.put(9, fullLine9);
        linesMap.put(10, fullLine10);
    }

    @FXML
    private Button checkButton;

    @FXML
    private Text line1;

    @FXML
    private Text line2;

    @FXML
    private Text line3;

    @FXML
    private Text line4;

    @FXML
    private Text line5;

    @FXML
    private Text line6;

    @FXML
    private Text line7;

    @FXML
    private Text line8;

    @FXML
    private Text line9;

    @FXML
    private Text line10;

    @FXML
    private Circle big10_2;

    @FXML
    private Circle big10_3;

    @FXML
    private Circle big10_1;

    @FXML
    private Circle big10_4;

    @FXML
    private Circle big1_1;

    @FXML
    private Circle big3_2;

    @FXML
    private Circle big1_4;

    @FXML
    private Circle big5_1;

    @FXML
    private Circle big3_3;

    @FXML
    private Circle big1_2;

    @FXML
    private Circle big3_1;

    @FXML
    private Circle big1_3;

    @FXML
    private Circle big7_2;

    @FXML
    private Circle big5_4;

    @FXML
    private Circle small5_1;

    @FXML
    private Circle small3_3;

    @FXML
    private Circle big9_1;

    @FXML
    private Circle big7_3;

    @FXML
    private Circle small5_2;

    @FXML
    private Circle small3_4;

    @FXML
    private Circle small7_1;

    @FXML
    private Circle big5_2;

    @FXML
    private Circle small5_3;

    @FXML
    private Circle big3_4;

    @FXML
    private Circle big7_1;

    @FXML
    private Circle small7_2;

    @FXML
    private Circle big5_3;

    @FXML
    private Circle small5_4;

    @FXML
    private Circle big9_4;

    @FXML
    private Circle small9_1;

    @FXML
    private Circle small7_3;

    @FXML
    private Circle small9_2;

    @FXML
    private Circle small7_4;

    @FXML
    private Circle big9_2;

    @FXML
    private Circle small9_3;

    @FXML
    private Circle big7_4;

    @FXML
    private Circle big9_3;

    @FXML
    private Circle small9_4;

    @FXML
    private Circle small2_1;

    @FXML
    private Circle small2_2;

    @FXML
    private Circle small4_1;

    @FXML
    private Circle small2_3;

    @FXML
    private Circle small10_3;

    @FXML
    private Circle small10_4;

    @FXML
    private Circle small10_1;

    @FXML
    private Circle small10_2;

    @FXML
    private Circle big4_1;

    @FXML
    private Circle big2_3;

    @FXML
    private Circle big4_2;

    @FXML
    private Circle big2_4;

    @FXML
    private Circle big2_1;

    @FXML
    private Circle big2_2;

    @FXML
    private Circle big8_1;

    @FXML
    private Circle big6_3;

    @FXML
    private Circle small4_2;

    @FXML
    private Circle small2_4;

    @FXML
    private Circle big8_2;

    @FXML
    private Circle big6_4;

    @FXML
    private Circle small6_1;

    @FXML
    private Circle small4_3;

    @FXML
    private Circle big6_1;

    @FXML
    private Circle small6_2;

    @FXML
    private Circle big4_3;

    @FXML
    private Circle small4_4;

    @FXML
    private Circle small8_1;

    @FXML
    private Circle big6_2;

    @FXML
    private Circle small6_3;

    @FXML
    private Circle big4_4;

    @FXML
    private Circle small8_2;

    @FXML
    private Circle small6_4;

    @FXML
    private Circle small8_3;

    @FXML
    private Circle big8_3;

    @FXML
    private Circle small8_4;

    @FXML
    private Circle big8_4;

    @FXML
    private Circle small1_1;

    @FXML
    private Circle small1_2;

    @FXML
    private Circle small3_1;

    @FXML
    private Circle small1_3;

    @FXML
    private Circle small3_2;

    @FXML
    private Circle small1_4;
}