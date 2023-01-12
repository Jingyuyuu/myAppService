package tw.mymis.myAppService.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tw.mymis.myAppService.model.Room;
import java.util.List;
import java.util.Map;

@Repository
public class RoomRepository implements IRoomDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Long getRoomCount() {
        return jdbcTemplate.queryForObject("select count(*) from room", Long.class);
    }

    @Override
    public Long getRoomCountWithProjector() {
        return jdbcTemplate.queryForObject("select count(*) from room where projector=true", Long.class);
    }

    @Override
    public Room getRoomByID(String roomID) {
        return null;
    }

    @Override
    public List<Map<String,Object>> getRoomAll() {
        List<Map<String,Object>> rowset = jdbcTemplate.queryForList("select * from room");
        return rowset;
    }

    @Override
    public Long countRoomByFloor(String floor) {
        return jdbcTemplate.queryForObject(
                "select count(*) from room where floor=?",
                new Object[] { floor} ,
                Long.class);
    }


    public Long countRoomByFloorWithProjectAndCapacity(String floor, int capacity, boolean isProjector) {
        return jdbcTemplate.queryForObject(
                "select count(*) from room where floor=? and capacity=? and projector=?",
                new Object[] { floor , capacity, isProjector} ,
                Long.class);
    }

    public List<String> getRoomIDCapacityMoreThan(int capacity) {
        return jdbcTemplate.queryForList(
                "select RID from room where capacity > ? ",
                new Object[] {capacity} ,
                String.class);
    }

    public Map<String,Object> getRoomDataByID(String roomID) {
        return jdbcTemplate.queryForMap("select name,capacity from room where rid =  ? ",  roomID  );
    }
}

