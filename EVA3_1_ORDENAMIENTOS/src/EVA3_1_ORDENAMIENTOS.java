public class EVA3_1_ORDENAMIENTOS {
    public static void main(String[] args) throws Exception {
        int[] original, selection, insertion, bubble, quick;
        long ini, fin, tiempo;
        original = new int [10];
        //***************** ARREGLO ORIGINAL ***************
        //llenamos el arreglo
        llenar(original);
        System.out.println("++++++++++ARREGLO ORIGINAL+++++++++++++");
        imprimir(original);
        //SELECTION SORT
        System.out.println("++++++++++SELECTION SORT+++++++++++++");
        selection = copiar(original);
        ini = System.nanoTime();
        selectionSort(selection);
        fin = System.nanoTime();
        tiempo = fin - ini;
        imprimir(selection);
        System.out.println("Selection Sort: " + tiempo);
        //INSERTION SORT
        System.out.println("++++++++++INSERTION SORT+++++++++++++");
        insertion = copiar(original);
        ini = System.nanoTime();
        insertionSort(insertion);
        fin = System.nanoTime();
        tiempo = fin - ini;
        imprimir(insertion);
        System.out.println("Insertion Sort: " + tiempo);
        //BUBBLE SORT
        System.out.println("++++++++++BUBBLE SORT+++++++++++++");
        bubble = copiar(original);
        ini = System.nanoTime();
        bubbleSort(bubble);
        fin = System.nanoTime();
        tiempo = fin - ini;
        imprimir(bubble);
        System.out.println("Bubble Sort: " + tiempo);
        //QUICK SORT
        System.out.println("++++++++++QUICK SORT+++++++++++++");
        quick = copiar(original);
        ini = System.nanoTime();
        quickSort(quick);
        fin = System.nanoTime();
        tiempo = fin - ini;
        imprimir(quick);
        System.out.println("Quick Sort: " + tiempo);

    
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
 
     public static int[] copiar(int[] arreglo){
       int resu[] = new int[arreglo.length];
       for (int i = 0; i < arreglo.length; i++) {
           resu[i] = arreglo[i];
       }
       return resu;
    }

    //METODOS DE ORDENAMIENTO
    //SELECTION SORT
    //O(N^2)
    //O(N^2) COMPARA MÁS
    //O(N) INTERCAMBIA MENOS
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
    public static void insertionSort(int arreglo[]){
        for (int i = 0; i < arreglo.length; i++){
            int temp = arreglo[i];
            int previo = i-1;
            while (previo >= 0 && arreglo[previo] > temp){
                arreglo[previo + 1] = arreglo[previo];
                previo--;
            }
            arreglo[previo + 1] = temp;
        }
    }
    //EL PEOR DE TODOS
    //O(N2)
    //TIENE LOS PEORES ATRIBUTOS DE LOS ALGORITMOS ANTERIORES
    //COMPARA MUCHO
    //INTERCAMBIA MUCHO
    //TENTADOR: ES EL MAS SENCILLO
    public static void bubbleSort(int arreglo[]){
        for (int i = 0; i < arreglo.length; i++){
            for (int j = 0; j < arreglo.length - 1; j++){
                if(arreglo[j] > arreglo[j + 1]){ //INTERCAMBIO O(N2)
                    int temp = arreglo[j]; //COMPARACIONES O(N2)
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }
    public static void quickSort(int[] arreglo){
        if (arreglo != null && arreglo.length > 1){
            quickSortRec(arreglo, 0, arreglo.length - 1);
        }
    }
    private static void quickSortRec(int[] arreglo, int ini, int fin){
        //CONDICION PARA EVITAR RECURSIVIDAD
        if (ini >= fin){
            return;
        }
        //SELECCIONAR EL PIVOTE -----> CUALQUIERA, NOSOTROS EL PRIMER ELEMENTO
        int pivote = arreglo[ini];
        int izq = ini + 1;
        int der = fin;
        //UN CICLO QUE SE REPITE MIENTRAS LOS INDICES NO SE CRUCEN
        while(izq <= der){

            //UN CICLO QUE BUSQUE LOS MAS GRANDES QUE EL PIVOTE
            while(izq <= der && arreglo[izq] <= pivote){
                izq++;
            }
            //UN CICLO QUE BUSQUE LOS MAS PEQUEÑOS
            while(izq <= der && arreglo[der] > pivote){
                der--;
            }
            //SI NO SE HAN CRUZADO, PERO SE DETUVIERON
            if(izq < der){
                //INTERCAMBIAR
                int temp = arreglo[izq];
                arreglo[izq] = arreglo[der];
                arreglo[der] = temp;
                izq++;
                der--;
            }
        }
        //SI SE CRUZAN:
        //INTERCAMBIAR SMALL CON PIVOTE ------> SMALL ES EL NUEVO PIVOTE
        int temp = arreglo[ini];
        arreglo[ini] = arreglo[der];
        arreglo[der] = temp;

        //TERMINAR EL CICLO PRINCIPAL

        //LLAMADAS (2 IZQ Y DER EL PIVOTE) RECURSIVAS
        quickSortRec(arreglo, ini, der - 1);
        quickSortRec(arreglo, der + 1, fin);
    }

}
