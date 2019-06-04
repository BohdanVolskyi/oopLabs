package com.company;

public class Authors {

    private String name;
    private String surname;
    private int isbn;


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




    public int isbn()
    {
        return this.getIsbn();
    }

    public void isbn(int isbn)
    {
        this.setIsbn(isbn);
    }

    public int getIsbn()
    {
        return isbn;
    }

    public void setIsbn(int isbn)
    {
        this.isbn = isbn;
    }



}