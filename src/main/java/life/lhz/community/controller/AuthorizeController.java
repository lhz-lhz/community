package life.lhz.community.controller;

import life.lhz.community.dto.AccessTokenDTO;
import life.lhz.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
   @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callbake")
    public String callbake(@RequestParam(name="code")String code,
                           @RequestParam(name = "state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("bb6507416ce03865bc13");
        accessTokenDTO.setClient_secret("050c277f07c03ed15e5b1409b941208a053fcb73");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
