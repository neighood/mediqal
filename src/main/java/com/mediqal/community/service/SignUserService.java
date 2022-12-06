package com.mediqal.community.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.IllVO;
import com.mediqal.community.domain.vo.InterestVO;
import com.mediqal.community.domain.vo.UserImgVO;
import com.mediqal.community.repository.IllDAO;
import com.mediqal.community.repository.InterestDAO;
import com.mediqal.community.repository.UserDAO;
import com.mediqal.community.repository.UserImgDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Qualifier("sign") @Primary
@Slf4j
public class SignUserService /*implements UserService*/{
    private final UserDAO userDAO;
    private final UserImgDAO userImgDAO;
    private final IllDAO illDAO;
    private final InterestDAO interestDAO;

    //      회원가입
//    @Transactional(rollbackFor = Exception.class)
    public void signUp(UserDTO userDTO) {
        userDAO.save(userDTO);
//        userImgDAO.save(userDTO.getUserImgVO());

        /*userImg*/
        UserImgVO userImgVO = new UserImgVO();
        userImgVO.setUserNumber(userDTO.getUserNumber());
        userImgDAO.save(userImgVO);
//        Optional.ofNullable(userImg).ifPresent(img -> {
//            img.setUserNumber(userDTO.getUserNumber());
//            userImgDAO.save(img);
//        });

        /*ill*/
//        List<IllVO> ills = userDTO.getIllVOs();
//        Optional.ofNullable(ills).ifPresent(illList -> {
//            illList.forEach(ill -> {
//                ill.setUserNumber(userDTO.getUserNumber());
//                illDAO.save(ill);
//            });
//        });

        IllVO illVO = new IllVO();
        illVO.setUserNumber(userDTO.getUserNumber());
        illDAO.save(illVO);
        illDAO.save(illVO);
//        userDTO.getIllVOs().stream().forEach(illVO -> {
//            illVO.setUserNumber(userDTO.getUserNumber());
//            illDAO.save(illVO);
//        });
        /*interest*/
//        List<InterestVO> interests = userDTO.getInterestVOs();
//        Optional.ofNullable(interests).ifPresent(interestList -> {
//            interestList.forEach(interest -> {
//                interest.setUserNumber(userDTO.getUserNumber());
//                interestDAO.save(interest);
//            });
//        });

        InterestVO interestVO = new InterestVO();
        interestVO.setUserNumber(userDTO.getUserNumber());
        interestDAO.save(interestVO);
        interestDAO.save(interestVO);
//        userDTO.getInterestVOs().stream().forEach(interestVO -> {
//            interestVO.setUserNumber(userDTO.getUserNumber());
//            interestDAO.save(interestVO);
//        });
    }

    //      비밀번호 찾기
    public String findPassword(String userEmail) {
        return userDAO.findPasswordByEmail(userEmail);
    }
    //      아이디 중복검사
    public int checkId(String userEmail) {
        return userDAO.checkId(userEmail);
    }
    //      닉네임 중복검사
    public int checkNickname(String userNickname) {
        return userDAO.checkNickname(userNickname);
    }
    //      로그인
    public long login(String userEmail, String userPassword) {
        return userDAO.login(userEmail,userPassword);
    }

    //    카카오 로그인
    public String getKaKaoAccessToken (String code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=b1942603844093783ad7859daa3b5918"); // TODO REST_API_KEY 입력
            sb.append("&redirect_uri=http://localhost:11000/user/kakao"); // TODO 인가코드 받은 redirect_uri 입력
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return access_Token;
    }

    /*------------------------------------------------------------------------------*/
//    public void createKakaoUser(String token) throws BaseException {
    public void createKakaoUser(String token) {

        String reqURL = "https://kapi.kakao.com/v2/user/me";

        //access_token을 이용하여 사용자 정보 조회
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + token); //전송할 header 작성, access_token전송

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //Gson 라이브러리로 JSON파싱
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            int id = element.getAsJsonObject().get("id").getAsInt();
            boolean hasEmail = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_email").getAsBoolean();
            String email = "";
            if(hasEmail){
                email = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString();
            }

            System.out.println("id : " + id);
            System.out.println("email : " + email);

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*------------------------------------------------------------------------------*/

    public HashMap<String, Object> getUserInfo (String access_Token) {

        //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, Object> userInfo = new HashMap<>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            //    요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();

            userInfo.put("nickname", nickname);
            userInfo.put("email", email);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userInfo;
    }

//    @Override
//    public void register(UserDTO userDTO) {
//
//    }
//
//    @Override
//    public void modify(UserDTO userDTO) {
//
//    }
//
//    @Override
//    public void remove(Long userNumber) {
//
//    }
//
//    @Override
//    public UserDTO show(Long userNumber) {
//        return null;
//    }
//
//    @Override
//    public List<UserVO> showAll(Criteria criteria) {
//        return null;
//    }
//
//    @Override
//    public int getTotal() {
//        return 0;
//    }
}
