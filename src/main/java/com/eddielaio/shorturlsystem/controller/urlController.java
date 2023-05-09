package com.eddielaio.shorturlsystem.controller;

import com.eddielaio.shorturlsystem.pojo.url;
import com.eddielaio.shorturlsystem.service.urlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eddielaio.shorturlsystem.limiter.myRateLimiter;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class urlController {

    @Autowired
    private urlService urlService;
    @Autowired
    private myRateLimiter myRateLimiter;

    private static final Logger logger = LoggerFactory.getLogger(urlController.class);

    @Operation(summary = "shorten the url")
    @ApiResponse(description = "Send the Original url, return the short url.")
    @PostMapping(value = "/shorten", consumes = "application/json")
    public ResponseEntity<Object> shortenUrl(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(examples = {@ExampleObject(
                    name = "Request Example",
                    summary = "Request Example",
                    value = "{\"url\":\"https://www.google.com\"}"
            )})
    ) @NotNull url OriginalUrl) {
        if(!myRateLimiter.rateLimiter.tryAcquire()){
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests, please try again later.");
        }
        String encode = urlService.encode(OriginalUrl.getUrl());
        url short_url = new url(encode);
        return ResponseEntity.status(HttpStatus.CREATED).body(short_url);
    }

    @Operation(summary = "redirect to the original url")
    @ApiResponse(description = "redirect to the original url if short url is exist")
    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> redirectToOriginalUrl(@PathVariable String shortUrl) throws URISyntaxException {
        String decode = urlService.decode(shortUrl);
        System.out.println(decode);
        if (decode == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI(decode));
            return new ResponseEntity<>(null, headers, HttpStatus.MOVED_PERMANENTLY);
        }
    }

}
