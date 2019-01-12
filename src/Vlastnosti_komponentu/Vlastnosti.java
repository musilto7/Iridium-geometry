package Vlastnosti_komponentu;

import java.awt.Color;

import Komponenty.VsechnyKomponenty;
import Tlacitka.VyberModu;

public class Vlastnosti {
	
	public static String[] typyCarStyl = new String[]{"", "pln·", "Ë·rkovan·", "Ëerchovana"};
	public static String[] typyCarSila = new String[]{"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	public static VlastnostiKomponentu[] vlastnosti;
		
	
	public Vlastnosti(){	
		vlastnosti = new VlastnostiKomponentu[8];
		
		vlastnosti[0] = new VlastnostiKomponentu(VyberModu.nazvyTlacitek[1], new Color(0,0,0), Vlastnosti.typyCarStyl[0], Vlastnosti.typyCarSila[0]);
		vlastnosti[1] = new VlastnostiKomponentu(VyberModu.nazvyTlacitek[2], new Color(0,0,0), Vlastnosti.typyCarStyl[1], Vlastnosti.typyCarSila[7]);
		vlastnosti[2] = new VlastnostiKomponentu(VyberModu.nazvyTlacitek[3],new Color(150,150,150), Vlastnosti.typyCarStyl[2], Vlastnosti.typyCarSila[5]);
		vlastnosti[3] = new VlastnostiKomponentu(VyberModu.nazvyTlacitek[4],new Color(0,255,0), Vlastnosti.typyCarStyl[3], Vlastnosti.typyCarSila[5]);
		vlastnosti[4] = new VlastnostiKomponentu(VyberModu.nazvyTlacitek[5],new Color(0,0,255), Vlastnosti.typyCarStyl[2], Vlastnosti.typyCarSila[3]);
		vlastnosti[5] = new VlastnostiKomponentu(VyberModu.nazvyTlacitek[6],new Color(255,80,80), Vlastnosti.typyCarStyl[3], Vlastnosti.typyCarSila[3]);
		vlastnosti[6] = new VlastnostiKomponentu(VsechnyKomponenty.osaX.name,new Color(0,0,0), Vlastnosti.typyCarStyl[1], Vlastnosti.typyCarSila[10]);
		vlastnosti[7] = new VlastnostiKomponentu(VsechnyKomponenty.osaY.name, new Color(0,0,0), Vlastnosti.typyCarStyl[1], Vlastnosti.typyCarSila[10]);
		
	}
	

}
