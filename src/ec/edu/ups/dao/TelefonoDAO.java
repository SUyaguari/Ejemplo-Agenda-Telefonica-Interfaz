package ec.edu.ups.dao;

import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Estudiantes
 */
public class TelefonoDAO implements ITelefonoDAO{

    private List<Telefono> lista;

    public TelefonoDAO() {
        lista = new ArrayList<>();
    }
        
    @Override
    public void create(Telefono telefono) {
        lista.add(telefono);
    }

    @Override
    public Telefono read(String codigo) {
        for (Telefono telefono : lista) {
            if(telefono.getCodigo() == codigo){
                return telefono;
            }
        }
        return null;
    }

    @Override
    public void update(Telefono telefono) {
        for (int i = 0; i < lista.size(); i++) {
            Telefono t = lista.get(i);
            if(t.getCodigo()== telefono.getCodigo()){
                lista.set(i, telefono);
            }
        }
    }

    @Override
    public void delite(Telefono telefono) {
        Iterator<Telefono> it = lista.iterator();
        while (it.hasNext()) {
            Telefono t = it.next();
            if (t.getCodigo() == telefono.getCodigo()){
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Telefono> listar() {
        return lista;     
    }
}
