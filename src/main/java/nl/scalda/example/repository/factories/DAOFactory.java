package nl.scalda.example.repository.factories;

import nl.scalda.example.repository.interfaces.IProductDAO;

public abstract class DAOFactory {

    private static DAOFactory factory;

    public static DAOFactory getFactory() {
        return factory;
    }

    public static void setFactory(Class<? extends DAOFactory> factory) {
        try {
            DAOFactory.factory = factory.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to create DAOFactory: " + factory);
        }
    }

    public abstract IProductDAO getProductDAO();

}
