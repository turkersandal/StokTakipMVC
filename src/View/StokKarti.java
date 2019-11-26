package View;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;

import Controller.StokKartiCopyCommand;
import Controller.StokKartiDeleteCommand;
import Controller.StokKartiGetDateCommand;
import Controller.StokKartiSaveCommand;
import Controller.StokKartiSearchCommand;
import Controller.StokKartiUpdateCommand;
import Model.ModelStokKarti;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JButton;

public class StokKarti extends JInternalFrame {
	public JTextField txtStokKodu;
	private JTextField txtStokAdi;
	private JTextField txtBarkod;
	private JTextField txtAra;
	private JFormattedTextField txtTarih;
	private JTextArea txtAciklama;
	private JComboBox cmbStokTipi;
	private JComboBox cmbStokBirimi;
	private JComboBox cmbKdvTipi;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDel;
	private JButton btnCopy;
	private JButton btnSearch;
	private JButton btnGetDate;
	 
 
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
				StokKarti frame = new StokKarti();
				frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public StokKarti() throws ParseException {
		setClosable(true);
		
		ModelStokKarti model = new ModelStokKarti();
		
		StokKartiSaveCommand    saveC    = new StokKartiSaveCommand(this,model);
		StokKartiUpdateCommand  updateC  = new StokKartiUpdateCommand(this,model);
		StokKartiSearchCommand  searchC  = new StokKartiSearchCommand(this,model);
		StokKartiDeleteCommand  deleteC  = new StokKartiDeleteCommand(this,model);
		StokKartiCopyCommand    copyC    = new StokKartiCopyCommand(this,model);
		StokKartiGetDateCommand getDateC = new StokKartiGetDateCommand(this);
		setBounds(100, 100, 307, 467);
		
		//--------------TextFields---------------
		txtStokKodu = new JTextField();
		txtStokKodu.setBounds(80, 11, 196, 20);
		txtStokKodu.setColumns(10);
		txtStokAdi = new JTextField();
		txtStokAdi.setBounds(80, 42, 196, 20);
		txtStokAdi.setColumns(10);
		txtAra = new JTextField();
		txtAra.setBounds(10, 414, 271, 20);
		txtAra.setColumns(10);
		txtBarkod = new JTextField();
		txtBarkod.setBounds(80, 135, 196, 20);
		txtBarkod.setColumns(10);
		txtTarih = new JFormattedTextField(new MaskFormatter("####-##-## ##:##:##"));
		txtTarih.setBounds(80, 259, 196, 20);
		txtAciklama = new JTextArea();
		txtAciklama.setBounds(80, 197, 196, 56);
		
		
		//-------------------Labels--------------
		JLabel lblStokKodu = new JLabel("Stok Kodu");
		lblStokKodu.setBounds(10, 14, 60, 14);
		JLabel lblStokAdi = new JLabel("Stok Adi");
		lblStokAdi.setBounds(10, 45, 48, 14);
		JLabel lblNewLabel = new JLabel("Stok Birimi");
		lblNewLabel.setBounds(10, 107, 71, 14);
		JLabel lblStokTipi = new JLabel("Stok Tipi");
		lblStokTipi.setBounds(10, 76, 60, 14);
		JLabel lblBarkodu = new JLabel("Barkodu");
		lblBarkodu.setBounds(10, 138, 60, 14);
		JLabel lblKdvTipi = new JLabel("KDV Tipi");
		lblKdvTipi.setBounds(10, 169, 52, 14);
		JLabel lblAklama = new JLabel("A\u00E7\u0131klama");
		lblAklama.setBounds(10, 197, 71, 14);
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setBounds(10, 262, 44, 14);
		JLabel lblAranacakrnnStok = new JLabel("Aranacak \u00DCr\u00FCn\u00FCn Stok Kodunu Giriniz");
		lblAranacakrnnStok.setBounds(10, 394, 266, 14);
		
		//------------ComboBoxes------------
		Integer tip[] = new Integer [2];
		tip[0]=1;
		tip[1]=2;
	    cmbStokTipi = new JComboBox(tip);
	    cmbStokTipi.setBounds(80, 73, 196, 20);
	    
	    String birim []  = {"desi","kg","koli"}; 
		cmbStokBirimi = new JComboBox(birim);
		cmbStokBirimi.setBounds(80, 104, 196, 20);
		
		Double kdv[] = new Double [3];
		kdv[0]=0.01;
		kdv[1]=0.08;
		kdv[2]=0.18;
		cmbKdvTipi = new JComboBox(kdv);
		cmbKdvTipi.setBounds(80, 166, 196, 20);
		
		//--------------Buttons-----------------------
		 btnSave = new JButton("KAYDET");
		 btnSave.setBounds(10, 297, 132, 23);
		 btnSave.addActionListener(saveC);
		 
		 
		 btnUpdate = new JButton("G\u00DCNCELLE");
		 btnUpdate.setBounds(152, 297, 124, 23);
		 btnUpdate.addActionListener(updateC);
		 
		 btnDel = new JButton("S\u0130L");
		 btnDel.setBounds(152, 331, 124, 23);
		 btnDel.addActionListener(deleteC);
		 
		 btnCopy = new JButton("KOPYALA");
		 btnCopy.setBounds(10, 331, 132, 23);
		 btnCopy.addActionListener(copyC);
		 
		 btnSearch = new JButton("ARA");
		 btnSearch.setBounds(10, 365, 132, 23);
		 btnSearch.addActionListener(searchC);
		 
		 btnGetDate = new JButton("TAR\u0130H AL");
		 btnGetDate.setBounds(152, 365, 124, 23);
		 btnGetDate.addActionListener(getDateC);
		
		 
		getContentPane().setLayout(null);
		getContentPane().add(txtAra);
		getContentPane().add(lblStokKodu);
		getContentPane().add(lblStokAdi);
		getContentPane().add(lblStokTipi);
		getContentPane().add(lblNewLabel);
		getContentPane().add(lblBarkodu);
		getContentPane().add(lblKdvTipi);
		getContentPane().add(lblTarih);
		getContentPane().add(lblAklama);
		getContentPane().add(txtTarih);
		getContentPane().add(txtAciklama);
		getContentPane().add(cmbKdvTipi);
		getContentPane().add(txtBarkod);
		getContentPane().add(cmbStokBirimi);
		getContentPane().add(cmbStokTipi);
		getContentPane().add(txtStokAdi);
		getContentPane().add(txtStokKodu);
		getContentPane().add(btnSearch);
		getContentPane().add(btnCopy);
		getContentPane().add(btnSave);
		getContentPane().add(btnDel);
		getContentPane().add(btnUpdate);
		getContentPane().add(lblAranacakrnnStok);
		getContentPane().add(btnGetDate);
		
		

	}
	//----------------GettersAndSetters-----------
	public String getTxtStokKodu() {
		
		return this.txtStokKodu.getText().trim();
	}
	public void setTextStokKodu(String stokAdi) {
		
		this.txtStokKodu.setText(stokAdi);
	}
	public String getTxtStokAdi() {
		
		return this.txtStokAdi.getText().trim();
	}
	public void setTextStokAdi(String stokAdi) {
		
		this.txtStokAdi.setText(stokAdi);
	}
	public Integer getCmbStokTipi() {
		
		return Integer.valueOf(this.cmbStokTipi.getSelectedItem().toString());
	}
	public void setCmbStokTipi(Integer stokTipi) {
		
		this.cmbStokTipi.setSelectedItem(stokTipi);
	}
	
