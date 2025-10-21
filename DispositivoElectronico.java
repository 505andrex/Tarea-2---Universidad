public abstract class DispositivoElectronico {
    //ATRIBUTOS PRIVADOS
    private String marca;
    private String modelo;
    private double precio;
    private int anioFabricacion;

    //CONSTRUCTOR
    public DispositivoElectronico(String marca, String modelo, double precio, int anioFabricacion){
        this.marca=marca;
        this.modelo=modelo;
        this.precio=precio;
        this.anioFabricacion=anioFabricacion;
    }

    //GETTERS Y SETTERS
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    //METODOS
    public void encender(){
        System.out.println("El dispositivo " + getModelo() + " se está encendiendo.");
    }
    public void apagar() {
        System.out.println("El dispositivo " + getModelo() + " se está apagando.");
    }


    public void mostrarDatos(){
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Año: " + getAnioFabricacion());
    }
}
