package com.raddan.hangman;

import com.raddan.service.Service;

public class Hangman {

    private final Service service = new Service();

    public void start() {
        service.start();
    }

}
