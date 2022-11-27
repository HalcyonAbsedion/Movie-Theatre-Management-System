public class Stack<T> extends LinkedList<T> {
    public void push(T data) {
        insertAtFront(data);
    }
    public T pop() {
        return deleteFromFront();
    }
    public T peek() {
        T x=null;
        x=pop();
        push(x);
        return x;
    }
    public void display() {
        Stack<T> temp=new Stack<T>();
        while(!isEmpty()) {
            T t=pop();
            System.out.print(t+" ");
            temp.push(t);
        }
        while(!temp.isEmpty()) {
            push(temp.pop());
        }

    }

}
