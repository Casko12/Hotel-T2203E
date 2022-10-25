package hotel.factory;

import hotel.dao.impls.RoomRepository;
import hotel.dao.interfaces.HotelRepository;
import hotel.enums.RepoType;

public class RepositoryFactory {
    private RepositoryFactory(){

    }
    public static HotelRepository creHotelRepository(RepoType type){
        switch (type){
            case ROOM: return new RoomRepository();
            default: throw new IllegalArgumentException("thiếu tham số ");
        }
    }
}
