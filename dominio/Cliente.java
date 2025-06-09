package zona_fit.dominio;

import java.util.Objects;

public class Cliente{
    private int id;
    private String nombre;
    private String apellido;
    private int membresia;

public Cliente(){}
 
//Este lo usamos para eliminar cliente
public Cliente(int id){
    this.id = id;
}
//Este lo usamos para insertar
public Cliente(String nombre, String apellido, int membresia){
    this.nombre = nombre;
    this.apellido = apellido;
    this.membresia = membresia;
}
//Este para modificar
public Cliente(String nombre, String apellido, int membresia, int id){
    this(nombre,apellido,membresia);
    //esto solo se puede hacer en la primer linea de la class
    
    this.id = id;
}

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id 
                + ", nombre=" + nombre 
                + ", apellido=" + apellido 
                + ", membresia=" + membresia + 
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())return false;
        Cliente cliente = (Cliente) obj;       
        return id == cliente.id && membresia == cliente.membresia && Objects.equals(nombre,apellido);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre,apellido, membresia);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setMembresia(int membresia) {
        this.membresia = membresia;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getMembresia() {
        return membresia;
    }


}

