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
                RoomRent r = new RoomRent(roomId,customerId,null,null);
                RR.add(r);

            }
        }catch (Exception e){}
        return RR;

    }


    @Override
    public boolean create(RoomRent roomRent) {
        try {
            String sql_txt = "insert into roomrent(roomId,customerId) values(?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(roomRent.getRoomId());
            arr.add(roomRent.getCustomerId());

            if (conn.execute(sql_txt, arr)) {
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());

        }

        return false;
    }


    @Override
    public boolean update(RoomRent roomRent) {
        try {
            String sql_txt = "update room set Status=1 where id =?";
            Connector conn = Connector.getInstance();
            ArrayList ls = new ArrayList<>();
            ls.add(roomRent.getRoomId());
            if(conn.execute(sql_txt,ls)){
                return true;
            }

        }catch (Exception e){}
        return false;
    }


    @Override
    public boolean checkin(RoomRent roomRent) {
        try {
            String sql_txt = "update room set Status=0 where id =?";
            Connector conn = Connector.getInstance();
            ArrayList ls = new ArrayList<>();
            ls.add(roomRent.getRoomId());
            if(conn.execute(sql_txt,ls)){
                return true;
            }

        }catch (Exception e){}
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
//