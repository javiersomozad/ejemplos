package es.anaya.spring.web.s04.routines.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.anaya.spring.web.s04.routines.domain.Routine;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RoutineRepositoryTest {

    @Autowired
    RoutineRepository routineRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldFindById() throws Exception {
        Routine routine = routineRepository.findById(1L).get();
        assertNotNull(routine);
        assertEquals(1, routine.getId().intValue());
    }
    
    @Test
    public void shouldFindByTitle() throws Exception {
        List<Routine> routineList = routineRepository.findByTask("Read a book");
        assertEquals(1, routineList.size());
    }

    @Test
    public void shoudlFindByContent() throws Exception {
        List<Routine> routineList = routineRepository.findByImportance(3);
        assertEquals(1, routineList.size());
    }

}