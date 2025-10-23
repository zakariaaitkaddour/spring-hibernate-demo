package tests.projets.agiles;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import util.HibernateConfig;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);

        if (sessionFactory != null)
            System.out.println("Hibernate SessionFactory is configured");
        else
            System.out.println("Hibernate SessionFactory is not configured");

        HibernateTransactionManager txManager = context.getBean(HibernateTransactionManager.class);

        if (txManager != null)
            System.out.println("Hibernate TransactionManager is configured");
        else
            System.out.println("Hibernate TransactionManager is not configured");

    }
}