package swf.d4;

import java.io.FileReader;
// import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.json.simple.parser.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Cookie {
    private String fortune;
    private String filename = "Cookies.json";

    private JSONArray loadCookies() {
        JSONArray cookies = new JSONArray();

        try (FileReader reader = new FileReader(filename)) {
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(reader);
            cookies = (JSONArray) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cookies;
    }

    private Cookie() {

    }

    private Cookie(String fortune) {
        this.fortune = fortune;
    }

    public static Cookie getCookie() {
        Cookie c = new Cookie();
        JSONArray cookies = c.loadCookies();

        int random = new Random().nextInt(cookies.size() - 1);
        String fortune = (String) cookies.get(random);
        c.setFortune(fortune);

        return c;
    }

    public String getFortune() {
        return fortune;
    }

    private void setFortune(String fortune) {
        this.fortune = fortune;
    }

    /* @SuppressWarnings("unchecked")
    private boolean saveCookie(Cookie c) {
        boolean saved = true;

        JSONArray cookies = loadCookies();

        for (int i = 0; i < cookies.size(); i++) {
            if (c.getFortune().equals(cookies.get(i))) {
                saved = false;
                break;
            }
        }
        if (saved) {
            cookies.add(c.getFortune());
            try (FileWriter file = new FileWriter("Cookies.json")) {
                file.write(cookies.toString());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return saved;
    } */

    /* @SuppressWarnings("unchecked")
    private void populateData() {
        JSONArray cookies = new JSONArray();
        cookies.add("Do, or do not. There is no try.");
        cookies.add("Extraordinary claims require extraordinary evidence.");
        cookies.add("Poetry is just the evidence of life. If your life is burning well, poetry is just the ash.");
        cookies.add("Do not try to solve all life's problems at once ― learn to dread each day as it comes.");
        cookies.add("Vodka mixes well with everything, except decisions.");
        cookies.add("Never make the same mistake twice. There are so many new ones. Try a different one each day.");
        cookies.add("I don't hold grudges. I hold memories that keep me better prepared for our next encounter.");
        cookies.add("The planet is fine. The people are fucked.");
        cookies.add("If a book about failures doesn't sell, is it a success?");
        cookies.add("A word to the wise ain't necessary, it's the stupid ones who need advice.");
        cookies.add("If you're too open-minded; your brains will fall out.");
        cookies.add("Life is pleasant. Death is peaceful. It's the transition that's troublesome.");
        cookies.add("The funniest people are the saddest ones.");
        cookies.add("Never trust people who smile constantly. They're either selling something or not very bright.");
        cookies.add("How is it possible to have a civil war?");
        cookies.add(
                "My congratulations to you, sir. Your manuscript is both good and original; but the part that is good is not original, and the part that is original is not good.");
        cookies.add("Rejection is an opportunity for your selection.");
        cookies.add("Pressure is something you feel when you don't know what the hell you're doing.");
        cookies.add("Everything is funny as long as it is happening to somebody else.");
        cookies.add("Nothing is funnier than unhappiness.");
        cookies.add(
                "Just because you're trash doesn't mean you can't do great things. Its called garbage can, not garbage cannot.");

        try (FileWriter file = new FileWriter("Cookies.json")) {
            file.write(cookies.toString());
            file.flush();
            file.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    } */

}