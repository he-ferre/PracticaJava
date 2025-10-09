import java.util.Scanner;


public class Main{
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String [] args){
        Categoria miListaDeCategorias = new Categoria();
        menu(miListaDeCategorias);
    }
    // En el main solo interactuo con el usuario (no importa como se manejan las listas y categorias);

    public static void menu(Categoria miListaDeCategorias){
        int aux = 0;
        while(aux != -1){
            System.out.println("1: Agregar empleado: ");
            System.out.println("2: Mostrar por categoria: ");
            System.out.println("-1: Salir: ");
            aux = scanner.nextInt();

            if(aux == 1){
                String nombre = "";
                String apellido = "";
                char categoria = ' ';
                int sueldo = 0;

                //Validacion de entradas

                nombre = validarEntrada("nombre");
                apellido = validarEntrada("apellido");
                categoria = validarEntradaCategoria();
                sueldo = validarSueldo();


                miListaDeCategorias.cargarEmpleado(nombre, apellido, categoria, sueldo);
            }else if(aux == 2){
                char categoria = ' ';
                categoria = validarEntradaCategoria();
                miListaDeCategorias.mostrarPorCategorias(categoria);
            }
        }
    }

    // Valido entradas Strings 
    private static String validarEntrada(String dato){
        scanner.nextLine();
        boolean continuar = false;
        String nombre0Apellido  = "";
        do {  
            System.out.println("Ingrese el " + dato + ": ");
            nombre0Apellido = scanner.nextLine();
            if(nombre0Apellido.isEmpty()){
                System.out.println("El dato no puede estar vacio: ");
                continuar = false;
            }else{
                continuar = true;
            }
            
        } while (!continuar);
        return nombre0Apellido;
    }
    // Valido entradas char
    private static char validarEntradaCategoria(){
        scanner.nextLine();
        boolean continuar = false;
        char categoria = ' ';

        do { 
            System.out.println("Ingrese la Categoria");
            categoria = scanner.nextLine().charAt(0);

            if(!Character.isDigit(categoria)){
                continuar = true;
            }else{
                System.out.println("Vuelva a ingresar el dato (La categoria debe ser una letra MAYUSCULA): ");
            }
        } while (!continuar);

        return categoria;
    }
    //Valido sueldo
    private static int validarSueldo(){
        boolean continuar = false;
        int sueldo = 0;
        do{
            try {
                System.out.println("Ingrese el sueldo: ");
                sueldo = scanner.nextInt();
                if( sueldo < 100000 || sueldo > 500000){
                    System.out.println("Ingrese un sueldo entre $100.000 y $500.000");
                }else{
                    continuar = true;
                }
            } catch (Exception e) {
                System.out.println("(Error , dato no valido). Ingrese el sueldo nuevamente: ");
                scanner.nextLine();
            }
        }while(!continuar);
        return sueldo;
    }

}