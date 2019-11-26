package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.ModelStokKarti;
import View.StokKarti;

public class StokKartiUpdateCommand implements ActionListener{

	private StokKarti view;
	private ModelStokKarti model;
	
	public StokKartiUpdateCommand(StokKarti  _view,ModelStokKarti  _model) {
		
		this.view =_view;
		this.model =_model;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			if(view.checkSpace()) {
			model.setguncelStokKodu(view.getTxtStokKodu());
			model.setStokAdi(view.getTxtStokAdi());
			model.setStokTipi(view.getCmbStokTipi());
			model.setStokBirimi(view.getCmbStokBirimi());
			model.setBarkod(view.getBarkod());
			model.setKdvTipi(view.getCmbKdvTipi());
			model.setAciklama(view.getTxtAciklama());
			model.setTarih(view.getTxtTarih());
			model.setStokKodu(view.getTxtAra());
			
			model.update();
			}else {
				
				JOptionPane.showMessageDialog(null, "Lütfen Arama Ýþlemini Gerçekleþtirdikten Sonra Güncelleme Ýþlemini Uygulayýnýz!");
				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		view.clear();
		
		
	}

}
