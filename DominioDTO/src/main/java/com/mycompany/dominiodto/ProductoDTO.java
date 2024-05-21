
package com.mycompany.dominiodto;

import java.util.Map;

/**
 *
 * @author Ruzzky
 */
public class ProductoDTO {
     private String id;
    private String nombre;
    private String descripcion;
    private CategoriaDTO categoria;
    private double precio;
    private Map<String, Integer> tallasCantidades;

    // Constructores, getters y setters

    public ProductoDTO() {}

    public ProductoDTO(String nombre, String descripcion, CategoriaDTO categoria, double precio, Map<String, Integer> tallasCantidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.tallasCantidades = tallasCantidades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
