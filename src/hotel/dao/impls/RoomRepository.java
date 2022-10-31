package hotel.dao.impls;

import hotel.dao.interfaces.HotelRepository;
import hotel.entities.Room;
import hotel.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RoomRepository implements HotelRepository<Room> {
    @Override
    public ArrayList all() {
        ArrayList<Room> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from room";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                String status = rs.getString("status");

                Room r = new Room(id,name,type,status);
                ls.add(r);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean create(Room room) {
        return false;
    }

    @Override
    public boolean update(Room room) {
        return false;
    }

    @Override
    public boolean delete(Room room) {
        return false;
    }

    @Override
    public Room findOne(Integer id) {
        try {
            String sql_txt = "select * from room where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt,arr);
            while (rs.next()){
                int Id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                String status = rs.getString("status");

                return new Room(id,name,type,status);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
