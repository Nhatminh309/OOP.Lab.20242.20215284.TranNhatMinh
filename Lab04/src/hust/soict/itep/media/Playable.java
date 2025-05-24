package hust.soict.itep.media;

import hust.soict.itep.exception.PlayerException;

public interface Playable {
    // Method to play
    public void play() throws PlayerException;
}
