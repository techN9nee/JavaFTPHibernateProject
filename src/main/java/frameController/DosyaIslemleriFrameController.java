package frameController;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.DosyaController;
import controller.HibernateShowController;
import model.StokDosya;
import view.DosyaIslemleriView;

public class DosyaIslemleriFrameController {
	
	private DosyaController dosyaController ;
	private DosyaIslemleriView dosyaIslemleriView ;
	private HibernateShowController hibernateShowController;
	
	public DosyaIslemleriFrameController(DosyaIslemleriView view) {
		this.hibernateShowController = new HibernateShowController();
		this.dosyaController = new DosyaController();
		this.dosyaIslemleriView = view;
		initController();
	}
	
	private void btnIndir() {
        int selectedRow = dosyaIslemleriView.getTable().getSelectedRow();
        if (selectedRow != -1) {
            String fileName = dosyaIslemleriView.getTable().getValueAt(selectedRow, 0).toString();
            dosyaController.dosyaIndir(fileName);
        } else {
            JOptionPane.showMessageDialog(null, "Bir dosya seçin!");
        }
	}
	
	private void btnAc() {
        int selectedRow = dosyaIslemleriView.getTable().getSelectedRow();
        if (selectedRow != -1) {
            String fileName = dosyaIslemleriView.getTable().getValueAt(selectedRow, 0).toString();
            dosyaController.dosyaAc(fileName);
        } else {
            JOptionPane.showMessageDialog(null, "Bir dosya seçin!");
        }
	}
	
	private void btnSil() {
        int selectedRow = dosyaIslemleriView.getTable().getSelectedRow();
        if (selectedRow != -1) {
            String fileName = dosyaIslemleriView.getTable().getValueAt(selectedRow, 0).toString();
            dosyaController.dosyaSil(fileName);
            dosyaTablo();
        } else {
            JOptionPane.showMessageDialog(null, "Bir dosya seçin!");
        }
	}
	
    private void dosyaTablo() {
        DefaultTableModel model = (DefaultTableModel) dosyaIslemleriView.getTable().getModel();
        model.setRowCount(0); 

        List<StokDosya> dosyalar = hibernateShowController.getAllFiles();
        for (StokDosya dosya : dosyalar) {
            model.addRow(new Object[] { dosya.getDosya_adi(), dosya.getOlusturma_zamani() });
        }
    }
	
	
	private void initController() {
		dosyaIslemleriView.btnIndır().addActionListener(e -> btnIndir());
		dosyaIslemleriView.btnAc().addActionListener(e -> btnAc());
		dosyaIslemleriView.btnSil().addActionListener(e -> btnSil());
		dosyaTablo();
	}

}
