import java.text.DecimalFormat;

public abstract class Ticket {

    private static int count = 1;
    private static double discount = 2.00;

    private int ticketID;
    private String ticketType;
    private double ticketPrice;
    private String filmName;
    private String showingDay;
    private Time showingTime;

    public Ticket(String ticketType, double ticketPrice, String filmName, String showingDay, Time showingTime)
    {
        this.ticketID = count;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
        this.filmName = filmName;
        this.showingDay = showingDay;
        this.showingTime = showingTime;
        this.applyDiscount(showingDay);
        count++;
    }
    private void applyDiscount(String showingDay)
    {
        if (showingDay.equals("Wednesday"))
            this.ticketPrice -= 2.00;
    }
    //get ticket information
    public int getTicketNumber()
    {
        return ticketID;
    } //return ticket number
    public String getTicketType()
    {
        return ticketType;
    } //return ticket type
    public double getTicketPrice()
    {
        return ticketPrice;
    } //return ticket price
    public String getFilmName()
    {
        return filmName;
    } //return film name
    public String getShowingDay()
    {
        return showingDay;
    } //return days of showing
    public Time getShowingTime()
    {
        return showingTime;
    } //return time of showing
    public boolean equals(Ticket other)
    {
        return this.ticketID == other.ticketID;
    } //check if two tickets are the same
    public String toString() //return information of ticket as string
    {
        return "Ticket ID "+ticketID+": "+ticketType+" ticket to see " + filmName + " on " +showingDay+ " at "+showingTime+" costing £" +new DecimalFormat("0.00").format(ticketPrice);
    }

}
