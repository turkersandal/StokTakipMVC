package View;


import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.StokKartiMenuChangeCommand;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JButton;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JMenuItem mn�tmStokKartListesi;
	private JMenuItem mn�tmStokKart;
	private JButton btnNewButton;
	private JMenuItem mn�tmPdfOlutur;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					StokKartiMenuChangeCommand change = new StokKartiMenuChangeCommand(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 535);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnStok = new JMenu("Stok");
		menuBar.add(mnStok);
		
		JMenu mnPdf = new JMenu("Pdf");
		menuBar.add(mnPdf);
		

		
	    mn�tmStokKart = new JMenuItem("Stok Kart\u0131");
		mnStok.add(mn�tmStokKart);
		
	    mn�tmStokKartListesi = new JMenuItem("Stok Kart\u0131 Listesi");
		mnStok.add(mn�tmStokKartListesi);
		
		mn�tmPdfOlutur = new JMenuItem("Pdf Olu\u015Ftur");
		mnPdf.add(mn�tmPdfOlutur);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
	
	public void stokKartClick(ActionListener mnuStokKart) {
		
		 mn�tmStokKart.addActionListener(mnuStokKart);
	}
	public void stokKartiListesiClick(ActionListener mnuStokKartListesi) {
		
		mn�tmStokKartListesi.addActionListener(mnuStokKartListesi);
	}
	public void pdfOlusturClick(ActionListener mnuPdfOlustur) {
		
		 mn�tmPdfOlutur.addActionListener(mnuPdfOlustur);
		
	}
	
}
