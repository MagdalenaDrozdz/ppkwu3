package com.example.demo.serwis;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.jsoup.nodes.Document;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@org.springframework.stereotype.Service


public class Serwis {
    public ResponseEntity<Resource>getCalendar(String year, String month) throws IOException {

        Document document;
        Elements events, days;
        Map<Integer, String> map = new TreeMap();
        int i;
        Calendar day = Calendar.getInstance();
        int m = Integer.parseInt(month);
        int y = Integer.parseInt(year);
        ICalendar iCal =  new  ICalendar ();
        Resource resource;

        document = Jsoup.connect("http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php?rok=" + year + "&miesiac=" + month + "&lang=1").get();

        events= document.select("div.InnerBox");
        days = document.select("a.active");

        for(i=0; i < events.size(); i++) {
            map.put(Integer.parseInt(days.get(i).text()), events.get(i).text());
        }

        for(Integer key : map.keySet()) {
            VEvent event = new VEvent();
            event.setSummary(map.get(key));
            day.set(y,  m - 1 , key);
            event.setDateStart(day.getTime());
            event.setDateEnd(day.getTime());
            iCal.addEvent(event);
        }

        File calendar = new File("Calendar_"+month+"_"+year+".ics");
        Biweekly.write(iCal).go(calendar);
        resource = new FileSystemResource(calendar);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("text/calendar"))
                .body(resource);
    }
}
