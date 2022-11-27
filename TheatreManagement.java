public class TheatreManagement extends Queue<TheatrePlan> {
    double totalTime=0;
    double time;
    private int rows,columns,vipRows;

    public TheatreManagement(int rows, int columns, int vipRows) {
        if(rows>26||rows<0) {
            System.out.println("Invalid Row Number!");
            return;
        }
        if(columns<0||columns>99) {
            System.out.println("Invalid Column Number!");
            return;
        }
        if(vipRows>rows||vipRows<0) {
            this.vipRows=0;
            System.out.println("Invalid VIP Row Position!");
            return;
        }
        this.rows = rows;
        this.columns = columns;
        this.vipRows = vipRows;
    }

    public boolean addMovie(Movie m){
        if(totalTime+m.getDuration()<=8){
            enqueue(new TheatrePlan(rows,columns,vipRows,m,totalTime));
            totalTime+=m.getDuration();
            return true;
        }
        return false;
    }
    public TheatrePlan getMoviePlanByIndex(int index){
        Queue<TheatrePlan> temp=new Queue<TheatrePlan>();
        TheatrePlan moviePlan=null;
        int i=0;
        if(!isEmpty()){
            while(!isEmpty()){
                TheatrePlan d=dequeue();
                if(i==index){
                    moviePlan=d;
                }
                i++;
                temp.enqueue(d);
            }
            while(!temp.isEmpty()){
                enqueue(temp.dequeue());
            }
        }
        return moviePlan;
    }
    public boolean removeMovieAtFront(){
        if(!isEmpty()){
            dequeue();
            return true;
        }
        return false;
    }
    public void displayMovies(){
        display();
    }
    public int displayMovies(Movie M){
        int x=0;
        if(!isEmpty()){
            Node<TheatrePlan> current = first;
            while (current != null) {
                if(current.data.getCurrentMovie()==M){
                    System.out.print(current.data);
                    x++;
                }
                current = current.next;
            }
        }
        return x;
    }
}
