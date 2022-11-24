public class Movie {
    private String name;
    private double duration,standardTicketPrice,premiumTicketPrice;
    private boolean $3deffects;

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

    public boolean is$3deffects() {
        return $3deffects;
    }

    public void set$3deffects(boolean $3deffects) {
        this.$3deffects = $3deffects;
    }
}
