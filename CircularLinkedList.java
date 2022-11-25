public class CircularLinkedList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int count;
    public boolean isEmpty() {
        return head==null;
    }
    public void insertAtFront(T d) {
        Node<T> p=new Node<T>(d);
        if(isEmpty()) {
            tail=p;
            head=p;
            tail.next=head;
            count++;
        }
        else {
            p.next=head;
            tail.next=p;
            head=p;
            count++;
        }
    }
    public void insertAtBack(T d) {
        Node<T> p=new Node<T>(d);
        if(isEmpty()) {
            head=p;
            tail=p;
            tail.next=head;
            head.next=tail;
            count++;
        }
        else {
            p.next = head;
            tail.next = p;
            tail = p;
            count++;
        }
        }
    public void display() {
        if(!isEmpty()) {
            Node<T> current=head;
            System.out.print(current.data+" ");
            current=current.next;
            while(current!=head) {
                System.out.print(current.data+" ");
                current=current.next;
            }
            System.out.println();
        }
    }

    public T removeFromFront() {
        T x=null;
        if(!isEmpty()) {
            if(head.next==head){
                head=null;
            }
            else {
                x = head.data;
                head = head.next;
                tail.next = head;
            }
            count--;
        }
        return x;
    }
    public T removeFromBack() {
        T x=null;
        if(!isEmpty()) {
            Node<T> current=head;
            Node<T> prev=null;
            while(current.next!=head) {
                prev=current;
                current = current.next;
            }
            if(prev==null) {
                x=head.data;
                head = null;
                count--;
            }
            else {
                x=current.data;
                prev.next=head;
                count--;
            }
        }
        return x;
    }

    public boolean search(T data) {
        if (!isEmpty()) {
            if(head.data.equals(data)) return true;
            Node<T> current = head;
            while (current.next != head) {

                current = current.next;
                if (current.data.equals(data))
                    return true;
            }

        }
        return false;
    }

    public int size(){
        return count;
    }

    public T searchAndDelete(T data) {
        if (!isEmpty()) {
            if(head.data.equals(data)){
                T d=head.data;
                removeFromFront();
                return d;
            }
            Node<T> current = head, previous = null;
            while (current.next != head ) {
                previous = current;
                current = current.next;
                if (current.data.equals(data)) {
                        previous.next = current.next;
                        count--;
                    return current.data;
                }
            }
        }
        return null;
    }

}
