package com.survivingcodingbootcamp.blog.integration;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void homePageShouldReturnA200ResponseCodeAndHtml(){
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/", String.class);
        HttpStatus status = response.getStatusCode();
        assertThat(status).isEqualTo(HttpStatus.OK);
        MediaType mediaType = response.getHeaders().getContentType();
        assertThat(mediaType).isEqualTo(MediaType.valueOf("text/html;charset=UTF-8"));
    }
}