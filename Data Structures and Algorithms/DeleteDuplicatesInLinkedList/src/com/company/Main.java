package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        System.out.println("how many elements would you like to add");

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        for(int i = 0; i < number; i++){
            System.out.println("Please enter the data you would like to add");
            Scanner data = new Scanner(System.in);
            int d = data.nextInt();
            list.append(d);

        }
        list.Print();
        list.deleteDup();
        list.Print();
    }
}
