public class EntreElite extends Entrenador {
    private int aniosExperiencia;

    public EntreElite(int id, String cedula, String nombres, String apellidos, int aniosExperiencia) {
        super(id, cedula, nombres, apellidos);
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public String toString() {
        return super.toString() + "¡ELITE! Años de experiencia: " + aniosExperiencia;
    }

    @Override
    public String presentacionEspecifica() {
        return "Elite - Años de experiencia: " + aniosExperiencia;
    }
}