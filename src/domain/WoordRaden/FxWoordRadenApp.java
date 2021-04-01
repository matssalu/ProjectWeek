package domain.WoordRaden;

import domain.Speler.Speler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxWoordRadenApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        TextField invoerNaam = new  TextField("Geef je naam");
        GridPane root = new GridPane();
        Scene scene = new Scene(root,700,700);

        primaryStage.setScene(scene);
        root.add(invoerNaam,0,0);
        invoerNaam.setOnAction(eventIngaveNaam -> {
            primaryStage.setTitle(invoerNaam.getText());
            root.getChildren().clear();
            new WoordRadenApp(root, new Speler(invoerNaam.getText()));
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}