package data;
import java.util.ArrayList;

public class MatrizConfusion {
    
    private ArrayList<PatronRepresentativo> Rep;//El arrayList es un tipo de dato
    private int mat[][];
    private ArrayList<String> aux;//Es para almacenar los nombres de clases
    private ArrayList<Patron> Patron;
    
    public MatrizConfusion(ArrayList<Patron> Lisa){
        this.Rep = new ArrayList<>();
        this.Patron = new ArrayList<>();
        this.Patron = Lisa;
        this.aux = new ArrayList<>();
        this.mat = null;
        //Imprimir();
        crearMatriz();
    }
    public MatrizConfusion(ArrayList<Patron> Lisa, ArrayList<PatronRepresentativo> Rep){
        this.Rep = new ArrayList<>();
        this.Rep = Rep;//La matriz va a funcionar junto con Rep
        this.Patron = new ArrayList<>();
        this.Patron = Lisa;
        this.aux = new ArrayList<>();
        this.mat = new int[this.Rep.size()][this.Rep.size()];
        crearMatriz2();
    }
    
    public void imprimir(){
        for(Patron p: this.Patron){
            System.out.println(p.getClaseResultante());
            if(p.getClase().equals("Desconocido")){
                
            }
            else{
                System.out.println(p.getClase());
            }
                for(double i : p.getVector()){
                    System.out.println(i + ",");
                }
        }
    }
    
    private void crearMatriz(){
        int a = 0;
        int b = 0;
        for(Patron p : Patron){
            if(aux.contains(p.getClase())){
                
            }
            else{
                aux.add(p.getClase());
            }
        }
        int m = this.aux.size();
        this.mat = new int[m][m+1];
        
        for(Patron p : Patron){
            a = aux.indexOf(p.getClase());
            b = aux.indexOf(p.getClaseResultante());
            this.mat[a][b]++;
        }
    }
    
    private void crearMatriz2(){//Requerimos a aux
        int a = 0;
        int b = 0;
        for(Patron p : Patron){
            if(aux.contains(p.getClase())){
                
            }
            else{
                aux.add(p.getClase());
            }
        }
        for(Patron p : Patron){
            a = aux.indexOf(p.getClase());
            b = aux.indexOf(p.getClaseResultante());
            this.mat[a][b]++;
        }
    }
    @Override
    public String toString(){
        String sts = " ";
        for(int i = 0; i < this.aux.size(); i++){
            sts += this.aux.get(i);
            for(int j = 0; j < this.aux.size(); j++){
                sts += " " + this.mat[i][j] + ",";
            }
            sts += "\n";
        }
        return sts;
    }
    public void calcularEfectividad(){
    System.out.println(" \n Efectividad por Clases");
       //Efectividad = (Pruebas de exito/ Pruebas totales)*100
       double EfectClase = 0;
       for(int i = 0; i < this.aux.size(); i++){
           System.out.print(this.aux.get(i));
           int PruExit = this.mat[i][i];
           int PruTotal = 0;
           for(int j = 0; j < this.aux.size(); j++)PruTotal += this.mat[i][j];
           EfectClase = (double)PruExit/PruTotal;
           EfectClase *= 100;
           System.out.println(" " + EfectClase);
       }
    }
    public void calcularEfectividadT(){
        System.out.println(" \n Efectividad total del Clasificador");
        double EfectTot = 0;
        int PruExit = 0;
        for(int i = 0; i < this.aux.size(); i++) {
            PruExit += this.mat[i][i];
        }
        int PruTotal = this.Patron.size();
        EfectTot = (double)PruExit/PruTotal;
        EfectTot *= 100;
        System.out.println(" " + EfectTot);
    }
       
}
