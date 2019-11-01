import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LogowanieOkienko extends JFrame {

	private JButton bUzytkownik;
	private JButton bPracownik;
	private final MenadzerSprzedazy menadzer;
	private final Zbiornik zbiornik;
	private final List<Dystrybutor> dystrybutory;

	public LogowanieOkienko(Zbiornik zbiornik, MenadzerSprzedazy sprzedaz, List<Dystrybutor> dystrybutory) {
		this.zbiornik = zbiornik;
		this.menadzer = sprzedaz;
		this.dystrybutory = dystrybutory;
		
		stworzWyglad();
	}

	private void stworzWyglad() {
		JPanel panel = new JPanel();
		add(panel);
		panel.add(new JLabel("Panel wyboru"));
		panel.add(bUzytkownik = new JButton("Uzytkownik"));
		panel.add(bPracownik = new JButton("Pracownik"));

		bPracownik.addActionListener(ev -> {
			String haslo = JOptionPane.showInputDialog("Podaj haslo");
			if("rzodkiewka".equals(haslo)){
				PracownikOkienko.odtworz(menadzer, zbiornik, dystrybutory);
			}else{
				JOptionPane.showMessageDialog(null, "Bledne haslo");
			}
		});
		bUzytkownik.addActionListener(ev -> UzytkownikOkienko.odtworz(menadzer, zbiornik, dystrybutory));
	}

	public static LogowanieOkienko odtworz(Zbiornik zbiornik, MenadzerSprzedazy sprzedaz, List<Dystrybutor> dystrybutory) {
		LogowanieOkienko frame = new LogowanieOkienko(zbiornik, sprzedaz, dystrybutory);
		frame.setVisible(true);
		frame.setBounds(new Rectangle(0, 0, 100, 140));
		frame.setLocationRelativeTo(null);
		return frame;
	}

	public static void main(String[] args) {
		odtworz(Zbiornik.FAKE_ZBIORNIK, MenadzerSprzedazy.FAKE_MENADZER, Dystrybutor.FAKE_DYSTRYBUTORY);
	}

}
