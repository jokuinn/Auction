package com.epam.auction.data;

import com.epam.auction.auction.data.DataException;
import com.epam.auction.auction.data.ParticipantFileDataReader;
import com.epam.auction.auction.model.Participant;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParticipantFileDataReaderTest {
    public static final String TEST_JSON_PARTICIPANTS = "src/test/resources/participants.json";
    public static final int FIRST_PARTICIPANT_ID = 1;
    public static final int SECOND_PARTICIPANT_ID = 2;
    public static final String FIRST_NAME = "Van";
    public static final String SECOND_NAME = "Dan";


    @Test
    public void testReadDataShouldReadDataAndReturnParticipantsList() throws DataException {
        Participant firstParticipant = new Participant(FIRST_PARTICIPANT_ID,
                FIRST_NAME);
        Participant secondParticipant = new Participant(SECOND_PARTICIPANT_ID,
                SECOND_NAME);
        List<Participant> expectedParticipants = Arrays
                .asList(firstParticipant, secondParticipant);
        ParticipantFileDataReader itemDataReader = new ParticipantFileDataReader();
        List<Participant> items = itemDataReader.read(TEST_JSON_PARTICIPANTS);
        Assert.assertEquals(items, expectedParticipants);
    }
}
