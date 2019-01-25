/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.AlumnoDao;
import pojos.Alumnos;

/**
 *
 * @author mrsops
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AlumnoDao d = new AlumnoDao();
        
        //Alta alumno
        Alumnos a = new Alumnos("Julian","Martinez Torro");
        d.altaAlumno(a);
        System.out.println("Dado de alta");
        
        //Consulta alumno
        Alumnos a2 = d.obtenerAlumno(3);
        System.out.println("Codigo: "+a2.getCodigo());
        System.out.println("Nombre: "+ a2.getNombre());
        
        
        //Baja alumno

        Alumnos a3 = new Alumnos();
        a.setCodigo(2);
        d.bajaAlumno(a);
        System.out.println("Borrado");

    }
    
}
