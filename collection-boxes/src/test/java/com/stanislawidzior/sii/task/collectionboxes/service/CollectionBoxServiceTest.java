package com.stanislawidzior.sii.task.collectionboxes.service;

import com.stanislawidzior.sii.task.collectionboxes.mappers.CollectionBoxMapper;
import com.stanislawidzior.sii.task.collectionboxes.model.CollectionBox;
import com.stanislawidzior.sii.task.collectionboxes.repositories.CollectionBoxRepository;
import com.stanislawidzior.sii.task.collectionboxes.repositories.EventRepository;
import com.stanislawidzior.sii.task.collectionboxes.service.impl.CollectionBoxService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CollectionBoxServiceTest {
    @Mock
    private CollectionBoxRepository collectionBoxRepository;


    @InjectMocks
    private CollectionBoxService collectionBoxService;

    @Test
    public void CollectionBoxServiceTestCreateCollectionBox() {
        var collectionBox = CollectionBox.builder().id(1L).build();

        when(collectionBoxRepository.save(Mockito.any(CollectionBox.class)))
                .thenAnswer(i-> i.getArguments()[0]);

        var response = collectionBoxService.createCollectionBox();

        Assertions.assertThat(response.id() ==  collectionBox.getId());
        Assertions.assertThat(response).isNotNull();

    }
}
