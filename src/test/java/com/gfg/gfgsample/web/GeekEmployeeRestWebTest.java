package com.gfg.gfgsample.web;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.gfg.gfgsample.domain.GeekEmployee;
import com.gfg.gfgsample.service.GeekEmployeeService;
@WebMvcTest(controllers = GeekEmployeeRestController.class)
class GeekEmployeeRestWebTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	GeekEmployeeService geekEmployeeService;
	
	@Test
	void whenReadGeekEmployee_returnJsonContent() throws Exception {
		GeekEmployee rachel = new GeekEmployee("Rachel", "Green", 100000);
		rachel.setEmployeeId(1000L);
		
		when(geekEmployeeService.findById(1000L)).thenReturn(Optional.of(rachel));
		

		this.mockMvc.perform(get("/geekemployees/1000"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString(
				"{\"employeeId\":1000,\"firstName\":\"Rachel\",\"lastName\":\"Green\",\"salary\":100000}")))
			.andDo(print());
	}

	
	
}
