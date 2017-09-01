public class OAP extends Ticket{
    public OAP(String filmName, String showingDay, Time showingTime)
    {//gets ticket of type OAP costin £6.00
        super("OAP",6.00, filmName, showingDay, showingTime);
    }
}
