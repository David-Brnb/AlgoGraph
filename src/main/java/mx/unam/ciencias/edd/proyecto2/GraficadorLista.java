package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;

public class GraficadorLista {
    private Lista<Integer> li = new Lista<>();

    public GraficadorLista(Lista<Integer> li){
        this.li = li;
    }

    public String grafica(){
        if(li.esVacia()) return "";

        int maxi = Integer.MIN_VALUE;

        for(int in: li){
            maxi = Math.max(maxi, Math.abs(in));

        }

        int cost = Math.max(50, (int)((Math.log10(maxi)+1)*15));

        StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='UTF-8' ?>\n"); 
        sb.append("<svg width='" + li.getElementos()*(cost+50) +"' height='100'>\n");
        sb.append(" <g>\n");

        int i = li.eliminaPrimero();
        sb.append(" <rect x='10' y='30' width='"+ cost +"' height='30' stroke='black' fill='white'/>\n" +
                  " <text x='"+(10+(cost)/2 -((i==0) ? 1 : (int)((Math.log10(Math.abs(i)) + ((i<0) ? 2 : 1))*8)/2))+"' y='50' font-family='Verdana' font-size='15'>" + i + "</text>\n");
        
        i=0;
        
        for(int in: li){
            sb.append("\n <!-- Draw Element -->\n");
            sb.append(" <polygon points='"+(15+cost+i)+",40 "+(11+cost+i)+",45 "+(15+cost+i)+",50' stroke='black' fill='black'/>\n"+
                      " <line x1='"+(11+cost+i)+"' y1='45' x2='"+(35+cost+i)+"' y2='45' stroke='black'/>\n" +
                      " <polygon points='"+(31+cost+i)+",40 "+(35+cost+i)+",45 "+(31+cost+i)+",50' stroke='black' fill='black'/>\n");
            
            sb.append(" <rect x='"+(36+cost+i)+"' y='30' width='"+ cost +"' height='30' stroke='black' fill='white'/>\n" +
                      " <text x='"+ ((36+cost+i) + (cost)/2 -((in==0) ? 1 : (int)((Math.log10(Math.abs(in))+ ((in<0) ? 2 : 1))*8)/2)) +"' y='50' font-family='Verdana' font-size='15'>" + in + "</text>\n"); 

            i+=26+cost;

        }

        sb.append(" </g>\n");
        sb.append("</svg>\n");

        return sb.toString();
    }
}
