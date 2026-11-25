import java.util.Scanner;

public class EVA3_3_BUSQUEDA_BINARIA {

    public static void main(String[] args) throws Exception {
        int[] original, selection;
        long ini, fin, tiempo;
        original = new int [10];
        //***************** ARREGLO ORIGINAL ***************
        //llenamos el arreglo
        llenar(original);
        System.out.println("++++++++++ARREGLO ORIGINAL+++++++++++++");
        imprimir(original);
        //ORDENAR
        selectionSort(original);
        System.out.println("Arreglo Ordenado");
        imprimir(original);
        //VALOR A BUSCAR
        Scanner captu = new Scanner (System.in);
        System.out.println("Valor a buscar: ");
        int valor = captu.nextInt();
        System.out.println("Valor en posicion: " + busquedaBinaria(original, valor));
    }
     public static void llenar(int[] arreglo){
for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int)(Math.random() * 100);
        }
    }
   
       public static void imprimir(int[] arreglo){
for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
    public static void selectionSort(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++){ //CONTROLA LAS PASADAS
            int min = i; // cuando empiezo, el más pequeño es el primer elemento
            for (int j = i + 1; j < arreglo.length; j++){ //BUSCA EL VALOR MAS PEQUEÑO
                if (arreglo[min] > arreglo[j]) { // nuevo minimo
                min = j;
                }
            }
            // intercambio o swap
                int temp = arreglo[min];
                arreglo[min] = arreglo[i];
                arreglo[i] = temp;
        }    
    }
    public static int busquedaBinaria(int[] arreglo, int valor){
        return busquedaBinariaRecu(arreglo, valor, 0, arreglo.length -1);
    }
    private static int busquedaBinariaRecu(int[] arreglo, int valor, int ini, int fin){
        int mitad = ini + ((fin - ini) / 2); //determina la posicion intermedia
        int posicion = -1; //por default --------> no encontrado (-1 no es posicion valida)
        if (ini <= fin){
        if(valor > arreglo[mitad]) //no esta ------> buscar en el lado derecho
            posicion = busquedaBinariaRecu( arreglo, valor, mitad + 1, fin);
            else if (valor < arreglo[mitad]) //mo esta -------> buscar en el lado izquierdo
            posicion = busquedaBinariaRecu(arreglo, valor, ini, mitad -1);
            else // lo encontre
            posicion = mitad;
        }
        return posicion; //regreso la posicion del elemento
    }
}
