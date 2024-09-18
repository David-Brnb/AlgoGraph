package mx.unam.ciencias.edd.proyecto2;

public class Tuple {
    int elem1; 
    double elem2; 
    double elem3;

    public Tuple(){
        elem1 = 0;
        elem2 = 0;
        elem3 = 0;
    }

    public Tuple(int e1, double e2, double e3){
        elem1 = e1;
        elem2 = e2;
        elem3 = e3;
    }

    public void setE1(int e1){
        elem1 = e1;
    }

    public void setE2(double e2){
        elem2 = e2;
    }

    public void setE3(double e3){
        elem3 = e3;
    }

    public int getE1(){
        return elem1;
    }

    public double getE2(){
        return elem2;
    }

    public double getE3(){
        return elem3;
    }
    
}
