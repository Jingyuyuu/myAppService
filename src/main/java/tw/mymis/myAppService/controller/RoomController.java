package tw.mymis.myAppService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.mymis.myAppService.repository.RoomRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    RoomRepository roomRepo;

    @GetMapping("/id/{roomID}")
    public Map<String,Object> getRoomCount(@PathVariable String roomID) {
        return roomRepo.getRoomDataByID(roomID);

    }

    @GetMapping("/all")
    public List<Map<String,Object>> getRoomAll() {
        return roomRepo.getRoomAll();
    }
    @GetMapping("/count")
    public String getRoomCount() {
        long count = roomRepo.getRoomCount();
        return "公有 " + count + " 間會議室";
    }
    @GetMapping("/count/Projector")
    public String getRoomCountProjector() {
        long count = roomRepo.getRoomCountWithProjector();
        return "有投影機的會議室有 " + count + " 間";
    }

    @GetMapping("/countByFloor/{floor}")
    public String getRoomCountByFloor(@PathVariable  String floor) {
        long count = roomRepo.countRoomByFloor(floor);
        return "在" + floor + " 的會議室有 " + count + " 間";
    }
    @GetMapping("/RIDByCapacity/{capacity}")
    public List<String> getRoomCountByFloor(@PathVariable  int capacity) {
        return roomRepo.getRoomIDCapacityMoreThan(capacity);
    }
}

