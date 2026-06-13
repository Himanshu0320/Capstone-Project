package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class JsonReportUtil {

    public static void writeResult(String testName, String status) {

        try {

            Map<String, Object> report = new HashMap<>();

            report.put("testName", testName);
            report.put("status", status);
            report.put("executionTime", System.currentTimeMillis());

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            FileWriter writer =
                    new FileWriter("test-output/JsonReport.json");

            gson.toJson(report, writer);

            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}