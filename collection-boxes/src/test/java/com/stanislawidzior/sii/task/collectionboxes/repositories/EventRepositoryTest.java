package com.stanislawidzior.sii.task.collectionboxes.repositories;

import com.stanislawidzior.sii.task.collectionboxes.model.Event;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@RequiredArgsConstructor
public class EventRepositoryTest {

private final EventRepository eventRepository;
private Event testEvent;
    @BeforeEach
    void setUp() {
        testEvent = new Event();
    }

    @Test
    public void accountCantBeNull(){
        boolean exceptionThrown = false;
        testEvent.setTitle("test title");
        testEvent.setAccount(null);
        try {
            eventRepository.save(testEvent);
        }catch (Exception e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

}
