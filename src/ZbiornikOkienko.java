import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ZbiornikOkienko extends JFrame{

	private Zbiornik zbiornik;

	public ZbiornikOkienko(Zbiornik zbiornik) {
		this.zbiornik = zbiornik;
		
		JPanel lista = new JPanel();
		for(RodzajPaliwa p: RodzajPaliwa.values()){
			JPanel panel = new JPanel();
			panel.add(new JLabel(p.name()));
			panel.add(new JLabel(this.zbiornik.podajStan(p) + " cm^3"));
			JButton bWypelnij;
			panel.add(bWypelnij = new JButton("Wypelnij"));
			bWypelnij.addActionListener(e -> {
				try {
					zbiornik.ustawStan(p, 1000);
				} catch (BrakPaliwaException e1) {
					e1.printStackTrace();
				}
				setVisible(false); 
				dispose(); 
			});
			lista.add(panel);
			// TODO: Uzupelnianie
		}
		add(lista);
	}
	
	public static ZbiornikOkienko odtworz(Zbiornik z) {
		ZbiornikOkienko frame = new ZbiornikOkienko (z);
		frame.setVisible(true);
		frame.setBounds(new Rectangle(0, 0, 300, 300));
		frame.setLocationRelativeTo(null);
		return frame;
	}

	public static void main(String[] args) {
		JFrame frame= new ZbiornikOkienko(Zbiornik.FAKE_ZBIORNIK);
		frame.setVisible(true);
		frame.setBounds(new Rectangle(0, 0, 100, 300));
		frame.setLocationRelativeTo(null);
	}
	
}
