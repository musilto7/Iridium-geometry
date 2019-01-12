package Obrazovka;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Iridium_Geometry.Iridium_Geometry;
import Komponenty.VsechnyKomponenty;
import Komponenty.VsechnyKomponenty.KteryKomponent;
import Tlacitka.*;



public class PanelSTlacitky extends Panel{
	public static String[] jmena = {"Ukazovátko", "Bod","Úseèka", "Pøímka", "Polopøímka", "Rovnobežka", "Kolmice", "Nanést vzdl.", "Prùseèík"}; 
	Tlacitko[] tlac;
	
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	
	
	public PanelSTlacitky(){
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		this.setLayout(gbl);
		
		VyberModu.nazvyTlacitek = jmena;
		
		VyberModu.vyberModu = new CheckboxGroup();
		VyberModu.jednotlivyMod = new Checkbox[jmena.length];
		for(int i = 0; i < VyberModu.jednotlivyMod.length; i++){
			if(i != 0)
			VyberModu.jednotlivyMod[i] = new Checkbox(jmena[i],VyberModu.vyberModu, false);
			else
				VyberModu.jednotlivyMod[i] = new Checkbox(jmena[i],VyberModu.vyberModu, true);
		}
		
		
		tlac = new Tlacitko[jmena.length];
		
		for(int i = 0; i < jmena.length; i++){
			tlac[i] = new Tlacitko(jmena[i], i);
			tlac[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i;
					for(i = 0; i < jmena.length; i++){
					
						if((e.getActionCommand()).compareTo(jmena[i]) == 0)
							break;
					}
					VsechnyKomponenty.pocetVolaniUsecky = 0;
					
					VyberModu.vyberModu.setSelectedCheckbox(VyberModu.jednotlivyMod[i]);
					KontrolniVypis.resetvypisu();
					if(VsechnyKomponenty.kteryKomponent != null){
						if(VsechnyKomponenty.kteryKomponent.dialog != null){
							if(VsechnyKomponenty.kteryKomponent.dialog.isVisible()){
						VsechnyKomponenty.kteryKomponent.dialog.setVisible(false);
						VsechnyKomponenty.kteryKomponent = null;
							}
						}
					}
				}
			});
				
			
		}
		
		
		gbc.gridx = 0; gbc.gridy = 0; gbc.insets = new Insets(10,5,0,5); gbc.weightx = 1.0; gbc.fill = GridBagConstraints.HORIZONTAL;  
		
		for(int i = 0; i < tlac.length; i++){
			gbl.setConstraints(tlac[i], gbc);
			this.add(tlac[i]);
			(gbc.gridy)++;
		}	
	}
	
}
