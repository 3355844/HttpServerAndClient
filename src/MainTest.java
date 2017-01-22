import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 33558 on 22.01.2017.
 */
public class MainTest {
    public static void main(String[] args) {
        String filePath = "index.html";
        HtmlTransformer htmlTransformer = new HtmlTransformer();
        String column = String.format(htmlTransformer.getColumn(), "Some");
        String row = String.format(htmlTransformer.getRow(), column);
        System.out.println(row);
        String table = String.format(htmlTransformer.getTable(), row);
        System.out.println(table);
        htmlTransformer.setBody(table);
        System.out.println(htmlTransformer.getBody());
        htmlTransformer.setHeadTitle("My Title");
        String resultHtml = String.format(htmlTransformer.getHtml(), htmlTransformer.getHeadTitle(), htmlTransformer.getBody());
        System.out.println(resultHtml);
        File fileHtml = new File(filePath);
        try {
            FileWriter writer = new FileWriter(fileHtml);
            writer.write(resultHtml);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
