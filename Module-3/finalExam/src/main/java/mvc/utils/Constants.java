package mvc.utils;

public interface Constants {
    String SELECT_ALL_FROM_CUSTOMER = "Select * from customer";
    String INSERT_INTO_CUSTOMER = "Insert into customer values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_CUSTOMER = "Update customer set customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone =?, customer_email = ?, customer_address=? where customer_id = ?";
    String FIND_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
    String SELECT_ALL_FROM_CUSTOMER_TYPE = "Select * from customer_type";
    String DELETE_CUSTOMER = "DELETE FROM customer WHERE customer_id = ?";
}
