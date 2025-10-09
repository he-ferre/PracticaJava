

public class Categoria{
    private NodoCategoria primera;

    public Categoria(){
        this.primera = null;
    }

    public void cargarEmpleado(String nombre, String apellido, char categoria, int sueldo){
        // Busco y agrego la categoria en caso de que no exista
        NodoCategoria categoriaAgregarEmpleado = cargarYBuscarCategoria(categoria);

        agregarEmpleado(categoriaAgregarEmpleado, nombre, apellido, sueldo );
    }


    private NodoCategoria cargarYBuscarCategoria(char categoria){
        NodoCategoria actual = primera;
        while((actual != null)&&(actual.getTipoCategoria() != categoria )){
            actual = actual.getSiguiente();
        }
        if (actual == null){
            actual = agregarCategoriaOrdenada(categoria);
            System.out.println("Se agrego una nueva categoria. ");
        }else{
            System.out.println("Se encontro la categoria. ");
        }
        return actual;
    }

    private NodoCategoria agregarCategoriaOrdenada(char categoria){
        NodoCategoria actual = primera;
        NodoCategoria anterior = null;
        NodoCategoria nuevaCategoria = new NodoCategoria(categoria);

        if(primera == null){
            primera = nuevaCategoria;
        }else{
            while((actual != null) && actual.getTipoCategoria() > categoria){
                anterior = actual;
                actual = actual.getSiguiente();
            }
            nuevaCategoria.setSiguiente(actual);
            anterior.setSiguiente(nuevaCategoria);
        }         
        return nuevaCategoria;
    }
    
    private void agregarEmpleado(NodoCategoria categoriaAgregarEmpleado, String nombre, String apellido, int sueldo){
        NodoEmpleado actual = categoriaAgregarEmpleado.getPrimerEmpleado();
        NodoEmpleado anterior = null;

        NodoEmpleado nuevoEmpleado = new NodoEmpleado(nombre, apellido, sueldo);

        if(actual == null){
            categoriaAgregarEmpleado.setPrimerEmpleado(nuevoEmpleado);
        }else{
            while((actual != null) && actual.getApellido().compareTo(apellido) < 0){
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if(actual == null){
                anterior.setSiguiente(nuevoEmpleado);
            }else{
                nuevoEmpleado.setSiguiente(actual);
                anterior.setSiguiente(nuevoEmpleado);
            }
        }
    }
    public void mostrarPorCategorias(char categoria){
        NodoCategoria actual = primera;

        while((actual != null) && (actual.getTipoCategoria() != categoria)){
            actual = actual.getSiguiente();
        }
        if(actual == null){
            System.out.print("La categoria '" + categoria + "' no existe." );
        }else{
            imprimir(actual);
        }
    }
    private void imprimir(NodoCategoria actual){
        NodoEmpleado actualEmpleado = actual.getPrimerEmpleado();

        if(actualEmpleado == null){
            System.out.print("La categoria esta vacia. ");
        }else{
            while((actualEmpleado != null)){
                System.out.println(actualEmpleado.getApellido() + " " + actualEmpleado.getNombre() + " " + actualEmpleado.getSueldo() + " ");
                actualEmpleado = actualEmpleado.getSiguiente();
            }
        }
    }


    public NodoCategoria getPrimera(){
        return primera;
    }
    public void setPrimera(NodoCategoria primera){
        this.primera = primera;
    }
}