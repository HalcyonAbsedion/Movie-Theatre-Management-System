public class LinkedList<T> {
    private Node<T> first;
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
    }
    public void insertAtFront(T data){
        Node<T> n=new Node(data);
        if(isEmpty())
            first=n;
        else{
            n.next=first;
            first=n;
        }
    }
    public T deleteFromFront(){
        if(isEmpty()){
            return null;
        }
        else{
            T data= first.data;
            first=first.next;
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
            return data;
        }
        else{
            Node<T> current=first;
            while(current.next.next!=null){
                current=current.next;
            }
            T data=current.next.data;
            current.next=null;
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
                    return true;
                }
                previous = current;
                current = current.next;
            }
        }
        return false;
    }
}
