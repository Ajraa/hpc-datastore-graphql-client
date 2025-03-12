package client;

import client.base.GraphQLException;
import models.DataReturn;

import java.io.IOException;

public interface IDatasetServerService {
    /**
     * Get the status of the dataset server
     * @return The server status
     * @throws IOException If communication fails
     */
    DataReturn getStatus() throws IOException, GraphQLException;

    /**
     * Read a block of data from the dataset
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @param time Time parameter
     * @param channel Channel parameter
     * @param angle Angle parameter
     * @param blocks Block specification
     * @return The requested data
     * @throws IOException If reading fails
     */
    DataReturn readBlock(long x, long y, long z, int time, int channel, int angle, String blocks) throws IOException, GraphQLException;

    /**
     * Write a block of data to the dataset
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @param time Time parameter
     * @param channel Channel parameter
     * @param angle Angle parameter
     * @param blocks Block specification
     * @param data Data to write (Base64 encoded)
     * @return Result of the write operation
     * @throws IOException If writing fails
     */
    DataReturn writeBlock(long x, long y, long z, int time, int channel, int angle, String blocks, String data) throws IOException, GraphQLException;

    /**
     * Get the type information for a specific position
     * @param time Time parameter
     * @param channel Channel parameter
     * @param angle Angle parameter
     * @return Type information
     * @throws IOException If the operation fails
     */
    DataReturn getType(int time, int channel, int angle) throws IOException, GraphQLException;
}
