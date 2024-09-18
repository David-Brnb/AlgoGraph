package mx.unam.ciencias.edd.proyecto2;


import mx.unam.ciencias.edd.Grafica;
import mx.unam.ciencias.edd.VerticeGrafica;
import mx.unam.ciencias.edd.Lista;

public class GraficadorGrafica {

    private double radius;
    private Grafica<Integer> ga; 
    private Lista<Integer> li;
    
    public GraficadorGrafica(Grafica<Integer> ga, Lista<Integer> vert){
        this.radius = (ga.getElementos()*120)/(2*Math.PI);
        this.ga = ga;
        this.li = vert;
    }

    public String graficador(){
        Lista<Tuple> tus = new Lista<>();
        Lista<Integer> visited = new Lista<>();
        double size = radius*2+60;
        double ang = (2*Math.PI)/ga.getElementos();

        double x = size/2;
        double y = size/2;

        String str = "";
        String str1 = "";
        String str2 = "";

        str += "<?xml version='1.0' encoding='UTF-8' ?>\n"+
                "<svg width='"+(size)+"' height='"+(size)+"'>\n"+
                "\t<g>\n";

        int e=1;
        for(int i: li){
            VerticeGrafica<Integer> vi = ga.vertice(i);

            tus.agrega(new Tuple(i, x+radius*Math.cos(e*ang), y+radius*Math.sin(e*ang)));

            str1+= "\t\t<circle cx='"+(x+radius*Math.cos(e*ang))+"' cy='"+(y+radius*Math.sin(e*ang))+"' r='20' stroke='black' stroke-width='3' fill='white' />\n " +
            "\t\t <text fill='black' font-family='sans-serif' font-size='20' x='"+(x+radius*Math.cos(e*ang))+"' y='"+(y+radius*Math.sin(e*ang)+5)+"' text-anchor='middle'>"+vi.get().toString()+"</text>\n";

            e++;

        }


        e=1;
        for(int i: li){
            visited.agrega(i);

            VerticeGrafica<Integer> vi = ga.vertice(i);
            Tuple ve = new Tuple(), vc = new Tuple();
            for(Tuple t: tus){
                if(t.getE1() == i){
                    ve=t;
                    break;
                }
            }

            for(VerticeGrafica<Integer> j : vi.vecinos()){
                for(Tuple t: tus){
                    if(t.getE1() == j.get()){
                        vc=t;
                        break;
                    }
                }

                if(!visited.contiene(j.get())) str2+= "\t\t<line x1='"+ve.getE2()+"' y1='"+ve.getE3()+"' x2='"+vc.getE2()+"' y2='"+vc.getE3()+"' stroke='black' stroke-width='3' />\n";
            }

            e++;

        }

        str += str2;

        str += str1;

        str +="\t</g>\n"+
                "</svg>\n";       

        return str;

    }
}
