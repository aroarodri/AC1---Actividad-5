public class Departamento {
    private Integer DIR;
    private String seccion;
    private String ciudad;


    public Departamento() {
        this.DIR = null;
        this.seccion = null;
        this.ciudad = null;
    }

    public Departamento(Integer DIR, String seccion, String ciudad) {
        this.DIR = DIR;
        this.seccion = seccion;
        this.ciudad = ciudad;
    }

    public Integer getDIR() {
        return DIR;
    }

    public void setDIR(Integer DIR) {
        this.DIR = DIR;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "DIR=" + DIR +
                ", seccion='" + seccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
