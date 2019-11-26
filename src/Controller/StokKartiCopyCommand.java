package Controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.ModelStokKarti;
import View.StokKarti;

public class StokKartiCopyCommand implements ActionListener {
	
	private StokKarti view;
	private ModelStokKarti model;
	
	public StokKartiCopyCommand(StokKarti  _view,ModelStokKarti  _model) {
		
		this.view =_view;
		this.model =_model;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 try {
			 
			 if(view.checkSpace()) {
			 
			 String newStockCode = JOptionPane.showInputDialog(view, "Yeni Stok Kodu Giriniz!");
			 model.setStokKodu(newStockCode);
			 model.setStokAdi(view.getTxtStokAdi());
			 model.setStokBirimi(view.getCmbStokBirimi());
			 model.setStokTipi(view.getCmbStokTipi());
			 model.setBarkod(view.getBarkod());
			 model.setKdvTipi(view.getCmbKdvTipi());
			 model.setAciklama(view.getTxtAciklama());
			 model.setTarih(view.getTxtTarih());
			 model.insert();
	
			 
			 }else {
				 JOptionPane.showMessageDialog(null, "Lütfen Arama Ýþlemini Gerçekleþtirdikten sonra Kopyalama Ýþlemini Uygulayýnýz!!!");
			 }
		} catch (HeadlessException e1) {
		
		}
		 view.clear();
		
	}
}
