package springbootweb.hamburger.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootweb.hamburger.dao.face.MemberDao;
import springbootweb.hamburger.dto.Member;
import springbootweb.hamburger.service.face.MemberService;


@Service
public class MemberServiceImpl implements MemberService {


     @Autowired private MemberDao memberDao;



    @Override
    public boolean login(Member member){


        int loginChk = memberDao.selectCntMember(member);

        if (loginChk > 0 ) return true;

        return false;

    }

    @Override
    public String getName(Member member){

        return memberDao.selectName(member);
    }

    @Override
    public boolean join(Member member){

        if (memberDao.selectCntById(member)>0){
            return false;
        }
        memberDao.insert(member);


        if (memberDao.selectCntById(member)>0){
            return true;
        }
        return false;
    }
}
