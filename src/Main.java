import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    static Model m1 = new Model();
    //    Hotels
    static Hotel hotel1 = new Hotel("Tel-Aviv", "Plaza", 5);
    static Hotel hotel2 = new Hotel("Tel-Aviv", "Crown", 4);
    static Hotel hotel3 = new Hotel("Las Vegas", "Leonardo", 5);

    //    Groups
    static Group group1 = new Group(1);

    //    Clients
    static Client c1 = new Client(1, 24, "Eitan", "Ashdod");
    static Client c2 = new Client(2, 20, "Tzair", "Ashdod");

    //    Reservations Set
    static ReservationSet rs1 = new ReservationSet();
    static ReservationSet rs2 = new ReservationSet();

    //     Reservations
    static Reservation res1 = new Reservation(Model.getDateFromString("22-10-2022"), Model.getDateFromString("23-10-2022"), 1);
    static Reservation res2 = new Reservation(Model.getDateFromString("24-10-2022"), Model.getDateFromString("25-10-2022"), 2);
    static Reservation res3 = new Reservation(Model.getDateFromString("24-09-2022"), Model.getDateFromString("25-09-2022"), 3);
    static Reservation res4 = new Reservation(Model.getDateFromString("27-09-2022"), Model.getDateFromString("29-09-2022"), 4);
    static Reservation res5 = new Reservation(Model.getDateFromString("27-09-2021"), Model.getDateFromString("29-09-2021"), 5);

    //    Room Categories
    static RoomCategory vip_cat = new RoomCategory(200, RoomCategory.RoomType.VIP);
    static RoomCategory basic_cat = new RoomCategory(100, RoomCategory.RoomType.BASIC);
    static RoomCategory suite_cat = new RoomCategory(150, RoomCategory.RoomType.SUITE);

    //    Rooms
    static Room room1 = new Room(1);
    static Room room2 = new Room(2);
    static Room room3 = new Room(3);
    static Room room4 = new Room(4);
    static Room room5 = new Room(5);
    static Room room6 = new Room(6);
    static Room room7 = new Room(7);
    static Room room8 = new Room(8);
    static Room room9 = new Room(9);
    static Room room10 = new Room(10);

    //    Bookings
    static Booking book1 = new Booking(Model.getDateFromString("22-10-2022"), room1);
    static Booking book2 = new Booking(Model.getDateFromString("22-08-2022"), room2);
    static Booking book3 = new Booking(Model.getDateFromString("22-08-2021"), room3);

    //    Services
    static Service ser1 = new CommunityService("transportation");
    static Service ser2 = new RegularService("Mini-bar");
    static Service ser3 = new VipService("Room service");
    static Service ser4 = new VipService("Jaccuzi");

    //    Hotel Services
    static HotelService h_ser1 = new HotelService(200, 1);
    static HotelService h_ser2 = new HotelService(100, 2);
    static HotelService h_ser3 = new HotelService(300, 1);
    static HotelService h_ser4 = new HotelService(50, 2);
    static HotelService h_ser5 = new HotelService(30, 3);
    static HotelService h_ser6 = new HotelService(120, 3);

    //    Reviews
    static Review rev1 = new Review(10, "OK", Model.getDateFromString("12-07-2020"));
    static Review rev2 = new Review(10, "Good", Model.getDateFromString("24-07-2020"));
    static Review rev3 = new Review(5, "Basic", Model.getDateFromString("12-09-2020"));


    public static void main(String[] args) {
        //setup();
        //assert constraint1():"constraint1 failed";
        //assert constraint2():"constraint2 failed";
//        assert constraint3():"constraint3 failed";
//        assert constraint4():"constraint4 failed";
//        assert constraint5():"constraint5 failed";
//        assert constraint6():"constraint6 failed";
//        assert constraint7():"constraint7 failed";
//        assert constraint8():"constraint8 failed";
//        assert constraint9():"constraint9 failed";
//        assert constraint10():"constraint10 failed";
//        assert constraint13() : "constraint13 failed";

        System.out.println("Finished Checking constraints successfully");
    }
