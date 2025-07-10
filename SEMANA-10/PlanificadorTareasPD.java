import java.util.*;

public class PlanificadorTareasPD {

    static class Tarea {
        int beneficio;
        int plazo;
        String nombre;

        public Tarea(String nombre, int beneficio, int plazo) {
            this.nombre = nombre;
            this.beneficio = beneficio;
            this.plazo = plazo;
        }
    }

    public static void main(String[] args) {
        // Lista de tareas: nombre, beneficio, plazo
        List<Tarea> tareas = Arrays.asList(
            new Tarea("T1", 100, 2),
            new Tarea("T2", 50, 1),
            new Tarea("T3", 20, 2),
            new Tarea("T4", 10, 1)
        );

        // Ordenar las tareas por beneficio descendente
        tareas.sort((a, b) -> b.beneficio - a.beneficio);

        // Buscar el plazo máximo para saber cuántos slots hay
        int maxPlazo = tareas.stream().mapToInt(t -> t.plazo).max().orElse(0);

        // Inicializar slots (uno por unidad de tiempo)
        String[] planificacion = new String[maxPlazo];
        boolean[] ocupado = new boolean[maxPlazo];

        int beneficioTotal = 0;

        for (Tarea tarea : tareas) {
            // Buscar el último tiempo disponible antes del plazo
            for (int i = tarea.plazo - 1; i >= 0; i--) {
                if (!ocupado[i]) {
                    planificacion[i] = tarea.nombre;
                    ocupado[i] = true;
                    beneficioTotal += tarea.beneficio;
                    break;
                }
            }
        }

        // Mostrar resultado
        System.out.println("\nPlanificación de tareas óptima:");
        for (int i = 0; i < planificacion.length; i++) {
            System.out.println("Tiempo " + (i + 1) + ": " + (planificacion[i] != null ? planificacion[i] : "(libre)"));
        }

        System.out.println("\nBeneficio total máximo obtenido: " + beneficioTotal);
    }
}
