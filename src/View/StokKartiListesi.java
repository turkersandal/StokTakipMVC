package View;

import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.StokKartiListCommand;
import Model.ModelStokKarti;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StokKartiListesi extends JInternalFrame {
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StokKartiListesi frame = new StokKartiListesi();
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
	public StokKartiListesi() {
		setMaximizable(true);
		setResizable(true);
		setBounds(100, 100, 615, 425);
		
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object [] rows = {"Stok Kodu","Stok Adý","Stok Birimi","Stok Tipi","Barkod","Kdv Tipi","Aciklama","Tarih"};
		model.setColumnIdentifiers(rows);
		table.setModel(model);
		JScrollPane pane = new JScrollPane(table);
		
		ModelStokKarti card = new ModelStokKarti();
		StokKartiListCommand listC = new StokKartiListCommand(this,card);
		
		JButton btnRefresh = new JButton("YEN\u0130LE");
		btnRefresh.addActionListener(listC);
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pane, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
						.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pane, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRefresh)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	public JTable getTable() {
		
		return this.table;
	}
	
	

}
