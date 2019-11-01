import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CennikOkienkoZKasowaniem extends PodstawoweOkienkoCena {

	public CennikOkienkoZKasowaniem(Cennik c) {
		super(c);
	}

	protected void dodajAkcjeWWierszu(RodzajPaliwa p, JPanel panel) {
		JButton bWypelnij;
		panel.add(bWypelnij = new JButton("Zmien cene"));
		bWypelnij.addActionListener(e -> {
			try {
				int cena = Integer.parseInt(JOptionPane.showInputDialog("Podaj nowa cene"));
				CennikOkienkoZKasowaniem.this.cennik.ustawStan(p, cena);
				
				setVisible(false); 
				dispose(); 
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Nie prawidlowa wartosc");
			}
		});
	}

	public static CennikOkienkoZKasowaniem odtworz(Cennik c) {
		CennikOkienkoZKasowaniem frame = new CennikOkienkoZKasowaniem(c);
		frame.setVisible(true);
		frame.setBounds(new Rectangle(0, 0, 300, 300));
		frame.setLocationRelativeTo(null);
		return frame;
	}

	public static void main(String[] args) {
		JFrame frame = new CennikOkienkoZKasowaniem(Cennik.FAKE_CENNIK);
		frame.setVisible(true);
		frame.setBounds(new Rectangle(0, 0, 300, 300));
		frame.setLocationRelativeTo(null);
	}

}
