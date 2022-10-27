package hotel.dao.impls;

import hotel.dao.interfaces.HotelRepository;
import hotel.entities.RoomRent;

import java.util.ArrayList;

public class RoomRentRepository implements HotelRepository<RoomRent> {
    @Override
    public ArrayList<RoomRent> all() {


        return null;
    }

    @Override
    public boolean create(RoomRent roomRent) {
        return false;
    }

    @Override
    public boolean update(RoomRent roomRent) {
        return false;
    }

    @Override
    public boolean delete(RoomRent roomRent) {
        return false;
    }

    @Override
    public RoomRent findOne(Integer id) {
        return null;
    }
}
