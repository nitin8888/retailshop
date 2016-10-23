package com.hcl.retailshop.api;

import com.hcl.retailshop.service.ShopServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    @Resource
    private ShopServiceImpl shopService;

    @Test
    public void addShop() throws Exception {
        URI resource = getClass().getResource("/json/shop.json").toURI();
        String shopJson = new String(Files.readAllBytes(Paths.get(resource)));
        mockMvc.perform(MockMvcRequestBuilders.post("/shop")
                .contentType(MediaType.APPLICATION_JSON)
                .content(shopJson))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getClosestShop() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/closestShop/?latitude=51.5217644&longitude=-0.093038")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}
