public class DronLiviano extends Dron {
    private double limiteHoras;

    // Valores quemados
    public DronLiviano() {
        super("DL-000", "LivianoDef", 5.0, 2.0, 1.0, 3.00);
        this.limiteHoras = 2.0;
    }

    public double getLimiteHoras() { return limiteHoras; }
    public void setLimiteHoras(double limiteHoras) { this.limiteHoras = limiteHoras; }

    // Sobrescritura de setters
    @Override
    public void setPesoPaquete(double peso) {
        if (peso > 0 && peso <= 5.0) {
            super.setPesoPaquete(peso);
        } else {
            System.out.println("ERROR: El peso excede el límite permitido (5 kg). No se asignó");
        }
    }

    @Override
    public void setHorasVuelo(double horas) {
        if (horas > 0 && horas <= limiteHoras) {
            super.setHorasVuelo(horas);
        } else {
            System.out.println("ERROR: Las horas exceden el límite permitido (" + limiteHoras + " horas). No se asignó");
        }
    }

    @Override
    public double calcularCostoEntrega() {
        return getCostoBase() + (getDistanciaKm() * 0.80) + (getPesoPaquete() * 0.50);
    }

    @Override
    public boolean validarDatos() {
        return getDistanciaKm() > 0 && getPesoPaquete() > 0 && getPesoPaquete() <= 5.0
                && getHorasVuelo() > 0 && getHorasVuelo() <= limiteHoras
                && getCodigo() != null && !getCodigo().isEmpty()
                && getModelo() != null && !getModelo().isEmpty();
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Dron Liviano ---");
        super.mostrarInformacion();
        System.out.println("Límite de peso: 5 kg");
        System.out.println("Límite de horas: " + limiteHoras + " horas");
        System.out.println("Costo de entrega: $" + String.format("%.2f", calcularCostoEntrega()));
    }
}