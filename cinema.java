import java.util.*;
import java.text.DecimalFormat;
public class cinema {
    public static void main(String[] args)
    {
        //Gets list of films
        List<Film> films = getFilms();
        //Gets list of days starting from today
        List<String> days = getDays();
        //set scanner
        Scanner input = new Scanner(System.in);
        //gets film selection, end code if they pick (q)uit
        int film = whichFilm(input, films);
        if (film == -1)
            return;
        else
            System.out.println("You selected to watch " + films.get(film) + "\n");
        //gets day selection, end code if they pick (q)uit
        int day = whichDay(input, days, films.get(film));
        if (day == -1)
            return;
        else
            System.out.println("You selected " + days.get(films.get(film).getShowingDays()[day]) + "\n");
        //gets time selection, end code if they pick (q)uit
        int showingTime = whichTime(input, films.get(film));
        if (showingTime == -1)
            return;
        else
            System.out.println("You selected the time " + films.get(film).getShowingTimes().get(showingTime) + "\n");
        //gets number of tickets for each ticket type
        int[] numberOfTickets = whichTickets(input);
        //gets list of tickets with ticket type, ticket price, film name, showing day, showing time
        List<Ticket> order = assignTickets(numberOfTickets, films.get(film).getFilmName(), days.get(day), films.get(film).getShowingTimes().get(showingTime));

        orderSummery(order);
    }
    private static int whichFilm(Scanner input, List<Film> films)//gives a list of the films that are showing and gets selection
    {
        String film;
        System.out.println("Hello and welcome to QA cinema. The current films on show are: ");
        for (int i = 0; i < films.size(); i++)
            System.out.println((i+1)+": "+films.get(i));
        System.out.print("Please enter the number corresponding to the film you would like to watch, type (q)uit to cancel your order: ");
        //loops util a valid answer is given
        while(true) {

            film = input.next();
            //check if the user wants to quit the order
            if (film.toLowerCase().equals("q") || film.toLowerCase().equals("quit"))
            {
                return -1;
            }
            //attempts to parse their input to an integer, then checks if it is a valid choice
            try {
                int filmInt = Integer.parseInt(film);
                if (filmInt > 0 && filmInt <= films.size()) {
                    return --filmInt;
                } else {
                    System.out.print("Please enter the number of the film you wish to see: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter the number of the film you wish to see: ");
            }
        }
    }
    private static int whichDay(Scanner input, List<String> days, Film film)//gives a list of the days the selected film is showing and gets selection
    {
        String day;
        System.out.println("This film is showing on the following days: ");
        for(int i = 0; i < film.getShowingDays().length; i++)
        {
            System.out.println((i+1) + ": " + days.get(film.getShowingDays()[i]));
        }
        System.out.print("Please enter the number corresponding to the day you would like to watch the film, type (q)uit to exit: ");
        //loops until a valid answer is given
        while(true) {

            day = input.next();
            //checks if the user wants to quit the order
            if (day.toLowerCase().equals("q") || day.toLowerCase().equals("quit"))
            {
                return -1;
            }
            //attempts to parse their input to an integer, then checks if it is a valid choice
            try {
                int dayInt = Integer.parseInt(day);
                if (dayInt > 0 && dayInt <= film.getShowingDays().length) {
                    return --dayInt;
                } else {
                    System.out.print("Please enter the number of the film you wish to see: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter the number of the film you wish to see: ");
            }
        }
    }
    private static int whichTime(Scanner input, Film film)//gives a list of showing times for selected film and gets selection
    {
        String time;
        System.out.println("This film is showing at the following times: ");
        for(int i = 0; i < film.getShowingTimes().size(); i++)
        {
            System.out.println((i+1) + ": " + film.getShowingTimes().get(i));
        }
        System.out.print("Please enter the number corresponding to the time you would like to watch the film, type (q)uit to exit: ");
        //loops until a valid answer is given
        while(true) {

            time = input.next();
            //checks if the user wants to quit the order
            if (time.toLowerCase().equals("q") || time.toLowerCase().equals("quit"))
            {
                return -1;
            }
            //attempts to parse their input to an integer, then checks if it is a valid choice
            try {
                int dayInt = Integer.parseInt(time);
                if (dayInt > 0 && dayInt <= film.getShowingTimes().size()) {
                    return --dayInt;
                } else {
                    System.out.print("Please enter the number of the time you would like to see the film: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter the number of the film you would like to see the film: ");
            }
        }
    }
    private static int[] whichTickets(Scanner input)//asks how many of each ticket type the user wants
    {
        int[] numberOfTickets = new int[4];
        String[] stringTicket = {"Standard", "OAP", "Student", "Child"};
        for (int i = 0; i < 4; i++)
        {
            System.out.print("How many "+stringTicket[i]+" tickets would you like? ");
            //loops until a valid answer is given
            while(true)
            {
                String holder = "";
                holder = input.next();
                try {
                    numberOfTickets[i] = Integer.parseInt(holder);
                    if (numberOfTickets[i] >= 0) {
                        break;
                    } else {
                        System.out.print("Please enter the number of "+stringTicket[i]+" tickets you would like: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Please enter the number of "+stringTicket[i]+" tickets you would like: ");
                }
            }
        }
        return numberOfTickets;
    }
    private static List<Ticket> assignTickets(int[] numberOfTickets, String filmName, String showingDay, Time showingTime)//assigns tickets based of ticket selection
    {
        List<Ticket> order = new ArrayList<Ticket>();

        for(int i = 0; i < numberOfTickets.length; i++) {
            for (int j = 0; j < numberOfTickets[i]; j++) {
                switch (i) {
                    case(0):
                        order.add(new Standard(filmName,showingDay,showingTime));
                        break;
                    case(1):
                        order.add(new OAP(filmName,showingDay,showingTime));
                        break;
                    case(2):
                        order.add(new Student(filmName,showingDay,showingTime));
                        break;
                    case(3):
                        order.add(new Child(filmName,showingDay,showingTime));
                        break;
                }
            }
        }
        return order;
    }
    private static void orderSummery (List<Ticket> order)//gives a summery of the order
    {
        double grandTotal = 0.0;
        System.out.println("\nThank you for your order.\nOrder Summery:\n");
        for (int i = 0; i < order.size(); i++) {
            System.out.println("" + order.get(i));
            grandTotal += order.get(i).getTicketPrice();
        }
        System.out.println("Grand total: £"+new DecimalFormat("0.00").format(grandTotal));
    }
    private static List<Film> getFilms()//sets up the current list of films
    {
        List<Film> films = new ArrayList<Film>();
        films.add(new Film("The Lord of the Rings: The Fellowship of the Ring",new int[] {0,1,2,3,4,5,6}, Arrays.asList(new Time(8,0),new Time(12,30),new Time(17,0))) );
        films.add(new Film("The Lord of the Rings: The Two Towers",new int[] {0,1,4,5,6}));
        films.add(new Film("The Lord of the Rings: The Return of the King",new int[] {0,1,4,5,6}));
        return films;
    }
    private static List<String> getDays()//gets the next 7 days starting from today
    {
        List<String> days = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        for (int i = 0; i < 7; i++)
        {
            switch ((dayOfWeek+i)%7) {
                case 0:
                    days.add("Saturday");
                    break;
                case 1:
                    days.add("Sunday");
                    break;
                case 2:
                    days.add("Monday");
                    break;
                case 3:
                    days.add("Tuesday");
                    break;
                case 4:
                    days.add("Wednesday");
                    break;
                case 5:
                    days.add("Thursday");
                    break;
                case 6:
                    days.add("Friday");
                    break;
            }
        }
        return days;
    }
}