	public String getCmbStokBirimi() {
		
		return  this.cmbStokBirimi.getSelectedItem().toString();
	}
	public void setCmbStokBirimi(String stokBirimi) {
		
		this.cmbStokBirimi.setSelectedItem(stokBirimi);
	}
	public String getBarkod() {
		
		return this.txtBarkod.getText().trim();
	}
	public void setBarkod(String stokAdi) {
		
		this.txtBarkod.setText(stokAdi);
	}
	public Double getCmbKdvTipi() {
		
		return Double.valueOf(this.cmbKdvTipi.getSelectedItem().toString());
	}
	public void setCmbKdvTipi(Double kdv) {
		
		this.cmbKdvTipi.setSelectedItem(kdv);
	}
	
	public String getTxtAciklama() {
		
		return this.txtAciklama.getText().trim();
	}
	public void setTextAciklama(String aciklama) {
		
		this.txtAciklama.setText(aciklama);
	}
	
	public String getTxtTarih() {
		
		return this.txtTarih.getText().trim();
	}
	public void setTextTarih(String tarih) {
		
		this.txtTarih.setText(tarih);
	}
	public String getTxtAra() {
		
		return this.txtAra.getText();
	}
	public void setTextAra(String tarih) {
		
		this.txtAra.setText(tarih);
	}
	public void clear() {
		this.txtStokKodu.setText("");
		this.txtStokAdi.setText("");
		this.txtBarkod.setText("");
		this.txtAciklama.setText("");
		this.txtTarih.setText("");
		
	}
	public boolean checkSpace() {
		
	if(this.txtStokKodu.getText().trim().isEmpty() && this.txtStokAdi.getText().trim().isEmpty() 
			&& this.txtBarkod.getText().trim().isEmpty() && this.txtBarkod.getText().trim().isEmpty()) {
		return false;
	}else 
	  {
		return true;
	  }
	}
}
