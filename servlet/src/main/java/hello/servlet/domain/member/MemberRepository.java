package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    //static 으로 함으로서 MemberRepository 가 아무리 많아도 Map 과 sequence 는 하나만 생성되도록 함
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    //무조건 아래 메서드를 이용해서 멤버리포지토리를 조회 하도록 만듬
    public static MemberRepository getInstance() {
        return instance;
    }

    //생성자를 private 로 함으로서 아무나 접근해서 멤버리포지토리를 생성하는것을 막음
    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    //새로운 ArrayList 를 만들어 store 에 있는 모든 값을 저장해서 반환해줌,
    //이렇게 만드는 이유는 ArrayList 내부의 값을 수정하더라도
    // store 내부의 값을 직접적으로 수정하고 싶지 않기 때문
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
