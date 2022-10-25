package hotel.dao.intefaces;

import java.util.ArrayList;

public interface HotelRepository<S> {
    ArrayList<S> all();
    boolean create(S s);
    boolean update(S s);
    boolean delete(S s);
}
