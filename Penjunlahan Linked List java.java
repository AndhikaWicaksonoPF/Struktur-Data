package penjumlahan.linked.list;


class LinkedList { 
   
    static Node head1, head2; 
   
    static class Node { 
   
        int data; 
        Node next; 
   
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 
   
    Node addTwoLists(Node first, Node second) { 
        Node res = null; 
        Node prev = null; 
        Node temp = null; 
        int carry = 0, sum; 
   
        while (first != null || second != null)
        { 
            sum = carry + (first != null ? first.data : 0) 
                    + (second != null ? second.data : 0); 
   
            carry = (sum >= 10) ? 1 : 0; 
   
            sum = sum % 10; 
    
            temp = new Node(sum); 
   
            if (res == null) { 
                res = temp; 
            } else
            { 
                prev.next = temp; 
            } 
   
            prev = temp; 
   
            if (first != null) { 
                first = first.next; 
            } 
            if (second != null) { 
                second = second.next; 
            } 
        } 
   
        if (carry > 0) { 
            temp.next = new Node(carry); 
        } 
  
        return res; 
    } 
   
    void printList(Node head) { 
        while (head != null) { 
            System.out.print(head.data + " "); 
            head = head.next; 
        } 
        System.out.println(""); 
    } 
   
    public static void main(String[] args) { 
        LinkedList list = new LinkedList(); 
   
        list.head1 = new Node(7); 
        list.head1.next = new Node(5); 
        list.head1.next.next = new Node(9); 
        list.head1.next.next.next = new Node(4); 
        list.head1.next.next.next.next = new Node(6); 
        System.out.print("List Pertama adalah "); 
        list.printList(head1); 
   
        list.head2 = new Node(8); 
        list.head2.next = new Node(4); 
        System.out.print("List Kedua adalah "); 
        list.printList(head2); 
   
        Node rs = list.addTwoLists(head1, head2); 
        System.out.print("Hasilnya  "); 
        list.printList(rs); 
    } 
} 
