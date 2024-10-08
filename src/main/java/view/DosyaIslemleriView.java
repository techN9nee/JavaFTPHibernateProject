package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DosyaIslemleriView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton btnIndir ;
	private JButton btnAc;
	private JButton btnSil;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DosyaIslemleriView frame = new DosyaIslemleriView();
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
	public DosyaIslemleriView() {
		setTitle("Dosya İşlemleri View");
		setClosable(true);
		setBounds(0, 101, 930, 280);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 900, 180);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Dosya Ad\u0131", "Olu\u015Fturulma Zaman\u0131"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 200, 900, 45);
		getContentPane().add(panel);
		
		btnIndir = new JButton("   İndir  ");
		btnIndir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnIndir);
		
		btnAc = new JButton("   Aç   ");
		btnAc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnAc);
		
		btnSil = new JButton("    Sil     ");
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnSil);
	}

    
    public JButton btnIndır() {
    	return btnIndir;
    }
    public JButton btnSil() {
    	return btnSil;
    } 
    public JButton btnAc() {
    	return btnAc;
    }
    public JTable getTable() {
    	return table;
    }
}
