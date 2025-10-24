package examples.structural.adapter;
class MusicAdapter {
 
    OldMusicPlayer oldPlayer = new OldMusicPlayer();
 
    void playModernSong() {
        oldPlayer.playOldSong(); // adapts old method to new
    }
 
}

