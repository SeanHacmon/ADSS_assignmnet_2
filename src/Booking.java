import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Booking implements  ITestable{
    private Date date;
    private Room room;
    private ArrayList<HotelService> services;
    private Reservation reservation;
    private Review review;


    public Booking(Date a_date, Room a_room){
        date = a_date;
        room = a_room;
        services = new ArrayList<HotelService>();
    }

    public void addService(HotelService s){
        services.add(s);
    }

    public void addReview(Review a_review) {review  = a_review; }

    public void addReservation(Reservation r){
        reservation = r;
    }

    public void assignRoom(Room room){
        this.room = room;
    }


    // getters

    public Date getDate() {
        return date;
    }

    public Room getRoom() {
        return room;
    }

    public ArrayList<HotelService> getServices() {
        return services;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Review getReview() {
        return review;
    }


    @Override
    public boolean checkConstraints()
    {
        // ~~ task 13 | Sean's code
//        for (int i =0;i<services.size();i++)
//        {if (this.services.get(i).getHotel() != this.getRoom().getHotel()) {return false;}}

        // ~~ task 8 | Sean's code
        return (reservation.getRoomCategory().getType() == RoomCategory.RoomType.VIP && room.getRoomCategory().getType() == RoomCategory.RoomType.VIP) ||
                (reservation.getRoomCategory().getType() == RoomCategory.RoomType.SUITE && room.getRoomCategory().getType() != RoomCategory.RoomType.BASIC) ||
                (reservation.getRoomCategory().getType() == RoomCategory.RoomType.BASIC);

    }

    public static boolean checkAllIntancesConstraints(Model model){
        return true;
    }
}