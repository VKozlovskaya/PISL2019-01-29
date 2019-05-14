package by.it.group673602.kozlovskaya.lab6_7.src.main.java.app;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(Integer id){
        super("Couldn't find person" + id);
    }
}
