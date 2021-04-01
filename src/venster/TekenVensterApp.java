package venster;

import domain.*;
import domain.Tekening.Tekening;
import domain.Vorm.UiException;
import javafx.scene.layout.Pane;

public class TekenVensterApp {
    private Tekening tekening;

    public TekenVensterApp(Pane root, Tekening tekening){
        if (tekening == null) throw new UiException();
        this.tekening = tekening;
        this.teken(root);
    }

    public void teken(Pane root) {
        tekening.teken(root);
    }
}