package cl.nisum.test.VO;

public class MessageResponse {
    private int code;
    private String mensaje;

    public MessageResponse(int code, String mensaje) {
        this.code = code;
        this.mensaje = mensaje;
    }

    public MessageResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
