package domain.Lijnstuk;

import domain.Punt.Punt;
import domain.Tekening.Tekening;
import domain.Speler.Vorm;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LijnstukApp {
    private Label startPuntLabel, eindPuntLabel;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);
    private TextField startPuntInvoerX, startPuntInvoerY, eindPuntInvoerX, eindPuntInvoerY;
    private Punt startPunt, eindPunt;
    private LijnStuk lijnStuk;
    private Vorm vorm;


    public LijnstukApp(GridPane root) {

        startPuntLabel = new Label("Geef de x- en y-coördinaat van het startpunt ");
        startPuntInvoerX = new TextField();
        startPuntInvoerY = new TextField();

        eindPuntLabel = new Label("Geef de x- en y-coördinaat van het eindpunt ");
        eindPuntInvoerX = new TextField();
        eindPuntInvoerY = new TextField();

        root.add(startPuntLabel, 0, 0);
        root.add(startPuntInvoerX, 1, 0);
        root.add(startPuntInvoerY, 2, 0);

        startPuntInvoerY.setOnAction(eventIngaveStartPunt -> {
            try {
                startPunt = new Punt(Integer.parseInt(startPuntInvoerX.getText()), Integer.parseInt(startPuntInvoerY.getText()));
                root.add(eindPuntLabel, 0, 1);
                root.add(eindPuntInvoerX, 1, 1);
                root.add(eindPuntInvoerY, 2, 1);
            } catch (NumberFormatException e) {
                startPuntInvoerX.clear();
                startPuntInvoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Startpunt moet een geldig punt zijn");
                foutenboodschap.showAndWait();
            }
        });

        eindPuntInvoerY.setOnAction(eventIngaveY -> {
            try {
                eindPunt = new Punt(Integer.parseInt(eindPuntInvoerX.getText()), Integer.parseInt(eindPuntInvoerY.getText()));

                lijnStuk = new LijnStuk(startPunt, eindPunt);
                root.getChildren().clear();

                Text uitvoer = new Text();

                uitvoer.setText(lijnStuk.toString());
                root.add(uitvoer, 0, 0);
            } catch (NumberFormatException e) {
                eindPuntInvoerX.clear();
                eindPuntInvoerY.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }


    public LijnstukApp(GridPane root, Tekening tekening) {
        init(root, 1);
        eindPuntInvoerY.setOnAction(eventIngaveStraal -> {
            try {
                startPunt = new Punt(Integer.parseInt(startPuntInvoerX.getText()), Integer.parseInt(startPuntInvoerY.getText()));
                eindPunt = new Punt(Integer.parseInt(eindPuntInvoerX.getText()), Integer.parseInt(eindPuntInvoerY.getText()));
                lijnStuk = new LijnStuk(startPunt, eindPunt);
                vorm = lijnStuk;
                tekening.voegToe(vorm);
                cleanUp(root);

            } catch (NumberFormatException ne) {
                eindPuntInvoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("straal van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            } catch (DomainException e) {
                cleanUp(root);
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }

        });
    }

    private void init(GridPane root, int teller) {

        startPuntLabel = new Label("Geef de x- en y-coördinaat van het startpunt");
        startPuntInvoerX = new TextField();
        startPuntInvoerY = new TextField();

        eindPuntLabel = new Label("Geef de x- en y-coördinaat van het eindpunt");
        eindPuntInvoerX = new TextField();
        eindPuntInvoerY = new TextField();


        root.add(startPuntLabel, 0, teller);
        root.add(startPuntInvoerX, 1, teller);
        root.add(startPuntInvoerY, 2, teller);

        startPuntInvoerY.setOnAction(eventIngaveX -> {
            try {
                startPunt = new Punt(Integer.parseInt(startPuntInvoerX.getText()), Integer.parseInt(startPuntInvoerY.getText()));
                root.add(eindPuntLabel, 0, teller + 1);
                root.add(eindPuntInvoerX, 1, teller + 1);
                root.add(eindPuntInvoerY, 2, teller + 1);
            } catch (NumberFormatException e) {
                startPuntInvoerX.clear();
                startPuntInvoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat van middelpunt van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });
    }


    private void  cleanUp(GridPane root){
        root.getChildren().remove(startPuntLabel);
        root.getChildren().remove(startPuntInvoerX);
        root.getChildren().remove(startPuntInvoerY);
        root.getChildren().remove(eindPuntLabel);
        root.getChildren().remove(eindPuntInvoerX);
        root.getChildren().remove(eindPuntInvoerY);

    }
}