package com.epam.auction.auction.application;

import com.epam.auction.auction.data.DataException;
import com.epam.auction.auction.data.FileDataReader;
import com.epam.auction.auction.data.ParticipantFileDataReader;
import com.epam.auction.auction.model.Auction;
import com.epam.auction.auction.model.AuctionStarter;
import com.epam.auction.auction.model.Participant;

import java.util.List;

public class AuctionApplication {
    public static final String PARTICIPANTS_JSON = "src/json/participants.json";

    public static void main(String[] args) throws DataException {
        Auction auction = Auction.getInstance();
        AuctionStarter starter = new AuctionStarter();
        FileDataReader<Participant> participantFileDataReader = new ParticipantFileDataReader();
        List<Participant> expectedParticipants = participantFileDataReader.read(PARTICIPANTS_JSON);
        auction.setParticipants(expectedParticipants);
        starter.startAuctionBidding(auction);
    }
}
