package Komponenty;

import Vlastnosti_komponentu.VlastnostiKomponentu;

public class Predek {
	public String name;
	public boolean vykresli, vykresleno;
	public VlastnostiKomponentu vlastnosti = null;
	
	public Predek(String jmeno){
		name = jmeno;
		vykresli = true;
		vykresleno = false;
	}
}
