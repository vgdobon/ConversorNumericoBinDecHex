public class Conversion {
    private char [] conversionArray;

    public Conversion(){

    }


    //Opcion 1 Binario a Decimal
    public double binarioADecimal(String numeroBinario){

        conversionArray= new char[numeroBinario.length()];
        for (int i = 0; i < numeroBinario.length(); i++) {
            for (int j = numeroBinario.length()-1-i; j <=numeroBinario.length()-1-i ; j++) {
                conversionArray[j]=numeroBinario.charAt(i);
            }
        }

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
        double numeroDecimal=binarioADecimal(numeroBinario);
        int numeroDecimalInt=(int)numeroDecimal;

        return decimalAHexadecimal(numeroDecimalInt);
    }

    //-------------------------------------------------------------


    //Opcion 3 Decimal a Binario
    public String decimalABinario(int numeroDecimal){
        String numeroBinario="";
        boolean seguirOperando=true;

        while(seguirOperando){

            numeroBinario=numeroDecimal%2+numeroBinario;
            numeroDecimal=numeroDecimal/2;
            if(numeroDecimal<4){
                if(numeroDecimal>1){
                    int primerNumero=numeroDecimal/2;
                    int segundoNumero=numeroDecimal%2;
                    numeroBinario=" "+primerNumero+segundoNumero+numeroBinario;
                }else{
                    numeroBinario=numeroDecimal+numeroBinario;
                }


                seguirOperando=false;
            }
        }


        return numeroBinario;
    }


    //Opcion 4 Decimal a Hexadecimal
    public String decimalAHexadecimal(int numeroDecimal){
        boolean seguirOperando=true;
        String numeroHexadecimal="";
        int numeroResultante;

        while (seguirOperando){
            if(numeroDecimal>15){
                if(numeroDecimal%16>9){
                    if(numeroDecimal%16==10){
                        numeroHexadecimal="A"+numeroHexadecimal;
                    }else if(numeroDecimal%16==11){
                        numeroHexadecimal="B"+numeroHexadecimal;
                    }else if(numeroDecimal%16==12){
                        numeroHexadecimal="C"+numeroHexadecimal;
                    }else if(numeroDecimal%16==13){
                        numeroHexadecimal="D"+numeroHexadecimal;
                    }else if(numeroDecimal%16==14){
                        numeroHexadecimal="E"+numeroHexadecimal;
                    }else {
                        numeroHexadecimal="F"+numeroHexadecimal;
                    }
                }else{
                    int numero=numeroDecimal%16;
                    numeroHexadecimal=numero+numeroHexadecimal;
                }
            }else{
                if(numeroDecimal>9){
                    if(numeroDecimal==10){
                        numeroHexadecimal="A"+numeroHexadecimal;
                    }else if(numeroDecimal==11){
                        numeroHexadecimal="B"+numeroHexadecimal;
                    }else if(numeroDecimal==12){
                        numeroHexadecimal="C"+numeroHexadecimal;
                    }else if(numeroDecimal==13){
                        numeroHexadecimal="D"+numeroHexadecimal;
                    }else if(numeroDecimal==14){
                        numeroHexadecimal="E"+numeroHexadecimal;
                    }else{
                        numeroHexadecimal="F"+numeroHexadecimal;
                    }
                }else{
                    numeroHexadecimal=numeroDecimal+numeroHexadecimal;
                }
                seguirOperando=false;
            }

            numeroDecimal=numeroDecimal/16;


        }
        return numeroHexadecimal;
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
