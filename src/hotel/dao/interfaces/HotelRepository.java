package hotel.dao.interfaces;

import java.util.ArrayList;

public interface HotelRepository<S> {
    ArrayList<S> all();

    boolean create(S s);

    boolean update(S s);

    boolean delete(S s);

    boolean checkout(S s);

    S findOne(Integer id);

    boolean checkOutUpdate(S s);
}
//