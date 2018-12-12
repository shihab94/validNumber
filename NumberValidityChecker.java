import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NumberValidityChecker {

    private final String BANGLADESH_NUMBER_PATTERN = "^((\\+8801)|(\\+880 1)|(8801)|(880 1)|(008801)|(00880 1)|(08801)|(01))[3456789]{1}(\\d){2}(-)?(\\d){6}$";
    private final String BANGLADESH_NUMBER_HEAD_PATTERN = "(\\+8801)|(\\+880 1)|(8801)|(880 1)|(008801)|(00880 1)|(08801)|(01)";

    public boolean isValidNumber(String number){
        Pattern pattern = Pattern.compile(BANGLADESH_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public boolean isValidNumber(int number){
        return false;
    }

    public String getOperatorName(String number){
        if(isValidNumber(number)){
            String[] temp = number.split(BANGLADESH_NUMBER_HEAD_PATTERN);
            String remainingNumber = temp[1];
            switch (remainingNumber.charAt(0)){
                case '3' :
                    return "GP";
                case '5' :
                    return "TELETALK";
                case '6' :
                    return "AIRTEL";
                case '7' :
                    return "GP";
                case '8' :
                    return "ROBI";
                case '9' :
                    return "BANGLALINK";
                case '4' :
                    return "BANGLALINK";    
                default:
                    return null;
            }
        }
        return null;
    }
}
