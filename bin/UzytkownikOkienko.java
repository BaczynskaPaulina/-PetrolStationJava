import java.awt.Rectangle;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UzytkownikOkienko extends JFrame {
	private MenadzerSprzedazy sprzedaz;
	private Zbiornik zbiornik;
	private List<Dystrybutor> dystrybutory;
	
	private JButton bCennik;
	private JButton bGenerujZamowienie;

	public UzytkownikOkienko(MenadzerSprzedazy sprzedaz, Zbiornik zbiornik, List<Dystrybutor> dystrtbutory) {
		this.sprzedaz = sprzedaz;
		this.zbiornik = zbiornik;
		this.dystrybutory = dystrtbutory;

		stworzWyglad();
	}

	private void stworzWyglad() {
		JPanel panel = new JPanel();
		add(panel);
		panel.add(new JLabel("Uzytkownik:"));
		panel.add(bCennik = new JButton("Cennik"));
		panel.add(bGenerujZamowienie = new JButton("Generuj zamowienie"));

		bCennik.addActionListener(ev -> CennikOkienko.odtworz(sprzedaz.getCennik()));//TODO
		bGenerujZamowienie.addActionListener(ev -> ZamowienieOkienko.odtworz(sprzedaz,dystrybutory));//TODO
		
	}

	public static UzytkownikOkienko odtworz(MenadzerSprzedazy menadzer, Zbiornik zbiornik, List<Dystrybutor> dystrybutory) {
		UzytkownikOkienko frame = new UzytkownikOkienko(menadzer, zbiornik,
				dystrybutory);
		frame.setVisible(true);
		frame.setBounds(new Rectangle(0, 0, 155, 150));
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
