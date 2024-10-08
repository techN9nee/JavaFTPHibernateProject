package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import frameController.AnaSayfaFrameController;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnaSayfaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnDosyaEkle ;
	private JMenu mnDosyaIslemleri ;
	private JDesktopPane desktopPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaSayfaView frame = new AnaSayfaView();
					AnaSayfaFrameController anaSayfaFrameController = new AnaSayfaFrameController(frame);
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
	public AnaSayfaView() {
		setResizable(false);
		setTitle("Ana Sayfa ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 970, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 10, 920, 60);
		contentPane.add(menuBar);
		
		mnDosyaEkle = new JMenu("Dosya Ekle");
		mnDosyaEkle.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		menuBar.add(mnDosyaEkle);
		
		JMenu mnAyirici = new JMenu("|");
		mnAyirici.setEnabled(false);
		mnAyirici.setForeground(Color.LIGHT_GRAY);
		mnAyirici.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuBar.add(mnAyirici);
		
		mnDosyaIslemleri = new JMenu("Dosya İşlemleri");
		mnDosyaIslemleri.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		menuBar.add(mnDosyaIslemleri);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 80, 930, 403);
		contentPane.add(desktopPane);
	}
	
	public JMenu getDosyaEkle() {
		return mnDosyaEkle;
	}
	public JMenu getDosyaIslemleri() {
		return mnDosyaIslemleri;
	}
	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}
	
}
