package springbootweb.hamburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootweb.hamburger.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
}
