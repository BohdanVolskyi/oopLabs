package com.company;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Books implements Serializable {



        public String isbn;

        public String name;

        public String genre;

        public String date;

        public String edition;


        public Authors aut = new Authors();

        public Books(Scanner in)
        {

            System.out.print("ISBN : ");
            isbn = in.nextLine();

            System.out.print("Name : ");
            name = in.nextLine();

            System.out.print("Genre : ");
            genre = in.nextLine();

            System.out.print("Date : ");
            date = in.nextLine();

            System.out.print("Duration : ");
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


        public void print()
        {
            System.out.println();

            System.out.printf
                    (
                            "Your Books:\n"+
                                    "ISBN:\t%s\n"+
                                    "Name:\t%s\n"+
                                    "Genre:\t%s\n"+
                                    "Date:\t%s\n"+
                                    "Edition:\t%s\n",
                            isbn,
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


    public void EnteredInfo() throws UnsupportedEncodingException {
        System.out.println();

        System.out.printf
                (
                        "Your Books:\n"+
                                "ISBN:\t%s\n"+
                                "Name:\t%s\n"+
                                "Genre:\t%s\n"+
                                "Date:\t%s\n"+
                                "Edition:\t%s\n",
                        isbn,
                        name,
                        genre,
                        date,
                        edition

                );



        System.out.println();

        System.out.printf("name:\t%s\n", this.aut.getName());
        System.out.printf("surname:\t%s\n", this.aut.getSurname());

    }


}
