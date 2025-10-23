package tests.projets.agiles;

import dao.IDao;
import entities.Category;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import util.HibernateConfig;

public class Presenetation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);


        IDao<Category> categoryDao = (IDao<Category>) context.getBean("categoryDaoImpl");
        IDao<Product> productDao = (IDao<Product>) context.getBean("productDao");


        Category category = new Category();
        Product product = new Product();

        category.setName("cat1");

        categoryDao.create(category);

        product.setName("Prod1");
        product.setPrice(100.0);
        product.setCategory(category);

        productDao.create(product);

    }
}
