import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Music {
    Clip clip;
    URL[] soundURL = new URL[5];

    public Music() {
        soundURL[0] = getClass().getResource("music/MonopolyPLUS-OST-MainMenu.wav");// bgm
        soundURL[1] = getClass().getResource("/Sound/Click.wav");//click
        soundURL[2] = getClass().getResource("music/Monopoly-PLUS-OST-Parkside-Version-2-_Intense_.wav");
    }

    public void setFiles(int i) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void play(){
        clip.start();
    }
    
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
}
