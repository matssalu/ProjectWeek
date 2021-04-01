package domain.WoordRaden;

import domain.Speler.Speler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FxWoordRadenApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        TextField invoerNaam = new  TextField("Geef je naam");
        GridPane root = new GridPane();
        Scene scene = new Scene(root,300,200);

        primaryStage.setScene(scene);
        root.add(invoerNaam,0,0);
        invoerNaam.setOnAction(eventIngaveNaam -> {
            primaryStage.setTitle(invoerNaam.getText());
            root.getChildren().clear();
            try {
                new WoordRadenApp(root, new Speler(invoerNaam.getText()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}