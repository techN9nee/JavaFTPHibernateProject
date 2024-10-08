package controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.StokDosya;
import service.HibernateService;

public class HibernateSaveController {
    public void saveFileRecord(StokDosya dosya) {
        Transaction transaction = null;
        try (Session session = HibernateService.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(dosya);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
