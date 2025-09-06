
import list.array.MergeSort;
import list.linkedlist.DoublyLinkedList;
import list.stack.StackUtil;
import map.HashMap;
import map.HashMapTwo;
import map.Map;
import map.MapTwo;
import parkingLot.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static class Database implements AutoCloseable{

        Database() {

        }

        void initialise() {
            throw new RuntimeException("");
        }


        @Override
        public void close() throws Exception {
            System.out.println("close");
        }
    }

    public static void main(String[] args) throws Exception {
//        LinkedList l = new LinkedList();
// 		l.addLast(1);
// 		l.addLast(2);
// 		l.addLast(3);
//        l.addFirst(1);
//        l.addLast(3);
//        l.addFirst(2);
// l.deleteFirst();
// l.deleteFirst();
// l.deleteLast();
//        l.printlist();

//        DoublyLinkedList dl = new DoublyLinkedList();
//        dl.addLast(1);
//
//       dl.addFirst(1);
//      dl.addFirst(2);
//       dl.addFirst(3);
//        dl.addLast(4);
//        dl.addLast(5);
//        dl.addLast(6);
//        dl.printList();
//        dl.deleteAtIndex(4);
//        dl.printList();
//        dl.deleteAtIndex(3);
//        dl.printList();
//        dl.deleteAtIndex(6);
//        dl.printList();
//        dl.deleteAtIndex(1);
//        dl.printList();
//
//        dl.deleteFirst();
//        dl.printList();
////
//        dl.deleteLast();
//        dl.printList();
////
//        dl.deleteLast();
//        dl.deleteLast();
////
//        dl.printList();
////
//        dl.deleteFirst();
//
//        dl.printList();
////
//        dl.deleteFirst();
//
//        dl.printList();
////
//        dl.deleteLast();
//        dl.deleteFirst();
//        Stack st = new Stack();
//        st.push(1);
//        st.push(2);
//        st.push(3);
//        st.print();
//        System.out.println(st.pop());
//        System.out.println(st.pop());
//        System.out.println(st.pop());
//        System.out.println(st.pop());

//        Queue q = new Queue();
//        q.enqueue(12);
//        q.enqueue(13);
//        q.enqueue(14);
//        q.print();
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());

//        Deque d = new Deque();
//        d.enqueueFirst(1);
//        d.enqueueFirst(2);
//        d.enqueueLast(3);
//        d.enqueueLast(4);
//        d.print();
//        System.out.println(d.dequeueFirst());
//        System.out.println(d.dequeueLast());

//        StackTwo st = new StackTwo();
//        st.push(1);
//        st.push(2);
//        st.push(3);
//        st.print();
//      System.out.println(st.pop());
//        System.out.println(st.pop());
//        st.push(4);
//        st.push(5);
//        System.out.println(st.pop());
//        System.out.println(st.pop());

//        QueueTwo q = new QueueTwo();
//        q.enqueue(1);
//        q.enqueue(2);
//        q.enqueue(3);
//        q.print();
//        System.out.println(q.dequeue());
//       System.out.println(q.dequeue());
//        q.enqueue(4);
//        q.enqueue(5);
//
//       System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());


//        Integer arr[] = {5,3,7,9,8,1,6};
//        System.out.println("Input Array : ");
//        ArrayUtils.printArray(arr);
//
//        Integer res[] = StackUtil.nextLargest(arr);
//        System.out.println("Next Largest : ");
//        ArrayUtils.printArray(res);
//
//        Integer res2[] = StackUtil.nextSmallest(arr);
//        System.out.println("Next Smallest : ");
//        ArrayUtils.printArray(res2);
//
//        Integer res3[] = StackUtil.previousSmallest(arr);
//        System.out.println("Previous Smallest : ");
//        ArrayUtils.printArray(res3);
//
//        Integer res4[] = StackUtil.previousLargest(arr);
//        System.out.println("Previous Largest : ");
//        ArrayUtils.printArray(res4);

//        MapTwo<Integer, Integer> map = new HashMapTwo<>();
//
//        map.put(1, 1);
//        map.put(1, 2);
//        map.put(1, 3);
//        map.put(2, 4);
//        map.put(3, 5);
//
//        System.out.println(map.get(1));
//        System.out.println(map.size());
//        System.out.println(map.remove(2));
//        System.out.println(map.size());
//        System.out.println(map.get(2));
//        System.out.println(map.contains(2));
//        MergeSort m = new MergeSort();
//        List<Integer> a = Arrays.asList(4,3,2,1);
////        int a[] = {4,2,3,1};
//    m.mergeSort(a,0, a.size()-1);
//        for(int i=0;i<a.size();i++){
//            System.out.print(a.get(i) + ", ");
//        }

//        PaymentService paymentService = new PaymentService();
//
//        Vehicle bmw = new Vehicle("1234", Constants.FOUR_WHEELER);
//        System.out.println(bmw);
//
//        Terminal terminal = new Terminal();
//
//        ParkingLot parkingLot = new ParkingLot();
//
//        Ticket ticket = parkingLot.parkVehicle(bmw);
//        System.out.println(ticket);
//
//        Bill bill = parkingLot.getBill(ticket);
//        System.out.println(bill);
//
//        paymentService.payBill(bill);
//        System.out.println(bill);
//
//        Vehicle myBmw = parkingLot.unPark(ticket, bill);
//        System.out.println(myBmw);
    }
}