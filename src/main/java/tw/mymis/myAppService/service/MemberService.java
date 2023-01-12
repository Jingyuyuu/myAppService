package tw.mymis.myAppService.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.mymis.myAppService.repository.MemberRepository;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public JSONObject getLoginResult(String username,String passwd){
        long c=memberRepository.checkUser(username,passwd);
        JSONObject responseObject=new JSONObject();
        responseObject.put("type",2);
        if(c==0){
            responseObject.put("status",12);
            responseObject.put("mesg","驗證失敗");

        }else{
            responseObject.put("status",11);
            responseObject.put("mesg","驗證成功");
        }

        return responseObject;
    }

}
