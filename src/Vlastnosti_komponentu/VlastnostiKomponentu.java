package Vlastnosti_komponentu;

import java.awt.Color;

public class VlastnostiKomponentu {	
	
		private Color barva;
		private String caraStyl;
		private String caraSila;
		private String jmeno;
		
		public VlastnostiKomponentu(String name , Color bar, String styl, String Sila){
			jmeno = name;
			barva = bar;
			caraStyl = styl;		
			caraSila = Sila;		
	}

		public Color getBarva() {
			return barva;
		}

		public String getCaraStyl() {
			return caraStyl;
		}

		public String getCaraSila() {
			return caraSila;
		}

		public String getJmeno() {
			return jmeno;
		}

		public void setBarva(Color barva) {
			this.barva = barva;
		}

		public void setCaraStyl(String caraStyl) {
			this.caraStyl = caraStyl;
		}

		public void setCaraSila(String caraSila) {
			this.caraSila = caraSila;
		}
		

}
