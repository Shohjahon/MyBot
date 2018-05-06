package Parser;

import Models.University;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shoh Jahon on 06.05.2018.
 */
public class UniversityJsonParser {
    private  Gson gson;

    public UniversityJsonParser(){
        gson = new Gson();
    }
    
    public List<University> getAllUniversities(){
        try (Reader reader = new FileReader("C:\\Users\\Shoh Jahon\\IdeaProjects\\UniversityBot\\src\\main\\resources\\universities.json")) {
            List<University> list = gson.fromJson(reader, new TypeToken<List<University>>(){}.getType());
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean universityExists(String universityName){
        String name = universityName.toLowerCase();
        List<University> universities = getAllUniversities();
        for (int i = 0; i < universities.size() ; i++) {
            String realName = universities.get(i).getG4().toLowerCase();
            if (realName.contains(name)||realName.equals(name)) return true;
        }
        return false;
    }

    public  University findUniversity(String universityName){
        String name = universityName.toLowerCase();
        List<University> universities = getAllUniversities();
        for (int i = 0; i < universities.size() ; i++) {
            String realName = universities.get(i).getG4().toLowerCase();
            if (realName.contains(name)||realName.equals(name)) return universities.get(i);
        }
        return null;
    }
}
