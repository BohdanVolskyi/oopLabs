package com.company;

public class Authors {

    private String name;
    private String surname;


    public String name()
    {
        return this.getName();
    }

    public void Name(String name)
    {
        this.setName(name);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }




    public String surname()
    {
        return this.getSurname();
    }

    public void Surname(String surname)
    {
        this.setSurname(surname);
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }



}
