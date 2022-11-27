public class TheatrePlan {
    private int seats[][],vipRows;
    private final String rowLabels="abcdefghijklmnopqrstuvwxyz";
    public int id=0;
    private Movie currentMovie;
    private double time;
    public TheatrePlan(int rows, int columns, int vipRows) {
        this.vipRows=vipRows;
        seats=new int[rows][columns];
        id++;
    }
    public TheatrePlan(int rows, int columns, int vipRows, Movie m,double time) {
        this(rows,columns,vipRows);
        this.currentMovie=m;
        this.time=time;
        id++;
    }
    public void displaySeats(){
        System.out.println();
        System.out.println("VIP ROWS: ["+Character.toUpperCase(rowLabels.charAt(vipRows))+",...,"+Character.toUpperCase(rowLabels.charAt(seats.length-1))+"]");
        System.out.print(" |");
        for(int j=0;j<seats[0].length;j++){
            if(j+1<10)
                System.out.print("0"+(j+1)+"|");
            else
                System.out.print((j+1)+"|");
        }
        System.out.println();
        for(int j=0;j<seats[0].length+1;j++){
            System.out.print("___");
        }
        System.out.println();
        for(int i=0;i<seats.length;i++){
            System.out.print(Character.toUpperCase(rowLabels.charAt(i))+"|");
            for(int j=0;j<seats[0].length;j++){
                if(seats[i][j]==1)
                    System.out.print("X |");
                else
                    System.out.print("  |");
            }
            System.out.println();
            for(int j=0;j<seats[0].length+1;j++){
                System.out.print("___");
            }
            System.out.println();
        }
    }
    public double reserveSeat(char row,int column){
        column=column-1;
        if(column<0||column>seats[0].length) {
            System.out.println("Invalid Column Number!");
            return 0;
        }
        row=Character.toLowerCase(row);
        int i=rowLabels.indexOf(row);
        if(i>seats.length||i<0) {
            System.out.println("Invalid Row Number!");
            return 0;
        }
        double price=0;
        if(seats[i][column]==0){
            seats[i][column]=1;
            if(i<vipRows)
                price=currentMovie.getStandardTicketPrice();
            else
                price= currentMovie.getPremiumTicketPrice();
        }
        else {
            System.out.println("Seat Already Reserved!");
        }
        return price;
    }

    public String toString(){
        return "\t--"+currentMovie+" on "+Main.timeDisplay(time)+"--\t";
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }
}
