public class Test {
    public static void main(String[] args){

        Movie m1=new Movie("Movie1",4,200000,300000,false);
        Movie m2=new Movie("Movie2",1.5,200000,300000,false);
        Movie m3=new Movie("Movie3",2.5,200000,300000,false);
        Movie m4=new Movie("Movie4",2,200000,300000,false);
        TheatreManagement t=new TheatreManagement(5,5,4);
        t.display();
        t.addMovie(m1);
        t.addMovie(m2);
        t.addMovie(m3);
        t.display();

    }
}
