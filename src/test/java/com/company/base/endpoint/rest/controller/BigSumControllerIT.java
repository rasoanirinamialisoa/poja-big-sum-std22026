package com.company.base.endpoint.rest.controller;

import com.company.base.PojaGenerated;
import com.company.base.conf.FacadeIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;

@PojaGenerated
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BigSumControllerIT extends FacadeIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testBigSumEndpoint() {
        String a = "1000000000000000000000";
        String b = "2";
        String expectedSum = "1000000000000000000002";

        String url = "http://localhost:" + port + "/big-sum?a=" + a + "&b=" + b;
        String result = restTemplate.getForObject(url, String.class);

        assertEquals(expectedSum, result);
    }
}
