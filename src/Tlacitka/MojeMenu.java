package Tlacitka;

import java.awt.*;
import java.awt.event.*;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import Iridium_Geometry.Iridium_Geometry;
import Komponenty.Usecka;
import Komponenty.VsechnyKomponenty;
import Konstanty.Konstanty;
import Konstanty._2Dsouradnice;
import Obrazovka.PanelSTlacitky;
import Vlastnosti_komponentu.Vlastnosti;

public class MojeMenu extends MenuBar{
	public Menu zobrazit, vlastnosti;
	public CheckboxMenuItem osaX, osaY, mrizoveBody, skryteBody;
	public MenuItem[] vlastnostiKomponent;
	public Dialog dialogVlastnosti;
	
	public MojeMenu(){
		super();		 
		zobrazit = new Menu("Zobrazit");
		vlastnosti = new Menu("Vlastnosti");
		osaX = new CheckboxMenuItem("Osa X", false);
		osaY = new CheckboxMenuItem("Osa Y", false);
		mrizoveBody = new CheckboxMenuItem("Møížové body", false);
		skryteBody = new CheckboxMenuItem("Skryté komponenty");
		
		this.add(zobrazit);
		zobrazit.add(osaX);
		zobrazit.add(osaY);
		zobrazit.add(mrizoveBody);
		zobrazit.add(skryteBody);
		
		vlastnostiKomponent = new MenuItem[6];
		for(int i = 1; i < 7; i++){
			vlastnostiKomponent[i-1] = new MenuItem(VyberModu.nazvyTlacitek[i]);
			vlastnosti.add(vlastnostiKomponent[i - 1]);
			vlastnostiKomponent[i - 1].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {					
					TextField nazevSkupinyKomponentu;
					Panel pan1, pan2;
					GridBagLayout gbl = new GridBagLayout();
					GridBagConstraints gbc = new GridBagConstraints();	
					int i = 0;
					
					for(i =0; i < Vlastnosti.vlastnosti.length; i++){
						if(Vlastnosti.vlastnosti[i].getJmeno() == e.getActionCommand()){
							
							break;
						}
					}
					
					dialogVlastnosti = new Dialog(Iridium_Geometry.okno, "Nastavení vlastností", false);
					dialogVlastnosti.setLayout(gbl);
					dialogVlastnosti.setLocation(100, 50);
					
					
					gbc.gridwidth = 2; gbc.weightx = 1.;gbc.fill = GridBagConstraints.HORIZONTAL;
					nazevSkupinyKomponentu = new TextField(e.getActionCommand() + ": ");
					gbl.setConstraints(nazevSkupinyKomponentu, gbc);
					dialogVlastnosti.add(nazevSkupinyKomponentu);
					nazevSkupinyKomponentu.setEditable(false);
					
					final TextField  opravdovaBarva = new TextField();		//komponenta s vyslednou barvou v pozadi z pan1
					final CheckboxGroup radio = new CheckboxGroup();		//komponenta zachycujici styl cary z pan2
					final TextField vysledekSila = new TextField();			//komponenta zachycujici silu cary z pan3
					
					pan1 = new Panel();					
					{	
						
						GridBagLayout gbll = new GridBagLayout();
						pan1.setLayout(gbll);
						GridBagConstraints gbcc = new GridBagConstraints();
						TextField barva = new TextField("Barva: ");
						
						final Scrollbar red = new Scrollbar(Scrollbar.HORIZONTAL, Vlastnosti.vlastnosti[i].getBarva().getRed(),1, 0, 256), green = new Scrollbar(Scrollbar.HORIZONTAL, Vlastnosti.vlastnosti[i].getBarva().getGreen(), 1, 0, 256);
						final Scrollbar blue = new Scrollbar(Scrollbar.HORIZONTAL, Vlastnosti.vlastnosti[i].getBarva().getBlue(), 1, 0, 256);
						final TextField cervena = new TextField(), zelena = new TextField(), modra = new TextField();
						TextField R = new TextField("R"), G = new TextField("G"), B = new TextField("B");
						R.setEditable(false); G.setEditable(false);B.setEditable(false);R.setBackground(new Color(255,255,255));G.setBackground(new Color(255,255,255));
						B.setBackground(new Color(255,255,255));
						
						barva.setEditable(false);
						gbcc.gridwidth = 1; gbcc.weightx = 1.; gbcc.fill = GridBagConstraints.HORIZONTAL;
						gbll.setConstraints(barva, gbcc);
						pan1.add(barva);
						gbcc.gridx = 1;
						gbll.setConstraints(opravdovaBarva,gbcc);
						pan1.add(opravdovaBarva);
						
						opravdovaBarva.setBackground(Vlastnosti.vlastnosti[i].getBarva());
						
						
						red.setPreferredSize(new Dimension(200, 20));
						gbcc.fill = gbcc.HORIZONTAL; gbcc.weightx = 1;gbcc.gridy = 1; gbcc.gridwidth = 1;gbcc.gridx = 0;
						gbll.setConstraints(red,gbcc);
						pan1.add(red);
						red.addAdjustmentListener(new AdjustmentListener() {							
							public void adjustmentValueChanged(AdjustmentEvent arg0) {
								cervena.setText(arg0.getValue() + "");
								opravdovaBarva.setBackground(new Color(red.getValue(),green.getValue(), blue.getValue()));
							}
						});
						
						green.setPreferredSize(new Dimension(200, 20));
						gbcc.gridy = 2;
						gbll.setConstraints(green, gbcc);
						pan1.add(green);
						green.addAdjustmentListener(new AdjustmentListener() {							
							public void adjustmentValueChanged(AdjustmentEvent arg0) {								
								zelena.setText(arg0.getValue() + "");
								opravdovaBarva.setBackground(new Color(red.getValue(),green.getValue(), blue.getValue()));
							}
						});
						
						
						blue.setPreferredSize(new Dimension(200,20));
						gbcc.gridy = 3;
						gbll.setConstraints(blue, gbcc);
						pan1.add(blue);
						blue.addAdjustmentListener(new AdjustmentListener() {							
							public void adjustmentValueChanged(AdjustmentEvent e) {
								modra.setText(e.getValue() + "");
								opravdovaBarva.setBackground(new Color(red.getValue(),green.getValue(), blue.getValue()));
							}
						});						
						
						cervena.setText(red.getValue() + "");
						gbcc.gridx = 1; gbcc.gridy =1;// gbcc.weightx = 0; gbcc.fill= gbcc.NONE;
						gbll.setConstraints(cervena,gbcc);
						pan1.add(cervena);
						cervena.setEditable(false);
						
						zelena.setText(green.getValue() + "");
						gbcc.gridx = 1; gbcc.gridy = 2;
						gbll.setConstraints(zelena, gbcc);
						pan1.add(zelena);
						zelena.setEditable(false);
						
						modra.setText(blue.getValue() + "");
						gbcc.gridx = 1; gbcc.gridy = 3;
						gbll.setConstraints(modra, gbcc);
						pan1.add(modra);
						modra.setEditable(false);
						
						gbcc.gridx = 2;	gbcc.gridy = 1; 
						gbll.setConstraints(R,gbcc);
						pan1.add(R);
						
						gbcc.gridy = 2;
						gbll.setConstraints(G,gbcc);
						pan1.add(G);
						
						gbcc.gridy = 3;
						gbll.setConstraints(B,gbcc);
						pan1.add(B);						
					}
					
					
					gbc.gridy = 1; gbc.gridwidth = 1; gbc.weightx = 0;gbc.fill = GridBagConstraints.NONE;gbc.insets = new Insets(20, 10, 10, 10);
					gbl.setConstraints(pan1, gbc);
					dialogVlastnosti.add(pan1);
					
					
					pan2 = new Panel();
					if(Vlastnosti.vlastnosti[i].getJmeno() != Vlastnosti.vlastnosti[0].getJmeno())
					{
						final class Platynka extends Canvas{
							private Usecka pomocnaUsecka;
							private int styl;
							public Platynka(Usecka usecka, int styll){
								super();
								this.setPreferredSize(new Dimension(200, 20));
								this.setBackground(new Color(255,255,255));
								pomocnaUsecka = usecka;
								styl = styll;
							}
							public void paint(Graphics g){
								if(styl == 0){
									g.drawLine(Konstanty.Zaokrouhli(pomocnaUsecka.prv.x),Konstanty.Zaokrouhli(pomocnaUsecka.prv.y), Konstanty.Zaokrouhli(pomocnaUsecka.dru.x), Konstanty.Zaokrouhli(pomocnaUsecka.dru.y));
								}else
									if(styl == 1){
										pomocnaUsecka.vykresliDotted(g);
									}
									else
										if(styl == 2)
								pomocnaUsecka.vykresliCerchovana(g);
							}							
						}
						
						GridBagLayout gbll = new GridBagLayout();
						GridBagConstraints gbcc = new GridBagConstraints();
						pan2.setLayout(gbll);
						Usecka usecka = new Usecka(new _2Dsouradnice(0, 10), new _2Dsouradnice(199, 10), VyberModu.nazvyTlacitek[2]);
						Platynka full = new Platynka(usecka, 0),  dotted =new Platynka(usecka,1), cerchovana =new Platynka(usecka,2);
						
						Checkbox[] stylCar = new Checkbox[3];
						TextField stylTxt = new TextField("Styly èar: ");
						
						stylTxt.setEditable(false);
						
						gbcc.gridwidth = 2;gbcc.weightx = 1.; gbcc.fill = gbcc.HORIZONTAL;
						gbll.setConstraints(stylTxt, gbcc);
						pan2.add(stylTxt);		
						
						
						gbcc.gridy = 1; gbcc.gridwidth = 1;gbcc.weightx = 0.; gbcc.fill = gbcc.NONE;
						gbll.setConstraints(full, gbcc);
						pan2.add(full);
						
						
						
						gbcc.gridy = 2;
						gbll.setConstraints(dotted, gbcc);
						pan2.add(dotted);
						
						gbcc.gridy = 3;
						gbll.setConstraints(cerchovana,gbcc);
						pan2.add(cerchovana);
						
						stylCar[0] = new Checkbox("", radio, Vlastnosti.vlastnosti[i].getCaraStyl() == Vlastnosti.typyCarStyl[1]);	stylCar[1] = new Checkbox("", radio, Vlastnosti.vlastnosti[i].getCaraStyl() == Vlastnosti.typyCarStyl[2]); stylCar[2] = new Checkbox("", radio,Vlastnosti.vlastnosti[i].getCaraStyl() == Vlastnosti.typyCarStyl[3]); 				
							stylCar[0].setName(Vlastnosti.typyCarStyl[1]); stylCar[1].setName(Vlastnosti.typyCarStyl[2]); stylCar[2].setName(Vlastnosti.typyCarStyl[3]); 
							gbcc.gridx = 1; gbcc.gridy = 1;
							gbll.setConstraints(stylCar[0], gbcc);
							pan2.add(stylCar[0]);
							
							gbcc.gridy = 2;
							gbll.setConstraints(stylCar[1], gbcc);
							pan2.add(stylCar[1]);
							
							gbcc.gridy = 3;
							gbll.setConstraints(stylCar[2],gbcc);
							pan2.add(stylCar[2]);
					}
					
					if(Vlastnosti.vlastnosti[i].getJmeno() != Vlastnosti.vlastnosti[0].getJmeno()){
					gbc.gridx = 1;
					gbl.setConstraints(pan2, gbc);
					dialogVlastnosti.add(pan2);}
					
					Panel pan3 = new Panel();
					
					if(Vlastnosti.vlastnosti[i].getJmeno() != Vlastnosti.vlastnosti[0].getJmeno())
					{
						final TextField silaCary = new TextField("Síla èáry: "); vysledekSila.setText(Vlastnosti.vlastnosti[i].getCaraSila());
						Scrollbar silaCarryScroll = new Scrollbar(Scrollbar.HORIZONTAL,Integer.parseInt(Vlastnosti.vlastnosti[i].getCaraSila()), 1, 0, 11);
						silaCary.setEditable(false); vysledekSila.setEditable(false);
						
						silaCarryScroll.setPreferredSize(new Dimension(200, 20));
						
						GridBagLayout gbll = new GridBagLayout();
						GridBagConstraints gbcc = new GridBagConstraints();
						pan3.setLayout(gbll);
						
						gbcc.gridwidth = 2; gbcc.weightx = 1.; gbcc.fill = gbcc.HORIZONTAL;
						gbll.setConstraints(silaCary, gbcc);
						pan3.add(silaCary);
						
						gbcc.gridy = 1; gbcc.gridwidth = 1; gbcc.weightx = 0; gbcc.fill = gbcc.NONE;
						gbll.setConstraints(silaCarryScroll, gbcc);
						pan3.add(silaCarryScroll);
						
						gbcc.gridx = 1;
						gbll.setConstraints(vysledekSila, gbcc);
						pan3.add(vysledekSila);
						
						silaCarryScroll.addAdjustmentListener(new AdjustmentListener() {
							public void adjustmentValueChanged(AdjustmentEvent e) {
								vysledekSila.setText(e.getValue() + "");
								
							}
						});
					}
					if(Vlastnosti.vlastnosti[i].getJmeno() != Vlastnosti.vlastnosti[0].getJmeno()){
					gbc.gridx = 0; gbc.gridy += 1;
					gbl.setConstraints(pan3, gbc);
					dialogVlastnosti.add(pan3);
					}
					
					Panel pan4 = new Panel(new FlowLayout());
					{
						final int k = i;
						Button okbutton = new Button("Ok"), zavritButton = new Button("Zavøít");
						pan4.add(zavritButton);
						pan4.add(okbutton);
						okbutton.setPreferredSize(new Dimension(100,30));
						zavritButton.setPreferredSize(new Dimension(100,30));
						
						
						okbutton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
																								
								Vlastnosti.vlastnosti[k].setBarva(opravdovaBarva.getBackground());
								if(Vlastnosti.vlastnosti[k].getJmeno() != Vlastnosti.vlastnosti[0].getJmeno()){
									Vlastnosti.vlastnosti[k].setCaraStyl(radio.getSelectedCheckbox().getName());
									Vlastnosti.vlastnosti[k].setCaraSila(vysledekSila.getText());									
								}
								VsechnyKomponenty.zmena.Prekresli(true);
							}
						});
						
						zavritButton.addActionListener(new ActionListener() {							
							public void actionPerformed(ActionEvent arg0) {							
								dialogVlastnosti.setVisible(false);
								dialogVlastnosti = null;
							}
						});
						
					}
					if((Vlastnosti.vlastnosti[i].getJmeno() != Vlastnosti.vlastnosti[0].getJmeno()))
					gbc.gridx +=1;
					gbl.setConstraints(pan4, gbc);
					dialogVlastnosti.add(pan4);	
					
					
					dialogVlastnosti.pack();
					dialogVlastnosti.setVisible(true);
					
