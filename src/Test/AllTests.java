package Test;

import domain.Cirkel.CirkelTest;
import domain.Driehoek.DriehoekTest;
import domain.Hangman.HangManTest;
import domain.HintLetterTest;
import domain.HintWoord.HintWoordTest;
import domain.Lijnstuk.LijnStukTest;
import domain.Omhullende.OmhullendeTest;
import domain.Punt.PuntTest;
import domain.Rechthoek.RechthoekTest;
import domain.Speler.SpelerTest;
import domain.Tekening.TekeningTest;
import domain.WoordenLijst.WoordenLijst;
import domain.WoordenLijst.WoordenLijstTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PuntTest.class, SpelerTest.class, CirkelTest.class, LijnStukTest.class, RechthoekTest.class, DriehoekTest.class, HintLetterTest.class, HintWoordTest.class, OmhullendeTest.class, TekeningTest.class, WoordenLijstTest.class, HangManTest.class})
public class AllTests {
}