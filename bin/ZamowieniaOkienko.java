import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ZamowieniaOkienko extends JFrame {

	private MenadzerSprzedazy sprzedaz;

	public ZamowieniaOkienko(MenadzerSprzedazy sprzedaz) {
		this.sprzedaz = sprzedaz;

		JPanel lista = new JPanel();
		for (Zamowienie p : sprzedaz.getZamowienia()) {
			JPanel panel = new JPanel();
			panel.add(new JLabel(p.getDystrybutor().getName()));
			panel.add(new JLabel(p.getIlosc() + ""));
			panel.add(new JLabel(p.getPaliwo().name()));
			panel.add(new JLabel(p.getWartosc() + " PAU"));
			
			lista.add(panel);

		}
		add(lista);
	}

	public static ZamowieniaOkienko odtworz(MenadzerSprzedazy sprzedaz) {
		ZamowieniaOkienko frame = new ZamowieniaOkienko(sprzedaz);
		frame.setVisible(true);
		frame.setBounds(new Rectangle(0, 0, 300, 300));
		frame.setLocationRelativeTo(null);
		return frame;
	}

	public static void main(String[] args) {
		odtworz(MenadzerSprzedazy.FAKE_MENADZER);
	}

}
