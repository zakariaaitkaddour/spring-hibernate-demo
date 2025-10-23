package metier;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dao.IDao;
import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl implements IDao<Product> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public boolean create(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        return true;
    }

    @Override
    public boolean delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        return true;
    }

    @Override
    public List<Product> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product", Product.class).list();
    }

    @Override
    public Product getById(int id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }
}

