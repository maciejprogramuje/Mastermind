package pl.maciejprogramuje.mastermind;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m.szymczyk on 2017-04-10.
 */
public class MyAlertWindow extends Alert {
    public MyAlertWindow(Alert.AlertType confirmation, String contentText, String headerText, int width, int height) {
        super(confirmation);
        setTitle(Main.bundles.getString("application.title.with.fb"));
        setContentText(contentText);
        setHeaderText(headerText);
        setGraphic(new ImageView(new Image("/images/logo.png")));

        DialogPane dialogPane = getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/css/dial.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        dialogPane.setPrefWidth(width);
        dialogPane.setPrefHeight(height);

        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.getIcons().add(new Image("images/ikona.png"));
    }

    private String getColorFromNumber(int number) {
        switch(number) {
            case 1:
                return "WHITE";
            case 2:
                return "DODGERBLUE";
            case 3:
                return "YELLOW";
            case 4:
                return "GREEN";
            case 5:
                return "BLACK";
            case 6:
                return "RED";
        }
        return "DARKGRAY";
    }

    public MyAlertWindow(Alert.AlertType confirmation, String contentText, String headerText, String trueProperContentText, int width, int height, List<Integer> trueColorCode) {
        super(confirmation);
        setTitle(Main.bundles.getString("application.title.with.fb"));
        //setContentText(contentText);
        setHeaderText(headerText);
        setGraphic(new ImageView(new Image("/images/logo.png")));

        DialogPane dialogPane = getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/css/dial.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        dialogPane.setPrefWidth(width);
        dialogPane.setPrefHeight(height);

        Circle trueCircle1 = new Circle(15, Paint.valueOf(getColorFromNumber(1)));
        Circle trueCircle2 = new Circle(15, Paint.valueOf(getColorFromNumber(2)));
        Circle trueCircle3 = new Circle(15, Paint.valueOf(getColorFromNumber(3)));
        Circle trueCircle4 = new Circle(15, Paint.valueOf(getColorFromNumber(4)));
        HBox circlesHBox = new HBox(trueCircle1, trueCircle2, trueCircle3, trueCircle4);
        circlesHBox.setSpacing(5);
        circlesHBox.setPadding(new Insets(20, 62, 20, 62));
        Label trueContentTextLabel = new Label(contentText);
        trueContentTextLabel.setWrapText(true);
        Label trueProperContentTextLabel = new Label(trueProperContentText);
        trueProperContentTextLabel.setWrapText(true);
        VBox trueVBox = new VBox(trueContentTextLabel, trueProperContentTextLabel, circlesHBox);
        dialogPane.setContent(trueVBox);

        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.getIcons().add(new Image("images/ikona.png"));
    }
}
