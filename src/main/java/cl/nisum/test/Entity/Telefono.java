package cl.nisum.test.Entity;

import javax.persistence.*;

@Entity
public class Telefono {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "number")
    private int number;

    @Column(name = "citycode")
    private int citycode;

    @Column(name = "countrycode")
    private int countrycode;

    @JoinColumn(name = "idsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Usuario idsuario;

    public Telefono() {
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

    public int getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(int countrycode) {
        this.countrycode = countrycode;
    }

    public Usuario getIdsuario() {
        return idsuario;
    }

    public void setIdsuario(Usuario idsuario) {
        this.idsuario = idsuario;
    }
}
