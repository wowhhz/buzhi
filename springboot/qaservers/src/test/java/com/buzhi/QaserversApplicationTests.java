package com.buzhi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//import com.buzhi.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class QaserversApplicationTests {
	
//	@Autowired
//	private UserService userService;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void userList() throws Exception{
//		mvc.perform(MockMvcRequestBuilders.get("/user"))
//		.andExpect(MockMvcResultMatchers.status().isOk());
	}
//	
//	@Test
//	public void test() throws Exception {
//		List<User> list = userService.findByAge(20);
//		Assert.assertEquals(list.get(0).getAge(), new Integer(20));
//
//    }

	@Test
	public void contextLoads() {
	}

}
