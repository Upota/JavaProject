import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

public class Document { 
    private long rowId; 
    private List<Field> fieldList = new ArrayList<Field>(); 
    private Map<String, Field> fieldsByName = new HashMap<String,Field>(); 
    public void addField(Field field) { 
        fieldList.add(field); 
        fieldsByName.put(field.getName(), field); 
    } 
    public List<Field> getFields() { 
        return fieldList; 
    } 
    public String get(String fieldName) { 
        return fieldsByName.get(fieldName).getValue(); 
    } /** * @return the rowId */ 
    public long getRowId() { 
        return rowId; 
    } /** * @param rowId the rowId to set */ 
    public void setRowId(long rowId) { 
        this.rowId = rowId; 
    } /* (non-Javadoc) * @see java.lang.Object#toString() */ 
    @Override 
    public String toString() { 
        return "Document [rowId=" + rowId + ", fieldList=" + fieldList + "]";
    } 
}
