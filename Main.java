import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Theatre t1=new Theatre(10,10,7);
        int week=0;
        while(1==1){
            for(int day=0;day<7;day++){
                for(double hour=0;hour<8;hour+=0.5){
                    timeDisplay(week,day,hour);
                    System.out.println("1.Admin");
                    System.out.println("2.Customer");
                    System.out.println("3.Exit");
                    int input=sc.nextInt();
                    System.out.println();
                    if(input==1) {
                        timeDisplay(week,day,hour);
                        System.out.println("1.View Movies");
                        System.out.println("2.Add Movie");
                        System.out.println("3.Delete Movie");
                        System.out.println();
                        //SUGGEST MORE CONTROLS PLEASE
                    }
                    else if(input==2) {
                        timeDisplay(week,day,hour);
                        System.out.println("1.View Movie Schedule Today");
                        System.out.println("2.Order Ticket");
                        System.out.println();
                    }
                    else if(input==3) {
                        System.out.println("Shutting down the system...");
                        return;
                    }
                    else{
                        System.out.println("Invalid Option!");
                        continue;
                    }
                }
            }
        }
    }
    public static void mainMenu(int week,int day,int hour,Theatre[] theatres,LinkedList<Movie> movies){


    }
    public static void timeDisplay(int week,int day,double hour){
        String[] weekDays={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        String timeHours=(int)(hour+2)+":00";
        if(hour-(int)hour!=0)
            timeHours=(int)hour+2+":30";
        System.out.println("Week "+(week+1)+", "+weekDays[day]+", "+timeHours+"pm");
    }
}
