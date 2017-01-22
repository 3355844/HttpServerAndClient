/**
 * Created by 33558 on 21.01.2017.
 */
public class HtmlTransformer {
    String headTitle = "Default Title";
    String body = "Default Body";
    String html = "<!DOCTYPE html><html><head><title>%s</title></head><body>%s</body></html>";
    String table = "<table>%s</table>";
    String row = "<tr>%s<tr>";
    String column = "<td>%s</td>";


    public void setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getHeadTitle() {
        return headTitle;
    }

    public String getBody() {
        return body;
    }

    public String getHtml() {
        return html;
    }

    public String getTable() {
        return table;
    }

    public String getRow() {
        return row;
    }


    public String getColumn() {
        return column;
    }

}
