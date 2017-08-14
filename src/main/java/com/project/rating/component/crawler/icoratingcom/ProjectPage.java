package com.project.rating.component.crawler.icoratingcom;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProjectPage {

    public static final String PROJECT_BLOCK = ".ico-project";
    public static final String CARD_TABLE = ".ico-card-table";
    public static final String COMPANY_NAME = ".hidden-xs.ico-name-title";
    public static final String CARD_SCORE_STATUS = ".ico-card-score__status";
    public static final String CARD_TABLE_RAW = ".ico-card-table__tr";

    private Document document;

    public ProjectPage(Document document) {
        this.document = document;
    }

    public Elements getProjectBlock() {
        return this.document.select(PROJECT_BLOCK);
    }

    public Elements getCardTable() {
        return this.document.select(CARD_TABLE);
    }

    public Elements getCompanyName() {
        return this.document.select(COMPANY_NAME);
    }

    public Elements getCardScoreStatus() {
        return this.document.select(CARD_SCORE_STATUS);
    }

    public Element getTableRawByIndex(Elements table, Integer i) {
        return table.get(i);
    }

    public Elements getTableDataFromRawByIndex(Element tableRaw, Integer i){
        return tableRaw.tagName()
    }

}
