package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.ModelStokKarti;
import View.StokKarti;



public class StokKartiSaveCommand implements ActionListener{
	
	private StokKarti view;
	private ModelStokKarti model;
	
	
	public StokKartiSaveCommand(StokKarti _view,ModelStokKarti _model){
		
		this.model = _model;
		this.view = _view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		try {
			if(view.checkSpace()) {
				
			model.setStokKodu(view.getTxtStokKodu());
			model.setStokAdi(view.getTxtStokAdi());
			model.setStokBirimi(view.getCmbStokBirimi());
			model.setStokTipi(view.getCmbStokTipi());
			model.setBarkod(view.getBarkod());
			model.setKdvTipi(view.getCmbKdvTipi());
			model.setAciklama(view.getTxtAciklama());
			model.setTarih(view.getTxtTarih());
			model.insert();
			
			}else {
				JOptionPane.showMessageDialog(null, "Lütfen Gerekli Tüm Alanlarý Doldurunuz!");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    view.clear();
		
	}
}
