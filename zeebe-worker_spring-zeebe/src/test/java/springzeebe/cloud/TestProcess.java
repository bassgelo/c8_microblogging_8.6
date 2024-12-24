package springzeebe.cloud;
import io.camunda.process.test.api.CamundaAssert;
import io.camunda.process.test.api.CamundaProcessTestContext;
import io.camunda.process.test.api.CamundaSpringProcessTest;
import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.DeploymentEvent;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import springzeebe.cloud.services.MastodonService;
import springzeebe.cloud.services.RandomStringService;
import static org.mockito.Mockito.when;

@SpringBootTest
@CamundaSpringProcessTest
//This test requires Docker to be up and running
public class TestProcess {

    @Autowired private ZeebeClient zeebeClient;
    @Autowired
    private CamundaProcessTestContext processTestContext;

    // mock services from job workers
    //@MockBean private MastodonService mastodonService;
    @MockBean private RandomStringService randomStringService;

    @BeforeEach
    void deployProcesses() {
        // The embedded engine is completely reset before each test run.
        // Therefore, we need to deploy the process each time
        DeploymentEvent event = zeebeClient.newDeployCommand()
                .addResourceFromClasspath("AutomatedMessagePosting.bpmn")
                .send()
                .join();
    }

    @Test //This method tests the happy path
    void testTweetApproved_happyPath() throws Exception {

        // given
        final String messageTest = "testing";

        when(randomStringService.getRandomString()).thenReturn(messageTest);

        final ProcessInstanceEvent processInstance =
                zeebeClient.newCreateInstanceCommand().bpmnProcessId("Process_AutomatedMessagePosting").latestVersion().send().join();

        // then
        CamundaAssert.assertThat(processInstance).isCompleted();

    }

}
