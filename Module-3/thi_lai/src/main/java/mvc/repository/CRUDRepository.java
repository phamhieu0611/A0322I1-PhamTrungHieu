package mvc.repository;

import java.sql.SQLException;
import java.util.List;

public interface CRUDRepository<T> {
    void create(T t) throws Exception;
    boolean deleteById(int id) throws Exception;
    T findById(int id) throws SQLException, ClassNotFoundException;
    List<T> findAll() throws SQLException, ClassNotFoundException;
}
