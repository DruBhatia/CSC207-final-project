package com.example.final_game.AntCrusher;
import android.content.Context;
import android.media.SoundPool;
import androidx.appcompat.app.AppCompatActivity;
import com.example.final_game.R;

public class SoundManager extends AppCompatActivity {

    static SoundPool soundPool;
    static int sound;

    public void InitSound(Context context) {
        soundPool = new SoundPool.Builder().build();
        sound = soundPool.load(context,R.raw.antsound,1);
    }

    public void playSound() {

        soundPool.play(sound, 1, 1, 1, 0, 1f);
    }

    public final void cleanUpIfEnd() {
        soundPool.release();
        soundPool = null;
    }

}
