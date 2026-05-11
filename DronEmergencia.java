public class DronEmergencia extends Dron {
    private double recargoUrgencia;
    private int nivelPrioridad;

    public DronEmergencia() {
        super("DE-000", "EmergenciaDef", 5.0, 2.0, 1.0, 8.00);
        this.recargoUrgencia = 10.00;
        this.nivelPrioridad = 1;
    }

    public double getRecargoUrgencia() { return recargoUrgencia; }
    public void setRecargoUrgencia(double recargoUrgencia) { this.recargoUrgencia = recargoUrgencia; }
    public int getNivelPrioridad() { return nivelPrioridad; }
    public void setNivelPrioridad(int nivelPrioridad) { this.nivelPrioridad = nivelPrioridad; }

    @Override
    public void setPesoPaquete(double peso) {
        if (peso > 0 && peso <= 10.0) {
            super.setPesoPaquete(peso);
        } else {
            System.out.println("ERROR: El peso excede el límite permitido (10 kg). No se asignó");
        }
    }

    @Override
    public void setHorasVuelo(double horas) {
        if (horas > 0 && horas <= 3.0) {
            super.setHorasVuelo(horas);
        } else {
            System.out.println("ERROR: Las horas exceden el límite permitido (3 horas). No se asignó");
        }
    }

    @Override
    public double calcularCostoEntrega() {
        return getCostoBase() + (getDistanciaKm() * 1.50) + (getPesoPaquete() * 0.90) + recargoUrgencia;
    }

    @Override
    public boolean validarDatos() {
        return getDistanciaKm() > 0 && getPesoPaquete() > 0 && getPesoPaquete() <= 10.0
                && getHorasVuelo() > 0 && getHorasVuelo() <= 3.0
                && getCodigo() != null && !getCodigo().isEmpty()
                && getModelo() != null && !getModelo().isEmpty();
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Dron Emergencia ---");
        super.mostrarInformacion();
        System.out.println("Recargo urgencia: $" + recargoUrgencia);
        System.out.println("Nivel prioridad: " + nivelPrioridad);
        System.out.println("Costo de entrega: $" + String.format("%.2f", calcularCostoEntrega()));
    }
}