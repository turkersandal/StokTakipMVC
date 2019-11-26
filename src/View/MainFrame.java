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
	private JMenuItem mnýtmStokKartListesi;
	private JMenuItem mnýtmStokKart;
	private JButton btnNewButton;
	private JMenuItem mnýtmPdfOlutur;
	
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
		

		
	    mnýtmStokKart = new JMenuItem("Stok Kart\u0131");
		mnStok.add(mnýtmStokKart);
		
	    mnýtmStokKartListesi = new JMenuItem("Stok Kart\u0131 Listesi");
		mnStok.add(mnýtmStokKartListesi);
		
		mnýtmPdfOlutur = new JMenuItem("Pdf Olu\u015Ftur");
		mnPdf.add(mnýtmPdfOlutur);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
	
	public void stokKartClick(ActionListener mnuStokKart) {
		
		 mnýtmStokKart.addActionListener(mnuStokKart);
	}
	public void stokKartiListesiClick(ActionListener mnuStokKartListesi) {
		
		mnýtmStokKartListesi.addActionListener(mnuStokKartListesi);
	}
	public void pdfOlusturClick(ActionListener mnuPdfOlustur) {
		
		 mnýtmPdfOlutur.addActionListener(mnuPdfOlustur);
		
	}
	
}
