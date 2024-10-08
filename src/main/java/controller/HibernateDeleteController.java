package controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import service.HibernateService;

public class HibernateDeleteController {

    public void deleteFileRecord(String fileName) {
        Transaction transaction = null;
        try (Session session = HibernateService.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM StokDosya WHERE dosya_adi = :fileName");
            query.setParameter("fileName", fileName);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
