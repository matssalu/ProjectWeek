package domain.Speler;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class SpelerApp {
    private Label invoerNaamLabel;
    private TextField invoerNaamVeld;
    private Speler speler ;

    private  Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public SpelerApp(GridPane root) {

        invoerNaamLabel = new Label("Geef de naam van de speler   ");
        invoerNaamVeld = new TextField();

        root.add(invoerNaamLabel, 0, 0);
        root.add(invoerNaamVeld, 1, 0);

        invoerNaamVeld.setOnAction(eventIngaveNaam -> {
            try {
                speler = new Speler(invoerNaamVeld.getText());
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(speler.toString());
                root.add(uitvoer, 0, 1);

            } catch (DomainException e) {
                invoerNaamVeld.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });


    }
}
