public class Empleado {
    private Integer ID;
    private String apellido;
    private String puesto;
    private Integer DIR;

    public Empleado() {
        this.ID = null;
        this.apellido = null;
        this.puesto = null;
        this.DIR = null;
    }

    public Empleado(Integer ID, String apellido, String puesto, Integer DIR) {
        this.ID = ID;
        this.apellido = apellido;
        this.puesto = puesto;
        this.DIR = DIR;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Integer getDIR() {
        return DIR;
    }

    public void setDIR(Integer DIR) {
        this.DIR = DIR;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "ID=" + ID +
                ", apellido='" + apellido + '\'' +
                ", puesto='" + puesto + '\'' +
                ", DIR=" + DIR +
                '}';
    }
}
