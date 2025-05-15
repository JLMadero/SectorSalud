package fachada;

/**
 *
 * @author adria
 */
public class ContenidoMensaje {
    private String cedulaProfesional;
    private String pacienteUuid;
    private String tipo;

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getPacienteUuid() {
        return pacienteUuid;
    }

    public void setPacienteUuid(String pacienteUuid) {
        this.pacienteUuid = pacienteUuid;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
