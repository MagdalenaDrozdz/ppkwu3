package com.example.demo.serwis;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;

@org.springframework.stereotype.Service


public class Serwis {
    public File getCalendar() throws IOException {

        Document document;
        Elements events, days;
        Map<String, String> map = new HashMap();
        int i;

        document = Jsoup.connect("http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php?rok=" + "2020" + "&miesiac=" + "10" + "&lang=1").get();

        events= document.select("div.InnerBox");
        days = document.select("a.active");

        for(i=0; i < events.size(); i++) {
            System.out.println(days.get(i).text());
            System.out.println(events.get(i).text());
            map.put(days.get(i).text(), events.get(i).text());
        }


        return new File("test");
    }
}
