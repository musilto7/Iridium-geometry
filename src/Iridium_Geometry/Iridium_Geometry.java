package Iridium_Geometry;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import Obrazovka.*;
import Tlacitka.MojeMenu;
import Vlastnosti_komponentu.Vlastnosti;

public class Iridium_Geometry {
	public static Frame okno;
	public static Toolkit t;
	private ScrollPane ScPanel;
	public static Platno platno;
	private PanelSTlacitky panelSTlacitky;
	public Panel spodniPanelProVypis;
	public static KontrolniVypis vypis;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	public static MojeMenu menu;
	
	public Iridium_Geometry(){		
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		t = Toolkit.getDefaultToolkit();
		okno = new Frame(getClass().getName().substring(0,(getClass().getName().indexOf("."))));
		okno.setLayout(gbl);
		okno.setSize((int)(t.getScreenSize().getWidth() - t.getScreenInsets(okno.getGraphicsConfiguration()).left - t.getScreenInsets(okno.getGraphicsConfiguration()).right), (int)(t.getScreenSize().getHeight()-t.getScreenInsets(okno.getGraphicsConfiguration()).bottom-t.getScreenInsets(okno.getGraphicsConfiguration()).top));	
		
		
		ScPanel = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		platno = new Platno(t);
		ScPanel.add(platno);
		
		gbc.weightx = 1.; gbc.weighty = 1;gbc.gridy = 0;  gbc.gridx = 1; gbc.fill = GridBagConstraints.BOTH; 
		gbl.setConstraints(ScPanel, gbc);
		okno.add(ScPanel);
		
		
		panelSTlacitky = new PanelSTlacitky();		
		
		menu = new MojeMenu();
		okno.setMenuBar(menu);
		
		gbc.weightx = 0;gbc.weighty = 1.0;gbc.gridy = 0; gbc.gridx = 0; gbc.gridheight = 2;
		gbl.setConstraints(panelSTlacitky, gbc);
		okno.add(panelSTlacitky);			
		
		spodniPanelProVypis = new Panel(gbl);		
		
		
		vypis = new KontrolniVypis();
		gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 1; gbc.weighty = 0;
		gbl.setConstraints(vypis, gbc);
		spodniPanelProVypis.add(vypis);
		gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 1; gbc.gridheight = 1;gbc.weighty = 0;gbl.setConstraints(spodniPanelProVypis, gbc);
		okno.add(spodniPanelProVypis);		
		okno.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});
	}
	public void NastavScrollPaneNaStred(){
		ScPanel.setScrollPosition(platno.getWidth()/3, platno.getHeight()/3);
	}
	
	public static Dimension GetPlatnoSize(){
		return platno.getSize();
	}	
}
