import java.util.HashMap;
import java.util.Map;

public class Zbiornik {
	private Map<RodzajPaliwa, Integer> stany = new HashMap<>();
	
	public static final Zbiornik FAKE_ZBIORNIK = new Zbiornik(){
	};
	
	public Zbiornik() {
		for (RodzajPaliwa p : RodzajPaliwa.values()) {
			stany.put(p, 100);
		}
	}
	public boolean jestPaliwo(RodzajPaliwa p){
		return this.podajStan(p) > 0;
	}
	
	public int podajStan(RodzajPaliwa p){
		return stany.get(p);
	}

	public void ustawStan(RodzajPaliwa p, int w) throws BrakPaliwaException{
		if(w <= 0){
			throw new BrakPaliwaException();
		}
		
		stany.put(p, w);
	}
	
	public void zmienStan(RodzajPaliwa p, int w) throws BrakPaliwaException{
		int s = this.podajStan(p);
		s += w;
		ustawStan(p, s);
	}
}
