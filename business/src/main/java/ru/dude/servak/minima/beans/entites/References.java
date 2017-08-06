package ru.dude.servak.minima.beans.entites;

import javax.persistence.*;

/**
 * Created by dude on 06.08.2017.
 */
@Entity
@Table(name = "reference")
public class References {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(name = "key")
    String key;

    @Column(name = "value")
    String value;

    @Column(name = "code")
    String code;

    @Column(name = "type")
    String type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
