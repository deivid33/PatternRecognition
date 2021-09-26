package data;

public class PatronRepresentativo extends Patron {
    private int cantidad;
    
    public PatronRepresentativo(Patron a,String nombre){
        super(a.getVector(),nombre);
        
        this.cantidad=0;
        acumular(a);
    }
   
    public PatronRepresentativo(Patron a){
        super(a.getVector().length);
        super.setClase(a.getClase());
        this.cantidad=0;
        acumular(a); 
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public  void acumular(Patron aux) {
       for (int x=0;x<aux.getVector().length;x++){
            super.getVector()[x]+=aux.getVector()[x];
        }
       this.cantidad++;
    }
    
    public void promediar(){
        for (int x=0;x<super.getVector().length;x++){
            super.getVector()[x]/=cantidad;
        }
    }
    
    public void actualizar(){
        for (int x=0;x<super.getVector().length;x++){
            super.getVector()[x]/=this.getCantidad();
        }
        this.cantidad = 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //Nos devuelve el equals de la clase padre
    }

    @Override
    public String toString() {
        String aux = "";
        for(int x=0; x<getVector().length;x++)
            aux+="["+getVector()[x]+"]";
        
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
    public void contar(){
        this.cantidad++;
    }
   
}