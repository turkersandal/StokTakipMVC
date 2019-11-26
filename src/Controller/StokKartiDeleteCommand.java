package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.ModelStokKarti;
import View.StokKarti;

public class StokKartiDeleteCommand implements ActionListener {

	private StokKarti view;
	private ModelStokKarti model;
	
	public StokKartiDeleteCommand(StokKarti  _view,ModelStokKarti  _model) {
		
		this.view =_view;
		this.model =_model;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			if(view.checkSpace()) {
				
			model.setStokKodu(view.getTxtAra());
			model.delete();
			
			}else {
				
				JOptionPane.showMessageDialog(null, "Lütfen Arama Ýþlemini Gerçekleþtirdikten Sonra Silme Ýþlemini Uygulayýnýz");
				
			}
		} catch (Exception e1) {
			
		}
		view.clear();
		
	}
	
}
