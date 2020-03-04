package cl.nisum.test.VO;

import cl.nisum.test.Entity.Telefono;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ResponseGetAll {
    private UUID id;
    private Date created;
    private Date modified;
    private Date last_login;
    private String token;
    private boolean isactive;
    private String correo;
    private String clave;
    private List<TelefonoVO> telefonos;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<TelefonoVO> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TelefonoVO> telefonos) {
        this.telefonos = telefonos;
    }

    public ResponseGetAll() {
    }

    public ResponseGetAll(UUID id, Date created, Date modified, Date last_login, String token, boolean isactive, String correo, String clave, List<TelefonoVO> telefonos) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.last_login = last_login;
        this.token = token;
        this.isactive = isactive;
        this.correo = correo;
        this.clave = clave;
        this.telefonos = telefonos;
    }
}
