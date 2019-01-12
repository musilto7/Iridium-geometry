import Vlastnosti_komponentu.Vlastnosti;
import Iridium_Geometry.Iridium_Geometry;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Iridium_Geometry n = new Iridium_Geometry();
		n.okno.setVisible(true);
		n.NastavScrollPaneNaStred();
		n.platno.komponents.zmena.addObserver(n.platno);
		new Vlastnosti();
	}

}
