package cl.nisum.test.VO;


import java.util.List;


public class RequestVO {
 private String nombre;
 private String correo;
 private String contrasena;
 private List<TelefonoVO> telefono;

 public RequestVO() {

 }

 public RequestVO(String nombre, String correo, String contrasena, List<TelefonoVO> telefono) {
  this.nombre = nombre;
  this.correo = correo;
  this.contrasena = contrasena;
  this.telefono = telefono;
 }

 public String getNombre() {
  return nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 public String getCorreo() {
  return correo;
 }

 public void setCorreo(String correo) {
  this.correo = correo;
 }

 public String getContrasena() {
  return contrasena;
 }

 public void setContrasena(String contrasena) {
  this.contrasena = contrasena;
 }

 public List<TelefonoVO> getTelefono() {
  return telefono;
 }

 public void setTelefono(List<TelefonoVO> telefono) {
  this.telefono = telefono;
 }
}

