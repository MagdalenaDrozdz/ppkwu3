package com.example.demo.serwis;

import biweekly.ICalendar;
import biweekly.component.VEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;

@org.springframework.stereotype.Service


public class Serwis {
    public Map<String, String> getCalendar(String year, String month) throws IOException {

        Document document;
        Elements events, days;
        Map<String, String> map = new HashMap();
        int i;
        Calendar day = Calendar.getInstance();
        int m = Integer.parseInt(month);
        int y = Integer.parseInt(year);

        document = Jsoup.connect("http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php?rok=" + year + "&miesiac=" + month + "&lang=1").get();

        events= document.select("div.InnerBox");
        days = document.select("a.active");

        for(i=0; i < events.size(); i++) {
            System.out.println(days.get(i).text());
            System.out.println(events.get(i).text());
            map.put(days.get(i).text(), events.get(i).text());
        }

        for(String key : map.keySet()) {
            VEvent event = new VEvent();
            event.setSummary(map.get(key));
            System.out.println("Key:" + key + "Value:" + map.get(key)) ;
            day.set(y,  m, Integer.parseInt(key));
            event.setDateStart(day.getTime());
            event.setDateEnd(day.getTime());
        }

        return map;
    }
}
