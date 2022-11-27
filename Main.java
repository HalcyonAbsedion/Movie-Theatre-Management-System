import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        TheatreManagement[] theatres=new TheatreManagement[3];
        theatres[0]=new TheatreManagement(5,5,4);
        theatres[1]=new TheatreManagement(5,5,4);
        theatres[2]=new TheatreManagement(5,5,4);
        Movie m1=new Movie("Movie1",2.5,20,30,false);
        Movie m2=new Movie("Movie2",1.5,20,30,false);
        Movie m3=new Movie("Movie3",2.5,20,30,false);
        Movie m4=new Movie("Movie4",2,20,30,false);
        CircularMovies movies=new CircularMovies();
        movies.addMovie(m1);
        movies.addMovie(m2);
        movies.addMovie(m3);
        movies.addMovie(m4);
        int week=0;
        int input;
        while(1==1){
            for(int day=0;day<7;day++){
                System.out.println("\"Start of New Day\"");
                timeDisplay(week,day);
                System.out.println("Welcome Admin");
                while(true){
                    System.out.println("1.Edit Today's Schedule");
                    System.out.println("2.View Todays Schedule");
                    System.out.println("3.Edit Movies");
                    System.out.println("4.View Movies");
                    System.out.println("5.Start Day");
                    System.out.println("6.Exit");
                    input=sc.nextInt();
                    System.out.println();
                    if(input==1){
                        while(true){
                            System.out.println("Editing Schedule:");
                            System.out.println("1.Auto-Generate Schedule");
                            System.out.println("2.Manually Edit Schedule");
                            System.out.println("3.Stop Editing");
                            input=sc.nextInt();
                            if(input==1){
                                Node<Movie> current = movies.head;
                                boolean[] schedule=new boolean[theatres.length];
                                for(int i=0;!scheduleIsFull(schedule);i++){
                                    if(!theatres[i % theatres.length].addMovie(current.data)) {
                                        schedule[i % theatres.length] = true;
                                        continue;
                                    }
                                    else
                                        current=current.next;
                                }
                            }
                            else if(input==2){
                                System.out.println("Choose Theatre to edit plan (press -1 to stop editing):");
                                for(int i=0;i<theatres.length;i++){
                                    System.out.println("Theatre "+(i+1));
                                }
                                input=sc.nextInt();
                                System.out.println();
                                if(input==-1){
                                    break;
                                }
                                else{
                                    while(true){
                                        System.out.println("Editing Theatre "+(input)+":");
                                        System.out.println("1.Add Movie");
                                        System.out.println("2.Remove Movie");
                                        System.out.println("3.Back to Editing Menu");
                                        int input2=sc.nextInt();
                                        if(input2==1){

                                        }
                                        else if (input2==2){

                                        }
                                        else if(input2==3){
                                            break;
                                        }
                                        else{
                                            System.out.println("Invalid Option!");
                                            continue;
                                        }
                                    }
                                }
                            }
                            else if (input==3) {
                                break;
                            }
                        }
                    }
                    else if(input==2){
                        displaySchedule(theatres);
                    }
                    else if(input==3){
                        while(true) {
                            System.out.println("Editing Movies:");
                            System.out.println("1.Add Movie");
                            System.out.println("2.Remove Movie");
                            System.out.println("3.Display Movies");
                            System.out.println("4.Back to Menu");
                            input=sc.nextInt();
                            if(input==1){

                            }
                            else if (input==2){

                            }
                            else if (input==3){
                                movies.display();
                            }
                            else if(input==4){
                                break;
                            }
                            else{
                                System.out.println("Invalid Option!");
                                continue;
                            }
                        }
                    }
                    else if(input==4){
                        movies.display();
                    }
                    else if(input==5)
                        break;
                    else if(input==6) {
                        System.out.println("Shutting down the system...");
                        return;
                    }
                    else{
                        System.out.println("Invalid Option!");
                        continue;
                    }
                }
                for(double hour=0;hour<8;hour+=0.5){
                    while(true){
                        timeDisplay(week,day,hour);
                        System.out.println("1.View Movies list with prices");
                        System.out.println("2.Order Ticket");
                        System.out.println("3.End Day");
                        System.out.println("4.Exit");
                        input=sc.nextInt();
                        System.out.println();
                        timeDisplay(week,day,hour);
                        System.out.println();
                        if(input==1) {
                            movies.displayWithPrices();
                        }
                        else if(input==2) {
                            while(true){
                                double price=0;
                                TheatrePlan theatrePlan=null;
                                System.out.println("1.Choose Movie");
                                System.out.println("2.View Full Schedule");
                                System.out.println("3.Confirm Purchase ("+price+"$)");
                                System.out.println("4.Back to Menu");
                                input=sc.nextInt();
                                System.out.println();
                                if(input==1){
                                    movies.displayAsList();
                                    input=sc.nextInt();
                                    if(input>movies.size()){
                                        System.out.println("Invalid Option!");
                                        continue;
                                    }
                                    else{
                                        Movie movie=movies.getMovie(input);

                                    }
                                }
                                else if (input==2) {
                                    displaySchedule(theatres);
                                }
                                else if(input==3){

                                }
                                else if(input==4){
                                    break;
                                }
                                else{
                                    System.out.println("Invalid Option!");
                                    continue;
                                }
                            }
                        }
                        else if(input==3) {
                            System.out.println("Shutting down the system...");
                            return;
                        }
                        else if(input==4){
                            break;
                        }
                        else{
                            System.out.println("Invalid Option!");
                            continue;
                        }
                    }
                }
            }
        }
    }
//    public static TheatreManagement createTheatre(String name,Movie[] movies){
//        Queue<TheatrePlan> TheatreQ = new Queue<TheatrePlan>();
//        for(int i=0;i<movies.length;i++) {
//            TheatreQ.enqueue(new TheatrePlan(movies[i]));
//
//        }
//        TheatreManagement theatre = new TheatreManagement(name,TheatreQ);
//        return theatre;
//    }
//    public static void mainMenu(int week, int day, int hour, TheatrePlan[] theatres, LinkedList<Movie> movies){
//
//
//    }
    public static boolean scheduleIsFull(boolean a[]){
        for (int i=0;i<a.length;i++){
            if(a[i]==false){
                return false;
            }
        }
        return true;
    }
    public static void displaySchedule(TheatreManagement[] theatres){
        for(int i=0;i<theatres.length;i++){
            System.out.println("Theatre "+(i+1)+":");
            theatres[i].display();
            System.out.println();
        }
    }
    public static void displaySchedule(TheatreManagement[] theatres,Movie m){
        for(int i=0;i<theatres.length;i++){
            System.out.println("Theatre "+(i+1)+":");
            theatres[i].display();
            System.out.println();
        }
    }
    public static void timeDisplay(int week,int day,double hour){
        String[] weekDays={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        String timeHours=(int)(hour+2)+":00";
        if(hour-(int)hour!=0)
            timeHours=(int)hour+2+":30";
        System.out.println("Week "+(week+1)+", "+weekDays[day]+", "+timeHours+"pm");
    }
    public static void timeDisplay(int week,int day){
        String[] weekDays={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        System.out.println("Week "+(week+1)+", "+weekDays[day]);
    }
    public static String timeDisplay(double hour){
        String timeHours=(int)(hour+2)+":00";
        if(hour-(int)hour!=0)
            timeHours=(int)hour+2+":30";
        return (timeHours+"pm");
    }
}
