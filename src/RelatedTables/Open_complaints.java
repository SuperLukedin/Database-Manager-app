package RelatedTables;

import java.util.ArrayList;
import java.util.List;

public class Open_complaints {
    String TableName = "open_complaints";
    List<String> Open_complaints = new ArrayList<>();
    String url;   // public website from tableau, all graphs are pre-made;

    public Open_complaints() {
        Open_complaints.add("open_complaints");
        url = "https://public.tableau.com/views/open_complaintsblocklot/Dashboard1?:embed=y&:display_count=yes";
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public List<String> getAbandoned_properties() {
        return Open_complaints;
    }

    public void setAbandoned_properties(List<String> open_complaints) {
        Open_complaints = open_complaints;
    }

    public String getUrl() {
        return url;
    }
}
