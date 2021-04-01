package domain.db;


import domain.WoordenLijst.WoordenLijst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class WoordenLezer {

    private final ArrayList<String> woorden;

    public WoordenLezer(String fileName) {
        this.woorden = new ArrayList<String>();
        Scanner scannerFile = null; 
        try {
            scannerFile = new Scanner(new File("src/domain/db/" + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scannerFile != null && scannerFile.hasNextLine()) {
            String s = scannerFile.nextLine(); 
            this.woorden.add(s);
        }
    }
    
    public static void setWoorden(WoordenLijst db, String path) {
        try{
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(new File(path).toPath(), Charset.defaultCharset() );
            for(String str: list) {
                if(!db.getDb().contains(str)){
                    db.voegToe(str);
                }
            }
        } catch (IOException e) {
            throw new DbException("Fout bij inlezen van het bestand");
        }
    }


    public WoordenLijst lees() {
        WoordenLijst woordenLijst = new WoordenLijst();
        for (String woord : this.woorden) {
            woordenLijst.voegToe(woord);
        }
        return woordenLijst;
    }
}