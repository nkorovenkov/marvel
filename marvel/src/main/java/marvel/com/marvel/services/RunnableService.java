package marvel.com.marvel.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class RunnableService implements Runnable {
    @Override
    public void run() {
        log.info("Character change started.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        log.info("The character change is finished.");
    }
}
