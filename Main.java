import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        Movie m1=new Movie("Spider-Man: No Way Home",2.5,20,30,false);
        Movie m2=new Movie("The Matrix: Ressurrections",2.5,18,25,false);
        Movie m3=new Movie("Bullet Train",2,20,30,false);
        Movie m4=new Movie("Top Gun: Maverick",2,20,30,false);
        Movie m5=new Movie("The Batman",3,22,31,false);
        CircularMovies movies=new CircularMovies();
        movies.addMovie(m1);
        movies.addMovie(m2);
        movies.addMovie(m3);
        movies.addMovie(m4);
        movies.addMovie(m5);
        int week=0;
        int input;
        while(1==1){
            for(int day=0;day<7;day++){
                TheatreManagement[] theatres=new TheatreManagement[3];
                theatres[0]=new TheatreManagement(5,5,4);
                theatres[1]=new TheatreManagement(5,5,4);
                theatres[2]=new TheatreManagement(5,5,4);
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
                                //Auto Generate
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
                                // Manual edit
                                System.out.println("Choose Theatre to edit plan (press -1 to stop editing):");
                                for(int i=0;i<theatres.length;i++){
                                    System.out.println("Theatre "+(i+1));
                                }
                                input=sc.nextInt();
                                System.out.println();
                                if(input==-1){
                                    //exit edit
                                    break;
                                }
                                else{
                                    //edit chosen theatre
                                    while(true){
                                        System.out.println("Editing Theatre "+(input)+":");
                                        System.out.println("1.Add Movie");
                                        System.out.println("2.Remove Movie");
                                        System.out.println("3.Display Schedule");
                                        System.out.println("4.Back to Editing Menu");
                                        int input2=sc.nextInt();
                                        if(input2==1){
                                            //add movie to the chosen theatre hall
                                            System.out.println("Choose a movie to add");
                                            movies.displayAsList();
                                            input2=sc.nextInt();
                                            if(theatres[input-1].addMovie(movies.getMovieByIndex(input2))){
                                                System.out.println("Successfully Added!");
                                            }
                                            else
                                                System.out.println("Error, theatre "+(input)+" schedule full!");
                                        }
                                        else if (input2==2){
                                            //remove movie from theatre hall
                                            theatres[input-1].printMoviesList();
                                            System.out.println("Choose a movie to remove:");
                                            int index=sc.nextInt();
                                            TheatrePlan theatrePlan=theatres[input-1].getMoviePlanByIndex(index-1);
                                            theatres[input-1].searchAndDelete(theatrePlan);
                                            theatres[input-1].displayMovies();
                                        }
                                        else if (input2==3) {
                                            //displays the movies that the theatre chosen is hosting
                                            theatres[input-1].displayMovies();
                                        } else if(input2==4){
                                            //go back to editing menue
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
//                                Exit edit Today's Schedule
                                break;
                            }
                        }
                    }
                    else if(input==2){
//                        View Todays Schedule
                        displaySchedule(theatres);
                    }
                    else if(input==3){
//                        Edit Movies
                        while(true) {
                            System.out.println("Editing Movies:");
                            System.out.println("1.Add Movie");
                            System.out.println("2.Remove Movie");
                            System.out.println("3.Display Movies");
                            System.out.println("4.Back to Menu");
                            input=sc.nextInt();
                            if(input==1){
//                                Add Movie
                                System.out.println("Enter Movie Name:");
                                String name=sc.next();
                                System.out.println("Enter duration of the movie:");
                                double duration = sc.nextDouble();
                                System.out.println("Enter standard ticket price: ");
                                double standardTicketPrice=sc.nextDouble();
                                System.out.println("Enter premium ticket price: ");
                                double premiumTicketPrice=sc.nextDouble();
                                System.out.println("Enter 3d effect (true/false): ");
                                boolean $3D_Effects= sc.nextBoolean();

                                Movie newMovie=new Movie(name,duration,standardTicketPrice,premiumTicketPrice,$3D_Effects);
                                movies.addMovie(newMovie);
                            }
                            else if (input==2){
//                                Remove Movie
                                System.out.println("Choose Movie to Delete:");
                                movies.displayAsList();
                                input=sc.nextInt();
                                System.out.println();
                                movies.removeMovie(movies.getMovieByIndex(input));
                            }
                            else if (input==3){
//                                Display Movies
                                movies.display();
                            }
                            else if(input==4){
//                                Back to Menu
                                break;
                            }
                            else{
                                System.out.println("Invalid Option!");
                                continue;
                            }
                        }
                    }
                    else if(input==4){
//                        View Movies
                        movies.display();
                    }
                    else if(input==5)
//                        Start Day
                        break;
                    else if(input==6) {
//                        Exit (Terminate)
                        System.out.println("Shutting down the system...");
                        return;
                    }
                    else{
                        System.out.println("Invalid Option!");
                        continue;
                    }
                }
//                 start day goes here
                for(double hour=0;hour<8;hour+=0.5){
                    double price=0;
                    TheatrePlan theatrePlan=null;
                    int theatreNumber=0;
                    char row=0;
                    int col=0;
                    while(price==0){
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
                                System.out.println("1.Choose Movie");
                                System.out.println("2.View Full Schedule");
                                System.out.println("3.Confirm Purchase ("+price+"$)");
                                System.out.println("4.Back to Menu");
                                input=sc.nextInt();
                                System.out.println();
                                if(input==1){
                                    movies.displayAsList();
                                    input=sc.nextInt();
                                    if(input>movies.size()||input<1){
                                        System.out.println("Invalid Option!");
                                        continue;
                                    }
                                    else{
                                        Movie movie=movies.getMovieByIndex(input);
                                        System.out.println(movie);
                                        while(true){
                                            System.out.println("Choose Time:");
                                            System.out.println();
                                            TheatrePlan[][] instances=displaySchedule(theatres,movie);
                                            System.out.println();
                                            input=sc.nextInt();
                                            theatreNumber=input;
                                            if(input<1||input>instances.length){
                                                System.out.println("Invalid Option!");
                                                continue;
                                            }
                                            else{
                                                System.out.println("Choose Seat:");
                                                theatrePlan=instances[input-1][0];
                                                theatrePlan.displaySeats();
                                                System.out.println("Enter Row(A,B...):");
                                                row=sc.next().charAt(0);
                                                System.out.println("Enter Column(1,2...):");
                                                col=sc.nextInt();
                                                price=theatrePlan.reserveSeat(row,col);
                                                theatrePlan.displaySeats();
                                                if(price>0)
                                                    break;
                                            }
                                        }
                                    }
                                }
                                else if (input==2) {
                                    displaySchedule(theatres);
                                }
                                else if(input==3){
                                    System.out.println("_________________________________________________");
                                    System.out.println("_________________________________________________");
                                    System.out.println("Ticket");
                                    System.out.println("_________________________________________________");
                                    timeDisplay(week,day,hour);
                                    System.out.println("_________________________________________________");
                                    System.out.println("Theatre number: "+theatreNumber);
                                    System.out.println(theatrePlan);
                                    timeDisplay(theatrePlan.getTime());
                                    System.out.println("Seat: "+row+col);
                                    System.out.println("Total Price: "+price+"$");
                                    System.out.println("_________________________________________________");
                                    System.out.println("_________________________________________________");
                                    break;
                                }
                                else if(input==4){
                                    price=0;
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
            theatres[i].displayMovies();
            System.out.println();
        }
    }

    public static TheatrePlan[][] displaySchedule(TheatreManagement[] theatres,Movie m){
        TheatrePlan[][] theatrePlans = new TheatrePlan[m.instances][];
        int j=0;
        int sum=0;
        for(int i=0;i<theatres.length&&sum<m.instances&&j<m.instances;i++){
            System.out.println((i+1)+". Theatre "+(i+1)+":");
            theatrePlans[j]=theatres[i].returnAndDisplayTheatrePlan(m);
            sum+=theatrePlans[j].length;
            System.out.println();
            if(theatrePlans[j].length>0){
                j++;
            }
        }
        return theatrePlans;
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
