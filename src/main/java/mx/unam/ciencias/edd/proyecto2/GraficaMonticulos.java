package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.VerticeArbolBinario;

public class GraficaMonticulos {
    private String str = "";
    private Lista<Integer> li = new Lista<>();
    
    

    public GraficaMonticulos(Lista<Integer> li){
        this.li = li;
    }

    public String graficador(VerticeArbolBinario<Integer> v){
        int fin = (int) Math.pow(2, v.altura());
        int maxi = Integer.MIN_VALUE;

        for(int in: li){
            maxi = Math.max(maxi, Math.abs(in));

        }
        
        int cost = Math.max(50, (int)((Math.log10(maxi)+1)*15));

        str += "<?xml version='1.0' encoding='UTF-8' ?>\n" +
               "<svg width='"+(Math.max(fin*100,li.getElementos()*(cost+50)))+"' height='"+((v.altura())*130+140)+"'>\n " +
               "\t<g>\n";
        
        str += grafica(0);
        grafica(0, fin*100, v, 100);

        str += "\t</g>\n"+
               "</svg>";

        return str;
    }


    //Centrar esta lista
    public void grafica(int inicio, int fin, VerticeArbolBinario<Integer> v, int altura){
        if(v==null) return;
        int x = (fin+inicio)/2;


        if(v.hayDerecho()){
            str+="\t\t<line x1='"+x+"' y1='"+altura+"' x2='"+((x+fin)/2)+"' y2='"+(altura+120)+"' stroke='black' stroke-width='3' />\n";
        }

        if(v.hayIzquierdo()){
            str+="\t\t<line x1='"+x+"' y1='"+altura+"' x2='"+((inicio+x)/2)+"' y2='"+(altura+120)+"' stroke='black' stroke-width='3' />\n";
        }
        
        //Dibujamos el circulo correspondiente
        str+="\t\t<circle cx='"+x+"' cy='"+altura+"' r='20' stroke='black' stroke-width='3' fill='white' />\n";
        str+="\t\t<text fill='black' font-family='sans-serif' font-size='20' x='"+x+"' y='"+(altura+5)+"' text-anchor='middle'>"+v.toString()+"</text>\n";


        if(v.hayIzquierdo()){
            //Dibuja linea hacia el hijo we
            grafica(inicio, x, v.izquierdo(), altura+120);
        }

        if(v.hayDerecho()){
            //Dibuja linea hacia el otro hijo we
            grafica(x, fin, v.derecho(), altura+120);
        }

    }

    public String grafica(int dist){
        if(li.esVacia()) return "";

        int maxi = Integer.MIN_VALUE;

        for(int in: li){
            maxi = Math.max(maxi, Math.abs(in));

        }

        int cost = Math.max(50, (int)((Math.log10(maxi)+1)*15));

        StringBuilder sb = new StringBuilder(""); 

        int i = li.eliminaPrimero();
        sb.append("\t\t<rect x='"+10+"' y='30' width='"+ cost +"' height='30' stroke='black' fill='white'/>\n" +
                  "\t\t<text x='"+(10+(cost)/2 -((i==0) ? 1 : (int)((Math.log10(Math.abs(i)) + ((i<0) ? 2 : 1))*8)/2))+"' y='50' font-family='Verdana' font-size='15'>" + i + "</text>\n");
        
        i=0;
        
        for(int in: li){
            sb.append("\n\t\t<!-- Draw Element -->\n");
            sb.append("\t\t<rect x='"+(10.5+cost+i)+"' y='30' width='"+ cost +"' height='30' stroke='black' fill='white'/>\n" +
                      "\t\t<text x='"+ ((10.5+cost+i) + (cost)/2 -((in==0) ? 1 : (int)((Math.log10(Math.abs(in))+ ((in<0) ? 2 : 1))*8)/2)) +"' y='50' font-family='Verdana' font-size='15'>" + in + "</text>\n"); 

            i+=cost;

        }

        return sb.toString();
    }
}
