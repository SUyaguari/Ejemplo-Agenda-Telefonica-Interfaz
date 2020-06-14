/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Telefono;
import java.util.List;

/**
 *
 * @author Estudiantes
 */
public interface ITelefonoDAO {
    public List<Telefono> listar();
    public void create(Telefono telefono);
    public Telefono read(String codigo);
    public void update(Telefono telefono);
    public void delite(Telefono telefono);
}
