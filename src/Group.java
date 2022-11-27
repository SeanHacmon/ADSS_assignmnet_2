import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Group implements  ITestable{
    private int groupId;
    HashSet<Hotel> hotels;

    public Group(int id){
        hotels = new HashSet<Hotel>();
        groupId = id;
    }



    public void addHotelToGroup(Hotel hotel){
        hotels.add(hotel);
    }

    //getters

    public int getGroupId() {
        return groupId;
    }

    public HashSet<Hotel> getHotels() {
        return hotels;
    }

    @Override
    public boolean checkConstraints() {
        // ~~ task 1 | Sean's code ~~
        HashSet<String> cities = new HashSet<>();
        for (Hotel h : hotels)
        {
            cities.add(h.getCity());
        }
        if (cities.size() != hotels.size())
            return false;
        // ~~ task 4 | Sean's code ~~
        ArrayList<Hotel> hotelArray = new ArrayList<>(hotels);
        for (int i=0; i<hotels.size() - 1;i++) {
            if (!(hotelArray.get(i).getServices().keySet().equals(hotelArray.get(i + 1).getServices().keySet())))
                return false; }

        // ~~ task 10 | Sean's code ~~
//        int fiveStarRating = 0;
//        int totalRating = 0;
//        for(Hotel h: this.hotels)
//        {
//            if (h.getRate() == 5)
//            {
//                Collection<Room> rooms = h.getRooms().values();
//                for (Room r: rooms)
//                {
//                   for (Booking b: r.getBookings().values())
//                   {
//                       fiveStarRating += b.getReview().getRank();
//                       totalRating++;
//                   }
//                }
//            }
//        }
//        if ((float)fiveStarRating/(float)totalRating <= 7.5) {return false;}
//
//        return true;
        return true;
    }
    public static boolean checkAllIntancesConstraints(Model model){
        return true;
    }
}