import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StacjaPaliw {
	
	public static void main(String[] args) {
		
		Cennik cennik = new Cennik();
		CennikZapisOdczyt cennik_zapis_odczyt = new CennikZapisOdczyt(cennik);
		cennik_zapis_odczyt.load();
		cennik.addListener(() -> cennik_zapis_odczyt.save());
		
		Zbiornik zbiornik = new Zbiornik();
		MenadzerSprzedazy sprzedaz = new MenadzerSprzedazy(cennik);
		List<Dystrybutor> dystrybutory = Arrays.asList(//
				new Dystrybutor("Prawy", zbiornik, sprzedaz), //
				new Dystrybutor("Lewo", zbiornik, sprzedaz)//
		);
		LogowanieOkienko.odtworz(zbiornik, sprzedaz, dystrybutory);
	}
}
