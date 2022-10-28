package hotel.dao.impls;

import hotel.dao.interfaces.HotelRepository;
import hotel.entities.RoomRent;
import hotel.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class RoomRentRepository implements HotelRepository<RoomRent> {
    @Override
    public ArrayList<RoomRent> all() {
        ArrayList<RoomRent> RR = new ArrayList<>();
        try {
            String sql_txt = "select * from roomrent";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int roomId =rs.getInt("roomId");
                int customerId = rs.getInt("customerId");
                int status = rs.getInt("status");
                RoomRent r = new RoomRent(roomId,customerId,status,null,null);
                RR.add(r);

            }
        }catch (Exception e){}
        return RR;

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
