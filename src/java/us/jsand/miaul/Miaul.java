package us.jsand.miaul;

import java.io.*;
import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.audiveris.proxymusic.*;
import com.audiveris.proxymusic.util.*;
import com.audiveris.proxymusic.ScorePartwise.Part;
import com.audiveris.proxymusic.ScorePartwise.Part.Measure;

public class Miaul {
    public static void main(String[] args) throws Exception {
        ObjectFactory factory = new ObjectFactory();

        // A score where measures are arranged in parts.
        // Use ScoreTimewise for a score where parts are arranged in measures.
        ScorePartwise score = factory.createScorePartwise();

        // Establish a list of parts.
        PartList parts = factory.createPartList();
        ScorePart scorePart = factory.createScorePart();
        scorePart.setId("P1");
        PartName name = factory.createPartName();
        name.setValue("Part 1");
        scorePart.setPartName(name);
        parts.getPartGroupOrScorePart().add(scorePart);

        // Now create the part that lives in the score.
        Part part = factory.createScorePartwisePart();
        part.setId("P1");

        // Create the measure that lives in the part.
        Measure measure = factory.createScorePartwisePartMeasure();
        measure.setNumber("1");

        // Set up the attributes of the measure.
        Attributes attr = factory.createAttributes();
        attr.setDivisions(new BigDecimal(1));

        Key keyOfC = factory.createKey();
        keyOfC.setFifths(new BigInteger("0"));
        attr.getKey().add(keyOfC);

        // This is really important
        Time commonTime = factory.createTime();
        // Particularly these two lines
        commonTime.getTimeSignature().add(factory.createTimeBeats("4"));
        commonTime.getTimeSignature().add(factory.createTimeBeatType("4"));
        attr.getTime().add(commonTime);

        Clef gClef = new Clef();
        gClef.setSign(ClefSign.G);
        gClef.setLine(new BigInteger("2"));

        // Now make an actual note
        Note note = factory.createNote();
        measure.getNoteOrBackupOrForward().add(note);

        // Set the pitch of the note
        Pitch pitch = factory.createPitch();
        note.setPitch(pitch);
        pitch.setStep(Step.C);
        pitch.setOctave(4);

        // Set the duration of the note
        note.setDuration(new BigDecimal(4));

        // Set the type of the note
        NoteType type = factory.createNoteType();
        type.setValue("whole");
        note.setType(type);

        Marshalling.marshal(score, System.out);
    }
}
