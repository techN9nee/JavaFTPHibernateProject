package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.StokDosya;
import service.HibernateService;

public class HibernateShowController {

    public List<StokDosya> getAllFiles() {
        try (Session session = HibernateService.getSessionFactory().openSession()) {
            Query<StokDosya> query = session.createQuery("FROM StokDosya", StokDosya.class);
            return query.list();
        }
    }
}
