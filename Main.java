import org.json.simple.*;

class JSONADD {
    String json;
    void jsonadd() {
        JSONObject inner = JSONObject();
        inner.put("professor", "�豳��");
        inner.put("student", "���л�");

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