import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ZamowienieOkienko extends JFrame {

	private final MenadzerSprzedazy sprzedaz;
	private final List<Dystrybutor> dystrybutory;
	private JComboBox<Dystrybutor> comboDystrybutory;
	private JComboBox<RodzajPaliwa> comboRodzaje;
	private JComboBox<String> comboJednostka;
	private JButton bZloz;
	private JTextField bWartosc;

	public ZamowienieOkienko(MenadzerSprzedazy sprzedaz, List<Dystrybutor> dystrybutory) throws HeadlessException {
		super();
		this.sprzedaz = sprzedaz;
		this.dystrybutory = dystrybutory;

		JPanel panel;
		add(panel = new JPanel());
		panel.add(new JLabel("Zamowienie"));
		
		panel.add(new JLabel("Wybierz dystrybutor: "));
		comboDystrybutory = new JComboBox<>(dystrybutory.toArray(new Dystrybutor[dystrybutory.size()]));
		panel.add(comboDystrybutory);

		panel.add(new JLabel("Wybierz rodzaj: "));
		comboRodzaje = new JComboBox<>(RodzajPaliwa.values());
		panel.add(comboRodzaje);
		
		panel.add(new JLabel("Wybierz jednostke: "));
		comboJednostka = new JComboBox<>(new String[]{"Ilosc", "Kwota"});
		panel.add(comboJednostka);
		
		panel.add(bWartosc = new JTextField(10));
		
		panel.add(bZloz = new JButton("Zloz zamowienie"));
		bZloz.addActionListener(ev -> {			
			Dystrybutor dystrybutor = (Dystrybutor) comboDystrybutory.getSelectedItem();
			RodzajPaliwa rodzaj = (RodzajPaliwa) comboRodzaje.getSelectedItem();
			String akcja = (String) comboJednostka.getSelectedItem();
			
			if(!dystrybutor.isWlaczony()){
				JOptionPane.showMessageDialog(null, "Dystrybutor wylaczony");
				return;
			}
			
			Zamowienie zamowienie = null;
			try{
				int wartosc = Integer.parseInt(bWartosc.getText());
		
				if("Ilosc".equals(akcja)){
					zamowienie = sprzedaz.sprzedajIlosc(dystrybutor, rodzaj, wartosc);
				}else{
					zamowienie = sprzedaz.sprzedajWartosc(dystrybutor, rodzaj, wartosc);
				}
				dystrybutor.nalej(rodzaj, zamowienie.getIlosc());
				int wartosc_z = zamowienie.getWartosc();
				
				while(wartosc_z > 0){
					int a = Integer.parseInt(JOptionPane.showInputDialog("Do zaplaty jest: " + wartosc_z + " PAU"));
					wartosc_z -= a;
				}
				if(wartosc_z != 0){
					JOptionPane.showMessageDialog(null, "Reszty zostalo: " + -1 * wartosc_z + " PAU");
				}
				
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "Nieprawidlowa liczba");
				return;
			} catch (BrakPaliwaException e) {
				JOptionPane.showMessageDialog(null, "Brak paliwa");
				sprzedaz.wycofajZamowienie(zamowienie);
				return;
			}
			
			JOptionPane.showMessageDialog(null, "Zamowienie zapisano.");
			
			
		});

	}

	public static ZamowienieOkienko odtworz(MenadzerSprzedazy sprzedaz, List<Dystrybutor> dystrybutory) {

		ZamowienieOkienko frame = new ZamowienieOkienko(sprzedaz, dystrybutory);
		frame.setVisible(true);
		frame.setBounds(new Rectangle(0, 0, 170, 300));
		frame.setLocationRelativeTo(null);
		return frame;
	}
}
