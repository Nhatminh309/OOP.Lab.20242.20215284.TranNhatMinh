package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.PlayerException;

public interface Playable {
    // Method to play
    public void play() throws PlayerException;
}
