public class Test {
    public static void main(String[] args){

        Movie m1=new Movie("Movie1");
        Movie m2=new Movie("Movie2",1,200000,300000,false);
        Movie m3=new Movie("Movie3");
        LinkedList<Movie> l= new LinkedList<Movie>();

        l.insertAtBack(m2);
        l.insertAtFront(m1);
        l.insertAtBack(m3);
        m2.setStandardTicketPrice(10);
        m2.setPremiumTicketPrice(15);
        Theatre t1=new Theatre(5,20,3);
        t1.currentMovie=m2;
        t1.displaySeats();
        System.out.println(t1.reserveSeat('A',1)+"$");
        t1.displaySeats();
        System.out.println(t1.reserveSeat('A',1)+"$");
    }
}
