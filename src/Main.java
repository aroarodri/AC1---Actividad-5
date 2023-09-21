import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;
import java.util.List;

public class Main {
    final static String BDAct5 = "EMPLEDEP.YAP";

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDAct5);//devuelve todos los objetos persona de la bd

        // Datps de los departamentos
        Departamento departamento = new Departamento(10, "CONTABILIDAD", "SEVILLA");
        Departamento departamento1 = new Departamento(20, "INVESTIGACIÓN", "MADRID");
        Departamento departamento2 = new Departamento(30, "VENTAS", "BARCELONA");

        List<Departamento> departamentoList = new ArrayList<>();

        departamentoList.add(departamento);
        departamentoList.add(departamento1);
        departamentoList.add(departamento2);

        // Comprobar si el DIR del departamento existe y si no existe agregarlo.
        for (Departamento depart : departamentoList) {
            ObjectSet<Departamento> resultDeptExistente = db.queryByExample(new Departamento(depart.getDIR(), null, null));

            if (resultDeptExistente.hasNext()) {
                System.out.println("El departamento con DIR " + depart.getDIR() + " ya existe en la base de datos.");
            } else {
                db.store(depart);
                System.out.println("Departamento con DIR " + depart.getDIR() + " añadido.");

            }
        }

        // Datos de los empleados
        Empleado empleado = new Empleado(7369, "SÁNCHEZ", "EMPLEADO", 20);
        Empleado empleado1 = new Empleado(7499, "ARROYO", "VENDEDOR", 30);
        Empleado empleado2 = new Empleado(7521, "SALA", "VENDEDOR", 30);
        Empleado empleado3 = new Empleado(7566, "JIMÉNEZ", "DIRECTOR", 20);
        Empleado empleado4 = new Empleado(7782, "CEREZO", "DIRECTOR", 10);
        Empleado empleado5 = new Empleado(7839, "REY", "PRESIDENTE", 10);

        List<Empleado> empleadoList = new ArrayList<>();

        empleadoList.add(empleado);
        empleadoList.add(empleado1);
        empleadoList.add(empleado2);
        empleadoList.add(empleado3);
        empleadoList.add(empleado4);
        empleadoList.add(empleado5);

        // Comprobar si el departamento de los empleados existe, si existe se comprueba si el empleado existe
        // y si no se agrega el nuevo empleado.
        for (Empleado emple : empleadoList) {
            ObjectSet<Departamento> departExiste = db.queryByExample(new Departamento(emple.getDIR(), null, null));

            if (departExiste.hasNext()) {
                ObjectSet<Empleado> empleExiste = db.queryByExample(new Empleado(emple.getID(), null, null, null));

                if (empleExiste.hasNext()) {
                    System.out.println("Empleado con ID " + emple.getID() + " ya existe.");
                } else {
                    db.store(emple);
                    System.out.println("Empleado agregado.");
                }
            } else {
                System.out.println("El departamento con DIR " + emple.getDIR() + " no existe en la base de datos.");
            }

        }
        db.close();
    }
}