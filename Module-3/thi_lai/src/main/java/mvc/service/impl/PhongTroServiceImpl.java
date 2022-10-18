package mvc.service.impl;

import mvc.model.LoaiThanhToan;
import mvc.model.PhongTro;
import mvc.repository.PhongTroRepository;
import mvc.repository.impl.PhongTroRepositoryImpl;
import mvc.service.PhongTroService;

import java.sql.SQLException;
import java.util.List;

public class PhongTroServiceImpl implements PhongTroService {

    private PhongTroRepository repository = new PhongTroRepositoryImpl();
    private PhongTroRepositoryImpl phongTroRepository = new PhongTroRepositoryImpl();
    @Override
    public void create(PhongTro phongTro) throws Exception {
        repository.create(phongTro);
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        return repository.deleteById(id);
    }

    @Override
    public PhongTro findById(int id) throws SQLException, ClassNotFoundException {
        return repository.findById(id);
    }

    @Override
    public List<PhongTro> findAll() throws SQLException, ClassNotFoundException {
        return repository.findAll();
    }

    public List<LoaiThanhToan> displayPaymanet() {
        return phongTroRepository.displayPaymanet();
    }
}
