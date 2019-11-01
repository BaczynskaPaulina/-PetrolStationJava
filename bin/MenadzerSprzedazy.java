import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MenadzerSprzedazy {

	public static final MenadzerSprzedazy FAKE_MENADZER = new MenadzerSprzedazy(Cennik.FAKE_CENNIK);
	static{
		FAKE_MENADZER.zamowienia.add(new Zamowienie(Dystrybutor.FAKE_DYSTRYBUTORY.get(0), RodzajPaliwa.LPG, 100, 100));
		FAKE_MENADZER.zamowienia.add(new Zamowienie(Dystrybutor.FAKE_DYSTRYBUTORY.get(0), RodzajPaliwa.ON, 120, 10));
		FAKE_MENADZER.zamowienia.add(new Zamowienie(Dystrybutor.FAKE_DYSTRYBUTORY.get(0), RodzajPaliwa.PB95, 150, 20));
		FAKE_MENADZER.zamowienia.add(new Zamowienie(Dystrybutor.FAKE_DYSTRYBUTORY.get(0), RodzajPaliwa.LPG, 160, 50));
		FAKE_MENADZER.zamowienia.add(new Zamowienie(Dystrybutor.FAKE_DYSTRYBUTORY.get(0), RodzajPaliwa.ON, 200, 70));
	}

	private final Cennik cennik;

	private final List<Zamowienie> zamowienia = new ArrayList<>();

	public MenadzerSprzedazy(Cennik cennik) {
		this.cennik = cennik;
	}

	public Zamowienie sprzedajIlosc(Dystrybutor d, RodzajPaliwa p, int ilosc) {
		int cena = this.cennik.podajCene(p);
		int wartosc = ilosc * cena;
		Zamowienie z = new Zamowienie(d, p, wartosc, ilosc);
		zamowienia.add(z);
		return z;
	}

	public Zamowienie sprzedajWartosc(Dystrybutor d, RodzajPaliwa p, int wartosc) {
		int cena = this.cennik.podajCene(p);
		int ilosc = wartosc / cena;
		Zamowienie z = new Zamowienie(d, p, wartosc, ilosc);
		zamowienia.add(z);
		return z;
	}

	public Cennik getCennik() {
		return cennik;
	}

	public List<Zamowienie> getZamowienia() {
		return Collections.unmodifiableList(zamowienia);
	}
	
	public void wycofajZamowienie(Zamowienie z){
		this.zamowienia.remove(z);
	}

}
