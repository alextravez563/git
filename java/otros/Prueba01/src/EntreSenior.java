public class EntreSenior extends Entrenador {
    private String grupo;
    private String rol;

    public EntreSenior(int id, String cedula, String nombres, String apellidos, String grupo, String rol) {
        super(id, cedula, nombres, apellidos);
        this.grupo = grupo;
        this.rol = rol;
    }

    @Override
    public String toString() {
        return super.toString() + "Grupo: " + grupo + ", Rol: " + rol;
    }

    @Override
    public String presentacionEspecifica() {
        return "Senior - Grupo: " + grupo + ", Rol: " + rol;
    }
}