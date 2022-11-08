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
                int Id = rs.getInt("id");
                int roomId = rs.getInt("roomId");
                int customerId = rs.getInt("customerId");
                Date dateIn = rs.getDate("dateIn");
                Date dateOut = rs.getDate("dateOut");
                RoomRent r = new RoomRent(Id,roomId, customerId, dateIn, dateOut);
                RR.add(r);

            }
        }catch (Exception e){}
        return RR;

    }


    @Override
    public boolean create(RoomRent roomRent) {
        try {
            String sql_txt = "insert into roomrent(roomId,customerId,dateIn) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(roomRent.getRoomId());
            arr.add(roomRent.getCustomerId());
            arr.add(roomRent.getDatein().toString());

            if (conn.execute(sql_txt, arr)) {
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());

        }

        return false;
    }
    public boolean dateout(RoomRent roomRent) {
        try {
            String sql_txt = "update roomrent set dateOut=? where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(roomRent.getDateout().toString());
            arr.add(roomRent.getId());
            System.out.println(roomRent.getDateout().toString());
            System.out.println(roomRent.getId());
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
    public boolean checkout(RoomRent roomRent) {
        try {
            String sql_txt = "update room set Status=0 where id =?";
            Connector conn = Connector.getInstance();
            ArrayList ls = new ArrayList<>();
            ls.add(roomRent.getRoomId());
            if (conn.execute(sql_txt, ls)) {
                return true;
            }

        } catch (Exception e) {
        }
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


    @Override
    public boolean checkOutUpdate(RoomRent roomRent) {
        try {
            String sql_txt = "update roomrent set dateOut=? where id =?";
            Connector conn = Connector.getInstance();
            ArrayList ls = new ArrayList<>();
            ls.add(roomRent.getRoomId());
            if (conn.execute(sql_txt, ls)) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }
}
//