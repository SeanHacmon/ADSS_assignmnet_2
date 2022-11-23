import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;


public class Client implements  ITestable {
    private HashMap<Hotel,ReservationSet> reservationsHistory;
    private int id;
    private int age;
    private String name;
    private String city;

    public HashMap<Hotel, ReservationSet> getReservationsHistory() {
        return reservationsHistory;
    }

    public Client(int a_id, int a_age, String a_name, String a_city){
        reservationsHistory = new HashMap<Hotel,ReservationSet>();
        id = a_id;
        age = a_age;
        city = a_city;
        name = a_name;
    }

    public void addReservationSet(Hotel hotel, ReservationSet reset){
        reservationsHistory.put(hotel,reset);
    }

    // getters

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean checkConstraints()
    {
        // ~~ task 2 | Sean's code ~~
        boolean flag = false;
        if (this.reservationsHistory.size() >= 5) {
            for (Hotel h : this.reservationsHistory.keySet()) {
                Collection<Room> hotelRooms = h.getRooms().values();
                for (Room r : hotelRooms) {
                    if (r.getRoomCategory().getType() == RoomCategory.RoomType.VIP)
                        flag = true;
                }
            }
            return flag;
        }
        return true;
    }

    public static boolean checkAllIntancesConstraints(Model model){
        return true;
    }
}
