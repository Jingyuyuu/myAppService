package tw.mymis.myAppService.repository;

import tw.mymis.myAppService.model.Room;

import java.util.List;
import java.util.Map;

/*
    將 MemberDao 的各種方法 定義(規範/規則) 先列出來
    後面實作功能的程式設計師(不管有幾個 先後離職與否....) 都會
    遵照這個規則

 */
public interface IRoomDao {

    // 呼叫 getRoomCount 應該要回傳所有會議室數量
    public Long getRoomCount() ;

    public Long getRoomCountWithProjector();

    // 呼叫 getRoomByID 應該要回傳該ID的會議室資訊
    public Room getRoomByID(String roomID) ;

    // 呼叫 getRoomAll 應該要回傳所有會議室的資料
    public List<Map<String,Object>> getRoomAll() ;

    public Long countRoomByFloor(String floor);
}
