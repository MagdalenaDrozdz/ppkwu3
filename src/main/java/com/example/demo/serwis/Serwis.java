package com.example.demo.serwis;

import org.springframework.core.io.Resource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

@org.springframework.stereotype.Service

public class Serwis {
    public File getCalendar() {
        return new File("test");
    }
}
