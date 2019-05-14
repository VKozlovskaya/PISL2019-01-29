package by.it.group673602.kozlovskaya.lab6_7.src.main.java.app.domains;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

public enum City {
    MINSK("Минск"),
    GRODNO("Гродно"),
    GOMEL("Гомель"),
    VITEBSK("Витебск"),
    BREST("Брест");

    private String value;

    City(String s){
        this.value = s;
    }

    @Override
    public String toString() {
        return value;
    }
}
