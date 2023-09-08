package nl.scalda.example;

import nl.scalda.example.model.Product;
import nl.scalda.example.repository.factories.DAOFactories;
import nl.scalda.example.repository.factories.DAOFactory;
import nl.scalda.example.repository.factories.HibernateDAOFactory;
import nl.scalda.example.repository.utils.HibernateSessionManager;

import java.util.List;

public class Starter {

    public static void main(String ... args) {

        DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());

        HibernateDAOFactory.getFactory().getProductDAO().saveAll(List.of(
                new Product("Kaas", 8.50),
                new Product("Koffie", 6.50),
                new Product("Brood", 3.25)
        ));

        System.out.println(HibernateDAOFactory.getFactory().getProductDAO().findAll());

        HibernateSessionManager.shutdown();

    }

}
