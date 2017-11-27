import objects.Article;
import objects.Company;

import java.util.ArrayList;

public class Run {

    public static void main(String[] args){

        System.out.println("\n\nHello RepRisk!\nThe program is running. This may take some minutes...");
        if (args.length != 2) {
            try {
                throw new Exception("Insufficient arguments!\n-  Intended use: Needs 2 args. \n" +
                        "First arg is the absolute path to the file CSV with the companies.\n" +
                        "Second arg is the directory where the articles are stored.\n" +
                        "Example: ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String companiesFile = args[0];
        ArrayList<Company> companiesList = Utils.getCompaniesFromFile(companiesFile);

        String articlesDir = args[1];
        ArrayList<Article> articlesList = Utils.getArticlesFromFile(articlesDir);

        System.out.println("[counter] Companies: " + companiesList.size());

        System.out.println("[counter] Articles: " + articlesList.size());

        ArrayList<Company> companiesMentioned = Utils.getMentionedCompanies(companiesList, articlesList);

        System.out.println("[counter] companiesMentioned: " + companiesMentioned.size());

    }

}
