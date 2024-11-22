public class EntreJunior extends Entrenador {
    private String grupo;

    public EntreJunior(int id, String cedula, String nombres, String apellidos, String grupo) {
        super(id, cedula, nombres, apellidos);
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return super.toString() + "Grupo: " + grupo;
    }

    @Override
    public String presentacionEspecifica() {
        return "Junior - Grupo: " + grupo;
    }
}