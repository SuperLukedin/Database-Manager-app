package RelatedTables;

import java.util.ArrayList;
import java.util.List;

public class Abandoned_properties {
    String TableName = "abandoned_properties";
    List<String> Abandoned_properties = new ArrayList<>();
    String url;   // public website from tableau, all graphs are pre-made;

    public Abandoned_properties() {
        Abandoned_properties.add("open_complaints");
        url = "https://public.tableau.com/views/abps_block/Dashboard1?:embed=y&:display_count=yes";
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public List<String> getAbandoned_properties() {
        return Abandoned_properties;
    }

    public void setAbandoned_properties(List<String> abandoned_properties) {
        Abandoned_properties = abandoned_properties;
    }

    public String getUrl() {
        return url;
    }
}
