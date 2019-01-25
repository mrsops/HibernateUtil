/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mrsops
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final ThreadLocal session = new ThreadLocal();
    
    static {
        try {
            File configFile = new File("src/config/hibernate.cfg.xml");
            Configuration config = new Configuration().configure(configFile);
            sessionFactory = config.buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static Session getCurrentSession(){
        Session s = (Session) session.get();
        if(s==null || !s.isOpen()){
            s = sessionFactory.openSession();
        }
        session.set(s);
        return s;
    }
    
    public static void CloseSession(){
        Session s = (Session)session.get();
        if(s != null || s.isOpen()){
            s.close();
        }
        session.set(s);
    }
}

