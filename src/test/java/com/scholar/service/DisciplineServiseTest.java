package com.scholar.service;


import com.schoolar.modules.model.Discipline;
import com.schoolar.modules.service.DisciplineService;
import com.schoolar.modules.service.Impl.DisciplineServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:core-spring-config.xml")
@Transactional
public class DisciplineServiseTest {

        @Autowired
        private DisciplineService disciplineService;

    @Before
    public void setUp() throws Exception {

            disciplineService = new DisciplineServiceImpl();

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void testDiscipline() throws Exception {
        Discipline discipline = new Discipline(3, "math");
        disciplineService.save(discipline);
        Discipline found = disciplineService.findById(3);
        Assert.assertEquals(discipline, found);



    }
}
