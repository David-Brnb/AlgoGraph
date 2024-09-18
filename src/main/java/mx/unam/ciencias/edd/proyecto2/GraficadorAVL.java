package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.VerticeArbolBinario;

public class GraficadorAVL {
    private String str = "";
    
    

    public GraficadorAVL(){}

    public String graficador(VerticeArbolBinario<Integer> v){
        int fin = (int) Math.pow(2, v.altura());

        str += "<?xml version='1.0' encoding='UTF-8' ?>\n" +
               "<svg width='"+(fin*110)+"' height='"+((v.altura())*130+80)+"'>\n " +
               "\t<g>\n";
        

        grafica(0, fin*100, v, 40, 0);

        String[] sr = v.toString().split(" ");
        str+="\t\t<text fill='black' font-family='sans-serif' font-size='15' x='"+((0+fin*100)/2)+"' y='"+(15)+"' text-anchor='middle'>("+sr[1]+")</text>\n";

        str += "\t</g>\n"+
               "</svg>";

        return str;
    }

    public void grafica(int inicio, int fin, VerticeArbolBinario<Integer> v, int altura, int plus){
        if(v==null) return;
        int x = (fin+inicio)/2;


        if(v.hayDerecho()){
            str+="\t\t<line x1='"+x+"' y1='"+altura+"' x2='"+((x+fin)/2)+"' y2='"+(altura+120)+"' stroke='black' stroke-width='3' />\n";
            
            String[] sr = v.derecho().toString().split(" ");
            str+="\t\t<text fill='black' font-family='sans-serif' font-size='15' x='"+((x+fin)/2+plus)+"' y='"+(altura+120-25)+"' text-anchor='middle'>("+sr[1]+")</text>\n";
        }

        if(v.hayIzquierdo()){
            str+="\t\t<line x1='"+x+"' y1='"+altura+"' x2='"+((inicio+x)/2)+"' y2='"+(altura+120)+"' stroke='black' stroke-width='3' />\n";

            String[] sr = v.izquierdo().toString().split(" ");
            str+="\t\t<text fill='black' font-family='sans-serif' font-size='15' x='"+((inicio+x)/2-plus)+"' y='"+(altura+120-25)+"' text-anchor='middle'>("+sr[1]+")</text>\n";
        }

        String[] sr = v.toString().split(" ");
        

        //Revisamos si es hijo izquierdo o derecho y asi para optimizar
        
        //Dibujamos el circulo correspondiente
        str+="\t\t<circle cx='"+x+"' cy='"+altura+"' r='20' stroke='black' stroke-width='3' fill='white' />\n";
        str+="\t\t<text fill='black' font-family='sans-serif' font-size='20' x='"+x+"' y='"+(altura+5)+"' text-anchor='middle'>"+sr[0]+"</text>\n";


        if(v.hayIzquierdo()){
            //Dibuja linea hacia el hijo we
            grafica(inicio, x, v.izquierdo(), altura+120, 10);
        }

        if(v.hayDerecho()){
            //Dibuja linea hacia el otro hijo we
            grafica(x, fin, v.derecho(), altura+120, 10);
        }

    }
}
