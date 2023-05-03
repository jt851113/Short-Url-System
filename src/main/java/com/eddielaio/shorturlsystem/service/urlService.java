package com.eddielaio.shorturlsystem.service;

public interface urlService {
    String encode(String longUrl);

    String decode(String shortUrl);
}
