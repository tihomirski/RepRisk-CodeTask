import objects.Article;
import objects.Company;
import org.junit.Test;
import sun.rmi.runtime.Log;
//import preprocess.Utils;

import java.util.ArrayList;

import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;

public class UtilsTest {
    @Test
    public void getCompaniesFromFile() throws Exception {
        String filename = "C:\\Tihomir\\Berlin\\RepRisk_project\\project\\src\\main\\resources\\160502_data\\160408_company_list.csv";
        ArrayList<Company> companiesList = Utils.getCompaniesFromFile(filename);
        Company expected1 = new Company("2", "ABB Ltd (ABB Asea Brown Boveri Ltd)");
        Company expected2 = new Company("113","Wells Fargo & Co");

        assertThat(companiesList, hasItem(samePropertyValuesAs(expected1)));
        assertThat(companiesList, hasItem(samePropertyValuesAs(expected2)));
    }

    @Test
    public void getArticlesFromFile() throws Exception {
        String dir = "C:\\Tihomir\\Berlin\\RepRisk_project\\project\\src\\main\\resources\\160502_data";
        //String filename = "160408_company_list.csv";
        ArrayList<Article> articlesList = Utils.getArticlesFromFile(dir);
//        Article expected = new Article("000D-2695-EAE6-7998", "\"I 'M terrified for myself to be honest, hugely daunted, so I can't even begin to imagine what it's going to be like for them.\" So says Prince Harry ahead of his epic 200km trek to the South Pole with wounded servicemen and women, as seen in Harry's South Pole Heroes (Sun, ITV, 8pm). Led by the prince, the team taking part in the fundraising expedition include a double leg amputee and the first British woman to lose a limb on the frontline.\n" +
//                "In the first episode, the expedition members undergo an intensive training regime, including a night in a specialised cold chamber normally used for testing vehicles, before Harry introduces them to grandma at Buckingham Palace.\n" +
//                "On a training exercise in Iceland, meanwhile, they learn the realities of skiing for up to ten hours a day, hauling 80kgs of kit in temperatures as low as -40C. \"To take a double amputee to the South Pole,\" ponders Harry, \"it's really going to be quite a moving moment when we get there. For me, it's bigger than just these guys. We are trying to raise money, but also to raise awareness of the fact that the injuries they have sustained, they are going to carry for the rest of their lives.\"\n" +
//                "More high exertion in Davina - Beyond Breaking Point For Sport Relief (Mon, BBC1, 9pm), charting Davina McCall's battle to run, swim, and cycle 450 miles from Edinburgh to London.\n" +
//                "The programme, in particular, reveals the inside story of the dramatic third day when the challenge became headline news as an exhausted McCall had to be carried ashore from Lake Windermere, explaining how her medical and training team had her back on her feet and cycling 60 miles just one hour later.\n" +
//                "We also witness the presenter's fight against fearsome weather, culminating in an emotional and overwhelming reunion with family and friends as she completes her epic challenge.\n" +
//                "What drove Davina on, we discover, was memories of her recent trip to Kenya where she met Anne, a young girl working in a quarry, breaking rocks with her family. Prostitution: What''s The Harm? (Mon, BBC3, 10pm) reveals how, revolutionised by the internet and serviced by an estimated 100,000 sex workers, prostitution in Britain is thriving.\n" +
//                "Billie JD Porter talks to the young men who pay for sex, and the women selling their bodies, such as 27-year-old Charlotte, who explains how she exploits social media to maximise her business opportunities, and explains why she finds it such a satisfying job.\n" +
//                "But Porter also investigates prostitution's darker side - 140 sex workers have been murdered in Britain since 1990. She visits the site of one such killing and also hears from a former sex worker about the violence and degradation she experienced, and the emotional damage it wreaked on her life.\n" +
//                "Finally, she meets former madam Becky Adams to see what it takes to set up and run a brothel, and quizzes one of the country's leading police officers on legalisation. Those who enjoyed exceptional pre-Olympic sitcom TwentyTwelve will be delighted to see that the team has been reassembled to oversee a transformation of the BBC. In W1A (Wed, BBC2, 9pm), the situation may have changed but, for boss Ian Fletcher, the irritations look horribly familiar. His first challenge on arriving at New Broadcasting House (on his new and much improved folding bike), is to find somewhere to sit in a building aggressively over designed around the principle of not having a desk.\n" +
//                "He soon finds himself holding the hottest of hot potatoes when activists complain the Cornish are shamefully under-represented on the BBC.\n" +
//                "Matters worsen when BBC Spotlight South West presenter Sally Wingate goes public with her feeling that her failure to progress to a national presenting role might be part of the BBC's institutionally anti-Cornish bias.\n" +
//                "Ideas how best to limit the damage lead to PR company Perfect Curve's Siobhan Sharpe suggesting getting Sally \"to do something on Springwatch or some kind of Bake Off\".\n" +
//                "Meanwhile, producer Lucy Freeman is having meetings with Head of Output Anna Rampton and Entertainment Format Creative David Wilkes about a forthcoming new flagship show - Britain's Tastiest Village - which according to David is 'kind of Britain's Got Talent meets Countryfile with a bit of The One Show thrown in just in case'. Hugh Bonneville and Jessica Hynes lead the worryingly realistic nonsense.");
//        assertThat(articlesList, hasItem(samePropertyValuesAs(expected)));
        //System.out.println("Test this --> " + articlesList.get(0).getId() + "||" + articlesList.get(0).getText());
        assertThat(articlesList, hasSize(700));
    }

    @Test
    public void parseXMLfile() throws Exception {

    }

}