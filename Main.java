import org.json.simple.*;

class JSONADD {
    String json;
    void jsonadd() {
        JSONObject inner = JSONObject();
        inner.put("professor", "김교수");
        inner.put("student", "이학생");

        JSONObject outer = new JSONObject();
        outer.put("univ", inner);

        json = outer.toJSONSring();
        
    }
}

public class Main{
    public static void main(String[] args) throws ParseException {
        JOSNAdd jsonAdd = new JSONAdd();
        jsonAdd.jsonadd();

        JSONParse parser = new JSONParser();

        JSONObject obj = (JSONObject)parser.parse(jsonAdd.json);
        JSONObject univ = (JSONObject)obj.get("univ");

        String professor = (String)univ.get("professor");
        String student = (String)univ.get("student");

        System.out.println(professor);
        System.out.println(student);
    }
}