package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.ModelStokKarti;
import View.StokKarti;

public class StokKartiSearchCommand implements ActionListener {
	
	private StokKarti view;
	private ModelStokKarti model;
	
	public StokKartiSearchCommand(StokKarti  _view,ModelStokKarti  _model) {
		
		this.view =_view;
		this.model =_model;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
			if(!view.getTxtAra().equals("")) {
			model.setStokKodu(view.getTxtAra());
			ArrayList<ModelStokKarti> cardList = new ArrayList<ModelStokKarti>();
			cardList = model.search();
			
			view.setTextStokKodu(cardList.get(0).getStokKodu());
			view.setTextStokAdi(cardList.get(0).getStokAdi());
			view.setCmbStokBirimi(cardList.get(0).getStokBirimi());
			view.setCmbStokTipi(cardList.get(0).getStokTipi());
			view.setBarkod(cardList.get(0).getBarkod());
			view.setCmbKdvTipi(cardList.get(0).getKdvTipi());
			view.setTextAciklama(cardList.get(0).getAciklama());
			view.setTextTarih(cardList.get(0).getTarih());
			
			
			}else {
				
				JOptionPane.showMessageDialog(null, "Lütfen Aranacak Ürünün StokKodunu Giriniz");
				
			}
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Girilen Stok Koduna Ait Ürün Bulunamadý!");
		
		}
		
		
		
		
	}

}
