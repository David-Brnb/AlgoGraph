package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.VerticeArbolBinario;

public class GraficadorRojinegros {
    private String str = "";
    ArbolRojinegro <Integer> abo = new ArbolRojinegro<>();

    public GraficadorRojinegros(){}

    public String graficador(VerticeArbolBinario<Integer> v){
        int fin = (int) Math.pow(2, v.altura());

        str += "<?xml version='1.0' encoding='UTF-8' ?>\n" +
               "<svg width='"+(fin*100)+"' height='"+((v.altura())*130+40)+"'>\n " +
               "\t<g>\n";
        

        grafica(0, fin*100, v, 40);

        str += "\t</g>\n"+
               "</svg>";

        return str;
    }

    public void grafica(int inicio, int fin, VerticeArbolBinario<Integer> v, int altura){
        if(v==null) return;
        int x = (fin+inicio)/2;

        

        if(v.hayDerecho()){
            str+="\t\t<line x1='"+x+"' y1='"+altura+"' x2='"+((x+fin)/2)+"' y2='"+(altura+120)+"' stroke='black' stroke-width='3' />\n";
        }

        if(v.hayIzquierdo()){
            str+="\t\t<line x1='"+x+"' y1='"+altura+"' x2='"+((inicio+x)/2)+"' y2='"+(altura+120)+"' stroke='black' stroke-width='3' />\n";
        }

        String color = (v.toString().contains("R")) ? "red" : "black";
        
        //Dibujamos el circulo correspondiente
        str+="\t\t<circle cx='"+x+"' cy='"+altura+"' r='20' stroke='black' stroke-width='3' fill='"+color+"' />\n";
        str+="\t\t<text fill='white' font-family='sans-serif' font-size='20' x='"+x+"' y='"+(altura+5)+"' text-anchor='middle'>"+v.toString().replaceAll("[R N { }]","")+"</text>\n";


        if(v.hayIzquierdo()){
            //Dibuja linea hacia el hijo we
            grafica(inicio, x, v.izquierdo(), altura+120);
        }

        if(v.hayDerecho()){
            //Dibuja linea hacia el otro hijo we
            grafica(x, fin, v.derecho(), altura+120);
        }

    }
}
