package Spring.controller;

import Spring.Entity.TestEntity;
import Spring.Entity.TestRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/home")
public class IndexController {

    @GetMapping("/main")
    public String home(){
        return "main";
    }
    @Autowired
    TestRepository testRepository;

    @GetMapping("/save")
    @ResponseBody
    public String getdata(HttpServletRequest request){
        String content = request.getParameter("content");
        //엔티티 생성
        TestEntity testEntity = new TestEntity();
        testEntity.content = content;
        //엔티티를 db에 저장해주는 메소드
        testRepository.save(testEntity);
        //반환
        return "작성성공";
    }

    @GetMapping("/getlist")
    public void getlist(HttpServletResponse response) {
        //1. 모든 엔티티 호출하기
        List<TestEntity> testEntity = testRepository.findAll();
        //2.JSON 화 하기
        JSONArray jsonArray = new JSONArray();  //1.json 리스트 선언
        for(TestEntity entity : testEntity){    //2. 모든 엔티티 반목분
            JSONObject JsonObject = new JSONObject();   //3. json 객체 선언
            JsonObject.put("no",entity.no); //4. json객체 엔트리(키:값)설정
            JsonObject.put("content", entity.content);
            jsonArray.put(JsonObject);
        }

        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/update")
    @ResponseBody
    @Transactional
    public String update(HttpServletRequest request){
        int no = Integer.parseInt(request.getParameter("no"));
        String content = request.getParameter("content");

        //1.pk값을 이용한 엔티티 찾기
        Optional<TestEntity> optionalTestEntity = testRepository.findById(no);
            //Optional 클래스 : 제네릭 클래스의 객체를 저장
        TestEntity entity = optionalTestEntity.get();

        entity.content = content;
        return "1";
    }

    @GetMapping("/delete")
    @ResponseBody
    @Transactional
    public String delete(HttpServletRequest request){
        int no = Integer.parseInt(request.getParameter("no"));

        //1.pk값을 이용한 엔티티 찾기

        Optional<TestEntity> optionalTestEntity = testRepository.findById(no);
        //Optional 클래스 : 제네릭 클래스의 객체를 저장
        TestEntity entity = optionalTestEntity.get();
        testRepository.delete(entity);

        return "1";
    }

    //@RequestMapping : 모든 URL 매핑 가능

    //@GetMapping : GET 메소드 URL 매핑 [요청변수 보임. 보안X 캐시O]

    //@PostMapping : POST 메소드 URL 매핑   [요청변수 안보임. 보안O 캐시X]
    /////////////////////////////////////////////////스프링에서 지원하는 요청방식 구분 ///////////////////////////////////////
    //@PutMapping : PUT 메소드 URL 매핑 [삽입, 수정 시 사용]

    //@DeleteMapping : DELETE 메소드 URL 매핑 [삭제시 사용]

    //@PathVariable : 경로에 변수를 바인딩(넘겨주기)

    //먹등성 : 요청후에 서버에 상태를 남기기
}
