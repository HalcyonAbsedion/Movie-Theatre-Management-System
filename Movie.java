public class Movie {
    private String name;
    private double duration,standardTicketPrice,premiumTicketPrice;
    private boolean $3D_Effects;


    public Movie(String name,double duration, double standardTicketPrice,double premiumTicketPrice,boolean $3D_Effects){
        this.name=name;
        this.duration=duration;
        this.standardTicketPrice=standardTicketPrice;
        this.premiumTicketPrice=premiumTicketPrice;
        this.$3D_Effects=$3D_Effects;
    }

    public Movie(String name){this.name=name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getStandardTicketPrice() {
        return standardTicketPrice;
    }

    public void setStandardTicketPrice(double standardTicketPrice) {
        this.standardTicketPrice = standardTicketPrice;
    }

    public double getPremiumTicketPrice() {
        return premiumTicketPrice;
    }

    public void setPremiumTicketPrice(double premiumTicketPrice) {
        this.premiumTicketPrice = premiumTicketPrice;
    }

    public boolean is3D_Effects() {
        return $3D_Effects;
    }

    public void set3D_Effects(boolean $3D_Effects) {
        this.$3D_Effects = $3D_Effects;
    }
    public String durationString(){
        String s=(int)duration+"hr";
        if(duration-(int)duration==0){
            return s;
        }
        return s+","+(int)((duration-(int)duration)*60)+"min";
    }
    public String toString(){
        return this.name+" ("+durationString()+")";
    }
    public void displayMoviePrice(){
        System.out.print(this+" standard ticket("+this.getStandardTicketPrice()+"$), "+" VIP ticket("+this.getPremiumTicketPrice()+"$)");
    }
}
