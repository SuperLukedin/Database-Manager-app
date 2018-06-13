package RelatedTables;

import java.util.ArrayList;
import java.util.List;

public class Relationships {
    String tableName;
    List<String> relatedTables = new ArrayList<>();

    public Relationships(String tableName, List<String> relatedTables) {
        this.tableName = tableName;
        this.relatedTables = relatedTables;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getRelatedTables() {
        return relatedTables;
    }

    public void setRelatedTables(List<String> relatedTables) {
        this.relatedTables = relatedTables;
    }
}
