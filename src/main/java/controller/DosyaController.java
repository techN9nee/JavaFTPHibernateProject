package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.StokDosya;
import service.FtpService;

public class DosyaController {

    private FtpService ftpService = new FtpService();
    private HibernateDeleteController hibernateDeleteController = new HibernateDeleteController();
    private HibernateSaveController hibernateSaveController = new HibernateSaveController();
    public void dosyaSecVeKaydet() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String localFilePath = selectedFile.getAbsolutePath();
            String fileName = selectedFile.getName();
            
            boolean isUploaded = ftpService.uploadFileToFTP(localFilePath, fileName);
            if (isUploaded) {
                StokDosya stokDosya = new StokDosya();
                stokDosya.setDosya_adi(fileName);
                stokDosya.setOlusturma_zamani(new Timestamp(System.currentTimeMillis()));
                hibernateSaveController.saveFileRecord(stokDosya);
                JOptionPane.showMessageDialog(null, "Dosyalar başarıyla MySqle kaydedildi");
            } else {
            	 JOptionPane.showMessageDialog(null, "Dosyalar MySqle kaydedilemedi",null,JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void dosyaIndir(String fileName) {
        String downloadPath = "C:\\Users\\aytek\\Desktop\\FTPIndir\\" + fileName;
        boolean isDownloaded = ftpService.downloadFileFromFTP(fileName, downloadPath);
        if (isDownloaded) {
            JOptionPane.showMessageDialog(null, "Dosya başarıyla indirildi!");
        } else {
            JOptionPane.showMessageDialog(null, "Dosya indirilemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Dosya açma
    public void dosyaAc(String fileName) {
        String filePath = "C:\\Users\\aytek\\Desktop\\FTPDeneme\\" + fileName;
        File file = new File(filePath);
        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Dosya bulunamadı!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Dosya silme
    public void dosyaSil(String fileName) {
        boolean isDeletedFromFtp = ftpService.deleteFileFromFTP(fileName);
        if (isDeletedFromFtp) {
        	hibernateDeleteController.deleteFileRecord(fileName);
            JOptionPane.showMessageDialog(null, "Dosya başarıyla silindi!");
        } else {
            JOptionPane.showMessageDialog(null, "Dosya silinemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
