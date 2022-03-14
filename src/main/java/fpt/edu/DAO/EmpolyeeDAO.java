package fpt.edu.DAO;

import fpt.edu.entity.Empolyee;
import fpt.edu.helper.jdbcHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpolyeeDAO extends ShopDAO<Empolyee, String>{

    @Override
    public void insert(Empolyee e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Empolyee e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updatePassword(Empolyee em) {
        String sql = "		UPDATE dbo.Account\n"
                + "		SET  password = ?\n"
                + "		FROM dbo.Account JOIN dbo.[User]\n"
                + "		ON [User].idUser = Account.idUser\n"
                + "		WHERE username = ?";
        jdbcHelper.update(sql, em.getPassword(), em.getUsername());
    }

    @Override
    public void delete(String k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empolyee> selectAll() {
        String sql = "SELECT * FROM dbo.Account JOIN dbo.[User] ON [User].idUser = Account.idUser ORDER BY [User].idUser Desc";
        return selectBySql(sql);
    }

    @Override
    public Empolyee selectById(String k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Empolyee> selectBySql(String sql, Object... args) {
        List<Empolyee> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Empolyee em = new Empolyee();
                em.setIdUser(rs.getInt("idUser"));
                em.setIdAccount(rs.getInt("IdAccount"));
                em.setName(rs.getString("name"));
                em.setPhoneNumber(rs.getString("phoneNumber"));
                em.setAddress(rs.getString("address"));
                em.setUsername(rs.getString("Username"));
                em.setPassword(rs.getString("password"));
                em.setGender(rs.getBoolean("gender"));
                em.setRole(rs.getBoolean("role"));
                em.setStatus(rs.getBoolean("status"));
                em.setBirthday(rs.getDate("birthday"));
                em.setSalary(rs.getDouble("salary"));
                em.setEmail(rs.getString("email"));
                list.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
