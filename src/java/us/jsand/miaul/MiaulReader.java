package us.jsand.miaul;

import java.io.InputStream;

import com.audiveris.proxymusic.*;
import com.audiveris.proxymusic.util.*;
import com.audiveris.proxymusic.ScorePartwise.Part;
import com.audiveris.proxymusic.ScorePartwise.Part.Measure;

abstract class MiaulReader {
    /**
     * Read in some plain-text music representation and return a
     * <code>ScorePartwise</code> object, which can be marshalled to a MusicXML
     * document.
     * @param in An <code>InputStream</code>, to be read char-by-char.
     * @return A MusicXML translation of the input.
     */
    abstract public ScorePartwise read(InputStream in);
}

