package mvc.service;

import java.sql.SQLException;
import java.util.List;

public interface CRUDService<T> {
    void create(T t) throws Exception;
    void update(T t) throws Exception;
    boolean deleteById(int id) throws Exception;
    T findById(int id) throws SQLException, ClassNotFoundException;
    List<T> findAll() throws SQLException, ClassNotFoundException;
}
