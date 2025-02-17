package UT3;

import java.util.Scanner;

public class ExamenControlB {

    public static void main(String[] args) {
        ej3();
    }

    /**
     * El código cuenta números pares introducidos por teclados. Para al introducir un -1.
     * c es la variable que cuenta cuantos impares hay. Es, por tanto, un contador.
     */
    public static void ej1(){
        Scanner sc = new Scanner(System.in);
        int c = 0;
        int n = 1;
        do {
            n = sc.nextInt();
            if (n%2==0){
                c++;
            }
        } while (n!=-1);
        System.out.println(c);
    }

    /**
     * Crea un programa que pida una frase por teclado y devuelva esa misma frase pero invertida y eliminando vocales.
     */
    public static void ej2(){
        Scanner sc = new Scanner(System.in);                            //Creamos un Scanner para poder leer por teclado
        String frase = sc.nextLine();                                   //Leemos una frase y la almacenamos en una variable de tipo String
        for (int i = frase.length()-1; i>=0; i--) {                     //Entramos en un bucle for. Como queremos invertir la cadena, el bucle comienza desde el final (lenght-1) y acaba en 0
            char c = frase.charAt(i);                 
            if (c!='a'&&c!='e'&&c!='i'&&c!='o'&&c!='u') {               //Filtramos las vocales. Hay que comprobar todas ellas en una función lógica multiple usando operadores AND
                System.out.print(c);                                    //Mostramos por pantalla el caracter. Usamos print en lugar de println para queden todos en la misma linea
            }
        }
        System.out.println();                                           //Pintamos un intro al final del código
    }

    /**
     * Escribe una función que calcule si un número introducido por parámetro es o no primo. 
     * Utililza esa fución para mostrar el producto de los primeros N números primos, siendo N un número introducido por teclado.
     */
    public static void ej3(){
        Scanner sc = new Scanner(System.in);                            //Creamos un Scanner para poder leer por teclado
        int n = sc.nextInt();                                           //Leemos un entero que representa el número de primos que queremos tener
        int contador = 0;                                               //Creamos un contador para almacenar cuantos primos hemos encontrado
        int sumaPrimos = 0;                                             //Creamos un acumulador para el producto de primos

        for (int i = 1; contador<n; i++) {                              //Entramos en un bucle. i representa los números sospechosos de ser primos. La condición de salida no depende de i, sino de contador, pues queremos un número concreto de primos en lugar de los primos hasta un número concreto
            if (!esPrimo(i)) {                                          //Llamamos a nuestra función para comprobar si i es o no primo
                contador++;                                             //Si no lo es, aumentamos el contador de primos encontrados
                sumaPrimos+=i;                                          //También multiplicamos el producto acumulado por el nuevo número primo
                System.out.print(i+" ");                                //Lo podemos mostrar por pantalla para asegurarnos de que todo va bien
            }
        }
        System.out.println("\nSuma: " + sumaPrimos);                    //Finalmente, mostramos por pantalla el profucto

    }  

    /**
     * Calcula si un número es o no primo
     * @param numero El número sospechoso de ser primo
     * @return Un booleano que vale true si numero es primo y false en caso contrario
     */
    public static boolean esPrimo(int numero){
        boolean primo = true;                                           //Creamos una variable booleana para el retorno de la función. Damos por hecho que el número es primo inicialmente. Cuando encontremos algún divisor, ademas de 1 o de si mismo, cambiaremos el booleano por false
        if (numero<2) {                                                 //Ningún número inferior a 2 es primo
            primo = false;
        }
        for (int i = 2; i <= numero/2 && primo; i++) {                  //Entramos en un bulcle. Comienza en 2, pues no queremos comprobar la divisibilidad entre 1. Acaba en la mitad del número, pues ningún número es divisible entre más de su mitad. Añadimos una segunda condición de parada, por eficiencia, cuando se detecte que el número no es primo
            if (numero%i==0) {                                          //Si el número es divisible entre i (cualquier número entre 2 y su mitad), no es primo
                primo = false;                                          //En consecuencia, actualizamos nuestro booleano como false, que llevaría a la finalización del bucle
            }
        }
        return primo;                                                   //Retornamos el booleano con la información de si el número es o no primo
    }
}