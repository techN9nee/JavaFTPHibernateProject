package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class DosyaEkleView extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JButton btnDosyaEkle ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DosyaEkleView frame = new DosyaEkleView();
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
	public DosyaEkleView() {
		setTitle("Dosya Ekle View");
		setClosable(true);
		setBounds(0, 0, 930, 100);
		getContentPane().setLayout(null);
		
		btnDosyaEkle = new JButton("Dosya Ekle");
		btnDosyaEkle.setForeground(Color.DARK_GRAY);
		btnDosyaEkle.setFont(new Font("Tahoma", Font.ITALIC, 26));
		btnDosyaEkle.setBounds(0, 0, 920, 71);
		getContentPane().add(btnDosyaEkle);

	}
	
	public JButton btnDosyaEkle() {
		return btnDosyaEkle;
	}
}
