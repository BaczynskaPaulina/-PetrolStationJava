import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DystrybutoryOkienko extends JFrame {

	private List<Dystrybutor> dystrybutory;

	public DystrybutoryOkienko(List<Dystrybutor> dystrybutory) {
		this.dystrybutory = dystrybutory;

		JPanel lista = new JPanel();
		for (Dystrybutor d : dystrybutory) {
			JPanel panel = new JPanel();
			panel.add(new JLabel(d.getName()));
			panel.add(new JLabel(d.isWlaczony() + " "));
			JButton bPrzelacz;
			panel.add(bPrzelacz = new JButton("Wlacz/Wylacz"));
			bPrzelacz.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					d.przelaczWlaczony();
					setVisible(false); 
					dispose(); 
				}
			});
			lista.add(panel);
			// TODO: Uzupelnianie
		}
		add(lista);
	}

	public static DystrybutoryOkienko odtworz(List<Dystrybutor> dystrybutory) {
		DystrybutoryOkienko frame = new DystrybutoryOkienko(dystrybutory);
		frame.setVisible(true);
		frame.setBounds(new Rectangle(0, 0, 300, 300));
		frame.setLocationRelativeTo(null);
		return frame;
	}

	public static void main(String[] args) {
		odtworz(Dystrybutor.FAKE_DYSTRYBUTORY);
	}

}
