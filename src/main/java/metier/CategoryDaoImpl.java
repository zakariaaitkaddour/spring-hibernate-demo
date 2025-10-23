package metier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dao.IDao;
import entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CategoryDaoImpl implements IDao<Category> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean create(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        sessionFactory.getCurrentSession().update(category);
        return true;
    }

    @Override
    public boolean delete(Category category) {
        sessionFactory.getCurrentSession().delete(category);
        return true;
    }

    @Override
    public List<Category> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Category", Category.class).list();
    }

    @Override
    public Category getById(int id) {
        return sessionFactory.getCurrentSession().get(Category.class, id);
    }
}
