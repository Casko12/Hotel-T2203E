package hotel.dao.intefaces;

import java.util.ArrayList;

public interface HotelRepository<S> {
    ArrayList<S> all();
}
