package frameController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JInternalFrame;

import view.AnaSayfaView;
import view.DosyaEkleView;
import view.DosyaIslemleriView;

public class AnaSayfaFrameController {

	private AnaSayfaView anaSayfaView = null ;
	
	public AnaSayfaFrameController(AnaSayfaView view) {
		this.anaSayfaView = view;
		initController();
	}
	
	public void openDosyaEkle() {
		
		boolean isOpen = false;
		for(JInternalFrame frame : anaSayfaView.getDesktopPane().getAllFrames()) {
			if(frame instanceof DosyaEkleView) {
				isOpen = true;
				frame.toFront();
				break;
			}
		}
		if(!isOpen) {
			DosyaEkleView dosyaEkleView = new DosyaEkleView();
			DosyaEkleFrameController dosyaEkleFrameController = new DosyaEkleFrameController(dosyaEkleView);
			anaSayfaView.getDesktopPane().add(dosyaEkleView).setVisible(true);
		}
	}
	
	public void openDosyIslemleri() {
		
		boolean isOpen = false; 
		
		for(JInternalFrame frame : anaSayfaView.getDesktopPane().getAllFrames()) {
			if(frame instanceof DosyaIslemleriView) {
				isOpen = true;
				frame.toFront();
				break;
			}
		}
		if(!isOpen) {
			DosyaIslemleriView dosyaIslemleriView = new DosyaIslemleriView();
			DosyaIslemleriFrameController dosyaIslemleriFrameController = new DosyaIslemleriFrameController(dosyaIslemleriView);
			anaSayfaView.getDesktopPane().add(dosyaIslemleriView).setVisible(true);
		}
	}
	
	public void initController() {
		anaSayfaView.getDosyaEkle().addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            openDosyaEkle();
	        }
		});
		
		anaSayfaView.getDosyaIslemleri().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openDosyIslemleri();
			}
		});
	}
	
	
}
