public abstract class Dron {
    private String codigo;
    private String modelo;
    private double distanciaKm;
    private double pesoPaquete;
    private double horasVuelo;
    protected double costoBase; // Protected

    // Constructor vacío
    public Dron() {}

    // Constructor con parámetros
    public Dron(String codigo, String modelo, double distanciaKm, double pesoPaquete, double horasVuelo, double costoBase) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.distanciaKm = distanciaKm;
        this.pesoPaquete = pesoPaquete;
        this.horasVuelo = horasVuelo;
        this.costoBase = costoBase;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getModelo() { return modelo; }
    public double getDistanciaKm() { return distanciaKm; }
    public double getPesoPaquete() { return pesoPaquete; }
    public double getHorasVuelo() { return horasVuelo; }
    public double getCostoBase() { return costoBase; }

    // Setters con validaciones obligatorias
    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.trim().isEmpty()) {
            this.codigo = codigo;
        } else {
            System.out.println("ERROR: El código no puede estar vacío");
        }
    }

    public void setModelo(String modelo) {
        if (modelo != null && !modelo.trim().isEmpty()) {
            this.modelo = modelo;
        } else {
            System.out.println("ERROR: El modelo no puede estar vacío");
        }
    }

    public void setDistanciaKm(double distanciaKm) {
        if (distanciaKm > 0) {
            this.distanciaKm = distanciaKm;
        } else {
            System.out.println("ERROR: La distancia debe ser mayor a 0");
        }
    }

    public void setPesoPaquete(double pesoPaquete) {
        if (pesoPaquete > 0) {
            this.pesoPaquete = pesoPaquete;
        } else {
            System.out.println("ERROR: El peso del paquete debe ser mayor a 0");
        }
    }

    public void setHorasVuelo(double horasVuelo) {
        if (horasVuelo > 0) {
            this.horasVuelo = horasVuelo;
        } else {
            System.out.println("ERROR: Las horas de vuelo deben ser mayores a 0");
        }
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    // Métodos Abstractos
    public abstract double calcularCostoEntrega();
    public abstract boolean validarDatos();

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Modelo: " + modelo);
        System.out.println("Distancia (km): " + distanciaKm);
        System.out.println("Peso paquete (kg): " + pesoPaquete);
        System.out.println("Horas de vuelo: " + horasVuelo);
        System.out.println("Costo base: $" + String.format("%.2f", costoBase));
    }
}