package RelatedTables;

import java.util.ArrayList;
import java.util.List;

public class Newark_housing {
    String TableName = "newark_housing";
    List<String> Newark_housing = new ArrayList<>();
    String url;   // public website from tableau, all graphs are pre-made;

    public Newark_housing() {
        Newark_housing.add("");
        url = "https://public.tableau.com/views/newark_housing_0/newark_housing?:embed=y&:display_count=yes&publish=yes";
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public List<String> getAbandoned_properties() {
        return Newark_housing;
    }

    public void setAbandoned_properties(List<String> newark_housing) {
        Newark_housing = newark_housing;
    }

    public String getUrl() {
        return url;
    }
}
