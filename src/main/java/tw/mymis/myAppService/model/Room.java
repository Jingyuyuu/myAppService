package tw.mymis.myAppService.model;

import lombok.Data;

@Data
public class Room {
    private String rid;
    private String name;
    private String floor;
    private String capacity;
    private boolean projector;

}
