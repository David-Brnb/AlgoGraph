package mx.unam.ciencias.edd.proyecto2;

public class RevisarEnteros {

    public RevisarEnteros(){}

    public void revisionEnteros(String args){
        for(int i=0; i<args.length(); i++){
            if(!(Integer.valueOf(args.charAt(i)) > 47 && Integer.valueOf(args.charAt(i)) < 58) && (Integer.valueOf(args.charAt(i)) !=45)) {
                
                System.out.println("\nArgumentos incorrectos. Se paso algo que no es entero \n" +
                           "Uso: java -jar proyecto2.jar <archivo>");
                System.exit(1);
            }
            
        }

        for(int i=0; i<args.length(); i++){
            if(Integer.valueOf(args.charAt(i)) == 45) {
                if(i==args.length()-1 || !(Integer.valueOf(args.charAt(i+1)) > 47 && Integer.valueOf(args.charAt(i+1)) < 58)){
                    System.out.println("\nArgumentos incorrectos. Se paso algo que no es entero \n" +
                            "Uso: java -jar proyecto2.jar <archivo>");
                    System.exit(1);
                }

                if(i<args.length()-1 && i>0){
                    if((Integer.valueOf(args.charAt(i-1)) > 47 && Integer.valueOf(args.charAt(i-1)) < 58) && (Integer.valueOf(args.charAt(i+1)) > 47 && Integer.valueOf(args.charAt(i+1)) < 58))
                    System.out.println("\nArgumentos incorrectos. Se paso algo que no es entero \n" +
                            "Uso: java -jar proyecto2.jar <archivo>");
                    System.exit(1);
                }
            }
        }
    }
}
