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
    public ArrayList<Customer> name() {
        ArrayList<Customer> lsname = new ArrayList<>();
        try {
            String sql_txt = "select name from customer";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){

                String name = rs.getString("name");


                Customer c = new Customer(name);
                lsname.add(c);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lsname;
    }
    public ArrayList<Customer> cmt() {
        ArrayList<Customer> lscmt = new ArrayList<>();
        try {
            String sql_txt = "select cmt from customer";
            Connector conn = Connector.getInstance();

            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){

                String cmt = rs.getString("cmt");


                Customer c = new Customer(cmt);
                lscmt.add(c);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lscmt;
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
        try{
            String sql_txt = "update customer set name =?, cmt = ? where id = ?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(customer.getName());
            arr.add(customer.getCmt());
            arr.add(customer.getId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Customer customer) {
        try{
            String sql_txt = "delete from customer where id = ?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(customer.getId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Customer findOne(Integer id) {
        try {
            String sql_txt = "select * from customer where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt,arr);
            while (rs.next()){
                int Id = rs.getInt("id");
                String name = rs.getString("name");
                String cmt = rs.getString("cmt");
                return new Customer(id,name,cmt);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean checkin(Customer customer) {
        return false;
    }
}

//