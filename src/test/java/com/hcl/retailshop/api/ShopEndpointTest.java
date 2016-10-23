package com.hcl.retailshop.api;

import com.hcl.retailshop.model.Coordinates;
import com.hcl.retailshop.model.Shop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Nitin Shreyakar.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShopEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addShop() throws Exception {

        Coordinates coordinates = new Coordinates(123, 456);
        Shop shop = new Shop("Tesco", "24", "EC2 3DY", coordinates);


        URI resource = getClass().getResource("/json/shop.json").toURI();
        String testJson = new String(Files.readAllBytes(Paths.get(resource)));
        mockMvc.perform(MockMvcRequestBuilders.post("/shop")
                .contentType(MediaType.APPLICATION_JSON)
                .content(testJson))
                .andExpect(status().isOk())
                .andReturn();
    }

}
