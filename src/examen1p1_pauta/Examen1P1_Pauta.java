/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1p1_pauta;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Examen1P1_Pauta {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion;
        do{
            System.out.println("1) Descifrar la Combinacion");
            System.out.println("2) Rotacion Circular de Arreglo");
            System.out.println("3) Bono: Suma De Binarios");
            System.out.println("4) Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            switch(opcion){
                case 1:
                    descifrarCombinacion();
                    break;
                case 2:
                    rotacionCircular();
                    break;
                case 3:
                    bono();
                case 4:
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }while(opcion!=4);
    }
    public static void descifrarCombinacion(){
        
        //Solicita dificultad al usuario
        System.out.println("1) Facil");
        System.out.println("2) Media");
        System.out.println("3) Dificil");
        System.out.print("Indique el Nivel de Dificultad: ");
        int opcion = scanner.nextInt();
        int intentos, tamanoArreglo;
        char[] arregloCombinacion;
        char[] arregloProgreso;
        boolean combinacionEncontrada = false;
        int i =1;
        switch(opcion){
            case 1:
                // Dficultad Facil
                intentos = 22;
                tamanoArreglo = 6;
                
                // Generar combinacion a buscar y arreglo de progreso.
                arregloCombinacion = crearCombinacion(tamanoArreglo);
                arregloProgreso = llenarArregloProgreso(tamanoArreglo);
                //mostrarCombinacion(arregloCombinacion);
                i =1;
                while(i<=intentos){
                    System.out.println("Intento " + i + "/" + intentos);
                    System.out.print("Su progreso: ");
                    mostrarCombinacion(arregloProgreso);
                    System.out.print("Ingrese un caracter: ");
                    char caracterBuscar = scanner.next().charAt(0);
                    arregloProgreso = adivinarCombinacion(arregloCombinacion, arregloProgreso, caracterBuscar);
                    
                    // Se verifica si la cadena fue encontrada.
                    combinacionEncontrada = seEncontro(arregloCombinacion, arregloProgreso);
                    if(combinacionEncontrada == true){
                        break;
                    }
                    i++;
                }
                
                if(combinacionEncontrada == true){
                    System.out.print("Has descifrado la cadena ");
                    mostrarCombinacion(arregloProgreso);
                }
                else{
                    System.out.print("No lograste descifrar la cadena. La cadena era ");
                    mostrarCombinacion(arregloCombinacion);
                }
                break;
            case 2:
                //Dificultad Media
                intentos = 20;
                tamanoArreglo = 8;
                
                // Generar combinacion a buscar y arreglo de progreso.
                arregloCombinacion = crearCombinacion(tamanoArreglo);
                arregloProgreso = llenarArregloProgreso(tamanoArreglo);
                //mostrarCombinacion(arregloCombinacion);
                i = 1;
                while(i<=intentos){
                    System.out.println("Intento " + i + "/" + intentos);
                    System.out.print("Su progreso: ");
                    mostrarCombinacion(arregloProgreso);
                    System.out.print("Ingrese un caracter: ");
                    char caracterBuscar = scanner.next().charAt(0);
                    arregloProgreso = adivinarCombinacion(arregloCombinacion, arregloProgreso, caracterBuscar);
                    
                    // Se verifica si la cadena fue encontrada.
                    combinacionEncontrada = seEncontro(arregloCombinacion, arregloProgreso);
                    if(combinacionEncontrada == true){
                        break;
                    }
                    i++;
                }
                if(combinacionEncontrada == true){
                    System.out.print("Has descifrado la cadena ");
                    mostrarCombinacion(arregloProgreso);
                }
                else{
                    System.out.print("No lograste descifrar la cadena. La cadena era ");
                    mostrarCombinacion(arregloCombinacion);
                }
                break;
            case 3:
                //Dificultad Dificil
                intentos = 18;
                tamanoArreglo = 10;
                
                // Generar combinacion a buscar y arreglo de progreso.
                arregloCombinacion = crearCombinacion(tamanoArreglo);
                arregloProgreso = llenarArregloProgreso(tamanoArreglo);
                i =1;
                while(i<=intentos){
                    System.out.println("Intento " + i + "/" + intentos);
                    System.out.print("Su progreso: ");
                    mostrarCombinacion(arregloProgreso);
                    System.out.print("Ingrese un caracter: ");
                    char caracterBuscar = scanner.next().charAt(0);
                    arregloProgreso = adivinarCombinacion(arregloCombinacion, arregloProgreso, caracterBuscar);
                    
                    // Se verifica si la cadena fue encontrada.
                    combinacionEncontrada = seEncontro(arregloCombinacion, arregloProgreso);
                    if(combinacionEncontrada == true){
                        break;
                    }
                    i++;
                    System.out.println("");
                }
                if(combinacionEncontrada == true){
                    System.out.print("Has descifrado la cadena ");
                    mostrarCombinacion(arregloProgreso);
                }
                else{
                    System.out.print("No lograste descifrar la cadena. La cadena era ");
                    mostrarCombinacion(arregloCombinacion);
                }
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                break;
        
        }
    }
    public static char[] crearCombinacion(int tamanoArreglo){
        char[] arregloCombinacion = new char[tamanoArreglo];
        for (int i = 0; i < arregloCombinacion.length; i++) {
            int randomNum = random.nextInt(26) + 97;
            arregloCombinacion[i] = (char) randomNum;
        }
        return arregloCombinacion;
    }
    public static char[] llenarArregloProgreso(int tamanoArreglo){
        char[] arregloProgreso = new char[tamanoArreglo];
        for (int i = 0; i < arregloProgreso.length; i++) {
            arregloProgreso[i] = '-';
        }
        return arregloProgreso;
    }
    public static void mostrarCombinacion(char[] arreglo){
        for (int i = 0; i < arreglo.length ; i++) {
            System.out.print(arreglo[i]);
        }
        System.out.println("");
    }
    public static char[] adivinarCombinacion(char[] arregloCombinacion, char[] arregloProgreso, char caracter){
        for (int i = 0; i < arregloCombinacion.length; i++) {
            if(arregloCombinacion[i] == caracter){
                arregloProgreso[i] = caracter;
            }
        }
        return arregloProgreso;
    }
    public static boolean seEncontro(char[] arregloCombinacion, char[] arregloProgreso){
        for (int i = 0; i < arregloCombinacion.length; i++) {
            if(arregloCombinacion[i] != arregloProgreso[i]){
                return false;
            }
        }
        return true;
    }
    public static void rotacionCircular(){
        // Obtiene tamaño de arreglo
        System.out.print("Ingrese el tamano del arreglo: ");
        int tamaño = scanner.nextInt();

        // Llenar arreglo con randoms
        int[] arreglo = llenarArreglo(tamaño);

        // Mostrar el arreglo generado
        System.out.print("Arreglo generado: ");
        mostrarArreglo(arreglo);

        // Ingresa cadena de rotacion
        System.out.print("Ingrese la cadena de rotacion (formato i|d:numero): ");
        String entrada = scanner.next();

        // Obtiene direccion de movimiento y cantidad de posiciones a mover
        char direccion = entrada.charAt(0);
        int k = Integer.parseInt(entrada.substring(2));

        // Se rota el arreglo
        int[] arregloModificado = rotarArreglo(arreglo, direccion, k);

        // Mostrar el arreglo después de la rotación
        System.out.print("Arreglo despues de la rotacion: ");
        mostrarArreglo(arregloModificado);
    }
    public static void mostrarArreglo(int[] arreglo) {
        System.out.print("[");
        for (int num : arreglo) {
            System.out.print(" "+num + " ");
        }
        System.out.println("]");
        System.out.println();
    }
    public static int[] llenarArreglo(int tamaño) {
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = random.nextInt(100) + 1;
        }
        return arreglo;
    }
    public static int[] rotarArreglo(int[] arreglo, char direccion, int k) {
        int tamaño = arreglo.length;

        // Validar que k no sea mayor que el tamaño del arreglo
        if (k > tamaño) {
            System.out.println("El número de posiciones a rotar (k) no puede ser mayor que el tamaño del arreglo.");
            return arreglo;
        }

        if (direccion == 'i') {
            // Rotación hacia la izquierda
            for (int i = 0; i < k; i++) {
                rotacionIzquierdaBurbuja(arreglo);
            }
        } else if (direccion == 'd') {
            // Rotación hacia la derecha
            for (int i = 0; i < k; i++) {
                rotacionDerechaBurbuja(arreglo);
            }
        } else {
            System.out.println("Dirección inválida.");
            return arreglo;
        }
        return arreglo;
    }
    public static void rotacionIzquierdaBurbuja(int[] arreglo) {
        int primero = arreglo[0];
        for (int i = 0; i < arreglo.length - 1; i++) {
            arreglo[i] = arreglo[i + 1];
        }
        arreglo[arreglo.length - 1] = primero;
    }

    // Método para rotación cíclica hacia la derecha usando un enfoque tipo burbuja
    public static void rotacionDerechaBurbuja(int[] arreglo) {
        int ultimo = arreglo[arreglo.length - 1];
        for (int i = arreglo.length - 1; i > 0; i--) {
            arreglo[i] = arreglo[i - 1];
        }
        arreglo[0] = ultimo;
    }
    public static void imprimirbinario(int [] num){
        System.out.print("[");
        for(int i=0; i<num.length;i++){
            System.out.print(num[i]);
        }
        System.out.println("]");
    }
    public static void bono(){
        int num1, num2;
        
        //Obtener los valores decimales
        
        System.out.print("Ingrese primer valor entero: ");
        num1 = scanner.nextInt();
        System.out.print("Ingrese segundo valor entero: ");
        num2 = scanner.nextInt();
        
        //Convertir decimal a binario y mostrarlos
        int[] binario1 = dec2bin(num1);
        int[] binario2 = dec2bin(num2);
        System.out.print(num1 + " -> ");
        imprimirbinario(binario1);
        System.out.print(num2 + " -> ");
        imprimirbinario(binario2);
        
        // Proceso de suma de binarios
        System.out.println("-----Suma Binaria-----");
        System.out.print("Binario 1: ");
        imprimirbinario(binario1);
        System.out.print("Binario 2: ");
        imprimirbinario(binario2);
        System.out.print("Respuesta: ");
        int[] respSumaBinaria = sumaBinaria(binario1, binario2);
        imprimirbinario(respSumaBinaria);
    }
    public static int[] dec2bin(int num){
        int[] binario = new int[8];
        for(int i=binario.length-1;i>=0;i--){
            if( num % 2 != 0){
                binario[i] = 1;
            }
            else{
                binario[i] = 0;
            }
            num = num/2;
        }
        return binario;
    }
    public static int[] sumaBinaria(int[] arreglo1, int[] arreglo2){
        int[] respArreglo = new int [arreglo1.length];
        int carryOver = 0;
        for (int i = arreglo1.length-1; i >=0; i--) {
            if((arreglo1[i] == 0 && arreglo2[i] == 0) && carryOver==0){
                respArreglo[i] = 0;
            }
            else if(((arreglo1[i] == 1 && arreglo2[i] == 0) || (arreglo1[i] == 0 && arreglo2[i] == 1)) && carryOver==0){
                respArreglo[i] = 1;
            }
            else if(arreglo1[i] == 1 && arreglo2[i] == 1 && carryOver==0){
                respArreglo[i] = 0;
                carryOver = 1;
            }
            else if((arreglo1[i] == 0 && arreglo2[i] == 0) && carryOver==1){
                respArreglo[i] = 1;
                carryOver = 0;
            }
            else if(((arreglo1[i] == 1 && arreglo2[i] == 0) || (arreglo1[i] == 0 && arreglo2[i] == 1)) && carryOver==1){
                respArreglo[i] = 0;
            }
            else if(arreglo1[i] == 1 && arreglo2[i] == 1 && carryOver==1){
                respArreglo[i] = 1;
                carryOver = 1;
            }
        }
        return respArreglo;
    }
}
