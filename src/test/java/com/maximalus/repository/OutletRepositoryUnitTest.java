package com.maximalus.repository;

import com.maximalus.model.Outlet;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.maximalus.repository.TestData.getListOfOutlets;
import static com.maximalus.repository.TestData.getOutlet;
import static com.maximalus.repository.TestData.getOutletForUpdate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(initializers = {OutletRepositoryUnitTest.Initializer.class})
public class OutletRepositoryUnitTest {
    @Autowired
    private OutletRepository outletRepository;

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

        }
    }

    @Test
    @Order(1)
    public void testFindAllOutlets(){
        List<Outlet> expectedOutlet = getListOfOutlets();
        List<Outlet> actualOutlet = (List<Outlet>) outletRepository.findAll();

        assertEquals(expectedOutlet, actualOutlet);
    }

    @Test
    @Order(2)
    public void testCreateOutlet(){
        Outlet expectedOutlet = getOutlet();
        Outlet actualOutlet = outletRepository.save(expectedOutlet);

        assertEquals(expectedOutlet, actualOutlet);
    }

    @Test
    @Order(3)
    public void testFindByIdOutlet(){
        Outlet expectedOutlet = getOutlet();
        Outlet actualOutlet = outletRepository.findById(expectedOutlet.getId()).orElseThrow();

        assertEquals(expectedOutlet, actualOutlet);
    }

    @Test
    @Order(4)
    public void testUpdateOutlet(){
        Outlet expectedOutlet = getOutletForUpdate();
        Outlet actualOutlet = outletRepository.save(expectedOutlet);

        assertEquals(expectedOutlet, actualOutlet);
    }

    @Test
    @Order(5)
    public void testDeleteOutlet(){
        Long id = getOutlet().getId();
        outletRepository.deleteById(id);

        assertFalse(outletRepository.findById(id).isPresent());
    }
}
