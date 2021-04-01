package domain.WoordRaden;

import domain.HintWoord.HintWoord;
import domain.Speler.Speler;
import domain.Tekening.DomainException;
import domain.WoordenLijst.WoordenLijst;
import domain.db.WoordenLezer;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import domain.db.WoordenLezer;

import java.io.IOException;
import java.util.ArrayList;

public class WoordRadenApp {
    private Label invoerStartLabel, invoerLabel, raadLabel, progressLabel, foutLabel, woordLabel, succesLabel;
    private TextField invoerChar, invoerStartChar;
    private boolean status;
    private WoordenLijst woorden;
    private int nummer;

    public WoordRadenApp(GridPane root, Speler speler) throws IOException {

        this.woorden = new WoordenLijst();
        HintWoord woord = new HintWoord(woorden.getRandomWoord());

        invoerStartLabel =  new Label("Geef je gok: ");
        invoerStartChar= new TextField();

        invoerLabel =  new Label("Geef een letter: ");
        invoerChar= new TextField();

        raadLabel = new Label("Rarara, welk woord zoeken we?");
        progressLabel = new Label("Super doe zo voort!");

        foutLabel = new Label("Helaas volgende keer beter");
        woordLabel = new Label(woord.toString());



        root.add(raadLabel, 0, 0);
        root.add(woordLabel, 0, 1);
        root.add(invoerStartLabel, 0, 2);
        root.add(invoerChar, 0, 3);

        invoerChar.setOnAction(eventIngaveChar -> {
            while (!woord.isGeraden()){
                if (invoerChar.getText().length() > 1)
                    throw new DomainException("Gok mag maar 1 character lang zijn");
                else {
                    if (woord.raad(invoerChar.getText().charAt(0))) {
                        status = true;
                    } else {
                        status = false;
                    }
                    invoerChar.clear();

                    root.getColumnConstraints().clear();
                    root.getRowConstraints().clear();
                    root.getChildren().clear();

                    if (status) {

                        root.add(progressLabel, 0, 0);
                        nummer++;
                    } else if (!status) {
                        root.add(foutLabel, 0, 0);
                        nummer++;
                    }
                    root.add(raadLabel, 0, 1);
                    root.add(new Label(woord.toString()), 0, 2);
                    root.add(invoerChar, 0, 3);
                }
            }
            root.getColumnConstraints().clear();
            root.getRowConstraints().clear();
            root.getChildren().clear();

            succesLabel = new Label("Goed gedaan " + speler.getNaam() + " Je hebt het woord geraden in " + nummer + " beurten!");
            root.add(succesLabel, 0,1);
        });
    }
}