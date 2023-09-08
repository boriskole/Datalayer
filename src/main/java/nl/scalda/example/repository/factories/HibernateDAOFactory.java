package nl.scalda.example.repository.factories;

import nl.scalda.example.model.Product;
import nl.scalda.example.repository.dao.GenericDAO;
import nl.scalda.example.repository.dao.ProductDAO;
import nl.scalda.example.repository.interfaces.IProductDAO;
import nl.scalda.example.repository.utils.HibernateSessionManager;
import org.hibernate.Session;

public class HibernateDAOFactory extends DAOFactory {

    protected Session getCurrentSession() {
        return HibernateSessionManager.getSessionFactory().openSession();
    }

    @Override
    public IProductDAO getProductDAO() {
        GenericDAO<Product, Long> dao = null;
        try {
            dao = ProductDAO.class.getDeclaredConstructor().newInstance();
            dao.setSession(getCurrentSession());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (IProductDAO) dao;
    }

}
