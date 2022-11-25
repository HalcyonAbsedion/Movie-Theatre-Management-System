public class Theatre {
    private int seats[][],vipRows;
    private final String rowLabels="abcdefghijklmnopqrstuvwxyz";
    Movie currentMovie;
    public Theatre(int rows,int columns,int vipRows) {
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
        this.vipRows=vipRows;
        seats=new int[rows][columns];
    }
    public void displaySeats(){
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
}
