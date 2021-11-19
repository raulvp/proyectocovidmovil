package com.example.vaccovidincos;

public class Paciente {

    private int idPaciente;
    private String nombre;
    private String apellidos;
    private int cedula;
    private String fechaNac;
    private String servSalud;
    private String municipio;
    private String establecimiento;
    private String fechaVacuna;
    private String dosis;
    private String proveedor;
    private String proxVacuna;

    public Paciente(){}

    public Paciente(int idPaciente, String nombre, String apellidos, int cedula, String fechaNac, String servSalud, String municipio, String establecimiento, String fechaVacuna, String dosis, String proveedor, String proxVacuna) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.fechaNac = fechaNac;
        this.servSalud = servSalud;
        this.municipio = municipio;
        this.establecimiento = establecimiento;
        this.fechaVacuna = fechaVacuna;
        this.dosis = dosis;
        this.proveedor = proveedor;
        this.proxVacuna = proxVacuna;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getServSalud() {
        return servSalud;
    }

    public void setServSalud(String servSalud) {
        this.servSalud = servSalud;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(String fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getProxVacuna() {
        return proxVacuna;
    }

    public void setProxVacuna(String proxVacuna) {
        this.proxVacuna = proxVacuna;
    }


    public String toString(){
        return "Nombres: "+nombre+"\napellidos: "+apellidos+"\nCarnet: "+cedula+"\nVacuna: "+proveedor;
    }
}
