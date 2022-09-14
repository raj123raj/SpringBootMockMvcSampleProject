package com.gfg.gfgsample.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.gfg.gfgsample.domain.GeekEmployee;
import com.gfg.gfgsample.service.GeekEmployeeService;
 
@WebMvcTest(controllers = GeekEmployeeMvcController.class)
class GeekEmployeeMvcWebTest {
 
    @Autowired
    MockMvc mockMvc;
 
    @MockBean
    GeekEmployeeService geekEmployeeService;
 
    @Test
    void checkForGeekEmployeeListView() throws Exception {
        GeekEmployee ge1 = new GeekEmployee("Rachel", "Green", 50000);
        GeekEmployee ge2 = new GeekEmployee("Monica", "Geller", 40000);
        GeekEmployee ge3 = new GeekEmployee("Phoebe", "", 45000);
        List<GeekEmployee> geekEmployeeList = List.of(ge1, ge2, ge3);
 
        when(geekEmployeeService.findAll()).thenReturn(geekEmployeeList);
 
        this.mockMvc.perform(get("/mvc/geekemployees"))
            .andExpect(status().isOk())
            .andExpect(view().name("geekemployee-list"))
            .andExpect(model().attribute("geekemployees", geekEmployeeList))
            .andExpect(model().attribute("geekemployees", Matchers.hasSize(3)))
            .andDo(print());
    }
 
}