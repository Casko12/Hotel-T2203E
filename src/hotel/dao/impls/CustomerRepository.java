package hotel.dao.impls;

import hotel.dao.interfaces.HotelRepository;
import hotel.entities.Customer;
import hotel.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerRepository implements HotelRepository<Customer> {
    @Override
    public ArrayList<Customer> all() {
        ArrayList<Customer> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from customer";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String cmt = rs.getString("cmt");

                Customer c = new Customer(id,name,cmt);
                ls.add(c);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;
    }


    @Override
    public boolean create(Customer customer) {
        try{
            String sql_txt ="insert into customer(name, cmt) values(?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(customer.getName());
            arr.add(customer.getCmt());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(Customer customer) {
        return false;
    }

    @Override
    public Customer findOne(Integer id) {
        return null;
    }
}
