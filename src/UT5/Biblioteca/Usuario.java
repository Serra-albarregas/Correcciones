package UT5.Biblioteca;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String nick;
    private String pass;
    private String email;
    private GestorLibro prestados;
    private int prestamosTotales;
    private boolean esAdmin;
    private static final int TAMPRESTADOS = 5;

    public Usuario(String nombre, String apellidos, String nick, String pass, String email, boolean esAdmin) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nick = nick;
        this.pass = pass;
        this.email = email;
        this.prestados = new GestorLibro(TAMPRESTADOS);
        this.prestamosTotales = 0;
        this.esAdmin=esAdmin;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GestorLibro getPrestados() {
        return this.prestados;
    }

    public void setPrestados(GestorLibro prestados) {
        this.prestados = prestados;
    }

    public int getPrestamosTotales() {
        return this.prestamosTotales;
    }

    public void setPrestamosTotales(int prestamosTotales) {
        this.prestamosTotales = prestamosTotales;
    }

    public boolean getEsAdmin() {
        return this.esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public int getNPrestadosActual(){
        return prestados.getLleno();
    }

    public boolean puedePedir(){
        return prestados.getLleno()<TAMPRESTADOS;
    }

    public void pedirPrestado(Libro l){
        prestados.addLibro(l);
        prestamosTotales++;
    }

    public void devolver(Libro l){
        prestados.eliminarLibroPorISBN(l.getISBN());
    }

    public boolean login(String nick, String pass){
        return this.nick.equals(nick) && this.pass.equals(pass);
    }

    public String infoUsuario(){
        return nick + " -" + apellidos + ", " + nombre + "- " + email + ". Libros prestados: actual " + getPrestados().getLleno() + " total " + prestamosTotales;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            ", nick='" + getNick() + "'" +
            ", email='" + getEmail() + "'" +
            ", prestados='" + getPrestados() + "'" +
            ", prestamosTotales='" + getPrestamosTotales() + "'" +
            ", esAdmin='" + getEsAdmin() + "'" +
            "}";
    }
}
