import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CennikZapisOdczyt {
	private Cennik cennik;

	public CennikZapisOdczyt(Cennik cennik) {
		super();
		this.cennik = cennik;
	}

	public void load() {
		try {
			System.out.println(new File("cennik.txt").getAbsolutePath());
			BufferedReader br = new BufferedReader(new FileReader("cennik.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split("@");
				RodzajPaliwa p = RodzajPaliwa.valueOf(parts[0]);
				int cena = Integer.parseInt(parts[1]);
				cennik.ustawStan(p, cena);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("cennik.txt"));
			for (RodzajPaliwa paliwo : RodzajPaliwa.values()) {
				bw.write(paliwo.name());
				bw.write("@");
				bw.write(""+cennik.podajCene(paliwo));
				bw.write("\n");
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
