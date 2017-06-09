package pl.maciejprogramuje.mastermind; /**
 * Created by m.szymczyk on 2017-04-07.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.maciejprogramuje.mastermind.Controllers.BoardController;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {
    public static ResourceBundle bundles;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Locale.setDefault(new Locale("en"));
        bundles = ResourceBundle.getBundle("bundles.messages");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Board.fxml"));

        loader.setResources(bundles);

        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("css/stylesheet.css");
        primaryStage.setTitle(bundles.getString("application.title"));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("images/ikona.png"));
        primaryStage.show();
    }
}
