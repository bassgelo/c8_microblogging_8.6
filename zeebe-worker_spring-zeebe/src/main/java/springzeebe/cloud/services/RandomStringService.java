package springzeebe.cloud.services;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class RandomStringService {

    public String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("[^a-zA-Z0-9]", "");
    }
}
