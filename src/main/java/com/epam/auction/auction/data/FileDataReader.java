package com.epam.auction.auction.data;

import java.util.List;

public interface FileDataReader<T>  {
    List<T> read(String filePath) throws DataException;
}
