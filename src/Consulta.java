import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Consulta {
    final static String BDAct5 = "EMPLEDEP.YAP";

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDAct5);//devuelve todos los objetos persona de la bd

        // Consulta para ver a los empleado del departamento 30.
        Empleado emple = new Empleado(null, null, null, 30);
        ObjectSet<Empleado> resultEmp = db.queryByExample(emple);

        if (resultEmp.isEmpty()) {
            System.out.println("No existe datos en la BBDD");
        } else {

            Empleado empleado = resultEmp.next();
            Departamento depart = new Departamento(empleado.getDIR(), null, null);
            ObjectSet<Departamento> resultDept = db.queryByExample(depart);

            Departamento departamento = resultDept.next();

            System.out.println("Empleados del departamento " + departamento.getSeccion() + ":");
            for (Empleado empleado1 : resultEmp) {
                System.out.println(empleado1.getApellido());
            }

        }

        db.close();
    }
}
