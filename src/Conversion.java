public class Conversion {
    private char [] conversionArray;

    public Conversion(){

    }


    //Opcion 1 Binario a Decimal
    public double binarioADecimal(String numeroBinario){
        //Mete el binario como String de forma inversa al array de char
        // ( Ej: String 001 -> Array char 100)
        conversionArray= new char[numeroBinario.length()];
        for (int i = 0; i < numeroBinario.length(); i++) {
            for (int j = numeroBinario.length()-1-i; j <=numeroBinario.length()-1-i ; j++) {
                conversionArray[j]=numeroBinario.charAt(i);
            }
        }
        //Sumatorio de los bits activados * potencia(2,elevado al indice
        double sumatorio=0;
        for (int i = 0; i <conversionArray.length; i++) {
            if(conversionArray[i]=='1'){
                sumatorio=sumatorio+Math.pow(2,i);
            }

        }
        return sumatorio;
    }


    //Opcion 2 Binario a Hexadecimal
    public String binarioAHexadecimal(String numeroBinario){
        //Usando los metodos de binarioADecimal y decimalABinario
        double numeroDecimal=binarioADecimal(numeroBinario);
        int numeroDecimalInt=(int)numeroDecimal;

        return decimalAHexadecimal(numeroDecimalInt);
    }

    //-------------------------------------------------------------


    //Opcion 3 Decimal a Binario
    public String decimalABinario(int numeroDecimal){
        //Creamos nuevo StringBuilder para poder usar sus metodos
        StringBuilder numeroBinario= new StringBuilder();
        boolean seguirOperando=true;

        while(seguirOperando){
            //Metodo insert(posicion(0-N),dato a introducir)
            //Guardamos el modulo de 2 del numeroDecimal en el StringBuilder
            numeroBinario.insert(0, numeroDecimal % 2);
            //Sobrescribimos numeroDecimal con el cociente
            numeroDecimal=numeroDecimal/2;
            //Si el numero es menor que 4 terminamos la operacion
            if(numeroDecimal<4){
                if(numeroDecimal>1){
                    int primerNumero=numeroDecimal/2;
                    int segundoNumero=numeroDecimal%2;
                    numeroBinario.insert(0, " " + primerNumero + segundoNumero);
                }else{
                    numeroBinario.insert(0, numeroDecimal);
                }


                seguirOperando=false;
            }
        }


        return numeroBinario.toString();
    }


    //Opcion 4 Decimal a Hexadecimal
    public String decimalAHexadecimal(int numeroDecimal){
        boolean seguirOperando=true;
        StringBuilder numeroHexadecimal= new StringBuilder();

        while (seguirOperando){
            if(numeroDecimal>15){
                if(numeroDecimal%16>9){
                    if(numeroDecimal%16==10){
                        numeroHexadecimal.insert(0, "A");
                    }else if(numeroDecimal%16==11){
                        numeroHexadecimal.insert(0, "B");
                    }else if(numeroDecimal%16==12){
                        numeroHexadecimal.insert(0, "C");
                    }else if(numeroDecimal%16==13){
                        numeroHexadecimal.insert(0, "D");
                    }else if(numeroDecimal%16==14){
                        numeroHexadecimal.insert(0, "E");
                    }else {
                        numeroHexadecimal.insert(0, "F");
                    }
                }else{
                    int numero=numeroDecimal%16;
                    numeroHexadecimal.insert(0, numero);
                }
            }else{
                if(numeroDecimal>9){
                    if(numeroDecimal==10){
                        numeroHexadecimal.insert(0, "A");
                    }else if(numeroDecimal==11){
                        numeroHexadecimal.insert(0, "B");
                    }else if(numeroDecimal==12){
                        numeroHexadecimal.insert(0, "C");
                    }else if(numeroDecimal==13){
                        numeroHexadecimal.insert(0, "D");
                    }else if(numeroDecimal==14){
                        numeroHexadecimal.insert(0, "E");
                    }else{
                        numeroHexadecimal.insert(0, "F");
                    }
                }else{
                    numeroHexadecimal.insert(0, numeroDecimal);
                }
                seguirOperando=false;
            }

            numeroDecimal=numeroDecimal/16;


        }
        return numeroHexadecimal.toString();
    }


    //------------------------------------------------------------

    //Opcion 5 Hexadecimal a Decimal
    public double hexadecimalADecimal(String numeroHexadecimal){
        int a=10;
        int b=11;
        int c=12;
        int d=13;
        int e=14;
        int f=15;
        conversionArray=new char[numeroHexadecimal.length()];
        for (int i = 0; i < numeroHexadecimal.length(); i++) {
            for (int j = conversionArray.length-1-i; j <= conversionArray.length-1-i; j++) {
                conversionArray[j]=numeroHexadecimal.charAt(i);
            }
        }
        double sumatorio=0;
        for (int i = 0; i < conversionArray.length; i++) {
            double numero;
            if(conversionArray[i]=='A'){
                numero = a*Math.pow(16,i);
            }else if(conversionArray[i]=='B'){
                numero = b*Math.pow(16,i);
            }else if(conversionArray[i]=='C'){
                numero = c*Math.pow(16,i);
            }else if(conversionArray[i]=='D'){
                numero = d*Math.pow(16,i);
            }else if(conversionArray[i]=='E'){
                numero = e*Math.pow(16,i);
            }else if(conversionArray[i]=='F'){
                numero = f*Math.pow(16,i);
            }else{
                numero=(conversionArray[i]-'0')*Math.pow(16,i);
            }
            sumatorio=numero+sumatorio;
        }

        return sumatorio;
    }


    //Opcion 6 Hexadecimal a Binario
    public String hexadecimalABinario(String numeroHexadecimal){

        int numeroDecimal=(int)hexadecimalADecimal(numeroHexadecimal);

        return decimalABinario(numeroDecimal);
    }
}
