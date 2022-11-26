public class Test {
    public static void main(String[] args){

        Movie m1=new Movie("Movie1");
        Movie m2=new Movie("Movie2",1,200000,300000,false);
        Movie m3=new Movie("Movie3");
        Movie m4=new Movie("Movie");
        LinkedList<Movie> l= new LinkedList<Movie>();
        CircularLinkedList<Movie> cl= new CircularLinkedList<Movie>();


        Movie movies1[]={m1,m2,m3};
        Movie movies2[]={m2,m4,m3};
        Movie movies3[]={m1,m4};
        TheatreManagement Theatres[]={createTheatre("Theater1",movies1),createTheatre("theatre2",movies2),createTheatre("theatre3",movies3)};

        for(int i=0;i<Theatres.length;i++){
            Theatres[i].displayMoviesOfTheatre();
            System.out.println();
        }



//        l.insertAtBack(m2);
//        l.insertAtFront(m1);
//        l.insertAtBack(m3);
//        m2.setStandardTicketPrice(10);
//        m2.setPremiumTicketPrice(15);
//        TheatrePlan t1=new TheatrePlan(5,20,3);
//        t1.currentMovie=m2;
//        t1.displaySeats();
//        System.out.println(t1.reserveSeat('A',1)+"$");
//        t1.displaySeats();
//        System.out.println(t1.reserveSeat('A',1)+"$");
//        System.out.println(t1.reserveSeat('D',1)+"$");
    }
    public static TheatreManagement createTheatre(String name,Movie[] movies){
        Queue<TheatrePlan> TheatreQ = new Queue<TheatrePlan>();
        for(int i=0;i<movies.length;i++) {
            TheatreQ.enqueue(new TheatrePlan(movies[i]));

        }
        TheatreManagement theatre = new TheatreManagement(name,TheatreQ);
        return theatre;
    }
}
