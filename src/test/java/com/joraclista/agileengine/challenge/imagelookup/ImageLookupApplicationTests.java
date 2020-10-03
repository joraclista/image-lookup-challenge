package com.joraclista.agileengine.challenge.imagelookup;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class ImageLookupApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void shouldReturnImageByItsID() throws Exception {
        this.mockMvc.perform(get("/api/search/988e07e74fe429912496")).andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("988e07e74fe429912496"))
                .andReturn();
    }

    @Test
    public void shouldReturnOnlyCorrectAuthors() throws Exception {
        this.mockMvc.perform(get("/api/search/Idolized Wing")).andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].author").value("Idolized Wing"))
                .andReturn();
    }

    @Test
    public void shouldReturnOnlyCorrectCamera() throws Exception {
        this.mockMvc.perform(get("/api/search/Leica M10")).andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].camera").value("Leica M10"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].camera").value("Leica M10"))
                .andReturn();
    }
}
