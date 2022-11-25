public class Test {
    public static void main(String[] args){

        Movie m1=new Movie("Movie1");
        Movie m2=new Movie("Movie2",1,200000,300000,false);
        Movie m3=new Movie("Movie3");
        LinkedList<Movie> l= new LinkedList<Movie>();

        l.insertAtBack(m2);
        l.insertAtFront(m3);
        l.insertAtBack(m1);
        System.out.println("Test insertAtBack insertAtFront and display functions:");
        l.display();
        System.out.println("");
        System.out.println("isEmpty: "+ l.isEmpty());

        System.out.println("Test deleteFromFront: "+l.deleteFromBack());

        System.out.println("Test deleteFromBack "+ l.deleteFromFront());

        System.out.println("Test size: "+ l.getSize());

        System.out.println("Test search: "+ l.search(m2));

        System.out.println("Test movie getters: "+ m2.getName()+" "+m2.getDuration()+" "+m2.getPremiumTicketPrice()+" "+m2.getStandardTicketPrice()+" "+m2.is3D_Effects());
        m2.setName("MOVIE");m2.setDuration(4);m2.setPremiumTicketPrice(3);m2.setStandardTicketPrice(2);m2.set3D_Effects(true);
        System.out.println("Test movie setters: "+ m2.getName()+" "+m2.getDuration()+" "+m2.getPremiumTicketPrice()+" "+m2.getStandardTicketPrice()+" "+m2.is3D_Effects());

        System.out.println("Test search and delete: "+ l.searchAndDelete(m2));

        System.out.println("isEmpty: "+ l.isEmpty());
    }
}
