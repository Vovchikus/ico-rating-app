package com.project.rating.controller;

import com.project.rating.component.crawler.ICORatingCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/parse")
public class ParseController {

    private ICORatingCrawler icoRatingCrawler;

    @Autowired
    public ParseController(ICORatingCrawler icoRatingCrawler) {
        this.icoRatingCrawler = icoRatingCrawler;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void parse() {
        //icoListWebCrawler.parseProjectPage("https://www.ico-list.com/index.php?m=Index&a=detail&id=227");
        icoRatingCrawler.parseProjectPage("http://icorating.com/project/127");

        for (int i = 262; i > 0; i--) {
            icoRatingCrawler.parseProjectPage("http://icorating.com/project/" + i);
            //icoListWebCrawler.parseProjectPage("https://www.ico-list.com/index.php?m=Index&a=detail&id=" + i);
        }
    }
}
