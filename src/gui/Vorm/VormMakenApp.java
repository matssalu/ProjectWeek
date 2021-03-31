package gui.Vorm;

import gui.Driehoek.DriehoekApp;
import gui.Lijnstuk.LijnstukApp;
import gui.Rechthoek.RechthoekApp;
import gui.Tekening.Tekening;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import gui.Cirkel.CirkelApp;

public class VormMakenApp {
    private GridPane root;
    private ComboBox<String> keuzeMenu;
    private ObservableList<String> mogelijkeFiguren;

    public VormMakenApp(GridPane root, Tekening tekening) {

        this.root = root;
        mogelijkeFiguren = FXCollections.observableArrayList("Cirkel","Rechthoek","Lijnstuk","Driehoek");
        keuzeMenu = new ComboBox(mogelijkeFiguren);

        root.add(keuzeMenu,0,1);
        keuzeMenu.setOnAction(eventKeuze -> {
                    if (keuzeMenu.getValue() != null) {
                        if (keuzeMenu.getValue().equals("Cirkel")) {
                            new CirkelApp(root, tekening);

                        } else if (keuzeMenu.getValue().equals("Rechthoek")) {
                            new RechthoekApp(root, tekening);

                        } else if (keuzeMenu.getValue().equals("Lijnstuk")) {
                            new LijnstukApp(root, tekening);

                        } else if (keuzeMenu.getValue().equals("Driehoek")) {
                            /*new DriehoekApp(root, tekening);*/

                        }
                        root.getChildren().remove(keuzeMenu);
                    }
                }

        );}
}
