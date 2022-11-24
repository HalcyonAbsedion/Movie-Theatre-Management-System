public class LinkedList<T> {
    private Node<T> first;
    public boolean isEmpty(){
        return first==null;
    }
    public void insert(T data){
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
//test comment
}
