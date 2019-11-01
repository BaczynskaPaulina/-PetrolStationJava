import java.util.Arrays;
import java.util.List;

public class Dystrybutor {

	public static final List<Dystrybutor> FAKE_DYSTRYBUTORY;
	static {
		FAKE_DYSTRYBUTORY = Arrays.asList(//
				new Dystrybutor("Prawy", Zbiornik.FAKE_ZBIORNIK, MenadzerSprzedazy.FAKE_MENADZER), //
				new Dystrybutor("Lewy", Zbiornik.FAKE_ZBIORNIK, MenadzerSprzedazy.FAKE_MENADZER)//
		);
	}
	private final String name;
	private final Zbiornik zbiornik;
	private final MenadzerSprzedazy menadzer_sprzedazy;
	private boolean wlaczony = true;

	public Dystrybutor(String name, Zbiornik zbiornik, MenadzerSprzedazy menadzer_sprzedazy) {
		this.name = name;
		this.zbiornik = zbiornik;
		this.menadzer_sprzedazy = menadzer_sprzedazy;
	}

	public boolean isWlaczony() {
		return wlaczony;
	}

	public void setWlaczony(boolean wlaczony) {
		this.wlaczony = wlaczony;
	}

	public void przelaczWlaczony() {
		setWlaczony(!isWlaczony());
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.getName();
	}
	
	public void nalej(RodzajPaliwa p, int ilosc) throws BrakPaliwaException{
		zbiornik.zmienStan(p, -1 * ilosc);
	}
}
