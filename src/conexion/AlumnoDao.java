/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import org.hibernate.Session;
import pojos.Alumnos;

/**
 *
 * @author mrsops
 */
public class AlumnoDao {

    public Alumnos obtenerAlumno(int id) {
        Session s = HibernateUtil.getCurrentSession();
        s.beginTransaction();
        Alumnos result = (Alumnos) s.get(Alumnos.class, id);
        s.getTransaction().commit();
        s.close();
        return result;
    }

    public void altaAlumno(Alumnos a) {
        Session s = HibernateUtil.getCurrentSession();
        s.beginTransaction();
        s.save(a);
        s.getTransaction().commit();
        s.close();
    }

    public void bajaAlumno(Alumnos a) {
        Session s = HibernateUtil.getCurrentSession();
        s.beginTransaction();
        s.delete(a);
        s.getTransaction().commit();
        s.close();
    }

}
