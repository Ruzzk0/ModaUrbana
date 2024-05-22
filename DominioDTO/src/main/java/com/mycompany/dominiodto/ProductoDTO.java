
package com.mycompany.dominiodto;

import java.util.Map;
import org.bson.types.ObjectId;

public class ProductoDTO {
    private String idProducto;
    private ObjectId _id;
    private String nombre;
    private String descripcion;
    private CategoriaDTO categoria;
    private double precio;
    private Map<String, Integer> tallasCantidades;

    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, String descripcion, CategoriaDTO categoria, double precio, Map<String, Integer> tallasCantidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.tallasCantidades = tallasCantidades;
    }

    // Getters y Setters
    
    

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }
    
        public String getIdProducto() {
        return _id != null ? _id.toHexString() : null;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
        this._id = new ObjectId(idProducto);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Map<String, Integer> getTallasCantidades() {
        return tallasCantidades;
    }

    public void setTallasCantidades(Map<String, Integer> tallasCantidades) {
        this.tallasCantidades = tallasCantidades;
    }
}
