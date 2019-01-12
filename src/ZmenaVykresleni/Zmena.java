package ZmenaVykresleni;

import java.util.Observable;
import java.util.Observer;

import Iridium_Geometry.Iridium_Geometry;

public class Zmena extends Observable{
	
	
	public void Prekresli(){
		setChanged();
		notifyObservers(true);
	}
	public void Prekresli(boolean bol){
		setChanged();
		notifyObservers(false);
	}
	
}
