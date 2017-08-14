package com.project.rating.component.crawler;

import com.project.rating.component.crawler.icoratingcom.ProjectPage;
import com.project.rating.model.Company;
import com.project.rating.model.Offering;
import com.project.rating.model.Rating;
import com.project.rating.service.MongoOfferingService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

@Component
public class ICORatingCrawler {

    private final MongoOfferingService service;

    @Autowired
    public ICORatingCrawler(MongoOfferingService service) {
        this.service = service;
    }

    public void parseProjectPage(String url) {
        try {
            Document document = Jsoup.connect(url).validateTLSCertificates(false).get();

            ProjectPage projectPage = new ProjectPage(document);
            String companyName = projectPage.getCompanyName().text().trim();
            String ratingResource = "ICORating.com";
            String ratingScore = projectPage.getCardScoreStatus().text().trim();

            Elements elements = document.select(".ico-project");
            elements.forEach((element) -> {

                Element overviewTable = projectPage.getTableRawByIndex(projectPage.getCardTable(), 0);

                String ratingHype = overviewTable.get(0).select(".ico-card-table__td").get(1).text().trim();
                String ratingRisk = overviewTable.get(1).select(".ico-card-table__td").get(1).text().trim();
                String ratingInvest = overviewTable.get(2).select(".ico-card-table__td").get(1).text().trim();
                String category = overviewTable.get(3).select(".ico-card-table__td").get(1).text().trim();
                String description = overviewTable.get(4).select(".ico-card-table__td").get(1).text().trim();
                String founded = overviewTable.get(5).select(".ico-card-table__td").get(1).text().trim();
                String website = overviewTable.get(6).select(".ico-card-table__td").get(1).text().trim();
                Elements links = overviewTable.get(7).select(".ico-card-table__td").get(1).select(".ico-card-socials").select("a");
                ArrayList<String> linksList = new ArrayList<>();
                links.forEach((el) -> {
                    linksList.add(el.select("a").attr("href"));
                });

                Rating rating = new Rating();
                rating.setHype(ratingHype);
                rating.setRisk(ratingRisk);
                rating.setResource(ratingResource);
                rating.setInvest(ratingInvest);
                rating.setScore(ratingScore);

                Company company = new Company();
                company.setName(companyName);
                company.setLinks(linksList);
                company.setRatings(new ArrayList<>(Collections.singletonList(rating)));
                company.setCategory(category);
                company.setDescription(description);
                company.setFounded(founded);
                company.setWebsite(website);

                Offering offering = new Offering();
                offering.setCompany(company);

                service.create(offering);


            });
        } catch (Exception e) {
            System.err.println("For '" + url + "': " + e.getMessage());
        }
    }
}
