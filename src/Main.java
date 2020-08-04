import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean ejecucion=true;
        String numeroBinario;
        int numeroDecimal;
        String numeroHexadecimal;
        String masOperaciones="";
        Conversion conversion=new Conversion();
        System.out.println("CONVERSOR ENTRE SISTEMA DECIMAL\\BINARIO\\HEXADECIMAL");
        System.out.println("_____________________________________________________");
        System.out.println();
        do {
            System.out.println("Elija la opcion que desea realizar: \n1.Binario a Decimal \n2.Binario a Hexadecimal \n" +
                    "3.Decimal a Binario \n4.Decimal a Hexadecimal \n5.Hexadecimal a Decimal \n6.Hexadecimal a Binario");
            int eleccion = sc.nextInt();
            sc.nextLine();

            switch (eleccion){
                case 1:
                    System.out.println("Introduzca un número en binario");
                    numeroBinario=sc.nextLine();
                    System.out.println("El numero binario: "+numeroBinario+" en decimal es :"+conversion.binarioADecimal(numeroBinario)+"\n");
                    break;

                case 2:
                    System.out.println("Introduzca un número en binario");
                    numeroBinario=sc.nextLine();
                    System.out.println("El numero binario: "+numeroBinario+" en hexadecimal es :"+conversion.binarioAHexadecimal(numeroBinario)+"\n");
                    break;

                case 3:
                    System.out.println("Introduzca un número en decimal");
                    numeroDecimal=sc.nextInt();
                    System.out.println("El numero decimal: "+numeroDecimal+" en binario es :"+conversion.decimalABinario(numeroDecimal)+"\n");
                    break;

                case 4:
                    System.out.println("Introduzca un número en decimal");
                    numeroDecimal=sc.nextInt();
                    System.out.println("El numero decimal: "+numeroDecimal+" en hexadecimal es :"+conversion.decimalAHexadecimal(numeroDecimal)+"\n");
                    break;

                case 5:
                    System.out.println("Introduzca un número en hexadecimal");
                    numeroHexadecimal=sc.nextLine();
                    System.out.println("El numero hexadecimal: "+numeroHexadecimal+" en decimal es :"+conversion.hexadecimalADecimal(numeroHexadecimal)+"\n");
                    break;

                case 6:
                    System.out.println("Introduzca un número en hexadecimal");
                    numeroHexadecimal=sc.nextLine();
                    System.out.println("El numero hexadecimal: "+numeroHexadecimal+" en binario es :"+conversion.hexadecimalABinario(numeroHexadecimal)+"\n");
                    break;

                default:
                    System.out.println("No ha escogido una opcion correcta. Introduzca un numero entre 1 y 6.");
            }

            System.out.println("¿Quieres realizar alguna operación más? [S/n]");
            masOperaciones=sc.nextLine();

            if(masOperaciones.equalsIgnoreCase("n")){
                ejecucion=false;
            }


        } while (ejecucion);
    }
}
