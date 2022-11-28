public class TheatreManagement extends Queue<TheatrePlan> {
    double totalTime=0;
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
            m.instances++;
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
    public void printMoviesList(){
        Queue<TheatrePlan> temp=new Queue<TheatrePlan>();
        int i=1;
        if(!isEmpty()){
            while(!isEmpty()){
                TheatrePlan t=dequeue();
                temp.enqueue(t);
                System.out.println(i+". "+t);
                i++;
            }
            while(!temp.isEmpty()){
                enqueue(temp.dequeue());
            }

        }

    }
    public void displayMovies(){
        display();
    }

    public TheatrePlan[] returnAndDisplayTheatrePlan(Movie m){
        int x=0;
        TheatrePlan[] theatrePlans = new TheatrePlan[0];
        if(!isEmpty()){
            Node<TheatrePlan> current = first;
            while (current != null) {
                if(current.data.getCurrentMovie()==m){
                    if(current.data!=null){
                        System.out.print(current.data);
                        x++;
                    }
                }
                current = current.next;
            }
            theatrePlans=new TheatrePlan[x];
            current = first;
            int i=0;
            while(current!=null) {
                if(current.data.getCurrentMovie()==m){
                    theatrePlans[i]=current.data;
                    i++;
                }
                current = current.next;
            }
        }
        return theatrePlans;
    }
    public boolean search(TheatrePlan t){
        return search(t);
    }
}
