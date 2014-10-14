package com.web.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
private static SessionFactory sessionFactory ;
static {
	Configuration configuration = new Configuration().configure(); 
	ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	sessionFactory= configuration.buildSessionFactory(serviceRegistry);

	/*Configuration cfg= new Configuration().configure("hibernate.cfg.xml"); 

StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder(); 
ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
sessionFactory = cfg.buildSessionFactory(serviceRegistry); 
*/

//	sessionFactory= new AnnotationConfiguration().configure().buildSessionFactory();
/*public static SessionFactory sessionfactory = null; static {
	  try {
	   // 通过hibernate.cfg.xml 产生一个SessionFactory
	   sessionfactory = new Configuration().configure().buildSessionFactory();
	  } catch (Throwable ce) {
	   ce.printStackTrace();
	  }
	 }
	 
	 
	 //Hibernate4
	 private static SessionFactory sessionFactory;
	 private static ServiceRegistry serviceRegistry; public static SessionFactory configureSessionFactory()throws HibernateException {
	  Configuration configuration = new Configuration();
	  configuration.configure();
	  serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	  return sessionFactory;
	 }*/

}
public static SessionFactory getSessionFactory(){
	return sessionFactory;
}
}

