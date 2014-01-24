package us.jsand.miaul;

import java.io.InputStream;

import com.audiveris.proxymusic.*;
import com.audiveris.proxymusic.util.*;
import com.audiveris.proxymusic.ScorePartwise.Part;
import com.audiveris.proxymusic.ScorePartwise.Part.Measure;

public class AbcReader extends MiaulReader {
    /**
     * Read in some abc notation and return a MusicXML document.
     * @param in An <code>InputStream</code> of any kind.
     * @return The abc document represented as a MusicXML document.
     */
    @Override
    public ScorePartwise read(InputStream in) {
        // ...okay, read

        // TODO
        return null;
    }
}

