package rp2022;
import clasificacionsupervisada.KNN;
import clasificacionsupervisada.MinimaDistancia;
import data.Herramientas;
import data.Patron;
import data.MatrizConfusion;
import data.PatronRepresentativo;
import java.util.ArrayList;
import java.util.Collections;

public class Test {

    public static void main(String[] args) {
        Herramientas.leerDatos();
        
     /*  MinimaDistancia m = new MinimaDistancia();
       m.entrenar(Herramientas.instancias);
       m.clasificar((ArrayList<Patron>)Herramientas.instancias.clone());
       System.out.println(m.getMc().toString());
       m.getMc().calcularEfectividad();
       m.getMc().calcularEfectividadT(); */
       
       KNN k = new KNN(7);
       k.entrenar(Herramientas.instancias);
       k.clasificar((ArrayList<Patron>)Herramientas.instancias.clone());
       System.out.println(k.getMc().toString());
       k.getMc().calcularEfectividad();
        
       k.getMc().calcularEfectividadT();
    }
    
}
