public class NodoEmpleado {
    private NodoEmpleado siguiente;
    private String nombre;
    private String apellido;
    private int sueldo;

    public NodoEmpleado(String nombre, String apellido, int sueldo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
    }

    public NodoEmpleado getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoEmpleado siguiente){
        this.siguiente = siguiente;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public int getSueldo(){
        return sueldo;
    }
    public void setSueldo(int sueldo){
        this.sueldo = sueldo;
    }
}
