import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CennikOkienko extends PodstawoweOkienkoCena {

	public CennikOkienko(Cennik c) {
		super(c);
	}

	protected void dodajAkcjeWWierszu(RodzajPaliwa p, JPanel panel) {
	
	}

	public static CennikOkienko odtworz(Cennik c) {
		CennikOkienko frame = new CennikOkienko(c);
		frame.setVisible(true);
		frame.setBounds(new Rectangle(0, 0, 300, 300));
		frame.setLocationRelativeTo(null);
		return frame;
	}

	public static void main(String[] args) {
		JFrame frame = new CennikOkienko(Cennik.FAKE_CENNIK);
		frame.setVisible(true);
		frame.setBounds(new Rectangle(0, 0, 300, 100));
		frame.setLocationRelativeTo(null);
	}

}
