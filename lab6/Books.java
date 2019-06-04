package com.company;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Books implements Comparable<Books>
{

    public String name;

    public String genre;

    public String date;

    public String edition;


    public Authors aut = new Authors();

    public Books(Scanner in)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("ISBN : ");
        aut.setIsbn(scan.nextInt());
        aut.isbn(this.aut.getIsbn());

        System.out.print("Name : ");
        name = in.nextLine();

        System.out.print("Genre : ");
        genre = in.nextLine();

        System.out.print("Date : ");
        date = in.nextLine();

        System.out.print("edition : ");
        edition = in.nextLine();



        System.out.println("Authors : \n");

        System.out.print("Name : ");
        aut.setName(in.nextLine());
        aut.Name(this.aut.getName());

        System.out.print("Surname : ");
        aut.setSurname(in.nextLine());
        aut.Surname(this.aut.getSurname());



    }


    public Books()
    {

    }


    public void print() throws UnsupportedEncodingException
    {
        System.out.println();

        System.out.printf("ISBN:\t%s\n",this.aut.getIsbn());

        System.out.printf
                (
                        "Your Books:\n"+
                                "Name:\t%s\n"+
                                "Genre:\t%s\n"+
                                "Date:\t%s\n"+
                                "Edition:\t%s\n",
                        name,
                        genre,
                        date,
                        edition
                );
        System.out.println();

        System.out.println("Author : ");
        System.out.printf("Name:\t%s\n",this.aut.getName());
        System.out.printf("Surname:\t%s\n",this.aut.getSurname());

    }

    public int Get()
    {
        return this.aut.getIsbn();
    }

    @Override
    public int compareTo(Books o)
    {
        return this.Get() < o.Get() ? -1 :(this.Get() > o.Get()) ? 1 : 0 ;
    }
}
