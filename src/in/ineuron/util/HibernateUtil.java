package in.ineuron.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.entity.Address;
import in.ineuron.entity.StudentInfo;



public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(StudentInfo.class).addAnnotatedClass(Address.class).buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null)
			session = sessionFactory.openSession();

		return session;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null)
			sessionFactory.close();
	}

	public static void closeSession(Session session) {

		if (session != null)
			session.close();

	}

}
