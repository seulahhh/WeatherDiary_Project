package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo newMemo = new Memo(10, "this is jpa memo");
        //when
        jpaMemoRepository.save(newMemo);
        //then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(!memoList.isEmpty());
    }

    @Test
    void findByIdTest() {
        //given
        Memo newMemo = new Memo(11, "jpa");
        //when
        Memo savedMemo = jpaMemoRepository.save(newMemo);

        //then
        Optional<Memo> foundMemo = jpaMemoRepository.findById(savedMemo.getId());
        assertEquals("jpa", foundMemo.get().getTest());

        // key값을 데이터베이스에서 자동생성하게 하는 설정을 적용시켰기 때문에(@GeneratedValue(Identify),
        // 컬럼 생성시 auto increment 옵션),
        // new Memo로 id를 지정해서 넣어줘도, 막상 jpaMemoRepository에 들어간 값은 지정한 id값이 아닌
        // My SQL 에서 자동으로 생성한 값 일것이다.
        // 따라서 findById(11) 을 해주면 원하는 값을 찾지 못함.
    }
}