					dialogVlastnosti.addWindowFocusListener(new WindowFocusListener() {						
						public void windowLostFocus(WindowEvent arg0) {
							if(dialogVlastnosti != null){
								dialogVlastnosti.setVisible(false);
								dialogVlastnosti = null;
							}
						}
						public void windowGainedFocus(WindowEvent arg0) {														
						}
					});
					
					dialogVlastnosti.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent arg0) {
							if(dialogVlastnosti != null){
								dialogVlastnosti.setVisible(false);
								dialogVlastnosti = null;
							}							
						}
					});
					
					
				}
			});
		}
		this.add(vlastnosti);
		
		skryteBody.addItemListener(new ItemListener() {
			
			
			public void itemStateChanged(ItemEvent e) {
				VsechnyKomponenty.ZobrazSkryteKomponenty = skryteBody.getState();
				if(skryteBody.getState() == true)
					VsechnyKomponenty.zmena.Prekresli();
				else
					VsechnyKomponenty.zmena.Prekresli(true);
			}
		});
		
		osaX.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				Iridium_Geometry.platno.komponents.osaX.viditelnost = osaX.getState();					
				if(osaX.getState() == true)
				VsechnyKomponenty.zmena.Prekresli();
				else
					VsechnyKomponenty.zmena.Prekresli(true);
			}
			
			
		});		
		
		osaY.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				Iridium_Geometry.platno.komponents.osaY.viditelnost = osaY.getState();
								
				if(osaY.getState() == true)
				VsechnyKomponenty.zmena.Prekresli();
				else
					VsechnyKomponenty.zmena.Prekresli(true);
			}
			
			
		});
		mrizoveBody.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				Iridium_Geometry.platno.komponents.mrizoveBody.viditelnost = mrizoveBody.getState();				
				
				VsechnyKomponenty.zmena.Prekresli(true);				
			}
			
		});
	}
	
	
}
