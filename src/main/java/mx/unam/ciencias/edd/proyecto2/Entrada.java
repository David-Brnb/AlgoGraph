/*
 * Esta clase esta hecha para el tratamiento de la entrada normal
 * En esta clase se tratan los casos de las banderas -r y -o
 */

package mx.unam.ciencias.edd.proyecto2;



public class Entrada {
    //Declaramos las variables que se utilizaran a lo largo del tratamiento de la entrada
    private String[] args;

    //Se realiza un constructor para la entrada y el argumento de args
    public Entrada(String[] args){
        this.args = args;
    }

    /* 
    Funcion que realiza el tratamiento de la entrada
    Aqui se validan las entradas dependeindo de si se trata de un archivo, o un texto
    así mismo, dentro de esta función revisamos 
    */ 

    public void tratamientoEntrada() {

        if(!(args.length > 0)){
            // Declaramos e instanciamos un objeto de tipo EntradaEstandar()
            EntradaEstandar es = new EntradaEstandar();

            // llamamos al método que lee la entrada estandar
            this.args = es.leerDesdeEntradaEstandar();
          
        }

        if(args.length == 1){
            EntradaArchivoN archN = new EntradaArchivoN(args[0]);
            this.args = archN.trataArchivo();

        }

        if(args.length>0){
            GraficaEstructura ge = new GraficaEstructura(args);
            ge.grafica();
        }     
        
    }
    
}
