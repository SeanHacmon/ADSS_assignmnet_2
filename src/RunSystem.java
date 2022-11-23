import java.util.Date;

public class RunSystem
{
    public static void main(String[] args)
    {
        // test 1
        Model m1 = new Model();
        Group g = new Group(1);
        Hotel h1 = new Hotel("Haifa", "Dan Panorama", 4);
        Hotel h2 = new Hotel("Haifa", "Dan Carmel", 4);
        m1.addObjectToModel(g);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(h2);
        m1.create_link_group_hotel(h1, g);
        m1.create_link_group_hotel(h2, g);
//        assert !m1.checkModelConstraints(); // test 1
        System.out.println(m1.checkModelConstraints());

        // test 7
        Model m = new Model();
        Client client1 = new Client(1,20,"Dolev","Tel Aviv");
        Hotel hotel1 = new Hotel("Las Vegas", "Paris", 5);
        Room room1 = new Room(404);
        ReservationSet reservationSet1 = new ReservationSet();
        Date orDate = Model.getDateFromString("25-12-2019");
        Date reqDate = Model.getDateFromString("01-01-2020");
        Reservation reservation1 = new Reservation(orDate, reqDate, 100);
        RoomCategory roomCategory1 = new RoomCategory(200, RoomCategory.RoomType.BASIC);
        m.addObjectToModel(client1);
        m.addObjectToModel(hotel1);
        m.addObjectToModel(reservationSet1);
        m.addObjectToModel(reservation1);
        m.addObjectToModel(room1);
        m.create_link_client_hotel_reservationSet(client1, hotel1, reservationSet1);
        m.create_link_reservationSet_reservation(reservationSet1, reservation1);
        m.create_link_reservation_roomCategory(reservation1, roomCategory1);
        m.create_link_hotel_room(room1, hotel1);
        m.create_link_room_roomCategory(room1, roomCategory1);
        System.out.println(m.checkModelConstraints()); // should print false






        // check if theres 2 vip rooms out of 10 rooms --> false
        Room room2 = new Room(403);
        Room room3 = new Room(405);
        Room room4 = new Room(406);
        Room room5 = new Room(407);
        Room room6 = new Room(408);
        Room room7 = new Room(409);
        Room room8 = new Room(410);
        Room room9 = new Room(411);
        Room room10 = new Room(412);
        RoomCategory roomCategory2 = new RoomCategory(200, RoomCategory.RoomType.VIP);
        m.addObjectToModel(room1);
        m.addObjectToModel(room2);
        m.addObjectToModel(room3);
        m.addObjectToModel(room4);
        m.addObjectToModel(room5);
        m.addObjectToModel(room6);
        m.addObjectToModel(room7);
        m.addObjectToModel(room8);
        m.addObjectToModel(room9);
        m.addObjectToModel(room10);
        m.create_link_hotel_room(room2, hotel1);
        m.create_link_hotel_room(room3, hotel1);
        m.create_link_hotel_room(room4, hotel1);
        m.create_link_hotel_room(room5, hotel1);
        m.create_link_hotel_room(room6, hotel1);
        m.create_link_hotel_room(room7, hotel1);
        m.create_link_hotel_room(room8, hotel1);
        m.create_link_hotel_room(room9, hotel1);
        m.create_link_hotel_room(room10, hotel1);

        m.create_link_room_roomCategory(room2, roomCategory2); // vip
        m.create_link_room_roomCategory(room3, roomCategory2); // vip
        m.create_link_room_roomCategory(room4, roomCategory1);
        m.create_link_room_roomCategory(room5, roomCategory1);
        m.create_link_room_roomCategory(room6, roomCategory1);
        m.create_link_room_roomCategory(room7, roomCategory1);
        m.create_link_room_roomCategory(room8, roomCategory1);
        m.create_link_room_roomCategory(room9, roomCategory1);
        m.create_link_room_roomCategory(room10, roomCategory1);
        System.out.println(m.checkModelConstraints()); // should print false


        // test 11 , 2 servers with same name --> false
        HotelService hotelService=new HotelService(100,2);
        VipService vipService=new VipService("vip_serv");
        RegularService regService=new RegularService("vip_servii");
        m.create_link_hotel_service_hotelService(hotel1,vipService,hotelService);
        m.create_link_hotel_service_hotelService(hotel1,regService,hotelService);

        System.out.println(m.checkModelConstraints()); // should print false

        //create objects
//
//        Model m1=new Model();
//        Group g=new Group(1);
//        Hotel h1=new Hotel("LAS VEGAS","Dan panorama",4);
//        Hotel h2=new Hotel("LAS ","Leonardo",4);
//        Client c1=new Client(318194230,24,"ori","ASHDOD");
//        Date first=Model.getDateFromString("12-06-2022");
//        Date second=Model.getDateFromString("12-06-2023");
//        ReservationSet reservationSet_1=new ReservationSet();
//        RoomCategory roomCategory_basic=new RoomCategory(100, RoomCategory.RoomType.BASIC);
//        RoomCategory roomCategory_VIP=new RoomCategory(100, RoomCategory.RoomType.VIP);
//        Reservation r1=new Reservation(first,second,1);
//        Reservation r2=new Reservation(first,second,2);
//        Reservation r3=new Reservation(first,second,3);
//        Reservation r4=new Reservation(first,second,4);
//        Reservation r5=new Reservation(first,second,5);
//        Room room_basic=new Room(318194230);
//        Room room_Vip=new Room(18194230);
//        Booking booking=new Booking(first,room_basic);
//        VipService vipService=new VipService("vip_serv");
//        RegularService regularService=new RegularService("reg_serv");
//        CommunityService communityService=new CommunityService("community_serv");
//        HotelService hotelService=new HotelService(100,2);
//        //add objects to the system:
//        m1.addObjectToModel(g);
//        m1.addObjectToModel(h1);
//        m1.addObjectToModel(h2);
//        m1.addObjectToModel(c1);
//        m1.addObjectToModel(r1);
//        m1.addObjectToModel(r2);
//        m1.addObjectToModel(r3);
//        m1.addObjectToModel(r4);
//        m1.addObjectToModel(r5);
//        m1.addObjectToModel(room_basic);
//        m1.addObjectToModel(reservationSet_1);
//        m1.addObjectToModel(booking);
//        m1.addObjectToModel(roomCategory_basic);
//        m1.addObjectToModel(roomCategory_VIP);
//        m1.addObjectToModel(room_Vip);
////        m1.addObjectToModel(room1);
////        m1.addObjectToModel(room2);
//        m1.addObjectToModel(vipService);
//        m1.addObjectToModel(communityService);
//        m1.addObjectToModel(regularService);
////        m1.addObjectToModel(hotelService);
//        //link object by UML
//        m1.create_link_group_hotel(h1,g);
//        m1.create_link_group_hotel(h2,g);
//
//        m1.create_link_reservationSet_reservation(reservationSet_1,r1);
//        m1.create_link_reservationSet_reservation(reservationSet_1,r2);
//        m1.create_link_reservationSet_reservation(reservationSet_1,r3);
//        m1.create_link_reservationSet_reservation(reservationSet_1,r4);
//        m1.create_link_reservationSet_reservation(reservationSet_1,r5);
//        m1.create_link_client_hotel_reservationSet(c1,h1,reservationSet_1);
//        m1.create_link_reservation_roomCategory(r1,roomCategory_basic);
//        m1.create_link_reservation_roomCategory(r2,roomCategory_basic);
//        m1.create_link_reservation_roomCategory(r3,roomCategory_basic);
//        m1.create_link_reservation_roomCategory(r4,roomCategory_basic);
//        m1.create_link_reservation_roomCategory(r5,roomCategory_VIP);
//        m1.create_link_reservation_booking(booking,r1);
//        m1.create_link_reservation_booking(booking,r2);
//        m1.create_link_reservation_booking(booking,r3);
//        m1.create_link_reservation_booking(booking,r4);
//        m1.create_link_reservation_booking(booking,r5);
//        m1.create_link_room_Booking(room_basic,booking);
//        m1.create_link_room_Booking(room_Vip,booking);
//        m1.create_link_hotel_room(room_basic,h1);
//        m1.create_link_hotel_room(room_Vip,h1);
//        m1.create_link_room_roomCategory(room_basic,roomCategory_basic);
//        m1.create_link_room_roomCategory(room_Vip,roomCategory_VIP);
//
////        m1.create_link_room_Booking(room2,booking);
////        m1.create_link_hotel_room(room1,h1);
////        m1.create_link_hotel_room(room2,h1);
//
////        m1.create_link_room_roomCategory(room1,roomCategory_basic);//----------------
////        m1.create_link_room_roomCategory(room2,roomCategory_VIP);//----------------
//        m1.create_link_hotel_service_hotelService(h1,vipService,hotelService);
//        m1.create_link_hotel_service_hotelService(h1,regularService,hotelService);
//        m1.create_link_hotel_service_hotelService(h2,vipService,hotelService);
//        m1.create_link_hotel_service_hotelService(h2,regularService,hotelService);
//        System.out.println(m1.checkModelConstraints());
    }
}
