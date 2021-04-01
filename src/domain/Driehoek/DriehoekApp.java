package domain.Driehoek;

import domain.Punt.Punt;
import domain.Tekening.Tekening;
import domain.Speler.Vorm;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DriehoekApp {
    private Label invoer1XLabel, invoer1YLabel, invoer2XLabel, invoer2YLabel, invoer3XLabel, invoer3YLabel;
    private TextField invoer1X, invoer1Y, invoer2X, invoer2Y, invoer3X, invoer3Y;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Punt punt1;
    private Punt punt2;
    private Punt punt3;
    private Driehoek driehoek;
    private Vorm vorm;

    public DriehoekApp(GridPane root) {

        invoer1XLabel = new Label("Geef de x-coördinaat van het eerste punt van de driehoek ");
        invoer1X= new TextField();
        invoer1YLabel = new Label("Geef de y-coördinaat van het eerste punt van de driehoek ");
        invoer1Y = new TextField();
        invoer2XLabel = new Label("Geef de x-coördinaat van het tweede punt van de driehoek ");
        invoer2X= new TextField();
        invoer2YLabel = new Label("Geef de y-coördinaat van het tweede punt van de driehoek ");
        invoer2Y = new TextField();
        invoer3XLabel = new Label("Geef de x-coördinaat van het tweede  punt van de driehoek ");
        invoer3X= new TextField();
        invoer3YLabel = new Label("Geef de y-coördinaat van het tweede punt van de driehoek ");
        invoer3Y = new TextField();

        root.add(invoer1XLabel, 0, 0);
        root.add(invoer1X, 1, 0);

        invoer1X.setOnAction(eventIngave1X ->{
            try {
                Integer.parseInt(invoer1X.getText());
                root.add(invoer1YLabel, 0, 1);
                root.add(invoer1Y, 1, 1);
            }
            catch (NumberFormatException e){
                invoer1X.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoer1Y.setOnAction(eventIngave1Y -> {
            try {
                punt1 = new Punt(Integer.parseInt(invoer1X.getText()), Integer.parseInt(invoer1Y.getText()));
                root.add(invoer2XLabel, 0, 2);
                root.add(invoer2X, 1, 2);
            } catch(NumberFormatException | DomainException e){

                invoer1Y.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoer2X.setOnAction(eventIngave2X -> {
            try {
                Integer.parseInt(invoer2X.getText());
                root.add(invoer2YLabel, 0, 3);
                root.add(invoer2Y, 1, 3);

            } catch (NumberFormatException e){

                invoer2X.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });

        invoer2Y.setOnAction(eventIngave2Y -> {
            try {
                punt2 = new Punt(Integer.parseInt(invoer2X.getText()), Integer.parseInt(invoer2Y.getText()));
                root.add(invoer3XLabel, 0, 4);
                root.add(invoer3X, 1, 4);
            } catch (NumberFormatException | DomainException e){

                invoer2X.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });

        invoer3X.setOnAction(eventIngave3X -> {
            try {
                Integer.parseInt(invoer3X.getText());
                root.add(invoer3YLabel, 0, 5);
                root.add(invoer3Y, 1, 5);
            } catch (NumberFormatException e){

                invoer2X.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });

        invoer3Y.setOnAction(eventIngave3Y -> {
            try {
                punt3 = new Punt(Integer.parseInt(invoer3X.getText()), Integer.parseInt(invoer3Y.getText()));
                driehoek = new Driehoek(punt1, punt2, punt3);

                root.getChildren().clear();

                Text uitvoer = new Text();

                uitvoer.setText(driehoek.toString());
                root.add(uitvoer, 0, 0);

            } catch (NumberFormatException | DomainException e){

                invoer2X.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }



    public DriehoekApp(GridPane root, Tekening tekening){
        init(root, 1);
        invoer3Y.setOnAction(eventIngaveStraal -> {
            try {
                punt3 = new Punt(Integer.parseInt(invoer3X.getText()), Integer.parseInt(invoer3Y.getText()));
                vorm = new Driehoek(punt1, punt2, punt3);
                tekening.voegToe(vorm);
                cleanUp(root);

            } catch (NumberFormatException ne) {
                invoer3X.clear();
                invoer3Y.clear();
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

        invoer1XLabel = new Label("Geef de x-coördinaat van het eerste punt van de driehoek ");
        invoer1YLabel = new Label("Geef de y-coördinaat van het eerste punt van de driehoek ");
        invoer1X = new TextField();
        invoer1Y = new TextField();

        invoer2XLabel = new Label("Geef de x-coördinaat van het tweede punt van de driehoek ");
        invoer2YLabel = new Label("Geef de y-coördinaat van het tweede punt van de driehoek ");
        invoer2X = new TextField();
        invoer2Y = new TextField();

        invoer3XLabel = new Label("Geef de x-coördinaat van het tweede  punt van de driehoek ");
        invoer3YLabel = new Label("Geef de y-coördinaat van het tweede punt van de driehoek ");
        invoer3X = new TextField();
        invoer3Y = new TextField();


        root.add(invoer1XLabel, 0, teller);
        root.add(invoer1X, 1, teller);
        root.add(invoer1YLabel, 2, teller);
        root.add(invoer1Y, 3, teller);


        invoer1Y.setOnAction(eventIngaveX -> {
            try {
                punt1 = new Punt(Integer.parseInt(invoer1X.getText()), Integer.parseInt(invoer1Y.getText()));
                root.add(invoer2XLabel, 0, teller + 1);
                root.add(invoer2X, 1, teller + 1);
                root.add(invoer2YLabel, 2, teller + 1);
                root.add(invoer2Y, 3, teller + 1);
            } catch (NumberFormatException e) {
                invoer1X.clear();
                invoer1Y.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat van middelpunt van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoer2Y.setOnAction(eventIngave2Y -> {
            try {
                punt2 = new Punt(Integer.parseInt(invoer2X.getText()), Integer.parseInt(invoer2Y.getText()));
                root.add(invoer3XLabel, 0, teller + 2);
                root.add(invoer3X, 1, teller + 2);
                root.add(invoer3YLabel, 2, teller + 2);
                root.add(invoer3Y, 3, teller + 2);
            } catch (NumberFormatException e) {
                invoer2X.clear();
                invoer2Y.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat van middelpunt van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }

    private void  cleanUp(GridPane root){
        root.getChildren().remove(invoer1XLabel);
        root.getChildren().remove(invoer1X);
        root.getChildren().remove(invoer1YLabel);
        root.getChildren().remove(invoer1Y);
        root.getChildren().remove(invoer2XLabel);
        root.getChildren().remove(invoer2X);
        root.getChildren().remove(invoer2YLabel);
        root.getChildren().remove(invoer2Y);
        root.getChildren().remove(invoer3XLabel);
        root.getChildren().remove(invoer3X);
        root.getChildren().remove(invoer3YLabel);
        root.getChildren().remove(invoer3Y);

    }
}