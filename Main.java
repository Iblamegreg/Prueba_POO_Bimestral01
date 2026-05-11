import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear objetos con datos quemados
        DronLiviano dl = new DronLiviano();
        DronCarga dc = new DronCarga();
        DronEmergencia de = new DronEmergencia();

        // Mostrar información inicial
        System.out.println("===== INFORMACIÓN INICIAL DE DRONES =====");
        dl.mostrarInformacion();
        System.out.println();
        dc.mostrarInformacion();
        System.out.println();
        de.mostrarInformacion();
        System.out.println();

        // Ingresar datos por teclado
        System.out.println("===== INGRESO DE NUEVOS DATOS =====");
        System.out.println("¿Qué dron desea actualizar?");
        System.out.println("1. Dron Liviano");
        System.out.println("2. Dron Carga");
        System.out.println("3. Dron Emergencia");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        // Polimorfismo
        Dron dronActual = null;
        if (opcion == 1) dronActual = dl;
        else if (opcion == 2) dronActual = dc;
        else if (opcion == 3) dronActual = de;
        else {
            System.out.println("Opción no válida. Saliendo del programa...");
            sc.close();
            return;
        }

        System.out.print("Ingrese código: ");
        String nuevoCodigo = sc.nextLine();

        System.out.print("Ingrese modelo: ");
        String nuevoModelo = sc.nextLine();

        System.out.print("Ingrese distancia (km): ");
        double nuevaDistancia = sc.nextDouble();

        System.out.print("Ingrese peso del paquete (kg): ");
        double nuevoPeso = sc.nextDouble();

        System.out.print("Ingrese horas de vuelo: ");
        double nuevasHoras = sc.nextDouble();

        System.out.println("\nValidando datos...");

        // Usar setters para modificar y validar
        dronActual.setCodigo(nuevoCodigo);
        dronActual.setModelo(nuevoModelo);
        dronActual.setDistanciaKm(nuevaDistancia);
        dronActual.setPesoPaquete(nuevoPeso);
        dronActual.setHorasVuelo(nuevasHoras);

        // Confirmación final mediante el método abstracto
        if (dronActual.validarDatos()) {
            System.out.println("Datos correctos.");
            System.out.println("Datos actualizados correctamente\n");

            // Mostrar información actualizada
            System.out.println("===== INFORMACIÓN ACTUALIZADA =====");
            dronActual.mostrarInformacion();
        } else {
            System.out.println("\nNo se guardaron los cambios debido a que algunos datos exceden los límites permitidos");
        }
        System.out.println();

        System.out.println("===== DEMOSTRACIÓN DE POLIMORFISMO =====");
        Dron[] listaDrones = {dl, dc, de}; // Arreglo tipo Dron almacena objetos hijos

        for (Dron dron : listaDrones) {
            System.out.println("Llamando al método mostrarInformacion() desde referencia Dron:");
            System.out.println("-> Código: " + dron.getCodigo() + " | Modelo: " + dron.getModelo() + " | Costo entrega: $" + String.format("%.2f", dron.calcularCostoEntrega()));
            dron.mostrarInformacion();
            System.out.println("----------------------------------------");
        }

        // Finalizar programa
        System.out.println("===== FIN DEL PROGRAMA =====");
        System.out.println("Gracias por usar el sistema de drones. Hasta Luego");

        sc.close();
    }
}
