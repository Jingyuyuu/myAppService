package tw.mymis.myAppService.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.mymis.myAppService.repository.MemberRepository;
import tw.mymis.myAppService.service.MemberService;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @RequestMapping("/login")
    public String login(@RequestBody String body){
        System.out.println("後端接收訊息"+body);

        JSONObject object=new JSONObject(body);
        System.out.println("後端接收訊息"+object.toString());
        System.out.println("data 資料??? " + object.getJSONObject("data").toString(4));
        JSONObject data = object.getJSONObject("data");
        System.out.println("帳號: " + data.getString("user") + "    密碼= " + data.getString("pass"));

        //long c=memberRepository.checkUser(data.getString("user"), data.getString("pass") );
        //System.out.println("後端接收訊息"+c);

        //return "server回應login需求";
        return memberService.getLoginResult(data.getString("user"), data.getString("pass") ).toString();
    }
}
