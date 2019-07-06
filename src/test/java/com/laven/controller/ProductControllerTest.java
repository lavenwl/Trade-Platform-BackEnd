package com.laven.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @Description:
 * @Author: laven
 * @Date: 2018/3/14 上午12:13
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getById() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/product/1"))
//                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
////                .andExpect(MockMvcResultMatchers.status().isOk());
////                .andExpect(MockMvcResultMatchers.content().string("abc"));
    }

}