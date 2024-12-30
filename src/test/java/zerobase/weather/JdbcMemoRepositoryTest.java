//package zerobase.weather;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//import zerobase.weather.domain.Memo;
//import zerobase.weather.repository.JdbcMemoRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//// ? @Transactional : 데이터베이스 테스트를 할 때 많이 사용되는 애노테이션
//// ? 데이터베이스를 테스트 할 때 테스트 때문에 JDBC 안의 정보가 변경되는 것을 방지하기 위한 어노테이션이다.
//// ? testcode 내에서 아무리 DB를 수정해도 테스트 진행 후 원복해준다.
//public class JdbcMemoRepositoryTest {
//
//    @Autowired
//    JdbcMemoRepository jdbcMemoRepository;
//
//    @Test
//    void insertMemoTest () {
//        //given
//        Memo newMemo = new Memo(2, "insertMemoTest");
//
//        //when
//        Memo save = jdbcMemoRepository.save(newMemo);
//
//        //then
//        Optional<Memo> result = jdbcMemoRepository.findById(2);
//        assertEquals("insertMemoTest", result.get().getTest());
//        // Optional 타입의 값은 .get()으로 가져온다!
//    }
//
//    @Test
//    void findAllMemoTest() {
//        //given
//        List<Memo> memoList = jdbcMemoRepository.findAll();
//        System.out.println(memoList);
//        //when
//        //then
//        assertNotNull(memoList);
//    }
//}
//
