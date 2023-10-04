package search;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchCriteria {
    public String key;
    public SearchOperation operation;
    public Object value;

    public SearchCriteria(String key, SearchOperation operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public static List<SearchCriteria> getListSearchCriteria(String search) {

        List<SearchCriteria> searchCriteriaList = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\w+)(=|<|>|!=|>=|<=|\\+|-|\\*|//)([\\w. ]+),");
        Matcher matcher = pattern.matcher(search+",");
        while(matcher.find()) {
            searchCriteriaList.add(new SearchCriteria(matcher.group(1), SearchOperation.getSearchOperation(matcher.group(2)), matcher.group(3)));
        }
        return searchCriteriaList;
    }
}
