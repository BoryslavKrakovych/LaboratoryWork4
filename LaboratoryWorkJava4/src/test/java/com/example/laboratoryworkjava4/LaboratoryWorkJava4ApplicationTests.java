package com.example.laboratoryworkjava4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@PropertySource("classpath:application.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LaboratoryWorkJava4ApplicationTests {

        @Autowired
        private MockMvc mvc;


        @Test
        public void contextLoads() {
            assertThat(mvc).isNotNull();
        }

        @AfterAll
        public void teardown(@Autowired Environment env) {
            System.out.println(env.getProperty("data.file.properties"));
        }


        @Test
        public void solveWithoutSteps() throws Exception {
            String request = """
            { 
            "FirstNumber": 6,
            "SecondNumber": 3,
            "Steps": false
            }

               """;

            mvc.perform(post(new URI("/solveGCD")).contentType(MediaType.APPLICATION_JSON).content(request))
                    .andExpect(status().isCreated())
                    .andExpect(content().string(containsString("\"result\":3")));

        }
        @Test
        public void solveWithSteps() throws Exception {

        String request = """
            {
            "FirstNumber": 6,
            "SecondNumber": 3,
            "Steps": true
            }
               """;

        var r = post(new URI("/solveGCD"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(request);

        mvc.perform(r).andExpect(status().isCreated());
    }




        @Test
        public void getSolved() throws Exception {

            String request = """
            {
            "FirstNumber": 6,
            "SecondNumber": 3,
            "Steps": true
            }
               """;

            var response = mvc.perform(post(new URI("/solveGCD")).contentType(MediaType.APPLICATION_JSON).content(request)).
                    andExpect(status().isCreated()).andReturn().getResponse();

            mvc.perform(get(new URI(Objects.requireNonNull(response.getHeader("Location"))))).andExpect(status().isOk());

        }

    }


