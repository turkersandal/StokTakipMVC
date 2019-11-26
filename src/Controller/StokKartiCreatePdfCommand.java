package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Model.ModelStokKarti;

public class StokKartiCreatePdfCommand {

	
	
	public StokKartiCreatePdfCommand() {
		
		try {

     		ModelStokKarti card = new ModelStokKarti();
     		ArrayList<ModelStokKarti> cardList = new ArrayList<ModelStokKarti>();
     		cardList = card.list();
     		
     		
     		Document my_pdf_report = new Document();
			PdfWriter.getInstance(my_pdf_report, new FileOutputStream("C:\\Users\\TurkerSandal\\Desktop\\pdf_table.pdf"));
			my_pdf_report.open();            
	        PdfPTable my_report_table = new PdfPTable(8);
	        PdfPCell table_cell =new PdfPCell();
	        
	         for(int i = 0;i<cardList.size();i++) {
	        	 
			         table_cell=new PdfPCell(new Phrase(cardList.get(i).getStokKodu()));
			         my_report_table.addCell(table_cell);
			         
			         table_cell=new PdfPCell(new Phrase(cardList.get(i).getStokAdi()));
			         my_report_table.addCell(table_cell);
			       
			         table_cell=new PdfPCell(new Phrase(cardList.get(i).getStokTipi().toString()));
			         my_report_table.addCell(table_cell);
			        
			         table_cell=new PdfPCell(new Phrase(cardList.get(i).getStokBirimi()));
			         my_report_table.addCell(table_cell);
			         
			         table_cell=new PdfPCell(new Phrase(cardList.get(i).getBarkod()));
			         my_report_table.addCell(table_cell);
			         
			         table_cell=new PdfPCell(new Phrase(cardList.get(i).getKdvTipi().toString()));
			         my_report_table.addCell(table_cell);
			       
			         table_cell=new PdfPCell(new Phrase(cardList.get(i).getAciklama()));
			         my_report_table.addCell(table_cell);
			        
			         table_cell=new PdfPCell(new Phrase(cardList.get(i).getTarih()));
			         my_report_table.addCell(table_cell);
	         
	         }
	         my_pdf_report.add(my_report_table); 
	         my_pdf_report.close();
	         JOptionPane.showMessageDialog(null,"Pdf Baþarýyla Oluþturulmuþtur...");
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
