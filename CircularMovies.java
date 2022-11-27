public class CircularMovies extends CircularLinkedList<Movie>{
    public CircularMovies() {
        super();
    }
    public void addMovie(Movie m){
        insertAtBack(m);
    }
    public void removeMovie(Movie m){
        searchAndDelete(m);
    }
    public void displayWithPrices(){
        if(!isEmpty()) {
            Node<Movie> current=head;
            current.data.displayMoviePrice();
            current=current.next;
            while(current!=head) {
                System.out.println();
                current.data.displayMoviePrice();
                current=current.next;
            }
            System.out.println();
        }
    }
    public void displayAsList(){
        if(!isEmpty()) {
            int i=1;
            Node<Movie> current=head;
            System.out.println(i+". "+current.data);
            i++;
            current=current.next;
            while(current!=head) {
                System.out.println();
                System.out.println(i+". "+current.data);
                i++;
                current=current.next;
            }
            System.out.println();
        }
    }
    public Movie getMovie(int x){
        x=x%this.size();
        for(int i=0;true;i++){
            Node<Movie> current=head;
            if(i==x)
                return current.data;
            current=current.next;
        }
    }
    public Movie getMovieIndex(int x){
        if(!isEmpty()) {
            int i=1;
            Node<Movie> current=head;
            if(x==i)
                return current.data;
            i++;
            current=current.next;
            while(current!=head) {
                if(x==i)
                    return current.data;
                i++;
                current=current.next;
            }
        }
        return null;
    }
}