// Each constraint should not pass assertion, each method creates invalid state of the model

    public static boolean constraint13() {
        m1.addObjectToModel(book1);
        m1.create_link_hotelService_booking(h_ser1, book1);
        m1.create_link_hotelService_booking(h_ser2, book1);
        m1.create_link_hotelService_booking(h_ser3, book1);
        m1.create_link_room_Booking(room1, book1);
        m1.create_link_hotel_room(room1, hotel1);
        m1.create_link_hotel_service_hotelService(hotel1, ser1, h_ser1);
        m1.create_link_hotel_service_hotelService(hotel1, ser2, h_ser2);
        m1.create_link_hotel_service_hotelService(hotel1, ser3, h_ser3);
//      Comment next 2 lines to pass
        m1.create_link_hotelService_booking(h_ser4, book1);
        m1.create_link_hotel_service_hotelService(hotel2, ser4, h_ser4);

        return m1.checkModelConstraints();
    }


    public static boolean constraint10() {
        m1.addObjectToModel(book1);
        m1.addObjectToModel(book2);
        m1.addObjectToModel(book3);
        m1.create_link_hotel_room(room1, hotel1);
        m1.create_link_hotel_room(room2, hotel2);
        m1.create_link_hotel_room(room3, hotel3);
        m1.create_link_booking_review(book1, rev1);
        m1.create_link_booking_review(book2, rev2);
//      Comment next line to pass
        m1.create_link_booking_review(book3, rev3);
        return m1.checkModelConstraints();
    }


    public static boolean constraint9() {
        m1.addObjectToModel(book1);
        m1.addObjectToModel(book2);
        m1.create_link_room_Booking(room1, book1);
        m1.create_link_room_roomCategory(room1, vip_cat);
        m1.create_link_room_Booking(room2, book2);
        m1.create_link_room_roomCategory(room2, basic_cat);
        m1.create_link_hotel_service_hotelService(hotel1, ser3, h_ser1);
        m1.create_link_hotel_service_hotelService(hotel1, ser1, h_ser2);
//        Comment next line to pass
        m1.create_link_hotelService_booking(h_ser1, book1);
        m1.create_link_hotelService_booking(h_ser2, book2);
        return m1.checkModelConstraints();
    }

    public static boolean constraint8() {
        m1.addObjectToModel(book1);
        m1.create_link_reservation_booking(book1, res1);
        m1.create_link_room_roomCategory(room2, suite_cat);
        m1.create_link_room_Booking(room2, book1);
//        commend next line to pass
        m1.create_link_reservation_roomCategory(res1, vip_cat);
//        m1.create_link_reservation_roomCategory(res1,suite_cat);
        return m1.checkModelConstraints();
    }

    public static boolean constraint7() {
        m1.addObjectToModel(hotel3);
        m1.addObjectToModel(c1);
        m1.addObjectToModel(c2);
        m1.addObjectToModel(rs1);
        m1.addObjectToModel(rs2);
//        Comment next line to pass
        m1.create_link_client_hotel_reservationSet(c2, hotel3, rs2);
        m1.create_link_client_hotel_reservationSet(c1, hotel3, rs1);
        return m1.checkModelConstraints();
    }

    public static boolean constraint6() {

        ArrayList<Room> rooms = new ArrayList<>(Arrays.asList(room1, room2, room3, room4, room5, room6, room7, room8));
//        uncomment to pass
//        ArrayList<Room> rooms = new ArrayList<>(Arrays.asList(room1,room2,room3,room4,room5,room6, room7, room8, room9));
        for (Room room : rooms) {
            m1.addObjectToModel(room);
            m1.create_link_room_roomCategory(room, basic_cat);
            m1.create_link_hotel_room(room, hotel1);
        }
        m1.addObjectToModel(room10);
        m1.create_link_room_roomCategory(room10, vip_cat);
        m1.create_link_hotel_room(room10, hotel1);
        m1.addObjectToModel(hotel1);
        return m1.checkModelConstraints();
    }


    public static boolean constraint5() {
        m1.addObjectToModel(room1);
        m1.addObjectToModel(book1);
        m1.create_link_room_Booking(room1, book1);
        m1.addObjectToModel(basic_cat);
        m1.create_link_room_roomCategory(room1, basic_cat);
        m1.addObjectToModel(ser1);
        m1.addObjectToModel(ser2);
        m1.addObjectToModel(ser3);
        m1.addObjectToModel(hotel1);
        m1.addObjectToModel(h_ser1);
        m1.addObjectToModel(h_ser2);
        m1.addObjectToModel(h_ser3);
        m1.create_link_hotel_service_hotelService(hotel1, ser1, h_ser1);
        m1.create_link_hotel_service_hotelService(hotel1, ser2, h_ser2);
        m1.create_link_hotel_service_hotelService(hotel1, ser3, h_ser3);
        m1.create_link_hotelService_booking(h_ser1, book1);
        m1.create_link_hotelService_booking(h_ser2, book1);
//        To pass comment this
        m1.create_link_hotelService_booking(h_ser3, book1);
        return m1.checkModelConstraints();
    }

    public static boolean constraint1() {
        m1.addObjectToModel(hotel1);
        m1.addObjectToModel(hotel2);
        m1.addObjectToModel(group1);
        m1.create_link_group_hotel(hotel1, group1);
        //        To pass comment this
        m1.create_link_group_hotel(hotel2, group1);
        return m1.checkModelConstraints();
    }

    public static boolean constraint2() {
        m1.addObjectToModel(hotel1);
        m1.addObjectToModel(c1);
        m1.addObjectToModel(rs1);
        rs1.setClient(c1);
        rs1.setHotel(hotel1);
        //        To pass comment this
        res1.addRoomCategory(vip_cat);
        rs1.addReservation(res1);
        rs1.addReservation(res2);
        rs1.addReservation(res3);
        rs1.addReservation(res4);
        rs1.addReservation(res5);
        m1.create_link_client_hotel_reservationSet(c1, hotel1, rs1);
        return m1.checkModelConstraints();
    }

    public static boolean constraint3() {
        m1.addObjectToModel(hotel1);
        m1.addObjectToModel(c1);
        m1.addObjectToModel(rs1);
        m1.addObjectToModel(book1);
        m1.addObjectToModel(room1);
        m1.addObjectToModel(res1);
        m1.create_link_client_hotel_reservationSet(c1, hotel1, rs1);
        m1.create_link_reservationSet_reservation(rs1, res1);
        m1.create_link_reservation_booking(book1, res1);
        m1.create_link_room_Booking(room1, book1);
        //        To pass comment this
        m1.create_link_hotel_room(room1, hotel2);
        m1.create_link_room_Booking(room1, book1);
        return m1.checkModelConstraints();
    }

    public static boolean constraint4() {
        m1.addObjectToModel(hotel1);
        m1.addObjectToModel(hotel3);
        m1.addObjectToModel(group1);
        m1.addObjectToModel(ser1);
        m1.addObjectToModel(ser2);
        m1.addObjectToModel(ser3);
        m1.create_link_group_hotel(hotel1, group1);
        m1.create_link_group_hotel(hotel3, group1);
        m1.create_link_hotel_service_hotelService(hotel1, ser1, h_ser1);
        m1.create_link_hotel_service_hotelService(hotel1, ser2, h_ser2);
        m1.create_link_hotel_service_hotelService(hotel1, ser3, h_ser3);
        m1.create_link_hotel_service_hotelService(hotel3, ser1, h_ser4);
        m1.create_link_hotel_service_hotelService(hotel3, ser2, h_ser5);
//        //        To pass uncomment this
//        m1.create_link_hotel_service_hotelService(hotel3,ser3,h_ser6);
        m1.create_link_hotel_service_hotelService(hotel3, ser4, h_ser6);
        return m1.checkModelConstraints();
    }
}
