package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.AbstractAction;

import View.MainFrame;
import View.StokKarti;
import View.StokKartiListesi;

public class StokKartiMenuChangeCommand {

	private MainFrame view;
	
	public StokKartiMenuChangeCommand(MainFrame _view) throws ParseException {
		
		
		this.view = _view;
		StokKarti stokKarti= new StokKarti();
		StokKartiListesi stokKartiListesi = new StokKartiListesi();
		
		
		view.stokKartClick(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.add(stokKarti);
				stokKarti.show();
				stokKarti.setClosable(true);
				
			}
		});
		
		view.stokKartiListesiClick(new  ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				view.add(stokKartiListesi);
				stokKartiListesi.show();
				stokKartiListesi.setClosable(true);
				
			}});
		
		
		view.pdfOlusturClick(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				StokKartiCreatePdfCommand pdf = new StokKartiCreatePdfCommand();
				
			}
		});
		
		
		
	}
	
}
