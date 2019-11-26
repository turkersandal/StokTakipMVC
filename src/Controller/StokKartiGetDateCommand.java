package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import View.StokKarti;

public class StokKartiGetDateCommand implements ActionListener{

	private StokKarti view;
	
	
	public StokKartiGetDateCommand(StokKarti _view) {
		
		this.view = _view;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		view.setTextTarih(formatter.format(date));
		
	}

	
	
}
