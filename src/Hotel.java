
import java.util.*;

public class Hotel implements  ITestable{
    private String name;
    private HashMap<Client, ReservationSet> allReservation;
    private HashMap<Service, HotelService> services;


    private HashMap<Integer,Room> rooms;
    private String city;
    private Group group;
    private int rate;



    public Hotel(String city, String name,int rate){
        this.city = city;
        this.name = name;
        this.rate = rate;
        rooms = new HashMap<Integer,Room>();
        allReservation = new HashMap<Client, ReservationSet>();
        services = new HashMap<Service, HotelService>();

    }

    public void addReservationSet(Client client,ReservationSet reservationSet){
        allReservation.put(client,reservationSet);
    }

    public void addService(Service service, HotelService hotelService){
        services.put(service,hotelService);
    }

    public void addRoom(int roomNumber, Room room){
        rooms.put(roomNumber,room);
    }


    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public HashMap<Client, ReservationSet> getAllReservation(){return allReservation;}

    public HashMap<Service, HotelService> getServices(){return services;}

    public int getRate(){return rate;}

    @Override
    public boolean checkConstraints()
    {
        // ~~ task 6 | Sean's code ~~
        int vipCounter = 0;
        for (Room r: this.rooms.values())
        {
            if (r.getRoomCategory().getType() == RoomCategory.RoomType.VIP)
            {
                vipCounter++;
            }
        }
        if (this.rooms.size() > 0)
        {if ((100*vipCounter)/this.rooms.size() > 10) {return false;}}
        // ~~ task 7 | Sean's code ~~
        if (this.city.equals("Las Vegas") || this.city.equals("las vegas") || this.city.equals("LAS VEGAS"))
        {for (Client c: allReservation.keySet()) {if (c.getAge() < 21) {return false;}}}


        // ~~ task 11 | Sean's code ~~
        HashSet<String> serviceNames = new HashSet<>();
        for (Service s:this.getServices().keySet())
        {
            serviceNames.add(s.getServiceName());
        }
        if (this.getServices().size() > serviceNames.size()){return false;}

        // ~~ task 12 | Sean's code ~~
        int amount = 0;
        int year = 0;
        Calendar calendar = new GregorianCalendar();
        HashMap<Integer, Integer> allYears = new HashMap<>();
        for (HotelService hs: this.services.values())
        {
            for (Booking b : hs.getGivenServices())
            {
                amount = hs.getPrice();
                calendar.setTime(b.getDate());
                year = calendar.get(Calendar.YEAR);
                allYears.put(year, amount);
            }
        }

        ArrayList<Integer> sortedMap = new ArrayList<>(allYears.keySet());
        Collections.sort(sortedMap);
        for (int i=0;i<sortedMap.size()-1; i++)
        {
            if (allYears.get(sortedMap.get(i)) < allYears.get(sortedMap.get(i+1)))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean checkAllIntancesConstraints(Model model){
        return true;
    }

    public HashMap<Integer, Room> getRooms() {
        return rooms;
    }
}