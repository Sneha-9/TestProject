package list.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void test() {
//        Node temp = new Node(5);
//
//        reassign(temp);
//
//        System.out.println(temp);

        /**
         * 1. Create a new object in heap
         * 2. Reserve X bits for the object
         * 3. Reserve Y bits in memory for the variable
         * 4. Update the value of reserved bits to be address of the object in heap
         * 5. a points to the memory block with Y bits reserved
         */

        
        Node a = new Node(5); //reserve 32 bits in

        reassign(a);

        System.out.println(a);
    }



    private void reassign(Node a){
        a = new Node(6);
    }

}