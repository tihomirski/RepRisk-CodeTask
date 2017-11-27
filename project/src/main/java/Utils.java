
import objects.Article;
import objects.Company;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Utils {

    public static ArrayList<Company> getCompaniesFromFile(String filename) {
        ArrayList<Company> companiesList = new ArrayList<>();

        File fileCompanies;
        BufferedReader br = null;

        try {

            fileCompanies = new File(filename);
            br = new BufferedReader(new FileReader(fileCompanies));
            String line = "";
            String separator = ",";
            int lineCounter = 1;
            while ((line = br.readLine()) != null) {
                String[] linePieces = line.split(separator);
                if (linePieces.length == 2 &&
                        (!linePieces[0].equals("")) &&
                        (!linePieces[1].equals("")) &&
                        (!linePieces[0].equals("RepRisk Company ID"))) {

                    companiesList.add(new Company(linePieces[0], linePieces[1]));

                } else {
                    System.err.println("Line ["+lineCounter+"] not added to the list of companies. linePieces.length = " + linePieces.length);
                }

                lineCounter++;

            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return companiesList;
    }

    public static ArrayList<Article> getArticlesFromFile(String dir) {

        ArrayList<Article> articlesList = new ArrayList<>();

        File dirArticles = new File(dir);

        BufferedReader br = null;

        try {

            String[] filenames = dirArticles.list();
            for (int i=0; i<filenames.length; i++) {

                Article article = parseXMLfile(new File(dir, filenames[i]).getAbsolutePath());
                articlesList.add(article);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return articlesList;
    }

    public static Article parseXMLfile(String filename) throws Exception {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File f = new File(filename);
            Document document = builder.parse(f);

            NodeList nodeList = document.getElementsByTagName("news-item");

            String id = null;
            String text = null;

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                id = node.getAttributes().getNamedItem("id").getTextContent();

                NodeList itemNodes = node.getChildNodes();

                for (int k=0; k<itemNodes.getLength(); k++) {

                    if (itemNodes.item(k).getNodeName().equals("text")) {
                        text = itemNodes.item(k).getTextContent();

                    }
                }

            }


            if (id != null && text != null) {
                return new Article(id, text);
            } else {
                throw new Exception("Cannot create Article object. Either id or text is null.");
            }

        } catch (Exception e) { e.printStackTrace(); }


        return null;


    }


    public static ArrayList<Company> getMentionedCompanies(ArrayList<Company> companies, ArrayList<Article> articles) {
        ArrayList<Company> result = new ArrayList<>();

        for (int i = 0; i<companies.size(); i++) {
            System.out.print("Company in position "+ i + " out of " + companies.size());
            String name = companies.get(i).getName();
            if (name.contains("(") && name.indexOf("(") > 0) {
                name = name.substring(0, name.indexOf("(")-1);
                companies.get(i).setName(name);
            }
            if (isCompanyInArticles(companies.get(i), articles)) {
                result.add(companies.get(i));
            }
        }
        return result;
    }

    public static boolean isCompanyInArticles(Company company, ArrayList<Article> articles) {
        System.out.println("---> " + company.getName() );
        for (int k=0; k<articles.size(); k++) {
            if (articles.get(k).getText().contains(company.getName())) {
                return true;
            }
        }

        return false;
    }

    public static void printCompanyList(ArrayList<Company> companies) {
        System.out.println("--|v|-----------------| Companies |-----------------------");
        for (Company c : companies) {
            System.out.println(c.getName());
        }
        System.out.println("--|^|-----------------| Companies |-----------------------");
    }




}
