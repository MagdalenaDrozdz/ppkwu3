package com.example.demo.serwis;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.jsoup.nodes.Document;

@org.springframework.stereotype.Service


public class Serwis {
    public File getCalendar() throws IOException {

        Document document;
        Elements days,events;

        document = Jsoup.connect("http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php?rok=" + "2020" + "&miesiac=" + "10" + "&lang=1").get();

        events= document.select("div.InnerBox");
        System.out.println(events);
        days = document.select("a.active");
        System.out.println(days);

        return new File("test");
    }
}
