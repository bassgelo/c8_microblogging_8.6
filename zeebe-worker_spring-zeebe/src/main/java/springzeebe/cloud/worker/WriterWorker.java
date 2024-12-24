package springzeebe.cloud.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springzeebe.cloud.services.RandomStringService;
import java.util.HashMap;
import java.util.Map;

@Component
public class WriterWorker {

    @Autowired
    private RandomStringService randomStringService;

    @JobWorker(type = "Worker_WriteMessage")
    public Map<String, Object> writeMessage(final ActivatedJob job) {

        // Generate a random String, with random UUID and convert it to a string
        String generatedString = randomStringService.getRandomString();

        // Return generated variable to Zeebe
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("message", generatedString);
        return variables;
    }
}
