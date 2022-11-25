public class LinkedList<T> {
    private Node<T> first;
    private int size=0;
    public boolean isEmpty(){
        return first==null;
    }
    public void insertAtBack(T data){
        Node<T> n=new Node(data);
        if(isEmpty()){
            first=n;
        }
        else{
            Node<T> current=first;
            while(current.next!=null){
                current=current.next;
            }
            current.next=n;
        }
        size++;
    }
    public void insertAtFront(T data){
        Node<T> n=new Node(data);
        if(isEmpty())
            first=n;
        else{
            n.next=first;
            first=n;
        }
        size++;
    }
    public T deleteFromFront(){
        if(isEmpty()){
            return null;
        }
        else{
            T data= first.data;
            first=first.next;
            size--;
            return data;
        }
    }
    public T deleteFromBack(){
        if(isEmpty()){
            return null;
        }
        else if(first.next==null){
            T data= first.data;
            first=null;
            size--;
            return data;
        }
        else {
            Node<T> current = first;
            while (current.next.next != null) {
                current = current.next;
            }
            T data = current.next.data;
            current.next = null;
            size--;
            return data;
        }
    }
    public boolean search(T data) {
        if (!isEmpty()) {
            Node<T> current = first;
            while (current != null) {
                if (current.data.equals(data))
                    return true;
                current = current.next;
            }
        }
        return false;
    }
    public boolean searchAndDelete(T data) {
        if (!isEmpty()) {
            Node<T> current = first, previous = null;
            while (current != null) {
                if (current.data.equals(data)) {
                    previous.next = current.next;
                    size--;
                    return true;
                }
                previous = current;
                current = current.next;
            }
        }
        return false;
    }
    public void display(){
        if(!isEmpty()){
            Node<T> current = first;
            while (current != null) {
                System.out.print(current.data);
                current = current.next;
            }
        }
    }
    public int getSize(){
        return size;
    }
}
