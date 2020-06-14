package ec.edu.ups.teset;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.vista.PantallaCrearTelefono;

/**
 *
 * @author Estudiantes
 */
public class Test {
    public static void main(String[] args) {
        PantallaCrearTelefono vista = new PantallaCrearTelefono();
        TelefonoDAO telefonoDAO = new TelefonoDAO();
        ControladorTelefono c = new ControladorTelefono(telefonoDAO,vista);
        
        c.iniciar();
    }
}
