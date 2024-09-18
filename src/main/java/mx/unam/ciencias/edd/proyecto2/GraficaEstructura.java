package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.Grafica;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.MonticuloMinimo;
import mx.unam.ciencias.edd.Pila;
import mx.unam.ciencias.edd.ValorIndexable;

public class GraficaEstructura {
    private String[] args;

    public GraficaEstructura(String[] args){
        this.args = args;
    }

    public void grafica(){
        // iteramos sobre args para identificar lo que el usuario ingreso
        String estructura = args[0];

        RevisarEnteros re = new RevisarEnteros();

        switch(estructura) {
            case "Lista":
                Lista<Integer> li = new Lista<>();
                for(int i=1; i<args.length; i++){
                    re.revisionEnteros(args[i]);

                    li.agrega(Integer.parseInt(args[i]));
                }

                GraficadorLista gl = new GraficadorLista(li);

                System.out.println(gl.grafica());
                break;

            case "Pila":
                Pila<Integer> pi = new Pila<>();
                for(int i=1; i<args.length; i++){
                    re.revisionEnteros(args[i]);
                    
                    pi.mete(Integer.parseInt(args[i]));
                }

                GraficadorPila gp = new GraficadorPila(pi);

                System.out.println(gp.grafica());
                break;

            case "Cola":
                Cola<Integer> ci = new Cola<>();
                for(int i=1; i<args.length; i++){
                    re.revisionEnteros(args[i]);
                    
                    ci.mete(Integer.parseInt(args[i]));
                }
                GraficadorCola gc = new GraficadorCola(ci);

                System.out.println(gc.grafica());
                break;

            case "ArbolBinarioCompleto":
                ArbolBinarioCompleto <Integer> abc = new ArbolBinarioCompleto<>();
                for(int i=1; i<args.length; i++){
                    re.revisionEnteros(args[i]);
                    
                    abc.agrega(Integer.parseInt(args[i]));
                }

                GraficadorArbol ga = new GraficadorArbol();

                System.out.println(ga.graficador(abc.raiz()));
                break;

            case "ArbolBinarioOrdenado":
                ArbolBinarioOrdenado <Integer> abo = new ArbolBinarioOrdenado<>();
                for(int i=1; i<args.length; i++){
                    re.revisionEnteros(args[i]);
                    
                    abo.agrega(Integer.parseInt(args[i]));
                }

                GraficadorArbol gac = new GraficadorArbol();

                System.out.println(gac.graficador(abo.raiz()));
                break;

            case "ArbolRojinegro":
                ArbolRojinegro <Integer> rbt = new ArbolRojinegro<>();
                for(int i=1; i<args.length; i++){
                    re.revisionEnteros(args[i]);
                    
                    rbt.agrega(Integer.parseInt(args[i]));
                }

                GraficadorRojinegros gr = new GraficadorRojinegros();
                String r = gr.graficador(rbt.raiz());
                System.out.println(r);
                break;

            case "ArbolAVL":
                ArbolAVL <Integer> avlt = new ArbolAVL<>();
                for(int i=1; i<args.length; i++){
                    re.revisionEnteros(args[i]);
                    
                    avlt.agrega(Integer.parseInt(args[i]));
                }

                GraficadorAVL gAVL = new GraficadorAVL();
                String avl = gAVL.graficador(avlt.raiz());
                System.out.println(avl);
                break;

            case "Grafica":
                Grafica<Integer> gaf = new Grafica<>();
                Lista<Integer> verti = new Lista<>();

                if(args.length%2 == 0){
                    System.out.println("\nArgumento incorrecto. graficas\n" +
                                    "Uso: java -jar proyecto2.jar <archivo>");
                    System.exit(1);
                    break;
                }

                for(int i=1; i<args.length-1; i+=2){
                    re.revisionEnteros(args[i]);

                    if(Integer.parseInt(args[i])!=Integer.parseInt(args[i+1])){
                        if(!gaf.contiene(Integer.parseInt(args[i]))){
                            gaf.agrega(Integer.parseInt(args[i]));
                            verti.agrega(Integer.parseInt(args[i]));
                        } 


                        if(!gaf.contiene(Integer.parseInt(args[i+1]))){
                            gaf.agrega(Integer.parseInt(args[i+1]));
                            verti.agrega(Integer.parseInt(args[i+1]));
                        }


                        if(!gaf.sonVecinos(Integer.parseInt(args[i]), Integer.parseInt(args[i+1])))
                            gaf.conecta(Integer.parseInt(args[i]), Integer.parseInt(args[i+1]));
                        
                    } else {
                        if(!gaf.contiene(Integer.parseInt(args[i]))){
                            gaf.agrega(Integer.parseInt(args[i]));
                            verti.agrega(Integer.parseInt(args[i]));
                        } 
                    }
                    
                }

                GraficadorGrafica grf = new GraficadorGrafica(gaf, verti);                    

                System.out.println(grf.graficador());
                break;

            case "MonticuloMinimo":
                Lista<ValorIndexable<Integer>> l = new Lista<ValorIndexable<Integer>>();  
                Lista<Integer> mm = new Lista<>();
                for(int i=1; i<args.length; i++){
                    re.revisionEnteros(args[i]);
                    ValorIndexable<Integer> idx = new ValorIndexable<Integer>(Integer.parseInt(args[i]), Integer.parseInt(args[i]));

                    l.agregaFinal(idx);

                    mm.agrega(Integer.parseInt(args[i]));
                }

                mm.limpia();
                ArbolBinarioCompleto <Integer> ab = new ArbolBinarioCompleto<>();


                MonticuloMinimo<ValorIndexable<Integer>> mMin = new MonticuloMinimo<>(l);

                ValorIndexable<Integer> e;
                while(!mMin.esVacia()){
                    e = mMin.elimina();
                    mm.agrega(e.getElemento());
                    ab.agrega(e.getElemento());
                }

                GraficaMonticulos gm = new GraficaMonticulos(mm);

                System.out.println(gm.graficador(ab.raiz()));
                break;

            

            default:
                System.out.println("\nArgumento incorrecto. En el tipo de dato\n" +
                                    "Uso: java -jar proyecto2.jar <archivo>");
                System.exit(1);
                break;
            } 
    }
}
