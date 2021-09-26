package clasificacionsupervisada;

import data.PatronRepresentativo;
import data.Patron;
import data.MatrizConfusion;
import data.Herramientas;
import java.util.ArrayList;

public class MinimaDistancia implements Clasificador {

    private  ArrayList<PatronRepresentativo> representativos;
    private MatrizConfusion mc;
    
    public MinimaDistancia() {
        this.representativos = new ArrayList<PatronRepresentativo>();
        this.mc = null;
    }
    
    public ArrayList<PatronRepresentativo> getRepresentativos()
    {
    return this.representativos;    
    }

    @Override
    public void entrenar(ArrayList<Patron> instancias) {
       
        // agregamos el primer representativo 
        representativos.add(new PatronRepresentativo(instancias.get(0)));
        // recorrer todas las instancias 
        for (int x=1; x<instancias.size();x++){
            Patron aux = instancias.get(x);
            // es verificar si el representativo existe o no
            int pos = representativos.indexOf(aux);
            if(pos!=-1){
                
                 // ACUMULAR AL REPRESENTATIVO QUE LE CORRESPONDA
                
                representativos.get(pos).acumular(aux);
              
                
            }else {
           // crear un nuevo patron representativo
                // agregamos el primer representativo 
                representativos.add(new PatronRepresentativo(aux));
            }
        }
        for(PatronRepresentativo aux: representativos){
            aux.actualizar();
        }
    
        
    }

    @Override
    public void clasificar(Patron patron) {
        int iMenor=0;
        double dMenor = Herramientas.calcularDistanciaEuclidiana
        (patron,this.representativos.get(0));
        
        // en proceso iterativo calcular las distancias con respecto a los representativos
        for(int i = 1; i < this.representativos.size();i+=1){
            double aux = Herramientas.calcularDistanciaEuclidiana(patron,this.representativos.get(i));
            if(aux<dMenor){
                dMenor = aux;
                iMenor = i;
            }
        }         //se asigna la clase a la que pertenece
        patron.setClaseResultante(this.representativos.get(iMenor).getClase());
       
    }

    @Override
    public void clasificar(ArrayList<Patron> patrones) {
       for(Patron p: patrones){
           clasificar(p);
       }
       this.mc = new MatrizConfusion(patrones);
   
    }


    public MatrizConfusion getMc() {
        return mc;
    }

   
}

