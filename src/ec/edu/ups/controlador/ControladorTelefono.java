package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.vista.PantallaCrearTelefono;
import ec.edu.ups.vista.PantallaListarTelefonos;
import ec.edu.ups.vista.PantallaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiantes
 */
public class ControladorTelefono implements ActionListener{
    ITelefonoDAO telefonoDAO;
    PantallaCrearTelefono pantallaTelefono;
    PantallaListarTelefonos pantalla = new PantallaListarTelefonos();
    Telefono telefono;

    public ControladorTelefono(TelefonoDAO telefonoDAO, PantallaCrearTelefono pantallaTelefono) {
        this.telefonoDAO = telefonoDAO;
        this.pantallaTelefono = pantallaTelefono;
        this.pantallaTelefono.btnRegistrar.addActionListener(this);
        this.pantallaTelefono.btnListar.addActionListener(this);
    }

    public void crearTelefono(){
        
        telefono=pantallaTelefono.crearTelefono();
        System.out.println(telefono);
        if(telefono!=null){
            JOptionPane.showMessageDialog(null, "Telefono registrado correctamente");
            telefonoDAO.create(telefono);
        }else{
            JOptionPane.showMessageDialog(null, "Error en el registro");
        }
    }
    
    public void listarTelefonos(){
        List<Telefono> telefonos;
        telefonos = telefonoDAO.listar();
        if(!telefonos.isEmpty()){
            pantalla.areaListar.setText(telefonos.toString());
        }else{
            pantalla.areaListar.setText("Agenda Vacia");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(pantallaTelefono.btnRegistrar)){
            crearTelefono();
        }
        if(e.getSource().equals(pantallaTelefono.btnListar)){
            listarTelefonos();
            pantalla.setVisible(true);
            pantalla.setLocationRelativeTo(null);
        }
    }
    
    public void iniciar(){
        PantallaPrincipal op = new PantallaPrincipal();
        op.setVisible(true);
        op.setLocationRelativeTo(null);
    }
    
}
