import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v1.Assistant;
import com.ibm.watson.assistant.v1.model.ListLogsOptions;
import com.ibm.watson.assistant.v1.model.Log;
import com.ibm.watson.assistant.v1.model.LogCollection;

import java.util.Iterator;

public class UserUtteranceExtraction {

    public static void main(String[] args) {
        String apiKey ="enter the apikey";
        String url = "enter the url";
        String workspaceId = "enter the workspace id";

        IamAuthenticator authenticator = new IamAuthenticator(apiKey);
        Assistant assistant = new Assistant("2020-04-01", authenticator);
        assistant.setServiceUrl(url);
        ListLogsOptions options = new ListLogsOptions.Builder(workspaceId).build();
        LogCollection response = assistant.listLogs(options).execute().getResult();
        //System.out.println(response);

        Iterator<Log> iterator = response.getLogs().iterator();
        while (iterator.hasNext()){
            Log element = iterator.next();
            String userUtterance = element.getResponse().getInput().getText();
            System.out.println(userUtterance);
        }
    }
}