import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cennik {
	
	public interface CennikListener{
		public void cenaZmienilaSie();
	}

	public static final Cennik FAKE_CENNIK = new Cennik(){
		{
			this.ustawStan(RodzajPaliwa.LPG, 500);
			this.ustawStan(RodzajPaliwa.ON, 500);
			this.ustawStan(RodzajPaliwa.PB95, 500);
			this.ustawStan(RodzajPaliwa.PB98, 500);
		}
	};
	
	private Map<RodzajPaliwa, Integer> stany = new HashMap<>();
	private List<CennikListener> listeners = new ArrayList<>();
	
	public Cennik() {
		for (RodzajPaliwa p : RodzajPaliwa.values()) {
			stany.put(p, 100);
		}
	}
	public boolean jestPaliwo(RodzajPaliwa p){
		return this.podajCene(p) > 0;
	}
	
	public int podajCene(RodzajPaliwa p){
		return stany.get(p);
	}

	public void ustawStan(RodzajPaliwa p, int w){
		notifyListeners();
		stany.put(p, w);
	}
	
	public void zmienStan(RodzajPaliwa p, int w){
		int s = this.podajCene(p);
		s += w;
		ustawStan(p, s);
	}
	
	private void notifyListeners(){
		for(CennikListener l:this.listeners){
			l.cenaZmienilaSie();
		}
	}
	public boolean addListener(CennikListener e) {
		return listeners.add(e);
	}
}
