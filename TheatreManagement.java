public class TheatreManagement {

    //a movie for TheatreManagement (or Theatre ) is a TheatrePlan (or a Seat&PriceOrganization)

    String nameOfTheatre;
    int theatresCount=0;
    Queue<TheatrePlan> theatre;

    public TheatreManagement(String n){
        nameOfTheatre=n;
        theatresCount++;
    }

    public TheatreManagement(String n,Queue<TheatrePlan> t){
        nameOfTheatre=n;
        theatresCount++;
        this.theatre=t;
    }

    public int getTheatresCount(){
        return theatresCount;
    }

    public void addMovieToTheatre(TheatrePlan m){
        theatre.enqueue(m);
    }

    public TheatrePlan removeMovieFromFrontOfTheatre(){
        return theatre.dequeue();
    }

    public TheatrePlan PeekMovieFromFrontOfTheatre(){
        return theatre.getFront();
    }

    public TheatrePlan searchAndRemoveFromTheatre(TheatrePlan m){
        return theatre.searchAndDelete(m);
    }

    public boolean searchMovieInTheatre(TheatrePlan m){
        return theatre.search(m);
    }

    public void displayMoviesOfTheatre(){
        System.out.print(nameOfTheatre+"{");
        theatre.display();
        System.out.print("}");
    }



}
