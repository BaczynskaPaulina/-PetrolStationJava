
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class PodstawoweOkienkoCena extends JFrame {

	protected Cennik cennik;

	public PodstawoweOkienkoCena(Cennik cennik) {
		this.cennik = cennik;

		stworzWyglad();
	}

	protected void stworzWyglad() {
		JPanel lista = new JPanel();
		for (RodzajPaliwa p : RodzajPaliwa.values()) {
			JPanel panel = stworzWiersz(p);
			lista.add(panel);
		}
		add(lista);
	}

	protected JPanel stworzWiersz(RodzajPaliwa p) {
		JPanel panel = new JPanel();
		panel.add(new JLabel(p.name()));
		panel.add(new JLabel(this.cennik.podajCene(p) + " PAU"));
		dodajAkcjeWWierszu(p, panel);
		return panel;
	}

	protected abstract void dodajAkcjeWWierszu(RodzajPaliwa p, JPanel panel);
}