package com.company;

public class LinkedList {
    Node head;
    public void append(int data){

        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = new Node(data);

    }
    public void prepend(int data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }
    public void deleteDup(){
        Node iterator = head.next;
        Node current = head;
        while(current != null){
            int test = current.data;
            while (iterator != null){
                int test2 = iterator.data;
                if(test == test2){
                    deleteWithValue(test2);
                }
                iterator = iterator.next;

        }
            current = current.next;

        }
    }
    public void deleteWithValue(int data){
        if(head == null) return;
        if(head.data == data){
            head = head.next;
            return;

        }
        Node current = head;
        while (current.next.data == data){

            current.next = current.next.next;
            return;
        }
        current = current.next;
    }
    public void Print(){
        Node current = head;
        if(head == null){
            System.out.println("NULL");

        }
        while(current.next != null){
            System.out.println(current.data);
            current = current.next;
        }
        if(current.next == null){
            System.out.println(current.data);


        }



    }


}