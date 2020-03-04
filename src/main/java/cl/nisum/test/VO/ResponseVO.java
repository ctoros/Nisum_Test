package cl.nisum.test.VO;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.UUID;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVO extends MessageResponse {
    private UUID id;
    private Date created;
    private Date modified;
    private Date last_login;
    private String token;
    private boolean isactive;
    private String correo;
    private String clave;

    public ResponseVO() {
    }

    public ResponseVO(UUID id, Date created, Date modified, Date last_login, String token, boolean isactive, String correo, String clave) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.last_login = last_login;
        this.token = token;
        this.isactive = isactive;
        this.correo = correo;
        this.clave = clave;
    }

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
}
