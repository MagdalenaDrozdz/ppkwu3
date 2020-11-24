package com.example.demo.restapi;

import com.example.demo.serwis.Serwis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/")
public class Restapi {

    private Serwis serwis;

    @Autowired
    public Restapi(Serwis serwis) {
        this.serwis = serwis;
    }

    @GetMapping("calendar/{year}/{month}")
    public ResponseEntity<Resource> getCalendarEvents(@PathVariable String year, @PathVariable String month) throws IOException {
        return serwis.getCalendar(year,month);
    }

}
