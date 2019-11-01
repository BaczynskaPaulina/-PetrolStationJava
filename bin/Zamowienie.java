
public class Zamowienie {
	private final Dystrybutor dystrybutor;
	private final RodzajPaliwa paliwo;
	private final int wartosc;
	private final int ilosc;

	public Zamowienie(Dystrybutor dystrybutor, RodzajPaliwa paliwo, int wartosc, int ilosc) {
		this.dystrybutor = dystrybutor;
		this.paliwo = paliwo;
		this.wartosc = wartosc;
		this.ilosc = ilosc;
	}

	public Dystrybutor getDystrybutor() {
		return dystrybutor;
	}

	public RodzajPaliwa getPaliwo() {
		return paliwo;
	}

	public int getWartosc() {
		return wartosc;
	}

	public int getIlosc() {
		return ilosc;
	}

}
