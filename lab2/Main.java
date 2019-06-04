package com.company;


import java.util.Scanner;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.io.IOException;

 public class Main
{


    public static void main(String[] args) throws Exception
    {
        Scanner reader = new Scanner(System.in);
        Container obj = new Container();

        help();
        System.out.println("введіть команду");
        while(true)
        {

            switch(reader.nextLine())
            {
                case "help":
                    help();
                    break;

                case "a":
                    System.out.print("шлях до файлу: ");
                    obj = Container.deserialize(reader.nextLine());
                    break;

                case "b":
                    System.out.print("шлях до файлу: ");
                    try
                    {
                        obj.serializeTo(reader.nextLine());
                    }
                    catch(IOException e)
                    {
                        System.out.println("помилка");
                    }
                    System.out.println("виконано");
                    break;

                case "c":
                    obj.sort();
                    System.out.println("посортовано.");
                    break;

                case "d":
                    System.out.print("введіть рядок щоб додати: ");
                    obj.add(reader.nextLine());
                    break;

                case "e":
                    System.out.print("введіть рядок щоб видалити: ");
                    if(obj.remove(reader.nextLine()))
                    {
                        System.out.println("видалено");
                    }
                    else
                    {
                        System.out.println("немає рядка.");
                    }
                    break;
                case "f":
                    obj.clear();
                    System.out.println("очищено.");
                    break;

                case "g":
                    System.out.println("ваш текст: ");
                    for(String string: obj)
                        System.out.println(string);
                    break;

                case "h":
                    if(obj == null)
                    {
                        System.out.println("пусто.");
                        break;
                    }
                    System.out.print("шлях до файлу: ");
                    Container cmpobj = obj.deserialize(reader.nextLine());
                    if(obj.containsAll(cmpobj)) {
                        System.out.println("одинакові");
                    }
                    else {
                        System.out.println("різні");
                    }
                    break;

                case "i":
                    System.out.println("введіть рядок щоб перевірити");
                    System.out.println(obj.contains(reader.nextLine()));
                    break;
                    
                case "exit":
                    System.out.println("the end");
                    return;
            }
        }
    }

    public static void help(){
        System.out.println(
                "меню:\n\n" +
                        "[a]  десереалізація\n" +
                        "[b]  серіалізація\n" +
                        "[c]  сортування\n" +
                        "[d] додає вказаний елемент до кінця контейнеру\n" +
                        "[e]  видаляє перший випадок вказаного елемента з контейнера \n" +
                        "[f]  видаляє всі елементи з контейнера\n" +
                        "[g]  повертає вміст контейнера\n" +
                        "[h]  порівнює контейнери\n"+
                        "[i]  порівнює рядок\n"+
                        "[exit] вийти з програми\n\n");
    }

}


