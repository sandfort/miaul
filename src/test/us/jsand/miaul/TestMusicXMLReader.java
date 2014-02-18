package us.jsand.miaul;

import static org.junit.Assert.*;

import java.io.*;
import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.audiveris.proxmusic;
import com.audiveris.proxymusic.ScorePartwise;
import com.audiveris.proxymusic.ScorePartwise.Part;
import com.audiveris.proxymusic.ScorePartwise.Part.Measure;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class TestMusicXMLReader {

    MusicXMLReader reader;
    String res;
    String in;

    @Before
    public void setUp() {
        reader = new MusicXMLReader();
        res = this.getClass().getResource("/res").toString();
        in = res + File.separator + "helloworld.xml";

        ObjectFactory factory = new ObjectFactory();

        ScorePartwise score = factory.createScorePartwise();
        PartList parts = factory.createPartList();
        score.setPartList(parts);
        ScorePart scorePart = factory.createScorePart();
        scorePart.setId("P1");
        PartName name = factory.createPartName();
        name.setValue("Part 1");
        scorePart.setPartName(name);
        parts.getPartGroupOrScorePart().add(scorePart);
        Part part = factory.createScorePartwisePart();
        part.setId(scorePart);
        score.getPart().add(part);
        Measure measure = factory.createScorePartwisePartMeasure();
        part.getMeasure().add(measure);
        measure.setNumber("1");
        Attributes attr = factory.createAttributes();
        measure.getNoteOrBackupOrForward().add(attr);
        attr.setDivisions(new BigDecimal(1));
        Key keyOfC = factory.createKey();
        keyOfC.setFifths(new BigInteger("0"));
        attr.getKey().add(keyOfC);
        Time commonTime = factory.createTime();
        commonTime.getTimeSignature().add(factory.createTimeBeats("4"));
        commonTime.getTimeSignature().add(factory.createTimeBeatType("4"));
        attr.getTime().add(commonTime);
        Clef gClef = new Clef();
        attr.getClef().add(gClef);
        gClef.setSign(ClefSign.G);
        gClef.setLine(new BigInteger("2"));
        Note note = factory.createNote();
        measure.getNoteOrBackupOrForward().add(note);
        Pitch pitch = factory.createPitch();
        note.setPitch(pitch);
        pitch.setStep(Step.C);
        pitch.setOctave(4);
        note.setDuration(new BigDecimal(4));
        NoteType type = factory.createNoteType();
        type.setValue("whole");
        note.setType(type);
    }

    @Test
    public void testRead() {
        MusicXMLReader reader = new MusicXMLReader();
        ScorePartwise result = reader.read(new FileInputStream(in));
    }
}
