package data;

public class Patron {
    
    private double vector[];
    private String clase;
    private String claseResultante;

    public Patron(int n) {
        this.vector = new double[n];
        this.clase = "Desconocida";
        this.claseResultante = "Desconocida";
    }

    public Patron(double[] vector, String clase) {
        this.vector = vector;
        this.clase = clase;
        this.claseResultante = "Desconocida";
    }
    
    public Patron (Patron aux){
        this.clase = aux.getClase();
        this.vector = aux.getVector().clone();
         this.claseResultante = "Desconocida";
    }

    public double[] getVector() {
        return vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getClaseResultante() {
        return claseResultante;
    }

    public void setClaseResultante(String claseResultante) {
        this.claseResultante = claseResultante;
    }
    
    @Override
    public boolean equals(Object obj) {//comparamos los objetos
      Patron aux = (Patron) obj;
      for(int x=0 ;x<this.vector.length;x++){
          if(this.vector[x]!=aux.getVector()[x]){
          return false;
          }
      }
      
      return true;   
    }
    
}
