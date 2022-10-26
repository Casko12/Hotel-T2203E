package hotel.factory;

import hotel.dao.impls.CustomerRepository;
import hotel.dao.impls.RoomRentRepository;
import hotel.dao.impls.RoomRepository;
import hotel.dao.interfaces.HotelRepository;
import hotel.enums.RepoType;

public class RepositoryFactory {
    private RepositoryFactory(){

    }
    public static HotelRepository creHotelRepository(RepoType type){
        switch (type){
            case ROOM: return new RoomRepository();
            case CUSTOMER: return new CustomerRepository();
            case ROOMRENT: return new RoomRentRepository();
            default: throw new IllegalArgumentException("thiếu tham số ");
        }
    }
}
