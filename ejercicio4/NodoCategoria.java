public class NodoCategoria {
    
    private char tipoCategoria;
    private NodoCategoria siguiente;
    private NodoEmpleado primerEmpleado;

    public NodoCategoria(char tipoCategoria){
        this.tipoCategoria = tipoCategoria;
        this.siguiente = null;
        this.primerEmpleado = null;
    }

    public char getTipoCategoria(){
        return tipoCategoria;
    }
    public void setTipoCategoria(char tipoCategoria){
        this.tipoCategoria = tipoCategoria;
    }
    public NodoCategoria getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoCategoria siguiente){
        this.siguiente = siguiente;
    }
    public NodoEmpleado getPrimerEmpleado(){
        return primerEmpleado;
    }
    public void setPrimerEmpleado(NodoEmpleado primerEmpleado){
        this.primerEmpleado = primerEmpleado;
    }
}
