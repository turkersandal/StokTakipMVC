package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.ModelStokKarti;
import View.StokKarti;
import View.StokKartiListesi;

public class StokKartiListCommand implements ActionListener  {
	
	private StokKartiListesi view;
	private ModelStokKarti model;
	
	public StokKartiListCommand(StokKartiListesi  _view,ModelStokKarti  _model) {
		
		this.view =_view;
		this.model =_model;
		
		retreiveData();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		retreiveData();
		
	}
	
	public void retreiveData() {
		
		ArrayList<ModelStokKarti> cardList = new ArrayList<ModelStokKarti>();
		cardList = model.list();
		DefaultTableModel model = (DefaultTableModel)view.getTable().getModel();
		model.setNumRows(0);
		try {
			
		for(int i =0;i<cardList.size();i++) {
			
				Object [] rows = new Object[8];
				rows[0]=(cardList.get(i).getStokKodu());
				rows[1]=(cardList.get(i).getStokAdi());
				rows[2]=(cardList.get(i).getStokBirimi());
				rows[3]=(cardList.get(i).getStokTipi());
				rows[4]=(cardList.get(i).getBarkod());
				rows[5]=(cardList.get(i).getKdvTipi());
				rows[6]=(cardList.get(i).getAciklama());
				rows[7]=(cardList.get(i).getTarih());
				
				model.addRow(rows);
		}
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	


