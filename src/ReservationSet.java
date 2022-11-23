import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ReservationSet implements  ITestable{
    private Client client;
    private Hotel hotel;
    private ArrayList<Reservation> reservations;

    public ReservationSet(){
        reservations = new ArrayList<Reservation>();
    }

    public void setClient(Client client){
        this.client = client;
    }

    public void setHotel(Hotel hotel){
        this.hotel = hotel;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }


    public Client getClient() {
        return client;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public boolean checkConstraints()
    {
        // ~~ task 9 | Sean's code ~~
       for(Service s : this.hotel.getServices().keySet())
       {
           if (s instanceof VipService)
           {for (Reservation r : reservations){
               if (r.getBookings() != null){if (r.getBookings().getReview() == null){return false;}}}}
       }
        return true;
    }

    public static boolean checkAllIntancesConstraints(Model model){
        return true;
    }
}
