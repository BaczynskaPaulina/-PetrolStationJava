import java.awt.Rectangle;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PracownikOkienko extends JFrame {
	private MenadzerSprzedazy sprzedaz;
	private Zbiornik zbiornik;
	private List<Dystrybutor> dystrybutory;
	
	private JButton bSprawdz;
	private JButton bCeny;
	private JButton bDystrybutory;
	private JButton bZamowienia;

	public PracownikOkienko(MenadzerSprzedazy sprzedaz, Zbiornik zbiornik, List<Dystrybutor> dystrtbutory) {
		this.sprzedaz = sprzedaz;
		this.zbiornik = zbiornik;
		this.dystrybutory = dystrtbutory;

		stworzWyglad();
	}

	private void stworzWyglad() {
		JPanel panel = new JPanel();
		add(panel);
		panel.add(new JLabel("Pracownik:"));
		panel.add(bSprawdz = new JButton("Stan zbiornikow"));
		panel.add(bCeny = new JButton("Cennik"));
		panel.add(bDystrybutory = new JButton("Dystrybutory"));
		panel.add(bZamowienia = new JButton("Zamowienia"));

		bCeny.addActionListener(ev -> CennikOkienkoZKasowaniem.odtworz(sprzedaz.getCennik()));
		bSprawdz.addActionListener(ev -> ZbiornikOkienko.odtworz(zbiornik));
		bDystrybutory.addActionListener(ev -> DystrybutoryOkienko.odtworz(dystrybutory));
		bZamowienia.addActionListener(ev -> ZamowieniaOkienko.odtworz(sprzedaz));
		
	}

	public static PracownikOkienko odtworz(MenadzerSprzedazy menadzer, Zbiornik fakezbiornik, List<Dystrybutor> dystrybutor) {
		PracownikOkienko frame = new PracownikOkienko(menadzer, fakezbiornik,
				dystrybutor);
		frame.setVisible(true);
		frame.setBounds(new Rectangle(0, 0, 100, 300));
		frame.setLocationRelativeTo(null);
		return frame;
	}

	public static void main(String[] args) {
		MenadzerSprzedazy menadzer = MenadzerSprzedazy.FAKE_MENADZER;
		Zbiornik fakezbiornik = Zbiornik.FAKE_ZBIORNIK;
		List<Dystrybutor> dystrybutor = Dystrybutor.FAKE_DYSTRYBUTORY;
		odtworz(menadzer, fakezbiornik, dystrybutor);
	}


}
