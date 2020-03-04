package cl.nisum.test.VO;

public class TelefonoVO {
    private int number;
    private int citycode;
    private int contrycode;

    public TelefonoVO(int number, int citycode, int contrycode) {
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
    }

    public TelefonoVO() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCitycode() {
        return citycode;
    }

    public void setCitycode(int citycode) {
        this.citycode = citycode;
    }

    public int getContrycode() {
        return contrycode;
    }

    public void setContrycode(int contrycode) {
        this.contrycode = contrycode;
    }
}