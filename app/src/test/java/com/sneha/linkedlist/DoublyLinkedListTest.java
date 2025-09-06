package com.sneha.linkedlist;

import list.linkedlist.DoublyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DoublyLinkedListTest {

    @Test
    void testAddFirst(){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst(2);

        Assertions.assertEquals(2, doublyLinkedList.deleteFirst());

    }

}