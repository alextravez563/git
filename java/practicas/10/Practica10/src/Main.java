/*
//Practica08
 // Nombre: Alex Travez , Mateo Oviedo
 // Fecha de realizacion:08/01/2025
 // Fecha de entrega: 09/01/2025

 */

public class Main {
    public static void main(String[] args) {
        // Simulación de un sistema de puerta automática que utiliza ladridos y un control remoto.

        // Se crea una puerta con un temporizador de cierre automático de 5 segundos.
        Puerta puerta = new Puerta(5000);

        // Se inicializa el sistema de autenticación, que almacena y valida perros registrados.
        SistemaAutenticacion sistemaAutenticacion = new SistemaAutenticacion();

        // Se configura un sensor que detecta ladridos y autentica el ladrido a través del sistema de autenticación.
        SensorLadridos sensorLadridos = new SensorLadridos(puerta, sistemaAutenticacion);

        // Se crean dos perros: uno registrado en el sistema y otro no registrado.
        Perro peluche = new Perro("Peluche", "ID123"); // Perro registrado.
        sistemaAutenticacion.registrarPerro(peluche); // Registro de "Peluche" en el sistema.

        Perro bitsie = new Perro("Bitsie", "ID456"); // Perro no registrado.

        // Se crea un control remoto que interactúa con la puerta y el sistema de autenticación.
        ControlRemoto controlRemoto = new ControlRemoto(puerta, sistemaAutenticacion);

        // **Simulación del escenario**
        // Paso 1: Peluche ladra.
        peluche.ladrar(); // Muestra "Peluche está ladrando."

        // Paso 2: El sensor detecta el ladrido de Peluche y lo autentica.
        sensorLadridos.detectarLadrido(peluche); // Abre la puerta porque Peluche está registrado.

        // Verificamos si Peluche está afuera.
        if (!peluche.isAdentro()) {
            System.out.println(peluche.getNombre() + " está afuera."); // Muestra "Peluche está afuera."
        }

        // Paso 3: Bitsie (no registrado) ladra.
        bitsie.ladrar(); // Muestra "Bitsie está ladrando."

        // Paso 4: El sensor intenta autenticar a Bitsie, pero falla porque no está registrado.
        sensorLadridos.detectarLadrido(bitsie); // Muestra "No se reconoce el ladrido de Bitsie."

        // Paso 5: El dueño escucha el ladrido de Peluche y usa el control remoto.
        peluche.ladrar(); // Muestra "Peluche está ladrando."
        System.out.println("El dueño de " + peluche.getNombre() + " escucha el ladrido y presiona el botón del control.");
        controlRemoto.presionarBoton(peluche); // Abre la puerta nuevamente y cambia su estado (adentro/afuera).

        // **Resultados**
        /*Resultados:
        1. La puerta se abrió automáticamente cuando el ladrido de Peluche fue autenticado.
        2. La puerta permaneció cerrada cuando el ladrido de Bitsie no fue autenticado.
        3. Peluche pudo salir de la casa con su ladrido autenticado.
        4. El dueño utilizó el control remoto para abrir la puerta y cambiar la posición de Peluche.
        5. Los eventos de apertura y cierre de la puerta quedaron registrados en el log. */

        // **Conclusiones**
        /*Conclusiones:
       /*1. El sistema es eficaz para autenticar perros registrados utilizando un identificador único de ladrido.
        2. La función de cierre automático garantiza que la puerta no quede abierta indefinidamente.
        3. Los perros no registrados no pueden activar la apertura de la puerta por seguridad.
        4. El control remoto añade una capa adicional de control manual para los dueños.
        5. El sistema es útil para mantener un registro de eventos mediante el log.*/

        // **Recomendaciones**
       /* Recomendaciones
        1. Agregar más métodos de autenticación, como reconocimiento de frecuencia del ladrido.
        2. Implementar notificaciones al dueño cuando un perro no registrado intenta abrir la puerta.
        3. Mejorar la interfaz del control remoto para incluir opciones avanzadas como temporizador personalizado.
        4. Probar el sistema con múltiples perros para garantizar que no ocurran conflictos.
        5. Realizar pruebas en distintos entornos para asegurar que el sensor de ladridos funcione correctamente.*/
    }
      /*Bibliografia
    1) Oracle. (n.d.). Java Timer Documentation.
Recuperado de https://docs.oracle.com/javase/8/docs/api/java/util/Timer.html
2) TutorialsPoint. (n.d.). UML Tutorial.
Recuperado de https://www.tutorialspoint.com/uml/index.htm
3)  Analisis y clases de diseño, Lenguaje UML (Material de clase, presentado por David Mejia)[Consultado: 8-JANUARY-2025].

     */
}
