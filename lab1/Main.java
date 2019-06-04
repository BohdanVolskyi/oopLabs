package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int debug = 0;
        if(args[0].equals("-d") || (args.length>1 && args[1].equals("-d")))
        {
            debug = 1;
            System.out.println("Вітаємо в режимі 'debug' ");
        }
        if (args[0].equals("-h") || (args.length>1 && args[1].equals("-h")))
            System.out.println("Привіт,ось твій хелп\n"
                    + "Виконав: Вольський Богдан, КН-108 \n\n"
                    + "Мета:\n"
                    + "Ввести текст.\n"
                    + " У кожному слові тексту k-ту літеру замінити заданим символом.\n"
                    + " Якщо k більше довжини слова, видати повідомлення та заміну не виконувати\n"
                    + "Команди меню:\n"
                    + "Для вводу нового тексту \"a\""
                    + "Для виводу тексту введіть \"b\" \n"
                    + "Для виконання заміни \"с\" \n");






        Scanner s = new Scanner(System.in);
        func q = new func();
        int n;
        char c;
        char[] arr ;

        // приймає текст
        System.out.println("введіть текст:");
        String str = s.nextLine();
        if (debug == 1)
            System.out.println(str);

// змінює стрінг в масив чарів
        arr = str.toCharArray();

// приймає номер букви
        System.out.println("введіть яку букву замінити:");
        n = s.nextInt();

// приймає символ яким потрібно замінити
        System.out.println("введіть яким символом  замінити:");
        c = s.next().charAt(0);

        if (debug == 1)
            System.out.println("номер букви:" + n + "символ для заміни:" + c );

        arr = q.calc(arr, n, c, debug);
        q.print(arr);
        String pop;

        System.out.print("\n"+"Наступна команда: ");
        s.nextLine();

        for(pop = s.nextLine();;System.out.print("Наступна команда: "),pop = s.next())     {

            switch(pop.charAt(0)){

                case 'a': {
                    System.out.println("введіть текст:");
                    str = s.nextLine();

                    arr = str.toCharArray();

                    System.out.println("введіть яку букву замінити:");
                    n = s.nextInt();

                    System.out.println("введіть яким символом  замінити:");
                    c = s.next().charAt(0);
                    break;
                }
                case 'b': {
                    q.print(arr);
                    break;
                }
                case 'c':{
                    arr = q.calc(arr, n, c, debug);
                    System.out.println("заміна виконана");
                    break;
                }
                default: {
                    System.out.println("Вихід!");
                    return;
                }
            }
        }
    }
}
