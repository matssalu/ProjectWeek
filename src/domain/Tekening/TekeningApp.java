package domain.Tekening;

import domain.Vorm.VormMakenApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import venster.TekenVensterApp;

public class TekeningApp {
    private Label naamTekeningLabel;
    private TextField invoerNaamTekening;

    private ComboBox<String> keuzeMenu;
    private ObservableList<String> opties;

    private TextArea uitvoer;
    private Tekening tekening;
    private Pane pane;
    private GridPane gridPane;

    public TekeningApp(GridPane root) {
        uitvoer = new TextArea();
        naamTekeningLabel = new Label("Geef de naam van je tekening: ");
        invoerNaamTekening = new TextField();
        pane = new Pane();
        gridPane = new GridPane();

        opties = FXCollections.observableArrayList("Vorm maken","Tekening tonen","stop");
        keuzeMenu = new ComboBox<>(opties);
        keuzeMenu.setValue("Kies actie");

        root.add(naamTekeningLabel,0,0);
        root.add(invoerNaamTekening,1,0);

        invoerNaamTekening.setOnAction(eventIngaveNaamTekening ->{
            String naamTekening = invoerNaamTekening.getText();
            if (!Tekening.isValidNaam(naamTekening)) {
                toonWaarschuwing("Naam van een tekening moet minimum 1 niet spatie bevatten");
            }else {
                tekening = new Tekening(naamTekening);

                root.getChildren().clear();
                root.add(keuzeMenu,0,0);
                root.add(uitvoer, 1, 0);

                uitvoer.setPrefRowCount(1);
                uitvoer.setPrefColumnCount(40);
                uitvoer.setVisible(false);
            }});

        keuzeMenu.setOnAction(eventKeuze -> {

            uitvoer.setVisible(false);
            if (keuzeMenu.getValue() != null) {
                switch (keuzeMenu.getValue()) {
                    case "Vorm maken" -> {
                        root.getChildren().remove(pane);
                        gridPane = new GridPane();
                        root.add(gridPane, 0, 1);
                        new VormMakenApp(gridPane, tekening);
                    }

                    case "Tekening tonen" -> {
                        root.getChildren().remove(gridPane);
                        uitvoer.setPrefRowCount(tekening.getAantalVormen() * 2);
                        uitvoer.setText(tekening.toString());
                        uitvoer.setVisible(true);
                        root.add(pane, 0, 1);
                        new TekenVensterApp(pane, tekening);
                    }

                    case "stop" -> System.exit(0);
                }
            }
        });
    }
    public void toonWaarschuwing(String s){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Waarschuwing");
        alert.setContentText(s);
        alert.showAndWait();
    }
}