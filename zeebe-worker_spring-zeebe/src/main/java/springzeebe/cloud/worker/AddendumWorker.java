package springzeebe.cloud.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class AddendumWorker {

    @JobWorker(type = "Worker_Addendum")
    public Map<String, Object> approveMessage(final ActivatedJob job) {

        String message = (String)job.getVariablesAsMap().get("message");
        message = message + ". GENERATED AT CAMUNDA MEETUP VIENNA ON 21.NOV.2024";

        HashMap<String, Object> variables = new HashMap<>();
        variables.put("message", message);
        return variables;
    }

}
