package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Cola;

public class GraficadorCola {

    private Cola<Integer> ci = new Cola<>();

    public GraficadorCola(Cola<Integer> ci){
        this.ci = ci;
    }

    public String grafica(){
        if(ci.esVacia()) return "";

        Cola<Integer> cAux = new Cola<>();
        int maxi = Integer.MIN_VALUE;
        int elem = 0;

        while(!ci.esVacia()){
            int i = ci.saca();
            cAux.mete(i);
            maxi = Math.max(maxi, Math.abs(i));
            elem++;
        }

        int cost = Math.max(50, (int)((Math.log10(maxi)+1)*15));

        StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='UTF-8' ?>\n"); 
        sb.append("<svg width='" + elem*(cost+35) +"' height='100'>\n");
        sb.append(" <g>\n");

        int i = cAux.saca();
        sb.append(" <rect x='10' y='30' width='"+ cost +"' height='30' stroke='black' fill='white'/>\n" +
                  " <text x='"+(10+(cost)/2 -((int)((Math.log10(Math.abs(i))+ ((i<0) ? 2 : 1))*8)/2))+"' y='50' font-family='Verdana' font-size='15'>" + i + "</text>\n");
        sb.append(" <line x1='5' y1='25' x2='"+ elem*(cost+25)+"' y2='25' stroke='black'/>\n"+
                  "\t<line x1='5' y1='65' x2='"+ elem*(cost+25) +"' y2='65' stroke='black'/>\n");

        sb.append(" <line x1='"+(11+cost)+"' y1='45' x2='"+(35+cost)+"' y2='45' stroke='black'/>\n" +
                  " <polygon points='"+(31+cost)+",40 "+(35+cost)+",45 "+(31+cost)+",50' stroke='black' fill='black'/>\n");
        
        i=0;
        
        while(!cAux.esVacia()){
            int in = cAux.saca();
            sb.append("\n <!-- Draw Element -->\n");
            
            sb.append(" <rect x='"+(36+cost+i)+"' y='30' width='"+ cost +"' height='30' stroke='black' fill='white'/>\n" +
                      " <text x='"+ ((36+cost+i) + (cost)/2 -((int)((Math.log10(Math.abs(in))+ ((in<0) ? 2 : 1))*8)/2)) +"' y='50' font-family='Verdana' font-size='15'>" + in + "</text>\n");
            
            sb.append(" <line x1='"+(37+2*cost+i)+"' y1='45' x2='"+(61+2*cost+i)+"' y2='45' stroke='black'/>\n" +
                      " <polygon points='"+(57+2*cost+i)+",40 "+(61+2*cost+i)+",45 "+(57+2*cost+i)+",50' stroke='black' fill='black'/>\n");

            i+=26+cost;

        }

        sb.append(" </g>\n");
        sb.append("</svg>\n");

        return sb.toString();
    }
    
}
