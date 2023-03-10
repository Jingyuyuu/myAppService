package tw.mymis.myAppService.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public long checkUser(String user,String pass){
        String query="select count (*) from member where email=? and passwd=?";
        long count =jdbcTemplate.queryForObject(query,new Object[]{user,pass},Long.class);
        return  count;
    }


}
