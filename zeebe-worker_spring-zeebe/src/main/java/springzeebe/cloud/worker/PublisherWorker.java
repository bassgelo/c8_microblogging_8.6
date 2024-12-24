package springzeebe.cloud.worker;

import com.sys1yagi.mastodon4j.api.exception.Mastodon4jRequestException;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springzeebe.cloud.services.MastodonService;

@Component
public class PublisherWorker {

    @Autowired
    private MastodonService mastodonService;

    @JobWorker(type = "Worker_PublishMessage")
    public void publishMessage(final ActivatedJob job) {
        String message = (String)job.getVariablesAsMap().get("message");
        try {
            mastodonService.publishMastodonMessage(message);
        } catch (Mastodon4jRequestException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
