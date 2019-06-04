package com.company;

public class func {
    char[] calc(char[] array, int number, char letter, int deb){
        int countWords = 1;

        for(int i = 1, j = 0; j < array.length; i++, j++){

// замінює букву символом
            if( i == number && array[j] != ' ' )
                array[j] = letter;

// рахує слова і анульовує рахунок букв в кожному слові
            if( array[j] == ' ' && i <= number || j == array.length - 1 && i < number) {
                System.out.println( "недостатньо букв в слові для заміни " + countWords );
                i = 0;
                countWords++;
            }
            else if(array[j] == ' ') {
                i = 0;
                countWords++;
            }
        }

        if (deb == 1){
            System.out.println("заміна виконана");
            for(int i = 0; i < array.length; i++){
                System.out.println("символ" + i + ":" + array[i]);
            }
        }

        return array;
    }


    void print(char[] o){
        for(int i = 0 ; i < o.length; i++) {

            System.out.print(o[i]);
        }
        System.out.println();
    }
}
