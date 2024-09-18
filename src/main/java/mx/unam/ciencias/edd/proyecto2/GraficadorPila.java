package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.Pila;

public class GraficadorPila {

    private Pila<Integer> pi = new Pila<>();

    public GraficadorPila(Pila<Integer> pi){
        this.pi = pi;
    }
    
    public String grafica(){
        Cola<Integer> cAux = new Cola<>();
        if(pi.esVacia()) return "";

        int maxi = Integer.MIN_VALUE;
        int elem = 0;

        while(!pi.esVacia()){
            int i = pi.saca();
            cAux.mete(i);
            maxi = Math.max(maxi, Math.abs(i));
            elem++;
        }

        int cost = Math.max(50, (int)((Math.log10(maxi)+1)*15));

        StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='UTF-8' ?>\n"); 
        sb.append("<svg width='" + (cost+20) +"' height='"+ (20+(elem*33)) +"'>\n");
        sb.append(" <g>\n");

        int i = cAux.saca();
        sb.append(" <rect x='10' y='10' width='"+ cost +"' height='30' stroke='#8FBC8F' fill='white' rx='5' ry='5'/>\n" +
                  " <text x='"+(10 +(cost)/2 -((int)((Math.log10(Math.abs(i))+ ((i<0) ? 2 : 1))*8)/2))+"' y='30' font-family='Verdana' font-size='15'>" + i + "</text>\n");

        i=33;

        while(!cAux.esVacia()){
            int in = cAux.saca();
            sb.append("\n <!-- Draw Element -->\n");
            sb.append(" <rect x='10' y='"+(i+10)+"' width='"+ cost +"' height='30' stroke='#8FBC8F' fill='white' rx='5' ry='5'/>\n" +
                      " <text x='"+ (10 +(cost)/2 -((int)((Math.log10(Math.abs(in))+ ((in<0) ? 2 : 1))*8)/2)) +"' y='"+(i+30)+"' font-family='Verdana' font-size='15'>" + in + "</text>\n");

            i+=33;
        }

        sb.append(" <line x1='5' y1='10' x2='5' y2='"+(i+12)+"' stroke='green'/>\n");
        sb.append(" <line x1='"+(cost+15)+"' y1='10' x2='"+(cost+15)+"' y2='"+(i+12)+"' stroke='green'/>\n");
        sb.append(" <line x1='5' y1='"+(i+12)+"' x2='"+(cost+15)+"' y2='"+(i+12)+"' stroke='green'/>\n");

        sb.append(" </g>\n");
        sb.append("</svg>\n");

        return sb.toString();
    }
}

