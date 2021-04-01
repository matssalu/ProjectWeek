package domain.Rechthoek;

import domain.Punt.Punt;
import domain.Tekening.Tekening;
import domain.Speler.Vorm;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RechthoekApp {
    private Label invoerXLabel, invoerYLabel, invoerBLabel, invoerHLabel;
    private TextField invoerX, invoerY, invoerB, invoerH;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);
    private Rechthoek vier;
    private Punt punt;
    private Vorm vorm;

    public RechthoekApp(GridPane root, Tekening tekening) {

        invoerXLabel =  new Label("Geef de x-coordinaat van de rechterbovenhoek");
        invoerX= new TextField();
        invoerYLabel = new Label("Geef de y-coordinaat van de rechterbovenhoek");
        invoerY = new TextField();
        invoerBLabel = new Label("Geef de breedte van de rechthoek");
        invoerB = new TextField();
        invoerHLabel = new Label("Geef de hoogte van de rechthoek");
        invoerH = new TextField();

        root.add(invoerXLabel,0,0);
        root.add(invoerX,1,0);



        invoerX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, 1);
                root.add(invoerY, 1, 1);
            }
            catch(NumberFormatException e){
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY.setOnAction(eventIngaveY ->{
            try {
                Integer.parseInt(invoerY.getText());
                root.add(invoerBLabel, 0, 2);
                root.add(invoerB, 1, 2);
            }
            catch(NumberFormatException e){
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerB.setOnAction(eventIngaveB ->{
            try {
                Integer.parseInt(invoerB.getText());
                root.add(invoerHLabel, 0, 3);
                root.add(invoerH, 1, 3);
            }
            catch(NumberFormatException e){
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("breedte moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerH.setOnAction(eventIngaveH -> {
            try {
                punt = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                vier = new Rechthoek(punt ,Integer.parseInt(invoerB.getText()), Integer.parseInt(invoerH.getText()));

                root.getChildren().clear();
                tekening.voegToe(vier);

            } catch(NumberFormatException e){

                invoerY.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("hoogte moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }

}
