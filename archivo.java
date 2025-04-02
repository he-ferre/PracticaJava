public class archivo{
  public static void main(String [] args){  
        //Tp 2.8
        int [] arrOriginal1 = {0,0,1,2,0,4,0,0,1,2,0,0,9,1,0};
        int [] secuencia2 = {0,1,2,0,0,0,0,0,0,0,0,0,0,0,0};
        eliminarSecuencia2(arrOriginal1, secuencia2);  
  }
    private static void eliminarSecuencia2(int [] arrOriginal1, int [] secuencia2){
        // cuento el tamaño de la secuencia y guardo su inicio
        int inicioSecuencia = 0;
        int longitudSecuencia = 0;
        for(int t = 0; t <= secuencia2.length - 1; t++){
            if(secuencia2[t] != 0){
                if(longitudSecuencia == 0){
                    inicioSecuencia = t;
                }
                longitudSecuencia++;
            }
        }

        int i = 0;
        int t = inicioSecuencia;
        int cont = 0;
        int inicio = 0;
        while(i <= arrOriginal1.length - 1){
            //comparo los elementos de secuecia en su inicio y cada posicion del arreglo hasta encontrar la coincidencia. Esto se va a cumplir mientras que t no sobrepase la longitud de la secuencia
            if((arrOriginal1[i] == secuencia2[t]) && (t < t + longitudSecuencia) ){
                // si cont == 0 , significa que comienza la secuencia en arr
                //System.out.print(inicio);
                if(cont == 0){
                    inicio = i;
                }

                i++;
                t++;
                cont++;

                // Si cont == longitud de secuencia significa que se encontro una secuencia que cumple con los requisitos

                if (cont == longitudSecuencia) {
                    //corrimiento
                    for(int b = 1 ; b <= longitudSecuencia; b++ ){
                        for(int k = inicio; k < arrOriginal1.length -1 ; k++){
                            arrOriginal1[k] = arrOriginal1[k + 1];
                            }
                        } 
                    
                    cont = 0;

                    // reinicio las variables para que continuen desde las iteraciones correspondientes y no se salten elementos
                    i -= longitudSecuencia;
                    t -= longitudSecuencia;


                    }
            }
            else{
                i++;
            }
        }


        // Imprimo los nuevos valores de arr
        for(int f : arrOriginal1){
            System.out.print(f);
            }
        System.out.println("");
            System.out.println(i);
    }

}
