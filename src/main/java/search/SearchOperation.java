package search;

public enum SearchOperation {
    EQUALITY, NEGATION, GREATER_THAN, LESS_THAN, GREATER_EQUAL, LESS_EQUAL;

    public static SearchOperation getSearchOperation(String input) {
       if(input.equals("="))
           return EQUALITY;
       else if(input.equals("!"))
           return NEGATION;
       else if(input.equals(">"))
           return GREATER_THAN;
       else if(input.equals("<"))
           return LESS_THAN;
       else if(input.equals(">="))
           return GREATER_EQUAL;
       else if(input.equals("<="))
           return LESS_EQUAL;
       return null;
    }
}
