import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataFetcher {

    public JSONObject fetchInputFile(String filename) {
        JSONParser parser = new JSONParser();
        JSONObject input = null;
        try {
            input = (JSONObject) parser.parse(new FileReader(filename));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return input;
    }

    public Boolean isRegularLanguage() {
        JSONObject inputJSON = fetchInputFile();
        List<State> states = (List<State>) inputJSON.get("states");
        State initialState = new State((String) inputJSON.get("initialState"));
        String transitionFunction = (String) inputJSON.get("transitionFunction");
        String alphabets = (String) inputJSON.get("alphabets");
        DFAMachine dfaMachine = new DFAMachine(states, initialState, transitionFunction);
        return dfaMachine.runString(alphabets);
    }
}
