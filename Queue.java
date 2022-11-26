public class Queue<T> extends LinkedList<T>{
        public void enqueue(T d){
            insertAtBack(d);
        }

        public T dequeue(){
            return deleteFromFront();
        }

        public T getFront(){
            Queue<T> temp=new Queue<T>();
            if(!isEmpty()){
                T data=dequeue();
                temp.enqueue(data);
                while(!isEmpty()){
                    temp.enqueue(dequeue());
                }
                while(!temp.isEmpty()){
                    enqueue(temp.dequeue());
                }

                return data;
            }
            return null;
        }

}
