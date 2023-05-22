package springbootweb.hamburger.dao.face;


import org.apache.ibatis.annotations.Mapper;
import springbootweb.hamburger.dto.Member;
@Mapper
public interface MemberDao   {


    /**
     * ID/PW가 일치하는 사용자 수를 반환한다
     * ->로그인 인증에 사용
     * @param member - 조회할 ID/PW정보
     * @return 조회된 행 수
     */
    public int selectCntMember(Member member);


    /**
     * ID를 이용하여 NAME 을 조회
     *
     * @param member - 조회하려는 회원의 id를 가진 객체
     * @return 조회된 Name
     */
    public String selectName(Member member);

    /**
     * 회원 id가 존재하는 값인지 확인
     *  -> 중복된 id인지 확인
     * 
     * @param member - 조회하려는 회원의 id 객체
     * @return 존재여부
     */
    public int selectCntById(Member member);


    /**
     * 신규 회원 정보 삽입
     * 
     * 
     * @param member - 신규 회원 정보
     */
    public void insert(Member member);
}

