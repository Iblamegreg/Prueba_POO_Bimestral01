public class DronCarga extends Dron {
    private double costoPorKg;

    public DronCarga() {
        super("DC-000", "CargaDef", 5.0, 2.0, 1.0, 6.00);
        this.costoPorKg = 1.20;
    }

    public double getCostoPorKg() { return costoPorKg; }
    public void setCostoPorKg(double costoPorKg) { this.costoPorKg = costoPorKg; }

    @Override
    public void setPesoPaquete(double peso) {
        if (peso > 0 && peso <= 30.0) {
            super.setPesoPaquete(peso);
        } else {
            System.out.println("ERROR: El peso excede el límite permitido (30 kg). No se asignó");
        }
    }

    @Override
    public void setHorasVuelo(double horas) {
        if (horas > 0 && horas <= 5.0) {
            super.setHorasVuelo(horas);
        } else {
            System.out.println("ERROR: Las horas exceden el límite permitido (5 horas). No se asignó");
        }
    }

    @Override
    public double calcularCostoEntrega() {
        return getCostoBase() + (getDistanciaKm() * 1.20) + (getPesoPaquete() * costoPorKg);
    }

    @Override
    public boolean validarDatos() {
        return getDistanciaKm() > 0 && getPesoPaquete() > 0 && getPesoPaquete() <= 30.0
                && getHorasVuelo() > 0 && getHorasVuelo() <= 5.0
                && getCodigo() != null && !getCodigo().isEmpty()
                && getModelo() != null && !getModelo().isEmpty();
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Dron Carga ---");
        super.mostrarInformacion();
        System.out.println("Costo por kg extra: $" + costoPorKg);
        System.out.println("Costo de entrega: $" + String.format("%.2f", calcularCostoEntrega()));
    }
}
